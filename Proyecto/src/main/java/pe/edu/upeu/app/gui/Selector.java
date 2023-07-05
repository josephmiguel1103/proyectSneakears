/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package pe.edu.upeu.app.gui;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import pe.edu.upeu.app.util.UtilsX;

public class Selector extends javax.swing.JFrame {

    BufferedImage image;
    UtilsX obj = new UtilsX();
    
    public Selector() {
        initComponents();
        //Titulo
        this.setTitle("Login El carraso");
        //Icono
        try {
            image = ImageIO.read(obj.getFile("icono.png"));
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        this.setIconImage(image);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel4 = new javax.swing.JLabel();
        fondoSelector1 = new pe.edu.upeu.app.component.FondoSelector();
        jButton1 = new javax.swing.JButton();
        btnGVenta = new javax.swing.JButton();
        btnGMarca = new javax.swing.JButton();
        btnGProducto = new javax.swing.JButton();
        btnGCategoria = new javax.swing.JButton();
        btnGCliente = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        jLabel4.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("gestionar categoria");
        jLabel4.setOpaque(true);
        jLabel4.setVerifyInputWhenFocusTarget(false);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setFont(new java.awt.Font("Sitka Subheading", 1, 14)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cerrar secion.png"))); // NOI18N
        jButton1.setText("CERRAR SECION");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        btnGVenta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/venta .png"))); // NOI18N
        btnGVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGVentaActionPerformed(evt);
            }
        });

        btnGMarca.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Marca.png"))); // NOI18N
        btnGMarca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGMarcaActionPerformed(evt);
            }
        });

        btnGProducto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images.jpg"))); // NOI18N
        btnGProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGProductoActionPerformed(evt);
            }
        });

        btnGCategoria.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Categoria.png"))); // NOI18N
        btnGCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGCategoriaActionPerformed(evt);
            }
        });

        btnGCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cliente.png"))); // NOI18N
        btnGCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGClienteActionPerformed(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icono3.png"))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("gestionar cliente");
        jLabel2.setOpaque(true);
        jLabel2.setVerifyInputWhenFocusTarget(false);

        jLabel3.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("gestionar categoria");
        jLabel3.setOpaque(true);
        jLabel3.setVerifyInputWhenFocusTarget(false);

        jLabel5.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("gestionar producto");
        jLabel5.setOpaque(true);
        jLabel5.setVerifyInputWhenFocusTarget(false);

        jLabel6.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("gestionar marca");
        jLabel6.setOpaque(true);
        jLabel6.setVerifyInputWhenFocusTarget(false);

        jLabel7.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("gestionar ventas");
        jLabel7.setOpaque(true);
        jLabel7.setVerifyInputWhenFocusTarget(false);

        javax.swing.GroupLayout fondoSelector1Layout = new javax.swing.GroupLayout(fondoSelector1);
        fondoSelector1.setLayout(fondoSelector1Layout);
        fondoSelector1Layout.setHorizontalGroup(
            fondoSelector1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, fondoSelector1Layout.createSequentialGroup()
                .addGroup(fondoSelector1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(fondoSelector1Layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(330, 330, 330)
                        .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(fondoSelector1Layout.createSequentialGroup()
                        .addGroup(fondoSelector1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(fondoSelector1Layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(fondoSelector1Layout.createSequentialGroup()
                                .addGap(46, 46, 46)
                                .addComponent(btnGCliente)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 77, Short.MAX_VALUE)
                                .addGroup(fondoSelector1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnGCategoria)
                                    .addGroup(fondoSelector1Layout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addComponent(jLabel3)))))
                        .addGap(87, 87, 87)
                        .addComponent(btnGProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(59, 59, 59))
            .addGroup(fondoSelector1Layout.createSequentialGroup()
                .addGroup(fondoSelector1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(fondoSelector1Layout.createSequentialGroup()
                        .addGap(250, 250, 250)
                        .addComponent(jButton1))
                    .addGroup(fondoSelector1Layout.createSequentialGroup()
                        .addGap(142, 142, 142)
                        .addGroup(fondoSelector1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(fondoSelector1Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(166, 166, 166)
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(fondoSelector1Layout.createSequentialGroup()
                                .addComponent(btnGMarca)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnGVenta)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        fondoSelector1Layout.setVerticalGroup(
            fondoSelector1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(fondoSelector1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(fondoSelector1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnGCategoria)
                    .addComponent(btnGProducto)
                    .addComponent(btnGCliente))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(fondoSelector1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(fondoSelector1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(36, 36, 36))
                    .addGroup(fondoSelector1Layout.createSequentialGroup()
                        .addGroup(fondoSelector1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(fondoSelector1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnGMarca)
                            .addGroup(fondoSelector1Layout.createSequentialGroup()
                                .addComponent(btnGVenta)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(fondoSelector1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel6))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                        .addComponent(jButton1)
                        .addGap(17, 17, 17))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(fondoSelector1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(fondoSelector1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGCategoriaActionPerformed
        MainCategoria mc = new MainCategoria();
        mc.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnGCategoriaActionPerformed

    private void btnGProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGProductoActionPerformed
        MainProducto mc = new MainProducto();
        mc.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnGProductoActionPerformed

    private void btnGClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGClienteActionPerformed
        MainCliente mc = new MainCliente();
        mc.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnGClienteActionPerformed

    private void btnGMarcaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGMarcaActionPerformed
        MainMarca mu = new MainMarca();
        mu.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnGMarcaActionPerformed

    private void btnGVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGVentaActionPerformed
        MainVentas mu = new MainVentas();
        mu.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnGVentaActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Login mu = new Login();
        mu.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGCategoria;
    private javax.swing.JButton btnGCliente;
    private javax.swing.JButton btnGMarca;
    private javax.swing.JButton btnGProducto;
    private javax.swing.JButton btnGVenta;
    private pe.edu.upeu.app.component.FondoSelector fondoSelector1;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    // End of variables declaration//GEN-END:variables
}
