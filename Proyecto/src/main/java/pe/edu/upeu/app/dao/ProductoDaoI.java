/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package pe.edu.upeu.app.dao;

import java.util.List;
import pe.com.syscenterlife.autocomp.ModeloDataAutocomplet;
import pe.edu.upeu.app.modelo.CategoriaTO;
import pe.edu.upeu.app.modelo.MarcaTO;
import pe.edu.upeu.app.modelo.ProductoTO;

public interface ProductoDaoI {
    public int create(ProductoTO d);

    public int update(ProductoTO d);

    public int delete(String id) throws Exception;

    public List<ProductoTO> listCmb(String filter);

    public List<ProductoTO> listarProductos();

    public ProductoTO buscarProducto(int id);

    public void reportarProducto();
    
    public List<ModeloDataAutocomplet> listAutoComplet(String filter); 
    
    public List<MarcaTO> listCmbMarca(String filter);
    
    public List<CategoriaTO> listCmbCategoria(String filter);
}
