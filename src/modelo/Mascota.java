
package modelo;


public class Mascota {
    private int codigo;
    private String nombreResponsable;
    private String nombreMascota;
    private Raza raza;
    private String numeroContacto;

    // Constructor
    public Mascota(){
        
    }
    
    public Mascota( String nombreResponsable, String nombreMascota, Raza raza, String numeroContacto) {
        this.codigo = 0;
        this.nombreResponsable = nombreResponsable;
        this.nombreMascota = nombreMascota;
        this.raza = raza;
        this.numeroContacto = numeroContacto;
    }
    
    // Get and Set
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombreResponsable() {
        return nombreResponsable;
    }

    public void setNombreResponsable(String nombreResponsable) {
        this.nombreResponsable = nombreResponsable;
    }

    public String getNombreMascota() {
        return nombreMascota;
    }

    public void setNombreMascota(String nombreMascota) {
        this.nombreMascota = nombreMascota;
    }

    public Raza getRaza() {
        return raza;
    }

    public void setRaza(Raza raza) {
        this.raza = raza;
    }

    public String getNumeroContacto() {
        return numeroContacto;
    }

    public void setNumeroContacto(String numeroContacto) {
        this.numeroContacto = numeroContacto;
    }

}
