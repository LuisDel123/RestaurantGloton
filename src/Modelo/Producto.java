
package Modelo;


public class Producto {
    private int id_Producto;
    private String nombre_Producto;
    private String descripcion_Producto;
    private double precio_Unitario;
    private int tiempo_entregaBase;
    private int id_Categoria;

    public Producto() {
    }

    public int getId_Categoria() {
        return id_Categoria;
    }

    public void setId_Categoria(int id_Categoria) {
        this.id_Categoria = id_Categoria;
    }

    public Producto(int id_Producto, String nombre_Producto, String descripcion_Producto, double precio_Unitario, int tiempo_entregaBase, int id_Categoria) {
        this.id_Producto = id_Producto;
        this.nombre_Producto = nombre_Producto;
        this.descripcion_Producto = descripcion_Producto;
        this.precio_Unitario = precio_Unitario;
        this.tiempo_entregaBase = tiempo_entregaBase;
        this.id_Categoria = id_Categoria;
    }

    public Producto(int id_Producto, String nombre_Producto, String descripcion_Producto, double precio_Unitario, int tiempo_entregaBase) {
        this.id_Producto = id_Producto;
        this.nombre_Producto = nombre_Producto;
        this.descripcion_Producto = descripcion_Producto;
        this.precio_Unitario = precio_Unitario;
        this.tiempo_entregaBase = tiempo_entregaBase;
    }
    

    public int getId_Producto() {
        return id_Producto;
    }

    public void setId_Producto(int id_Producto) {
        this.id_Producto = id_Producto;
    }

    public String getNombre_Producto() {
        return nombre_Producto;
    }

    public void setNombre_Producto(String nombre_Producto) {
        this.nombre_Producto = nombre_Producto;
    }

    public String getDescripcion_Producto() {
        return descripcion_Producto;
    }

    public void setDescripcion_Producto(String descripcion_Producto) {
        this.descripcion_Producto = descripcion_Producto;
    }

    public double getPrecio_Unitario() {
        return precio_Unitario;
    }

    public void setPrecio_Unitario(double precio_Unitario) {
        this.precio_Unitario = precio_Unitario;
    }

    public int getTiempo_entregaBase() {
        return tiempo_entregaBase;
    }

    public void setTiempo_entregaBase(int tiempo_entregaBase) {
        this.tiempo_entregaBase = tiempo_entregaBase;
    }
    
}
