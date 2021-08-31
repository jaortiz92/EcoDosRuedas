package access;

import model.ClienteModel;
import utils.ConeccionDB;

import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;

public class ClienteDAO {
    private Connection connection = null;

    public void insertarCliente(ClienteModel cliente) {
        try {
            if (connection == null) {
                connection = ConeccionDB.getConeccion();
            }
            String sql = "INSERT INTO clientes VALUES (?, ?, ?, ?, ?, ?, ?);";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, cliente.getAlias());
            statement.setString(2, cliente.getNombre());
            statement.setString(3, cliente.getApellido());
            statement.setString(4, cliente.getEmail());
            statement.setString(5, cliente.getCelular());
            statement.setString(6, cliente.getContrasena());
            statement.setDate(7, cliente.getFechaNacimiento());

            int lineasInsertadas = statement.executeUpdate();
            if (lineasInsertadas > 0) {
                JOptionPane.showMessageDialog(null, "El Cliente fue ingresado");
            }
            connection.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Cliente no agregado\nError: " + e);
        }
    }

    public ArrayList<ClienteModel> leerCliente() {
        ArrayList<ClienteModel> clientes = new ArrayList<>();
        try {
            if (connection == null) {
                connection = ConeccionDB.getConeccion();
            }
            String sql = "SELECT * FROM clientes;";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet result = statement.executeQuery();

            while (result.next()) {
                ClienteModel cliente = new ClienteModel(
                        result.getString(1),
                        result.getString(2),
                        result.getString(3),
                        result.getString(4),
                        result.getString(5),
                        result.getString(6),
                        result.getString(7));

                clientes.add(cliente);
            }
            connection.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error: " + e);
        }
        return clientes;
    }

    public void modificarCliente(ClienteModel cliente) {
        try {
            if (connection == null) {
                connection = ConeccionDB.getConeccion();
            }
            String sql = "UPDATE clientes SET nombre = ?, apellido = ?, email = ?, celular = ?, contrasena = ?, fecha_nacimiento = ? WHERE alias = ?";
            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setString(1, cliente.getNombre());
            statement.setString(2, cliente.getApellido());
            statement.setString(3, cliente.getEmail());
            statement.setString(4, cliente.getCelular());
            statement.setString(5, cliente.getContrasena());
            statement.setDate(6, cliente.getFechaNacimiento());
            statement.setString(7, cliente.getAlias());

            int lineaModificada = statement.executeUpdate();
            if (lineaModificada > 0) {
                JOptionPane.showMessageDialog(null, "El Cliente " + cliente.getAlias() + " fue modificado");
            }
            connection.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Cliente no modificado\nError: " + e);
        }
    }

    public void eliminarCliente(String alias) {
        try {
            if (connection == null) {
                connection = ConeccionDB.getConeccion();
            }
            String sql = "DELETE FROM clientes WHERE alias = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, alias);

            int lineaModificada = statement.executeUpdate();
            if (lineaModificada > 0) {
                JOptionPane.showMessageDialog(null, "El Cliente " + alias + " fue eliminado");
            }
            connection.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Cliente no eliminado\nError: " + e);
        }
    }
}
