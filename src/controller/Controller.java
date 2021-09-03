package controller;

import access.ClienteDAO;
import model.ClienteModel;
import access.BicicletaDAO;
import model.BicicletaModel;
import view.VentanaPrincipal;
import java.sql.Date;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


//Creación de la clase Controller
public class Controller implements ActionListener {
    private VentanaPrincipal    ventana;
    private ClienteDAO          clienteDAO;
    private BicicletaDAO        bicicletaDAO;
    
    //Creación del metodo Controller
    public Controller(){
        ventana = new VentanaPrincipal();
        asignarOyentes();
        clienteDAO = new ClienteDAO();
        bicicletaDAO = new BicicletaDAO();

    }
    
    //Creación del metodo Controller
    public void asignarOyentes(){
        ventana.getMenuMostrarCliente().addActionListener(this);
        ventana.getMenuModificarCliente().addActionListener(this);
        ventana.getMenuCrearCliente().addActionListener(this);
        ventana.getMenuEliminarCliente().addActionListener(this);
        ventana.getMenuBuscarClienteAlias().addActionListener(this);
        ventana.getMenuMostrarBicicleta().addActionListener(this);
        ventana.getMenuModificarBicicleta().addActionListener(this);
        ventana.getMenuCrearBicicleta().addActionListener(this);
        ventana.getMenuEliminarBicicleta().addActionListener(this);
        ventana.getMenuBuscarBicicletaFabricante().addActionListener(this);
    }
    
    //Creación del metodo actionPerformed con el switch/case para cada acción del usuario
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        String comando = actionEvent.getActionCommand();
        String primaryKey;

