
package Modelo;

public class Empleado {
    private String dni_emp;
    private String nombre_emp;
    private String apellido_emp;
    private String cargo_emp;
    private String pwd_emp;

    public Empleado() {
    }

    public Empleado(String dni_emp, String nombre_emp, String apellido_emp, String cargo_emp, String pwd_emp) {
        this.dni_emp = dni_emp;
        this.nombre_emp = nombre_emp;
        this.apellido_emp = apellido_emp;
        this.cargo_emp = cargo_emp;
        this.pwd_emp = pwd_emp;
    }

    public String getDni_emp() {
        return dni_emp;
    }

    public void setDni_emp(String dni_emp) {
        this.dni_emp = dni_emp;
    }

    public String getNombre_emp() {
        return nombre_emp;
    }

    public void setNombre_emp(String nombre_emp) {
        this.nombre_emp = nombre_emp;
    }

    public String getApellido_emp() {
        return apellido_emp;
    }

    public void setApellido_emp(String apellido_emp) {
        this.apellido_emp = apellido_emp;
    }

    public String getCargo_emp() {
        return cargo_emp;
    }

    public void setCargo_emp(String cargo_emp) {
        this.cargo_emp = cargo_emp;
    }

    public String getPwd_emp() {
        return pwd_emp;
    }

    public void setPwd_emp(String pwd_emp) {
        this.pwd_emp = pwd_emp;
    }
    
}
