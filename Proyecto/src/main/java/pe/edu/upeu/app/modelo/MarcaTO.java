package pe.edu.upeu.app.modelo;

import lombok.Data;

@Data

public class MarcaTO {

    public int idMarca;
    public String nombre;

    @Override
    public String toString() {
        return nombre;
    }
}
