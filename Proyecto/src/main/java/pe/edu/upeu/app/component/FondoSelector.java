/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.upeu.app.component;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import pe.edu.upeu.app.util.UtilsX;

public class FondoSelector extends JPanel {

    public Image imageX;
    UtilsX obj = new UtilsX();

    @Override
    public void paint(Graphics g) {
        imageX = new ImageIcon(obj.getFile("fondoselector.png")).getImage();
        g.drawImage(imageX, 0, 0, getWidth(), getHeight(), this);
        setOpaque(false);
        g.setColor(getBackground());
        super.paint(g);
    }
}
