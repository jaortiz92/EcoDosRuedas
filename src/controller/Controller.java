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
       //Datos para Cliente
       String alias, nombre, apellido, email, celular, contrasena, fechaNacimiento = "";
       //Datos para la Bicicleta
       String fabricanteBici = "";
       int precioUnitarioBici, ano = 0;
        
        if (comando.equals("CLIENTEMOSTAR")){
            ArrayList<ClienteModel> clientes = clienteDAO.leerCliente();
            ventana.getResultados().inicializarPanelMostrarClientes(clientes);
        } 
        
        //Revisar este comando ya que elimina con exito al cliente pero al ejecutarlo se abre dos veces
        else if (comando.equals("CLIENTEELIMINAR")) {
                alias = ventana.leerDatoString("Ingresar Alias:");
                if (clienteDAO.eliminarCliente(alias)) {
                    ventana.mostrarInformacion("Se eliminó el cliente\n");
                } 
                else {
                    ventana.mostrarInformacion("No se eliminó el cliente\n");
                }
        
        }
        //revisar como continuar para convertir de string a date y para crear el cliente
        
        else if (comando.equals("ADICIONAR")) {
            alias = ventana.leerDatoString("Ingresar alias:\n");
            nombre = ventana.leerDatoString("Ingresar nombre:\n");
            apellido = ventana.leerDatoString("Ingresar apellido:\n");
            email = ventana.leerDatoString("Ingresar email:\n");
            celular = ventana.leerDatoString("Ingresar email\n");
            contrasena = ventana.leerDatoString("Ingresar contraseña\n");
            fechaNacimiento = ventana.leerDatoString("Ingresar fecha de nacimiento (YYYY-MM-DD):\n");
            if (clienteDAO.insertarCliente(cliente)) {
                ventana.mostrarInformacion("Se agregó el estudiante\n");
            } else {
                ventana.mostrarInformacion("No se agregó el estudiante\n");
            }
        }
        
        // revisar que no funciona correctamente
        else if (comando.equals("BICICLETAMOSTAR")){
            ArrayList<BicicletaModel> bicicletas = bicicletaDAO.leerBicicletas();
            ventana.getResultados().inicializarPanelMostrarBicicletas(bicicletas);
        } 
        // revisar que no me muestra los datos del metodo anterior
        else if (comando.equals("BICICLETAELIMINAR")) {
                fabricanteBici = ventana.leerDatoString("Ingresar Fabricante de la bicicleta:");
                if (bicicletaDAO.borrarBicicleta(fabricanteBici)) {
                    ventana.mostrarInformacion("Se eliminó la bicicleta\n");
                } 
                else {
                    ventana.mostrarInformacion("No se eliminó la bicicleta\n");
                }
        
        }
        ventana.repaint();
    }
    
    
}
