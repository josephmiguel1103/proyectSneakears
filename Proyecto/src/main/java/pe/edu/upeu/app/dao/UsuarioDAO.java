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
import pe.edu.upeu.app.modelo.UsuarioTO;
import pe.edu.upeu.app.util.ErrorLogger;


public class UsuarioDAO implements UsuarioDaoI{
    
    Statement stmt = null;
    Vector columnNames;
    Vector visitdata;
    Connection connection = ConnS.getInstance().getConnection();
    static PreparedStatement ps;
    static ErrorLogger log = new ErrorLogger(ClienteDAO.class.getName());
    ResultSet rs = null;

    public UsuarioDAO() {
        columnNames = new Vector();
        visitdata = new Vector();
    }

    @Override
    public int create(UsuarioTO d) {
        int rsId = 0;
        String[] returns = {"nombre"};
        String sql = "INSERT INTO usuario(nombre,apellido,usuario,clave) "
                + "VALUES(?,?,?,?)";
        int i = 0;
        try {
            ps = connection.prepareStatement(sql, returns);
            ps.setString(++i, d.getNombre());
            ps.setString(++i, d.getApellido());
            ps.setString(++i, d.getUsuario());
            ps.setString(++i, d.getClave());
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
    public int update(UsuarioTO d) {
        System.out.println("actualizar d.getNombre: " + d.getNombre());
        int comit = 0;
        String sql = "UPDATE usuario SET "  + "nombre=? " + "WHERE id_usuario=?";
        int i = 0;
        try {
            ps = connection.prepareStatement(sql);
            ps.setString(++i, d.getNombre());
            //ps.setString(++i, d.getApellido());
            //ps.setString(++i, d.getUsuario());
            //ps.setString(++i, d.getClave());
            ps.setInt(++i, d.getIdUsuario());
            comit = ps.executeUpdate();
        } catch (SQLException ex) {
            log.log(Level.SEVERE, "update", ex);
        }
        return comit;}

    @Override
    public int delete(String id) throws Exception {
         int comit = 0;
        String sql = "DELETE FROM usuario WHERE nombre = ?";
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
    public List<UsuarioTO> listCmb(String filter) {
        List<UsuarioTO> ls = new ArrayList();
        ls.add(new UsuarioTO());
        ls.addAll(listarUsuario());
        return ls;
    }

    @Override
    public List<UsuarioTO> listarUsuario() {
        List<UsuarioTO> listarusuario = new ArrayList<>();
        String sql = "SELECT * FROM usuario";
        try {
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                UsuarioTO uTO = new UsuarioTO();
                uTO.setIdUsuario(rs.getInt("id_usuario"));
                uTO.setNombre(rs.getString("nombre"));
                uTO.setApellido(rs.getString("apellido"));
                uTO.setUsuario(rs.getString("usuario"));
                uTO.setClave(rs.getString("clave"));
                listarusuario.add(uTO);
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return listarusuario;
    }

    @Override
    public UsuarioTO buscarUsuario(int id) {
        UsuarioTO usuario= new UsuarioTO();
        String sql = "SELECT * FROM usuario WHERE id_usuario = ?";
        System.out.println("ID: "+ id);
        try {
            ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                System.out.println("nombre: "+ rs.getString("nombre"));
                usuario.setIdUsuario(rs.getInt("id_usuario"));
                usuario.setNombre(rs.getString("nombre"));
                usuario.setApellido(rs.getString("apellido"));
                usuario.setUsuario(rs.getString("usuario"));
                usuario.setClave(rs.getString("clave"));
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return usuario;}

    @Override
    public void reportarUsuario() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
    
}
