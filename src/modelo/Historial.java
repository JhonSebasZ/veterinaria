
package modelo;

public class Historial {
    private int codigo;
    private String descripcion;
    private Procedimiento Procedimiento;
    private int codigoMascota;
    
    //Constructores
    public Historial() {
    
    }

    public Historial(int codigo, String descripcion, Procedimiento Procedimiento, int codigoMascota) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.Procedimiento = Procedimiento;
        this.codigoMascota = codigoMascota;
    }
    
    // get and set
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Procedimiento getProcedimiento() {
        return Procedimiento;
    }

    public void setProcedimiento(Procedimiento Procedimiento) {
        this.Procedimiento = Procedimiento;
    }

    public int getCodigoMascota() {
        return codigoMascota;
    }

    public void setCodigoMascota(int codigoMascota) {
        this.codigoMascota = codigoMascota;
    }

    

    
}
