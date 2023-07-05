/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.upeu.app.encript;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.util.HashMap;
import javax.crypto.Cipher;

public class EncriptRSA extends Observer {

    public EncriptRSA(Subject subject) {
        this.subject = subject;
        subject.attach(this);
    }

    public void addTextEncript(String msg, String typex) {
        subject.setState(msg, typex);
    }

    @Override
    public Object encrypt(String msg, String typex) {
        byte[] mensajeCifrado = null;
        try {
            KeyPairGenerator keygen = KeyPairGenerator.getInstance("RSA");
            KeyPair keypair = keygen.generateKeyPair();
            Cipher rsaCipher = Cipher.getInstance("RSA");
            rsaCipher.init(Cipher.ENCRYPT_MODE, keypair.getPrivate());
            mensajeCifrado = rsaCipher.doFinal(msg.getBytes("UTF8"));
            //System.out.println(mensajeCifrado);
            rsaCipher.init(Cipher.DECRYPT_MODE, keypair.getPublic());
            byte[] mensajeDescifrado = rsaCipher.doFinal(mensajeCifrado);
            String mensajeDescifrado2 = new String(mensajeDescifrado, "UTF8");
        //System.out.println(mensajeDescifrado2);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mensajeCifrado.toString();
    }

    public HashMap<Integer, Object> sendEncript() {
        return subject.notifyObservers();
    }
}
