package Controlador;

import Modelo.Producto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductoDao {
    Producto prodXnombre=new Producto();
    List<Producto> productoscat = new ArrayList<>();
    List<Producto> listproductos = new ArrayList<>();
    List<Producto> productosfav = new ArrayList<>();
    Double tpromedio=0.0;
    Connection ncon;
    PreparedStatement ps;
    ResultSet rs;
    Conexion cn = new Conexion();

    public List<Producto> buscarProductosPorCat(String catPD) {
        String sql = "Select * from Producto p INNER JOIN Categoria c ON p.id_Categoria_Prod = c.id_Categoria WHERE c.Nombre =?";

        try {
            ncon = cn.getConexion();
            ps = ncon.prepareStatement(sql);
            ps.setString(1, catPD);
            rs = ps.executeQuery();
            while (rs.next()) {
                Producto producto = new Producto();
                producto.setId_Producto(rs.getInt("id_Producto"));
                producto.setNombre_Producto(rs.getString("nombre_Producto"));
                producto.setDescripcion_Producto(rs.getString("descripcion_Producto"));
                producto.setPrecio_Unitario(rs.getDouble("precio_Unitario"));
                producto.setTiempo_entregaBase(rs.getInt("tiempo_entrega_minutos"));
                productoscat.add(producto);
            }
            ncon.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    return productoscat;
    }
    public Double ObtenerPromedio (int idProd){
    String sql = "SELECT IFNULL(AVG(TIMESTAMPDIFF(MINUTE, hora_registro, hora_entrega)), 0) AS tiempo_promedio FROM detalle_pedido WHERE id_producto_dt =?";
        try {
            ncon = cn.getConexion();
            ps = ncon.prepareStatement(sql);
            ps.setInt(1, idProd);
            rs = ps.executeQuery();
            while (rs.next()) {
                tpromedio=rs.getDouble("tiempo_promedio");
            }
            ncon.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    return tpromedio;
    }
    public Producto buscarProductosPorNom(String nomPr){
    String sql = "Select * from Producto WHERE nombre_Producto=?";

        try {
            ncon = cn.getConexion();
            ps = ncon.prepareStatement(sql);
            ps.setString(1, nomPr);
            rs = ps.executeQuery();
            while (rs.next()) {
                prodXnombre.setId_Producto(rs.getInt("id_Producto"));
                prodXnombre.setNombre_Producto(rs.getString("nombre_Producto"));
                prodXnombre.setDescripcion_Producto(rs.getString("descripcion_Producto"));
                prodXnombre.setPrecio_Unitario(rs.getDouble("precio_Unitario"));
                prodXnombre.setTiempo_entregaBase(rs.getInt("tiempo_entrega_minutos"));
            }
            ncon.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    return prodXnombre;
    
    }
    public List<Producto> buscarProductosFavoritos(String DNI) {
        String sql = "SELECT p.id_Producto, p.nombre_Producto, p.descripcion_Producto, p.precio_unitario, p.tiempo_entrega_minutos FROM favoritos f JOIN Producto p ON f.id_producto_fav = p.id_Producto WHERE f.id_cliente_fav = ?";

        try {
            ncon = cn.getConexion();
            ps = ncon.prepareStatement(sql);
            ps.setString(1, DNI);
            rs = ps.executeQuery();
            while (rs.next()) {
                Producto producto = new Producto();
                producto.setId_Producto(rs.getInt("id_Producto"));
                producto.setNombre_Producto(rs.getString("nombre_Producto"));
                producto.setDescripcion_Producto(rs.getString("descripcion_Producto"));
                producto.setPrecio_Unitario(rs.getDouble("precio_Unitario"));
                producto.setTiempo_entregaBase(rs.getInt("tiempo_entrega_minutos"));
                productosfav.add(producto);
            }
            ncon.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    return productosfav;
    }
    
    public List<Producto> listarProductos( ) {
        String sql = "Select * from Producto ";

        try {
            ncon = cn.getConexion();
            ps = ncon.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Producto producto = new Producto();
                producto.setId_Producto(rs.getInt("id_Producto"));
                producto.setNombre_Producto(rs.getString("nombre_Producto"));
                producto.setDescripcion_Producto(rs.getString("descripcion_Producto"));
                producto.setPrecio_Unitario(rs.getDouble("precio_Unitario"));
                producto.setTiempo_entregaBase(rs.getInt("tiempo_entrega_minutos"));
                producto.setId_Categoria(rs.getInt("id_Categoria_Prod"));
                listproductos.add(producto);
            }
            ncon.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    return listproductos;
    }
    public void crearProducto(Producto pro) {
        String sql = "INSERT INTO producto  (nombre_Producto, descripcion_Producto, precio_unitario, tiempo_entrega_minutos, id_Categoria_Prod) VALUES (?, ?, ?, ?, ?);";
        try {
            ncon = cn.getConexion();
            ps = ncon.prepareStatement(sql);
            ps.setString(1, pro.getNombre_Producto());
            ps.setString(2,pro.getDescripcion_Producto());
            ps.setDouble(3,pro.getPrecio_Unitario());
            ps.setInt(4,pro.getTiempo_entregaBase());
            ps.setInt(5,pro.getId_Categoria());
            ps.executeUpdate();
            ncon.close();
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
    }
}
