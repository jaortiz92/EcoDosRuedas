package controller;

import access.ClienteDAO;
import model.ClienteModel;
//Importacion del DAO y Model de las bicicletas
import access.BicicletaDAO;
import model.BicicletaModel;
import view.VentanaPrincipal;
import java.sql.Date;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Controller implements ActionListener {
    private VentanaPrincipal    ventana;
    private ClienteDAO          clienteDAO;
    private BicicletaDAO        bicicletaDAO;

    public Controller(){
        ventana = new VentanaPrincipal();
        asignarOyentes();
        clienteDAO = new ClienteDAO();
        bicicletaDAO = new BicicletaDAO();

    }

    public void asignarOyentes(){
        ventana.getMenuMostrarCliente().addActionListener(this);
        ventana.getMenuModificarCliente().addActionListener(this);
        ventana.getMenuCrearCliente().addActionListener(this);
        ventana.getMenuEliminarCliente().addActionListener(this);
        //Revisar
        ventana.getMenuMostrarBicicleta().addActionListener(this);
        ventana.getMenuModificarBicicleta().addActionListener(this);
        ventana.getMenuCrearBicicleta().addActionListener(this);
        ventana.getMenuEliminarBicicleta().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        String comando = actionEvent.getActionCommand();

        switch (comando) {
            case "CLIENTEMOSTAR":
                clienteMostar();
                break;
            case "CLIENTEELIMINAR":
                clienteEliminar();
                clienteMostar();
                break;
            case "CLIENTECREAR":
                clientecrear();
                clienteMostar();
                break;
            case "BICICLETAMOSTAR":
                bicicletaMostar();
                break;
            case "BICICLETAELIMINAR":
                bicicletaEliminar();
                bicicletaMostar();
                break;
        }
        ventana.repaint();
    }

    private void clienteMostar(){
        ArrayList<ClienteModel> clientes = clienteDAO.leerCliente();
        ventana.getResultados().inicializarPanelMostrarClientes(clientes);
    }

    private void clienteEliminar(){
        String alias;
        alias = ventana.leerDatoString("Ingresar Alias:");
        if (clienteDAO.eliminarCliente(alias)) {
            ventana.mostrarInformacion("Se eliminó el cliente\n");
        }
        else {
            ventana.mostrarInformacion("No se eliminó el cliente\n");
        }
    }

    private void clientecrear(){
        String alias, nombre, apellido, email, celular, contrasena, fechaNacimiento;

        alias = ventana.leerDatoString("Ingresar alias:\n");
        nombre = ventana.leerDatoString("Ingresar nombre:\n");
        apellido = ventana.leerDatoString("Ingresar apellido:\n");
        email = ventana.leerDatoString("Ingresar email:\n");
        celular = ventana.leerDatoString("Ingresar celular\n");
        contrasena = ventana.leerDatoString("Ingresar contraseña\n");
        fechaNacimiento = ventana.leerDatoString("Ingresar fecha de nacimiento (YYYY-MM-DD):\n");
        ClienteModel cliente = new ClienteModel(alias, nombre, apellido, email, celular, contrasena, fechaNacimiento);
        if (clienteDAO.insertarCliente(cliente)) {
            ventana.mostrarInformacion("Se agregó el cliente\n");
        } else {
            ventana.mostrarInformacion("No se agregó el cliente\n");
        }
    }

    private void bicicletaMostar(){
        ArrayList<BicicletaModel> bicicletas = bicicletaDAO.leerBicicletas();
        ventana.getResultados().inicializarPanelMostrarBicicletas(bicicletas);
    }

    private void bicicletaEliminar(){
        String fabricanteBici;
        fabricanteBici = ventana.leerDatoString("Ingresar Fabricante de la bicicleta:");
        if (bicicletaDAO.borrarBicicleta(fabricanteBici)) {
            ventana.mostrarInformacion("Se eliminó la bicicleta\n");
        }
        else {
            ventana.mostrarInformacion("No se eliminó la bicicleta\n");
        }
    }
}
