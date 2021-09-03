package access;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import java.util.ArrayList;
import model.MotocicletaElectricaModel;
import utils.ConeccionDB;


//Creación de la clase MotocicletaElectricaDAO (Data Access Object)
public class MotocicletaElectricaDAO {
    private Connection conn = null;
    
    //Creación del metodo leerMotocicletas
    public ArrayList<MotocicletaElectricaModel> leerMotocicletas() {
        ArrayList<MotocicletaElectricaModel> motocicletas = new ArrayList<>();
        try {
            if(conn == null)
                conn = ConeccionDB.getConeccion();
            
            String sql = "SELECT fabricante, precio_unitario, autonomia, proveedor_del_motor_fk FROM motocicletas_electricas;";
            Statement statement = conn.createStatement();
            ResultSet result    = statement.executeQuery(sql);
            
            while (result.next()) {
                MotocicletaElectricaModel motocicleta = new MotocicletaElectricaModel(result.getString(1), result.getInt(2), result.getInt(3), result.getString(4));
                motocicletas.add(motocicleta);
            }
        } 
        catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : " + ex.getErrorCode() 
                                        + "\nError :" + ex.getMessage());
        }
        return motocicletas;
    }
    
    //Creación del metodo insertarMotocicletaElectrica
    public void insertarMotocicletaElectrica(MotocicletaElectricaModel motocicleta){
        try {
            if(conn == null)
                conn = ConeccionDB.getConeccion();
            
            String sql = "INSERT INTO motocicletas_electricas(fabricante, precio_unitario, autonomia, proveedor_del_motor_fk) VALUES (?, ?, ?, ?);";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, motocicleta.getFabricante());
            statement.setInt(2, motocicleta.getPrecioUnitario());
            statement.setInt(3, motocicleta.getAutonomia());
            statement.setString(4, motocicleta.getProvMotorfk());
            
            int rowsInserted = statement.executeUpdate();
            if(rowsInserted > 0) 
                JOptionPane.showMessageDialog(null, "La motocicleta fue agregada exitosamente !");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : " + ex.getErrorCode() 
                                        + "\nError :" + ex.getMessage());
        }
    }
    
    //Creación del metodo modificarMotocicletaElectrica
    public void modificarMotocicletaElectrica(MotocicletaElectricaModel motocicleta) {
        try {
            if(conn == null)
                conn = ConeccionDB.getConeccion();
            
            String sql = "UPDATE motocicletas_electricas SET precio_unitario=?, autonomia=?, proveedor_del_motor_fk=? WHERE fabricante=?;";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, motocicleta.getPrecioUnitario());
            statement.setInt(2, motocicleta.getAutonomia());
            statement.setString(3, motocicleta.getProvMotorfk());
            statement.setString(4, motocicleta.getFabricante());
            
            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) 
                JOptionPane.showMessageDialog(null, "La motocicleta fue actualizada exitosamente !");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : " + ex.getErrorCode() 
                                        + "\nError :" + ex.getMessage());
        }
    }
    
    //Creación del metodo borrarMotocicletaElectrica
    public void borrarMotocicleta(String id) {
        try {
            if(conn == null)
                conn = ConeccionDB.getConeccion();
            
            String sql = "DELETE FROM motocicletas_electricas WHERE fabricante=?;";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, id);
            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted > 0) {
                JOptionPane.showMessageDialog(null, "La motocicleta fue borrada exitosamente !");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : "
                    + ex.getErrorCode() + "\nError :" + ex.getMessage());
        }
    }
}