package Controlador;

import Modelo.Cliente;
import Modelo.Empleado;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDao {

    Connection ncon;
    PreparedStatement ps;
    ResultSet rs;
    Conexion cn = new Conexion();

    public Empleado Logueo(String dniE, String pwdE) {
        // System.out.println("dni: " + dniE + " pwd: " + pwdE);
        Empleado emp = new Empleado();
        String sql = "Select * from empleado where dni_empleado=? and contrasena=?";
        try {
            ncon = cn.getConexion();
            ps = ncon.prepareStatement(sql);
            ps.setString(1, dniE);
            ps.setString(2, pwdE);
            rs = ps.executeQuery();
            if (rs.next()) {
                emp.setDni_emp(rs.getString("dni_empleado"));
                emp.setNombre_emp(rs.getString("nombre_empleado"));
                emp.setApellido_emp(rs.getString("apellido_empleado"));
                emp.setCargo_emp(rs.getString("cargo_empleado"));
                emp.setPwd_emp(rs.getString("contrasena"));
            }
            ncon.close();
        } catch (SQLException e) {
            System.out.println("Error en Logueo: " + e.getMessage());
            e.printStackTrace();
        } catch (Exception ex) {
            System.out.println("Error en Logueo: " + ex.getMessage());
            ex.printStackTrace();
        }
        return emp;

    }

    public int existeCliente(String dniC) {
        Cliente cli = new Cliente();
        int Cusuario = 0;
        String sql = "select count(*) AS cantidad from cliente where dni_cliente=?";
        try {
            ncon = cn.getConexion();
            ps = ncon.prepareStatement(sql);
            ps.setString(1, dniC);
            rs = ps.executeQuery();
            if (rs.next()) {
                Cusuario = rs.getInt("cantidad");
            }
            ncon.close();
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return Cusuario;

    }

    public Cliente buscaCliente(String dniC) {
        Cliente cli = new Cliente();
        String sql = "select *  from cliente where dni_cliente=?";
        try {
            ncon = cn.getConexion();
            ps = ncon.prepareStatement(sql);
            ps.setString(1, dniC);
            rs = ps.executeQuery();
            if (rs.next()) {
                cli.setDni_cli(rs.getString("dni_cliente"));
                cli.setNombre_cli(rs.getString("nombre_cliente"));
                cli.setApellido_cli(rs.getString("apellido_cliente"));
                cli.setTelf_cli(rs.getString("telefono"));
            }
            ncon.close();
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return cli;
    }

    public void crearCliente(Cliente cliente) {
        String sql = "INSERT INTO cliente (dni_cliente,nombre_cliente,apellido_cliente,telefono) VALUES (?,?,?,?)";
        try {
            ncon = cn.getConexion();
            ps = ncon.prepareStatement(sql);
            ps.setString(1, cliente.getDni_cli());
            ps.setString(2,"NA");
            ps.setString(3,"NA");
            ps.setString(4,"NA");
            ps.executeUpdate();
            ncon.close();
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
    }
}
