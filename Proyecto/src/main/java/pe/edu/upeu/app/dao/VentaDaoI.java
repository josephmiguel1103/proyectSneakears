
package pe.edu.upeu.app.dao;

import java.util.List;
import pe.edu.upeu.app.modelo.VentaDetalleTO;
import pe.edu.upeu.app.modelo.VentaTO;

public interface VentaDaoI {

    public int createVenta(VentaTO to);

    public List listarVentas();

    public int createVentaDetalle(VentaDetalleTO vdTo);

    public List listarVentaDetalle(VentaTO to);
    
}
