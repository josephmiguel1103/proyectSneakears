/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.upeu.app.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import pe.edu.upeu.app.conx.ConnS;
import pe.edu.upeu.app.modelo.MarcaTO;
import pe.edu.upeu.app.util.ErrorLogger;


public class MarcaDAO implements MarcaDaoI{
    
    Statement stmt = null;
    Vector columnNames;
    Vector visitdata;
    Connection connection = ConnS.getInstance().getConnection();
    static PreparedStatement ps;
    static ErrorLogger log = new ErrorLogger(ClienteDAO.class.getName());
    ResultSet rs = null;

    public MarcaDAO() {
        columnNames = new Vector();
        visitdata = new Vector();
    }

    @Override
    public int create(MarcaTO d) {
        int rsId = 0;
        String[] returns = {"nombre"};
        String sql = "INSERT INTO marca(nombre) "
                + "VALUES(?)";
        int i = 0;
        try {
            ps = connection.prepareStatement(sql, returns);
            ps.setString(++i, d.getNombre());
            rsId = ps.executeUpdate();// 0 no o 1 si commit
            try ( ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) {
                    rsId = rs.getInt(1);
                }
                rs.close();
            }
        } catch (SQLException ex) {
            //System.err.println("create:" + ex.toString());
            log.log(Level.SEVERE, "create", ex);
        }
        return rsId;}

    @Override
    public int update(MarcaTO d) {
        System.out.println("actualizar d.getNombre: " + d.getNombre());
        int comit = 0;
        String sql = "UPDATE marca SET "  + "nombre=? " + "WHERE id_marca=?";
        int i = 0;
        try {
            ps = connection.prepareStatement(sql);
            ps.setString(++i, d.getNombre());
            ps.setInt(++i, d.getIdMarca());
            comit = ps.executeUpdate();
        } catch (SQLException ex) {
            log.log(Level.SEVERE, "update", ex);
        }
        return comit;}

    @Override
    public int delete(String id) throws Exception {
         int comit = 0;
        String sql = "DELETE FROM marca WHERE nombre = ?";
        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, id);
            comit = ps.executeUpdate();
        } catch (SQLException ex) {
            log.log(Level.SEVERE, "delete", ex);
            // System.err.println("NO del " + ex.toString());
            throw new Exception("Detalle:" + ex.getMessage());
        }
        return comit;}

    @Override
    public List<MarcaTO> listCmb(String filter) {
        List<MarcaTO> ls = new ArrayList();
        ls.add(new MarcaTO());
        ls.addAll(listarMarca());
        return ls;
    }

    @Override
    public List<MarcaTO> listarMarca() {
        List<MarcaTO> listarMarca = new ArrayList<>();
        String sql = "SELECT * FROM marca";
        try {
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                MarcaTO uTO = new MarcaTO();
                uTO.setIdMarca(rs.getInt("id_marca"));
                uTO.setNombre(rs.getString("nombre"));
                listarMarca.add(uTO);
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return listarMarca;}

    @Override
    public MarcaTO buscarMarca(int id) {
        MarcaTO marca= new MarcaTO();
        String sql = "SELECT * FROM marca WHERE id_marca = ?";
        System.out.println("ID: "+ id);
        try {
            ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                System.out.println("nombre: "+ rs.getString("nombre"));
                marca.setIdMarca(rs.getInt("id_marca"));
                marca.setNombre(rs.getString("nombre"));
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return marca;}

    @Override
    public void reportarMarca() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }


    
    
    
}
