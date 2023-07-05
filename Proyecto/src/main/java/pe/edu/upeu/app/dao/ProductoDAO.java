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
import pe.com.syscenterlife.autocomp.ModeloDataAutocomplet;
import pe.edu.upeu.app.conx.ConnS;
import pe.edu.upeu.app.modelo.CategoriaTO;
import pe.edu.upeu.app.modelo.MarcaTO;
import pe.edu.upeu.app.modelo.ProductoTO;
import pe.edu.upeu.app.util.ErrorLogger;

public class ProductoDAO implements ProductoDaoI {

    ConnS instance = ConnS.getInstance();
    Connection connection = instance.getConnection();
    Statement stmt = null;
    Vector columnNames;
    Vector visitdata;
    
    static PreparedStatement ps;
    static ErrorLogger log = new ErrorLogger(ProductoDAO.class.getName());
    ResultSet rs = null;



    @Override
    public int create(ProductoTO d) {
        int rsId = 0;
        String[] returns = {"nombre"};
        String sql = "INSERT INTO producto(nombre,pu,utilidad,stock,id_categoria,id_marca) "
                + "VALUES(?,?,?,?,?,?)";
        int i = 0;
        System.out.println("Create categoria" + d.getIdCategoria());
        System.out.println("Create marca" + d.getIdMarca());
        try {

            ps = connection.prepareStatement(sql, returns);
            ps.setString(++i, d.getNombre());
            ps.setDouble(++i, d.getPu());
            ps.setDouble(++i, d.getUtilidad());
            ps.setDouble(++i, d.getStock());
            ps.setInt(++i, d.getIdCategoria());
            ps.setInt(++i, d.getIdMarca());
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
    public int update(ProductoTO d) {
        System.out.println("actualizar d.getNombre: " + d.getNombre());
        int comit = 0;
        String sql = "UPDATE producto SET "
                + "nombre=? "
                + "pu=?, "
                + "utilidad=?, "
                + "stock=?, "
                + "id_categoria=?, "
                + "id_marca=? "
                + "WHERE id_producto=?";
        int i = 0;
        try {
            ps = connection.prepareStatement(sql);
            ps.setString(++i, d.getNombre());
            ps.setDouble(++i, d.getPu());
            ps.setDouble(++i, d.getUtilidad());
            ps.setDouble(++i, d.getStock());
            ps.setInt(++i, d.getIdCategoria());
            ps.setInt(++i, d.getIdMarca());
            ps.setInt(++i, d.getIdProducto());
            comit = ps.executeUpdate();
        } catch (SQLException ex) {
            log.log(Level.SEVERE, "update", ex);
        }
        return comit;
    }

    @Override
    public int delete(String id) throws Exception {
        int comit = 0;
        String sql = "DELETE FROM producto WHERE nombre = ?";
        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, id);
            comit = ps.executeUpdate();
        } catch (SQLException ex) {
            log.log(Level.SEVERE, "delete", ex);
            // System.err.println("NO del " + ex.toString());
            throw new Exception("Detalle:" + ex.getMessage());
        }
        return comit;
    }

    @Override
    public List<ProductoTO> listCmb(String filter) {
        List<ProductoTO> ls = new ArrayList();
        ls.add(new ProductoTO());
        ls.addAll(listarProductos());
        return ls;
    }

    @Override
    public List<ProductoTO> listarProductos() {
        List<ProductoTO> listarproducto = new ArrayList<>();
        String sql = "SELECT * FROM producto";
        try {
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                ProductoTO uTO = new ProductoTO();
                uTO.setIdProducto(rs.getInt("id_producto"));
                uTO.setNombre(rs.getString("nombre"));
                uTO.setPu(rs.getDouble("pu"));
                uTO.setUtilidad(rs.getDouble("utilidad"));
                uTO.setStock(rs.getDouble("stock"));
                uTO.setIdCategoria(rs.getInt("id_categoria"));
                uTO.setIdMarca(rs.getInt("id_marca"));
                listarproducto.add(uTO);
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return listarproducto;
    }

    @Override
    public ProductoTO buscarProducto(int id) {
        ProductoTO uTO = new ProductoTO();
        String sql = "SELECT * FROM producto WHERE id_producto = ?";
        System.out.println("ID: " + id);
        try {
            ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                System.out.println("nombre: " + rs.getString("nombre"));
                uTO.setIdProducto(rs.getInt("id_producto"));
                uTO.setNombre(rs.getString("nombre"));
                uTO.setPu(rs.getDouble("pu"));
                uTO.setUtilidad(rs.getDouble("utilidad"));
                uTO.setStock(rs.getDouble("stock"));
                uTO.setIdCategoria(rs.getInt("id_categoria"));
                uTO.setIdMarca(rs.getInt("id_marca"));
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return uTO;
    }

    @Override
    public void reportarProducto() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<ModeloDataAutocomplet> listAutoComplet(String filter) {
        List<ModeloDataAutocomplet> listarProducto = new ArrayList();
        String sql = "select * from producto where nombre like ?";
        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, filter + "%");
            rs = ps.executeQuery();
            while (rs.next()) {
                ModeloDataAutocomplet data = new ModeloDataAutocomplet();
                ModeloDataAutocomplet.TIPE_DISPLAY = "ID";
                data.setIdx(rs.getString("nombre"));
                data.setNombreDysplay(rs.getString("id_producto"));
                data.setOtherData(rs.getDouble("pu") + ":" + rs.getDouble("stock"));
                listarProducto.add(data);
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return listarProducto;
    }

    @Override
    public List<MarcaTO> listCmbMarca(String filter) {
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
        return listarMarca;
    }

    @Override
    public List<CategoriaTO> listCmbCategoria(String filter) {
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
        return listarclientes;
    }
}
