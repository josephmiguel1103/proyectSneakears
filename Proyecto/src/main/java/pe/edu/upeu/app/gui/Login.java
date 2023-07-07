/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package pe.edu.upeu.app.gui;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import pe.edu.upeu.app.modelo.Usuario;
import pe.edu.upeu.app.util.UtilsX;

/**
 *
 * @author HP
 */
public class Login extends javax.swing.JFrame {

    BufferedImage image, imagex;
    UtilsX obj = new UtilsX();

    public Login() {
        initComponents();
        //Titulo
        this.setTitle("Login");
        //Icono
        try {
            image = ImageIO.read(obj.getFile("icono.png"));
            imagex = ImageIO.read(obj.getFile("login1.jpg"));
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        this.setIconImage(image);
        //Tamaño
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        this.setSize(633, 410);

        //iMAGENES
        Image scaleImage = imagex.getScaledInstance(jLabel4.getWidth(), jLabel4.getHeight(), Image.SCALE_DEFAULT);
        jLabel4.setIcon(new ImageIcon(scaleImage));

        //Añadir imagen icono
        ImageIcon imagea = new ImageIcon(obj.getFile("icono_login.png"));
        jLabel5.setIcon(imagea);
        //Posicion
        this.setLocationRelativeTo(null);
    }
    Usuario uTO = new Usuario();

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        fondoPanel1 = new pe.edu.upeu.app.component.FondoPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtUsuario = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        msg = new javax.swing.JLabel();
        txtClave = new javax.swing.JPasswordField();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(153, 153, 153));

        jLabel4.setToolTipText("");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(152, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addContainerGap(152, Short.MAX_VALUE))
            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 348, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(71, 71, 71)
                .addComponent(jLabel3))
        );

        jLabel1.setBackground(new java.awt.Color(0, 0, 51));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("USUARIO");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("CONTRASEÑA");

        txtUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUsuarioActionPerformed(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(255, 255, 51));
        jButton1.setText("CANCELAR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(255, 255, 51));
        jButton2.setText("INICIAR");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        txtClave.setToolTipText("txtclave");

        jButton3.setText("CREAR USUARIO");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout fondoPanel1Layout = new javax.swing.GroupLayout(fondoPanel1);
        fondoPanel1.setLayout(fondoPanel1Layout);
        fondoPanel1Layout.setHorizontalGroup(
            fondoPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(fondoPanel1Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, fondoPanel1Layout.createSequentialGroup()
                .addGroup(fondoPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, fondoPanel1Layout.createSequentialGroup()
                        .addGroup(fondoPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, fondoPanel1Layout.createSequentialGroup()
                                .addGap(137, 137, 137)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, fondoPanel1Layout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addComponent(jLabel1)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(fondoPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(fondoPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtClave)
                            .addComponent(txtUsuario))))
                .addContainerGap())
            .addGroup(fondoPanel1Layout.createSequentialGroup()
                .addGroup(fondoPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(fondoPanel1Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(jLabel2))
                    .addGroup(fondoPanel1Layout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(fondoPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(fondoPanel1Layout.createSequentialGroup()
                    .addGap(0, 161, Short.MAX_VALUE)
                    .addComponent(msg)
                    .addGap(0, 160, Short.MAX_VALUE)))
        );
        fondoPanel1Layout.setVerticalGroup(
            fondoPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(fondoPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtClave, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(fondoPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(fondoPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(fondoPanel1Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(msg)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(fondoPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(fondoPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 348, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUsuarioActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        //Iniciar objeto
        String busqueda_usuario = uTO.BuscarUsuarioRegistrado(txtUsuario.getText(), txtClave.getText());
        //Buscar usuario
        if (txtUsuario.getText().equals("root") && txtClave.getText().equals("root")) {
            //Si es root y root entrara aqui
            JOptionPane.showMessageDialog(this, "Bienvenido iniciaste como root (Administrador)");
            Selector slc = new Selector();
            slc.setVisible(true);
            this.dispose();
        } else if (busqueda_usuario.equals("Usuario encontrado")) {
            //Si es un usuario de la base de datos entrara aqui
            String busqueda_nombre = uTO.buscarnombre(txtUsuario.getText());
            JOptionPane.showMessageDialog(this, "Bienvenid@ \n" + busqueda_nombre);
            Selector slc = new Selector();
            slc.setVisible(true);
            this.dispose();
        } else {
            //Si no es ninguno de los dos entrara aqui
            JOptionPane.showMessageDialog(this, "Usuario no registrado, favor de crear usuario");
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        MainUsuario mu = new MainUsuario();
        mu.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private pe.edu.upeu.app.component.FondoPanel fondoPanel1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel msg;
    private javax.swing.JPasswordField txtClave;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables

}
