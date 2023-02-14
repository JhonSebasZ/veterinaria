
package modelo;

public class Raza {
    private int codigoRaza;
    private String nombreRaza;
    
    //Constructores
    public Raza(){
        
    }
    
    public Raza(int codigoRaza, String nombreRaza) {
        this.codigoRaza = codigoRaza;
        this.nombreRaza = nombreRaza;
    }
    
    //get and set
    public int getCodigoRaza() {
        return codigoRaza;
    }

    public void setCodigoRaza(int codigoRaza) {
        this.codigoRaza = codigoRaza;
    }

    public String getNombreRaza() {
        return nombreRaza;
    }

    public void setNombreRaza(String nombreRaza) {
        this.nombreRaza = nombreRaza;
    }
}
