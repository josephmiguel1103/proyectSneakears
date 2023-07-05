package pe.edu.upeu.app.modelo;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ProductoTO {

    public int idProducto, idCategoria, idMarca;
    public String  nombre,unidMed;
    public double pu, utilidad, stock, precioUnid, cantMayor;

}
