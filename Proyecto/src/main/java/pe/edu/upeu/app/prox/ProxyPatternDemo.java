/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.upeu.app.prox;

public class ProxyPatternDemo {

    public static void main(String[] args) {
        //Con Proxy
        Image image = new ProxyImage("fondo2.png");
        image.display();
        System.out.println("");
        //Sin Proxy
        //Image imagex = new RealImage("proxy_pattern_uml_diagram.jpg");
        //imagex.display();
    }
}
