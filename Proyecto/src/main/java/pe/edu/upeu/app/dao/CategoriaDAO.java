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
import pe.edu.upeu.app.modelo.CategoriaTO;
import pe.edu.upeu.app.util.ErrorLogger;


public class CategoriaDAO implements CategoriaDaoI{
    
    //Crear variables
    Statement stmt = null;
    Vector columnNames;
    Vector visitdata;
    Connection connection = ConnS.getInstance().getConnection();
    static PreparedStatement ps;
    static ErrorLogger log = new ErrorLogger(ClienteDAO.class.getName());
    ResultSet rs = null;

    public CategoriaDAO() {
        columnNames = new Vector();
        visitdata = new Vector();
    }

    @Override
    public int create(CategoriaTO d) {
        int rsId = 0;
        String[] returns = {"nombre"};
        String sql = "INSERT INTO categoria(nombre) "
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
        return rsId;
    }

    @Override
    public int update(CategoriaTO d) {
        System.out.println("actualizar d.getNombre: " + d.getNombre());
        int comit = 0;
        String sql = "UPDATE categoria SET "  + "nombre=? " + "WHERE nombre=?";
        int i = 0;
        try {
            ps = connection.prepareStatement(sql);
            ps.setString(++i, d.getNombre());
            comit = ps.executeUpdate();
        } catch (SQLException ex) {
            log.log(Level.SEVERE, "update", ex);
        }
        return comit;}

    @Override
    public int delete(String id) throws Exception {
         int comit = 0;
        String sql = "DELETE FROM categoria WHERE nombre = ?";
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
    public List<CategoriaTO> listCmb(String filter) {
        List<CategoriaTO> ls = new ArrayList();
        ls.add(new CategoriaTO());
        ls.addAll(listarCategoria());
        return ls;}

    @Override
    public List<CategoriaTO> listarCategoria() {
        List<CategoriaTO> listarclientes = new ArrayList<>();
        String sql = "SELECT * FROM categoria";
        try {
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                CategoriaTO cli = new CategoriaTO();
                cli.setNombre(rs.getString("nombre"));
                cli.setIdCategoria(rs.getInt("id_categoria"));
                listarclientes.add(cli);
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return listarclientes;}

    @Override
    public CategoriaTO buscarCategoria(int id) {
        CategoriaTO categoria = new CategoriaTO();
        String sql = "SELECT * FROM categoria WHERE id_categoria = ?";
        System.out.println("ID: "+ id);
        try {
            ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                System.out.println("nombre: "+ rs.getString("nombre"));
                categoria.setIdCategoria(rs.getInt("id_categoria"));
                categoria.setNombre(rs.getString("nombre"));
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return categoria;}

    @Override
    public void reportarCategoria() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
    
}
