
package Modelo;

public class Pedido {
    private int Id_Pedido;
    private String producto_Pedido;
    private Double costoTotal;
    private int cantidad;

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    private String HoraEntrega;
    private String HoraRegistro;
    private String Estado_Pedido;

    public Pedido(int Id_Pedido, String producto_Pedido, Double costoTotal, int cantidad, String HoraEntrega, String HoraRegistro, String Estado_Pedido) {
        this.Id_Pedido = Id_Pedido;
        this.producto_Pedido = producto_Pedido;
        this.costoTotal = costoTotal;
        this.cantidad = cantidad;
        this.HoraEntrega = HoraEntrega;
        this.HoraRegistro = HoraRegistro;
        this.Estado_Pedido = Estado_Pedido;
    }

    public Pedido() {
    }

    public int getId_Pedido() {
        return Id_Pedido;
    }

    public void setId_Pedido(int Id_Pedido) {
        this.Id_Pedido = Id_Pedido;
    }

    public String getProducto_Pedido() {
        return producto_Pedido;
    }

    public void setProducto_Pedido(String producto_Pedido) {
        this.producto_Pedido = producto_Pedido;
    }

    public Double getCostoTotal() {
        return costoTotal;
    }

    public void setCostoTotal(Double costoTotal) {
        this.costoTotal = costoTotal;
    }

    public String getHoraEntrega() {
        return HoraEntrega;
    }

    public void setHoraEntrega(String HoraEntrega) {
        this.HoraEntrega = HoraEntrega;
    }

    public String getHoraRegistro() {
        return HoraRegistro;
    }

    public void setHoraRegistro(String HoraRegistro) {
        this.HoraRegistro = HoraRegistro;
    }

    public String getEstado_Pedido() {
        return Estado_Pedido;
    }

    public void setEstado_Pedido(String Estado_Pedido) {
        this.Estado_Pedido = Estado_Pedido;
    }
           
    
}
