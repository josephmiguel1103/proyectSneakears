/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package pe.edu.upeu.app.gui;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;
import pe.com.syscenterlife.autocomp.AutoCompleteTextField;
import pe.com.syscenterlife.autocomp.ModeloDataAutocomplet;
import pe.com.syscenterlife.jtablecomp.ButtonsEditor;
import pe.com.syscenterlife.jtablecomp.ButtonsPanel;
import pe.com.syscenterlife.jtablecomp.ButtonsRenderer;
import pe.edu.upeu.app.conx.ConnS;
import pe.edu.upeu.app.dao.CarritoDAO;
import pe.edu.upeu.app.dao.CarritoDaoI;
import pe.edu.upeu.app.dao.ClienteDAO;
import pe.edu.upeu.app.dao.ClienteDaoI;
import pe.edu.upeu.app.dao.ProductoDAO;
import pe.edu.upeu.app.dao.ProductoDaoI;
import pe.edu.upeu.app.dao.VentaDao;
import pe.edu.upeu.app.dao.VentaDaoI;
import pe.edu.upeu.app.modelo.CarritoTO;
import pe.edu.upeu.app.modelo.VentaDetalleTO;
import pe.edu.upeu.app.modelo.VentaTO;
import pe.edu.upeu.app.util.UtilsX;

/**
 *
 * @author HP
 */
public class MainVentas extends javax.swing.JFrame {

    BufferedImage image;
    UtilsX obj = new UtilsX();
    ProductoDaoI daoP;
    CarritoDaoI daoC;
    DefaultTableModel modelo;
    VentaDaoI daoV;

