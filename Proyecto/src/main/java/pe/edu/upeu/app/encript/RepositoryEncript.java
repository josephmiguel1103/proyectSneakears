/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.upeu.app.encript;

public class RepositoryEncript {

    EncriptMD5 emd5;

    public RepositoryEncript(Subject subject) {
        this.emd5 = new EncriptMD5(subject);
        new EncriptSHA1(subject);
        new EncriptRSA(subject);
    }

    public EncriptMD5 getInstance() {
        return emd5;
    }
}
