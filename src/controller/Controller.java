package controller;

import access.ClienteDAO;
import access.MotocicletaElectricaDAO;
import model.ClienteModel;
import access.BicicletaDAO;
import model.BicicletaModel;
import model.MotocicletaElectricaModel;
import view.VentanaPrincipal;
import java.sql.Date;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


//Creación de la clase Controller
public class Controller implements ActionListener {
    private VentanaPrincipal ventana;
    private ControllerCliente controllerCliente;
    private ControllerBicicleta controllerBicicleta;
    private ControllerMotocicletaElectrica controllerMotocicletaElectrica;
    private ControllerIntencionCompra controllerIntencionCompra;
    
    //Creación del metodo Controller
    public Controller(){
        ventana = new VentanaPrincipal();
        asignarOyentes();
        controllerCliente = new ControllerCliente(ventana);
        controllerBicicleta = new ControllerBicicleta(ventana);
        controllerMotocicletaElectrica = new ControllerMotocicletaElectrica(ventana);
        controllerIntencionCompra = new ControllerIntencionCompra(ventana);
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
        ventana.getMenuMostrarMotocicleta().addActionListener(this);
        ventana.getMenuModificarMotocicleta().addActionListener(this);
        ventana.getMenuCrearMotocicleta().addActionListener(this);
        ventana.getMenuEliminarMotocicleta().addActionListener(this);
        ventana.getMenuBuscarMotocicletaFabricante().addActionListener(this);
        ventana.getMenuMostrarIntencionCompra().addActionListener(this);
    }
    
    //Creación del metodo actionPerformed con el switch/case para cada acción del usuario
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        String comando = actionEvent.getActionCommand();
        String primaryKey;

        switch (comando) {
            case "CLIENTEMOSTAR":
                controllerCliente.clienteMostar();
                break;
            case "CLIENTEELIMINAR":
                controllerCliente.clienteEliminar();
                controllerCliente.clienteMostar();
                break;
            case "CLIENTECREAR":
                primaryKey = controllerCliente.clientecrear();
                controllerCliente.clienteBuscarAlias(primaryKey);
                break;
            case "CLIENTEMODIFICAR":
                primaryKey = controllerCliente.clienteModificar();
                controllerCliente.clienteBuscarAlias(primaryKey);
                break;
            case "CLIENTEBUSCARALIAS":
                controllerCliente.clienteBuscarAlias();
                break;
            case "BICICLETAMOSTAR":
                controllerBicicleta.bicicletaMostar();
                break;
            case "BICICLETAELIMINAR":
                controllerBicicleta.bicicletaEliminar();
                controllerBicicleta.bicicletaMostar();
                break;
            case "BICICLETACREAR":
                primaryKey = controllerBicicleta.bicicletaCrear();
                controllerBicicleta.bicicletaBuscarFabricante(primaryKey);
                break;
            case "BICICLETAMODIFICAR":
                primaryKey = controllerBicicleta.bicicletaModificar();
                controllerBicicleta.bicicletaBuscarFabricante(primaryKey);
                break;
            case "BICICLETABUSCARFABRICANTE":
                controllerBicicleta.bicicletaBuscarFabricante();
                break;
            case "MOTOCICLETAMOSTAR":
                controllerMotocicletaElectrica.motocicletaMostar();
                break;
            case "MOTOCICLETAELIMINAR":
                controllerMotocicletaElectrica.motocicletaEliminar();
                controllerMotocicletaElectrica.motocicletaMostar();
                break;
            case "MOTOCICLETACREAR":
                primaryKey = controllerMotocicletaElectrica.motocicletaCrear();
                controllerMotocicletaElectrica.motocicletaBuscarFabricante(primaryKey);
                break;
            case "MOTOCICLETAMODIFICAR":
                primaryKey = controllerMotocicletaElectrica.motocicletaModificar();
                controllerMotocicletaElectrica.motocicletaBuscarFabricante(primaryKey);
                break;
            case "MOTOCICLETABUSCARFABRICANTE":
                controllerMotocicletaElectrica.motocicletaBuscarFabricante();
                break;
            case "INTENCIONCOMPRAMOSTRAR":
                controllerIntencionCompra.intencionCompraMostrar();
                break;
        }
        ventana.repaint();
    }
}
