
package modelo;

public class Procedimiento {
    private int codigo;
    private String nombre;
    
    //Constructores
    public Procedimiento() {
    }

    public Procedimiento(int codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
    }
    
    //get and set
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
}