    public MainVentas() {
        initComponents();
        //Titulo
        this.setTitle("Gestionar ventas");
        //Icono
        try {
            image = ImageIO.read(obj.getFile("icono.png"));
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        this.setIconImage(image);

        //Tamaño
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        this.setSize(new Dimension(screenSize.width, (screenSize.height) - 36));

        ClienteDaoI daoC = new ClienteDAO();
        List<ModeloDataAutocomplet> items = daoC.listAutoComplet("");
        AutoCompleteTextField.setupAutoComplete(txtDniAutoComplete, items, "ID");//ID,NAME, OTHER

        txtDniAutoComplete.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if ((e.getKeyCode() == KeyEvent.VK_ENTER || e.getKeyCode() == KeyEvent.VK_UP || e.getKeyCode() == KeyEvent.VK_DOWN)
                        && AutoCompleteTextField.dataGetReturnet != null) {
                    if (ModeloDataAutocomplet.TIPE_DISPLAY.equals("ID") && txtDniAutoComplete.getText().equals(AutoCompleteTextField.dataGetReturnet.getIdx())) {
                        txtNombre.setText(AutoCompleteTextField.dataGetReturnet.getNombreDysplay());
                    } else if (ModeloDataAutocomplet.TIPE_DISPLAY.equals("NAME")
                            && txtDniAutoComplete.getText().equals(AutoCompleteTextField.dataGetReturnet.getNombreDysplay())) {
                        txtNombre.setText(AutoCompleteTextField.dataGetReturnet.getIdx());
                    } else if (ModeloDataAutocomplet.TIPE_DISPLAY.equals("OTHER")
                            && txtDniAutoComplete.getText().equals(AutoCompleteTextField.dataGetReturnet.getOtherData())) {
                        System.out.println("Valor:" + txtDniAutoComplete.getText());
                        System.out.println("Valor:" + AutoCompleteTextField.dataGetReturnet.getIdx() + "\tContenido:"
                                + AutoCompleteTextField.dataGetReturnet.getNombreDysplay());
                        txtNombre.setText(AutoCompleteTextField.dataGetReturnet.getIdx());
                    } else {
                        System.out.println("Valor:" + txtDniAutoComplete.getText());
                        txtNombre.setText("");
                    }
                    listarCarrito(txtDniAutoComplete.getText());
                }
            }
        });

        buscarProducto();

        txtProducto.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (AutoCompleteTextField.dataGetReturnet.getNombreDysplay() != null) {
                    txtCodigo.setText(AutoCompleteTextField.dataGetReturnet.getNombreDysplay());
                    String[] dataX = AutoCompleteTextField.dataGetReturnet.getOtherData().split(":");
                    txtStock.setText(dataX[0]);
                    txtPUnitario.setText(dataX[1]);
                }

            }

        });
        txtCantidad.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                double cant = Double.parseDouble(String.valueOf(txtCantidad.getText()));
                double pu = Double.parseDouble(String.valueOf(txtPUnitario.getText()));
                txtPTotal.setText(String.valueOf(cant * pu));
            }

        });

    }

    public List<CarritoTO> listarCarrito(String dni) {
        daoC = new CarritoDAO();
        List<CarritoTO> listarCleintes = daoC.lista(dni);
        jTable1.setAutoCreateRowSorter(true);
        modelo = (DefaultTableModel) jTable1.getModel();
        ButtonsPanel.metaDataButtons = new String[][]{{"", "del-icon.png"}};
        jTable1.setRowHeight(40);
        TableColumn column = jTable1.getColumnModel().getColumn(8);
        column.setCellRenderer(new ButtonsRenderer());
        ButtonsEditor be = new ButtonsEditor(jTable1);
        column.setCellEditor(be);
        modelo.setNumRows(0);
        Object[] ob = new Object[9];
        double impoTotal = 0, igv = 0;
        for (int i = 0; i < listarCleintes.size(); i++) {
            int x = -1;
            ob[++x] = listarCleintes.get(i).getIdCarrito();
            ob[++x] = listarCleintes.get(i).getDniruc();
            ob[++x] = listarCleintes.get(i).getIdProducto();
            ob[++x] = listarCleintes.get(i).getNombreProducto();
            ob[++x] = listarCleintes.get(i).getCantidad();
            ob[++x] = listarCleintes.get(i).getPunitario();
            ob[++x] = listarCleintes.get(i).getPtotal();
            ob[++x] = listarCleintes.get(i).getEstado();
            ob[++x] = "";
            impoTotal += Double.parseDouble(String.valueOf(listarCleintes.get(i).getPtotal()));
            modelo.addRow(ob);
        }
        JButton btnDel = be.getCellEditorValue().buttons.get(0);
        btnDel.addActionListener((ActionEvent e) -> {
            System.out.println("VERRRRRR:");
            int row
                    = jTable1.convertRowIndexToModel(jTable1.getEditingRow());
            Object o = jTable1.getModel().getValueAt(row, 0);
            daoC = new CarritoDAO();
            try {
                daoC.delete(Integer.parseInt(String.valueOf(o)));
                listarCarrito(dni);
            } catch (Exception ex) {
                System.err.println("Error:" + ex.getMessage());
            }
            System.out.println("AAAA:" + String.valueOf(o));
            JOptionPane.showMessageDialog(this, "Editing: " + o);
        });
        jTable1.setModel(modelo);
        txtImporte.setText(String.valueOf(impoTotal));
        double pv = impoTotal / 1.18;
        txtPVenta.setText(String.valueOf(Math.round(pv * 100.0) / 100.0));
        txtIgv.setText(String.valueOf(Math.round((pv * 0.18) * 100.0) / 100.0));
        return listarCleintes;
    }

    public void buscarProducto() {
        daoP = new ProductoDAO();
        List<ModeloDataAutocomplet> itemsP = daoP.listAutoComplet("");
        AutoCompleteTextField.setupAutoComplete(txtProducto, itemsP, "ID");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        txtDniAutoComplete = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        txtDireccion = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        txtProducto = new javax.swing.JTextField();
        txtPUnitario = new javax.swing.JTextField();
        txtPTotal = new javax.swing.JTextField();
        txtCantidad = new javax.swing.JTextField();
        txtCodigo = new javax.swing.JTextField();
        txtStock = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        txtPVenta = new javax.swing.JTextField();
        txtIgv = new javax.swing.JTextField();
        txtDescuento = new javax.swing.JTextField();
        txtImporte = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 0, 102));

        jLabel1.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("DNI/RUC CLIENTE");

        jLabel2.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("NOMBRE ");

        jLabel3.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("DIRECCION");

        jButton1.setFont(new java.awt.Font("Viner Hand ITC", 1, 14)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/add-contact-icon.png"))); // NOI18N
        jButton1.setText("ADD");

        jButton4.setText("REGRESAR");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtDniAutoComplete, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1)))
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton4)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(25, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jButton4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDniAutoComplete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addGap(25, 25, 25))
        );

        jPanel2.setBackground(new java.awt.Color(153, 153, 153));

        txtPUnitario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPUnitarioActionPerformed(evt);
            }
        });

        txtStock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtStockActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel4.setText("PRODUCTO");

        jLabel5.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel5.setText("CODIGO");

        jLabel6.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel6.setText("P. UNIDAD");

        jLabel7.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel7.setText("CANTIDAD");

        jLabel8.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel8.setText("STOCK");

        jLabel9.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel9.setText("P. TOTAL");

        jButton2.setFont(new java.awt.Font("Viner Hand ITC", 1, 14)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/data-add-icon.png"))); // NOI18N
        jButton2.setText("ADD");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(txtProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtStock, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(25, 25, 25)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtPUnitario, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel6)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(txtPTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(50, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(jLabel9)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPUnitario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtStock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2))
                .addContainerGap())
        );

        jPanel3.setBackground(new java.awt.Color(51, 255, 255));

        jTable1.setFont(new java.awt.Font("Viner Hand ITC", 1, 14)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "DNI/RUC", "Id producto", "Producto", "Cantidad", "P.Unitario S/", "P.Total", "Estado", "OPC"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel4.setBackground(new java.awt.Color(204, 255, 255));

        jLabel10.setFont(new java.awt.Font("Viner Hand ITC", 1, 14)); // NOI18N
        jLabel10.setText("PRECIO VENTA");

        jLabel11.setFont(new java.awt.Font("Viner Hand ITC", 1, 14)); // NOI18N
        jLabel11.setText("IGV");

        jLabel12.setFont(new java.awt.Font("Viner Hand ITC", 1, 14)); // NOI18N
        jLabel12.setText("DESCUENTOS");

        jLabel13.setFont(new java.awt.Font("Viner Hand ITC", 1, 14)); // NOI18N
        jLabel13.setText("P.TOTAL");

        jButton3.setFont(new java.awt.Font("Viner Hand ITC", 1, 14)); // NOI18N
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/shop-cart-add-icon.png"))); // NOI18N
        jButton3.setText("R. VENTA");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtPVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtIgv, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtDescuento, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(txtImporte, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addComponent(jButton3)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(30, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11)
                    .addComponent(jLabel12)
                    .addComponent(jLabel13))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtIgv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDescuento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtImporte, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3))
                .addGap(26, 26, 26))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtStockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtStockActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtStockActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        Selector se = new Selector();
        se.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        daoC = new CarritoDAO();
        CarritoTO to = new CarritoTO();
        to.setDniruc(txtDniAutoComplete.getText());
        to.setIdProducto(Integer.parseInt(txtCodigo.getText()));
        to.setNombreProducto(txtProducto.getText());
        to.setCantidad(Double.parseDouble(txtCantidad.getText()));
        to.setPunitario(Double.parseDouble(txtPUnitario.getText()));
        to.setPtotal(Double.parseDouble(txtPTotal.getText()));
        to.setEstado(1);
        daoC.crear(to);
        listarCarrito(txtDniAutoComplete.getText());
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

        registrarVenta();


    }//GEN-LAST:event_jButton3ActionPerformed

    private void txtPUnitarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPUnitarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPUnitarioActionPerformed

    private void runReport1(int idv) {
        try {
            ConnS instance = ConnS.getInstance();
            HashMap param = new HashMap();
            String imagen = getFile("04.png").getAbsolutePath(); 
            param.put("idventa", idv);
            param.put("image", imagen);
            JasperDesign jdesign = JRXmlLoader.load(getFile("comprobante.jrxml"));
            JasperReport jreport = JasperCompileManager.compileReport(jdesign);
            JasperPrint jprint = JasperFillManager.fillReport(jreport, param,
                    instance.getConnection());
            JasperViewer.viewReport(jprint, false);
        } catch (JRException ex) {
            System.out.println("Error:\n" + ex.getLocalizedMessage());
        }
    }

    public File getFile(String filex) {
        File newFolder = new File("jasper");
        String ruta = newFolder.getAbsolutePath();
        //CAMINO = Paths.get(ruta+"/"+"reporte1.jrxml");
        Path CAMINO = Paths.get(ruta + "/" + filex);
        System.out.println("Llegasss Ruta 2:" + CAMINO.toFile().getAbsolutePath());
        return CAMINO.toFile();
    }

    public void registrarVenta() {
        daoV = new VentaDao();
        VentaTO to = new VentaTO();
        to.setDniruc(txtDniAutoComplete.getText());
        to.setPreciobase(Double.parseDouble(txtPVenta.getText()));
        to.setIgv(Double.parseDouble(txtIgv.getText()));
        to.setPrecioTotal(Double.parseDouble(txtImporte.getText()));
        int idX = daoV.createVenta(to);
        List<CarritoTO> dd = listarCarrito(txtDniAutoComplete.getText());
        if (idX != 0) {
            for (CarritoTO car : dd) {
                VentaDetalleTO vd = new VentaDetalleTO();
                vd.setIdVenta(idX);
                vd.setIdProducto(car.getIdProducto());
                vd.setCantidad(car.getCantidad());
                vd.setDescuento(0);
                vd.setPu(car.getPunitario());
                vd.setSubtotal(car.getPtotal());

                daoV = new VentaDao();
                daoV.createVentaDetalle(vd);
            }

        }
        daoC = new CarritoDAO();
        daoC.deleteCarAll(txtDniAutoComplete.getText());
        listarCarrito(txtDniAutoComplete.getText());
        runReport1(idX);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField txtCantidad;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtDescuento;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtDniAutoComplete;
    private javax.swing.JTextField txtIgv;
    private javax.swing.JTextField txtImporte;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtPTotal;
    private javax.swing.JTextField txtPUnitario;
    private javax.swing.JTextField txtPVenta;
    private javax.swing.JTextField txtProducto;
    private javax.swing.JTextField txtStock;
    // End of variables declaration//GEN-END:variables
}
