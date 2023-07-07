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
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

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

        btnGMarca.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MarcaA.png"))); // NOI18N
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

        btnGCategoria.setIcon(new javax.swing.ImageIcon(getClass().getResource("/CategoriaA.png"))); // NOI18N
        btnGCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGCategoriaActionPerformed(evt);
            }
        });

        btnGCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/clienteA.png"))); // NOI18N
        btnGCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGClienteActionPerformed(evt);
            }
        });

        jLabel1.setText("GESTIONAR CLIENTE");
        jLabel1.setOpaque(true);

        jLabel2.setText("GESTIONAR CATEGORIA");
        jLabel2.setOpaque(true);

        jLabel3.setText("GESTIONAR PRODUCTO");
        jLabel3.setOpaque(true);

        jLabel4.setText("GESTIONAR MARCA");
        jLabel4.setOpaque(true);

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("GESTIONAR VENTA");
        jLabel5.setOpaque(true);

        javax.swing.GroupLayout fondoSelector1Layout = new javax.swing.GroupLayout(fondoSelector1);
        fondoSelector1.setLayout(fondoSelector1Layout);
        fondoSelector1Layout.setHorizontalGroup(
            fondoSelector1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(fondoSelector1Layout.createSequentialGroup()
                .addGroup(fondoSelector1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(fondoSelector1Layout.createSequentialGroup()
                        .addGroup(fondoSelector1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(fondoSelector1Layout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addComponent(btnGCliente))
                            .addGroup(fondoSelector1Layout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(75, 75, 75)
                        .addComponent(jButton1))
                    .addGroup(fondoSelector1Layout.createSequentialGroup()
                        .addGap(252, 252, 252)
                        .addGroup(fondoSelector1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnGCategoria)
                            .addGroup(fondoSelector1Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(77, 77, 77)
                        .addGroup(fondoSelector1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnGProducto)
                            .addComponent(jLabel3)))
                    .addGroup(fondoSelector1Layout.createSequentialGroup()
                        .addGap(144, 144, 144)
                        .addComponent(btnGMarca)
                        .addGap(82, 82, 82)
                        .addComponent(btnGVenta))
                    .addGroup(fondoSelector1Layout.createSequentialGroup()
                        .addGap(161, 161, 161)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(128, 128, 128)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(34, Short.MAX_VALUE))
        );
        fondoSelector1Layout.setVerticalGroup(
            fondoSelector1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(fondoSelector1Layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addGroup(fondoSelector1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnGCliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnGProducto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnGCategoria, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(fondoSelector1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE)
                    .addGroup(fondoSelector1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(27, 27, 27)
                .addGroup(fondoSelector1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnGMarca)
                    .addComponent(btnGVenta))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(fondoSelector1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(fondoSelector1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(fondoSelector1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
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
    // End of variables declaration//GEN-END:variables
}
