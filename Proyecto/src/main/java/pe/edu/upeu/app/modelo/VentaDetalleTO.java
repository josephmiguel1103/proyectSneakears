package pe.edu.upeu.app.modelo;

import lombok.Data;

@Data
public class VentaDetalleTO {
    
    public int idVentaDetalle,idVenta,idProducto;
    public double cantidad, pu, descuento, subtotal;
}
