package Conexion;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

/**
 * Created by esva on 9/05/17.
 */
public class ActualizarSQL {

    public static void actualizarProducto (String nombre, String presentacion, String proveedor, double costo, double precio, String pathFoto, boolean activo) {
        String sql = "UPDATE Producto SET proveedor = ?, costo = ?, precio = ?, path_foto = ?, activo = ? WHERE nombre = ? and presentacion = ?";
        try {
            PreparedStatement ps = ConexionSQL.getConexion().prepareStatement(sql);
            ps.setString(1, proveedor);
            ps.setDouble(2, costo);
            ps.setDouble(3, precio);
            ps.setString(4, pathFoto);
            ps.setBoolean(5, activo);
            ps.setString(6, nombre);
            ps.setString(7, presentacion);
            ps.executeUpdate();
        } catch (SQLIntegrityConstraintViolationException sqlConstraint) {
            System.out.println(sqlConstraint.getMessage());
        } catch (SQLException sqlException) {
            System.out.println(sqlException.getMessage());
        }
    }

}
