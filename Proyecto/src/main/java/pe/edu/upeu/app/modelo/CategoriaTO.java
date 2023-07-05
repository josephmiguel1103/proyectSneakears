
package pe.edu.upeu.app.modelo;

import lombok.Data;

@Data
public class CategoriaTO {    
    public String  nombre;
    public int idCategoria;
    
    @Override
    public String toString(){
     return nombre;
    }
}
