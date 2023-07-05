package pe.edu.upeu.app.modelo;

import lombok.Data;

@Data
public class VentaTO {

    public int idVenta;
    public String dniruc;
    public double preciobase, igv, precioTotal;
}
