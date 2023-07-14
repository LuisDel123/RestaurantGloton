
package Modelo;

public class Cliente {
    private String dni_cli;
    private String nombre_cli;
    private String apellido_cli;
    private String telf_cli;

    public Cliente(String dni_cli) {
        this.dni_cli = dni_cli;
    }

    public Cliente() {
    }
    
    
    

    public String getDni_cli() {
        return dni_cli;
    }

    public void setDni_cli(String dni_cli) {
        this.dni_cli = dni_cli;
    }

    public String getNombre_cli() {
        return nombre_cli;
    }

    public void setNombre_cli(String nombre_cli) {
        this.nombre_cli = nombre_cli;
    }

    public String getApellido_cli() {
        return apellido_cli;
    }

    public void setApellido_cli(String apellido_cli) {
        this.apellido_cli = apellido_cli;
    }

    public String getTelf_cli() {
        return telf_cli;
    }

    public void setTelf_cli(String telf_cli) {
        this.telf_cli = telf_cli;
    }

    
}
