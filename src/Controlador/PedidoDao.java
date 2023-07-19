package Controlador;

import Modelo.Pedido;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PedidoDao {

    Pedido pedido = new Pedido();
    List<Pedido> listPedidos = new ArrayList<>();

    Connection ncon;
    PreparedStatement ps;
    ResultSet rs;
    Conexion cn = new Conexion();

    public List<Pedido> ListarTodosPedidos() {
        String sql = "SELECT p.id_pedido,dp.cantidad ,pr.nombre_Producto, dp.subtotal, DATE_FORMAT(dp.hora_entrega, '%H:%i') AS hora_entrega,  DATE_FORMAT(dp.hora_registro, '%H:%i') AS hora_registro, dp.estado FROM Pedido p\n"
                + "JOIN detalle_pedido dp ON p.id_pedido = dp.id_pedido_dt\n"
                + "JOIN Producto pr ON pr.id_Producto = dp.id_producto_dt";
        try {
            ncon = cn.getConexion();
            ps = ncon.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Pedido pedido = new Pedido();
                pedido.setId_Pedido(rs.getInt("id_pedido"));
                pedido.setProducto_Pedido(rs.getString("nombre_Producto"));
                pedido.setCostoTotal(rs.getDouble("subtotal"));
                pedido.setHoraEntrega(rs.getString("hora_entrega"));
                pedido.setHoraRegistro(rs.getString("hora_registro"));
                pedido.setEstado_Pedido(rs.getString("estado"));
                pedido.setCantidad(rs.getInt("cantidad"));
                listPedidos.add(pedido);
            }
            ncon.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listPedidos;

    }
}
