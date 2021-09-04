package access;

import model.ClienteModel;
import model.IntencionCompraModel;
import model.MotocicletaElectricaModel;
import model.Vehiculo;
import utils.ConeccionDB;

import javax.swing.*;
import javax.xml.transform.Result;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

//Creación de la clase IntencionCompraDAO (Data Access Object)
public class IntencionCompraDAO {
    private Connection connection = null;
    
    //Creación del metodo insertarIntencionCompra
    public boolean insertarIntencionCompra(IntencionCompraModel intencionCompra, boolean esBicicleta){
        try {
            if (connection == null) {
                connection = ConeccionDB.getConeccion();
            }
            String sql;
            if (esBicicleta){
                sql = "INSERT INTO intencion_de_compra(alias_fk, fabricante_bici_fk, fecha) VALUES (?, ?, ?);";
            } else {
                sql = "INSERT INTO intencion_de_compra(alias_fk, fabricante_moto_fk, fecha) VALUES (?, ?, ?);";
            }

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, intencionCompra.getAliasComprafk().getAlias());
            statement.setString(2, intencionCompra.getFabComprafk().getFabricante());
            statement.setTimestamp(3, intencionCompra.getFechaCompra());

            int lineasInsertadas = statement.executeUpdate();
            if (lineasInsertadas > 0) {
                //JOptionPane.showMessageDialog(null, "La intencion de compra fue ingresada");
                return true;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "La intencion de compra no fue ingresada\nError: " + e);
        }
        return false;
    }
    
    //Creación del metodo leerIntencionCompra
    public ArrayList<IntencionCompraModel> leerIntencionCompra(){
        ArrayList<IntencionCompraModel> intencionesCompra = new ArrayList<>();
        try {
            if (connection == null) {
                connection = ConeccionDB.getConeccion();
            }
            String sql = "SELECT * FROM intencion_de_compra";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet result = statement.executeQuery();

            while (result.next()){
                Vehiculo vehiculo;
                if (result.getString(3) == null){
                    vehiculo = new Vehiculo(result.getString(4));
                } else {
                    vehiculo = new Vehiculo(result.getString(3));
                }

                IntencionCompraModel intencionCompra = new IntencionCompraModel(
                        result.getInt(1),
                        new ClienteModel(result.getString(2)),
                        vehiculo,
                        result.getString(5)
                );
                intencionesCompra.add(intencionCompra);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "La tabla intencion de compra genero error\nError: " + e);
        }

        return intencionesCompra;
    }
    
    //Creación del metodo eliminarIntencionCompra
    public boolean eliminarIntencionCompra(int id, String Alias) {
        try {
            if (connection == null) {
                connection = ConeccionDB.getConeccion();
            }
            String sql = "DELETE FROM intencion_de_compra WHERE codigo=? AND alias_fk=?;";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            statement.setString(2, Alias);
            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted > 0) {
                JOptionPane.showMessageDialog(null, "La motocicleta fue borrada exitosamente !");
                return true;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : "
                    + ex.getErrorCode() + "\nError :" + ex.getMessage());
        }
        return false;
    }
}