        switch (comando) {
            case "CLIENTEMOSTAR":
                clienteMostar();
                break;
            case "CLIENTEELIMINAR":
                clienteEliminar();
                clienteMostar();
                break;
            case "CLIENTECREAR":
                primaryKey = clientecrear();
                clienteBuscarAlias(primaryKey);
                break;
            case "CLIENTEMODIFICAR":
                primaryKey = clienteModificar();
                clienteBuscarAlias(primaryKey);
                break;
            case "CLIENTEBUSCARALIAS":
                clienteBuscarAlias();
                break;
            case "BICICLETAMOSTAR":
                bicicletaMostar();
                break;
            case "BICICLETAELIMINAR":
                bicicletaEliminar();
                bicicletaMostar();
                break;
            case "BICICLETACREAR":
                primaryKey = bicicletaCrear();
                bicicletaBuscarFabricante(primaryKey);
                break;
            case "BICICLETAMODIFICAR":
                primaryKey = bicicletaModificar();
                bicicletaBuscarFabricante(primaryKey);
                break;
            case "BICICLETABUSCARFABRICANTE":
                bicicletaBuscarFabricante();
        }
        ventana.repaint();
    }
    
    //Creación del metodo clienteMostrar
    private void clienteMostar(){
        ArrayList<ClienteModel> clientes = clienteDAO.leerCliente();
        ventana.getResultados().inicializarPanelMostrarClientes(clientes);
    }
    
    //Creación del metodo clienteEliminar
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
    
    //Creación del metodo clienteCrear
    private String clientecrear(){
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
        return alias;
    }

    //Creación del metodo clienteModificar
    private String clienteModificar(){
        String alias, nombre, apellido, email, celular, contrasena, fechaNacimiento;

        alias = ventana.leerDatoString("Ingresar alias a modificar:\n");
        nombre = ventana.leerDatoString("Ingresar nombre:\n");
        apellido = ventana.leerDatoString("Ingresar apellido:\n");
        email = ventana.leerDatoString("Ingresar email:\n");
        celular = ventana.leerDatoString("Ingresar celular\n");
        contrasena = ventana.leerDatoString("Ingresar contraseña\n");
        fechaNacimiento = ventana.leerDatoString("Ingresar fecha de nacimiento (YYYY-MM-DD):\n");
        ClienteModel cliente = new ClienteModel(alias, nombre, apellido, email, celular, contrasena, fechaNacimiento);
        if (clienteDAO.modificarCliente(cliente)) {
            ventana.mostrarInformacion("Se modifico el cliente\n");
        } else {
            ventana.mostrarInformacion("No se modifico el cliente\n");
        }
        return alias;
    }
    
    //Creación del metodo clienteBuscarAlias
    private void clienteBuscarAlias(String alias){
        ArrayList<ClienteModel> clientes = clienteDAO.buscarCliente(alias);
        ventana.getResultados().inicializarPanelMostrarClientes(clientes);
    }

    //Sobrecarga del metodo clienteBuscarAlias
    private void clienteBuscarAlias(){
        String alias = ventana.leerDatoString("Ingresar alias a buscar:\n");
        ArrayList<ClienteModel> clientes = clienteDAO.buscarCliente(alias);
        ventana.getResultados().inicializarPanelMostrarClientes(clientes);
    }
    
    //Creación del metodo bicicletaMostrar
    private void bicicletaMostar(){
        ArrayList<BicicletaModel> bicicletas = bicicletaDAO.leerBicicletas();
        ventana.getResultados().inicializarPanelMostrarBicicletas(bicicletas);
    }
    
    //Creación del metodo bicicletaEliminar
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
    
    //Creación del metodo bicicletaCrear
    private String bicicletaCrear(){
        String fabricanteBici;
        int precioUnitarioBici;
        int ano;
        fabricanteBici = ventana.leerDatoString("Ingresar marcar de bicicleta:\n");
        precioUnitarioBici = Integer.parseInt(ventana.leerDatoString("Ingresar precio:\n"));
        ano = Integer.parseInt(ventana.leerDatoString("Ingresar año:\n"));
        BicicletaModel bicicleta = new BicicletaModel(fabricanteBici, precioUnitarioBici, ano);
        if (bicicletaDAO.insertarBicicleta(bicicleta)) {
            ventana.mostrarInformacion("Se agregó la bicicleta\n");
        } else {
            ventana.mostrarInformacion("No se agregó la bicicleta\n");
        }
        return fabricanteBici;
    }
    
    //Creación del metodo bicicletaModificar
    private String bicicletaModificar(){
        String fabricanteBici;
        int precioUnitarioBici;
        int ano;
        fabricanteBici = ventana.leerDatoString("Ingresar marcar de bicicleta a modificar:\n");
        precioUnitarioBici = Integer.parseInt(ventana.leerDatoString("Ingresar precio:\n"));
        ano = Integer.parseInt(ventana.leerDatoString("Ingresar año:\n"));
        BicicletaModel bicicleta = new BicicletaModel(fabricanteBici, precioUnitarioBici, ano);
        if (bicicletaDAO.insertarBicicleta(bicicleta)) {
            ventana.mostrarInformacion("Se modifico la bicicleta\n");
        } else {
            ventana.mostrarInformacion("No se modifico la bicicleta\n");
        }
        return fabricanteBici;
    }
    
    //Creación del metodo bicicletaBuscarFabricante
    private void bicicletaBuscarFabricante(String fabricanteBici){
        ArrayList<BicicletaModel> bicicletas = bicicletaDAO.buscarBicicletas(fabricanteBici);
        ventana.getResultados().inicializarPanelMostrarBicicletas(bicicletas);
    }
    
    //Sobrecarga del metodo bicicletaBuscarFabricante
    private void bicicletaBuscarFabricante(){
        String fabricanteBici = ventana.leerDatoString("Ingresar fabricante de bicicleta a buscar:\n");
        ArrayList<BicicletaModel> bicicletas = bicicletaDAO.buscarBicicletas(fabricanteBici);
        ventana.getResultados().inicializarPanelMostrarBicicletas(bicicletas);
    }
}
