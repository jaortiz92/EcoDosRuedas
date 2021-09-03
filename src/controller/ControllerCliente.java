package controller;

import access.ClienteDAO;
import model.ClienteModel;
import view.VentanaPrincipal;

import java.util.ArrayList;

public class ControllerCliente {

    private VentanaPrincipal ventana;
    private ClienteDAO clienteDAO;

    public ControllerCliente(VentanaPrincipal ventana){
        clienteDAO = new ClienteDAO();
        this.ventana = ventana;
    }

    //Creación del metodo clienteMostrar
    public void clienteMostar(){
        ArrayList<ClienteModel> clientes = clienteDAO.leerCliente();
        ventana.getResultados().inicializarPanelMostrarClientes(clientes);
    }

    //Creación del metodo clienteEliminar
    public void clienteEliminar(){
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
    public String clientecrear(){
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
    public String clienteModificar(){
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
    public void clienteBuscarAlias(String alias){
        ArrayList<ClienteModel> clientes = clienteDAO.buscarCliente(alias);
        ventana.getResultados().inicializarPanelMostrarClientes(clientes);
    }

    //Sobrecarga del metodo clienteBuscarAlias
    public void clienteBuscarAlias(){
        String alias = ventana.leerDatoString("Ingresar alias a buscar:\n");
        ArrayList<ClienteModel> clientes = clienteDAO.buscarCliente(alias);
        ventana.getResultados().inicializarPanelMostrarClientes(clientes);
    }

}
