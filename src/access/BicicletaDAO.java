package access;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import java.util.ArrayList;
import model.BicicletaModel;
import utils.ConeccionDB;


//Creación de la clase BicicletaDAO (Data Access Object)
public class BicicletaDAO {
    private Connection conn = null;
    
    //Creación del metodo leerBicicletas
    public ArrayList<BicicletaModel> leerBicicletas() {
        ArrayList<BicicletaModel> bicicletas = new ArrayList<>();
        try {
            if(conn == null)
                conn = ConeccionDB.getConeccion();
            
            String sql = "SELECT fabricante, precio_unitario, ano FROM bicicletas ORDER BY fabricante, ano;";
            Statement statement = conn.createStatement();
            ResultSet result    = statement.executeQuery(sql);
            
            while (result.next()) {
                BicicletaModel bicicleta = new BicicletaModel(result.getString(1), result.getInt(2), result.getInt(3));
                bicicletas.add(bicicleta);
            }
        } 
        catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : " + ex.getErrorCode() 
                                        + "\nError :" + ex.getMessage());
        }
        return bicicletas;
    }
    
    //Creación del metodo buscarBicicletas
    public ArrayList<BicicletaModel> buscarBicicletas(String fabricanteBici) {
        ArrayList<BicicletaModel> bicicletas = new ArrayList<>();
        try {
            if(conn == null)
                conn = ConeccionDB.getConeccion();

            String sql = "SELECT fabricante, precio_unitario, ano FROM bicicletas WHERE fabricante = ? ORDER BY fabricante, ano;";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, fabricanteBici);
            ResultSet result    = statement.executeQuery();

            while (result.next()) {
                BicicletaModel bicicleta = new BicicletaModel(result.getString(1), result.getInt(2), result.getInt(3));
                bicicletas.add(bicicleta);
            }
        }
        catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : " + ex.getErrorCode()
                    + "\nError :" + ex.getMessage());
        }
        return bicicletas;
    }

    //Creación del metodo insertarBicicleta
    public boolean insertarBicicleta(BicicletaModel bicicleta){
        try {
            if(conn == null)
                conn = ConeccionDB.getConeccion();
            
            String sql = "INSERT INTO bicicletas(fabricante, precio_unitario, ano) VALUES (?, ?, ?);";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, bicicleta.getFabricante());
            statement.setInt(2, bicicleta.getPrecioUnitario());
            statement.setInt(3, bicicleta.getAno());
            
            int rowsInserted = statement.executeUpdate();
            if(rowsInserted > 0) 
                //JOptionPane.showMessageDialog(null, "La bicicleta fue agregada exitosamente !");
                return true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : " + ex.getErrorCode() 
                                        + "\nError :" + ex.getMessage());
        }
        return false;
    }
    
    //Creación del metodo modificarBicicletas
    public void modificarBicicleta(BicicletaModel bicicleta) {
        try {
            if(conn == null)
                conn = ConeccionDB.getConeccion();
            
            String sql = "UPDATE bicicletas SET precio_unitario=?, ano=? WHERE fabricante=?;";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, bicicleta.getPrecioUnitario());
            statement.setInt(2, bicicleta.getAno());
            statement.setString(3, bicicleta.getFabricante());
            
            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) 
                JOptionPane.showMessageDialog(null, "La bicicleta fue actualizada exitosamente !");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : " + ex.getErrorCode() 
                                        + "\nError :" + ex.getMessage());
        }
    }
    
    //Creación del metodo borrarBicicletas
    public boolean borrarBicicleta(String id) {
        try {
            if(conn == null)
                conn = ConeccionDB.getConeccion();
            
            String sql = "DELETE FROM bicicletas WHERE fabricante=?;";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, id);
            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted > 0) {
                //JOptionPane.showMessageDialog(null, "La bicicleta fue borrada exitosamente !");
                return true;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : "
                    + ex.getErrorCode() + "\nError :" + ex.getMessage());
        }
        return false;
    }
}