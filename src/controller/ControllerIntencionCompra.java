package controller;

import access.BicicletaDAO;
import access.ClienteDAO;
import access.IntencionCompraDAO;
import access.MotocicletaElectricaDAO;
import model.*;
import view.VentanaFormularioIntencionCompra;
import view.VentanaPrincipal;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

//Creación de la clase ControllerIntencionCompra
public class ControllerIntencionCompra implements ActionListener {
    private VentanaPrincipal ventana;
    private IntencionCompraDAO intencionCompraDAO;
    private ClienteDAO clienteDAO;
    private BicicletaDAO bicicletaDAO;
    private MotocicletaElectricaDAO motocicletaElectricaDAO;
    private VentanaFormularioIntencionCompra ventanaFormularioIntencionCompra;

    //Creación del metodo Constructor
    ControllerIntencionCompra(VentanaPrincipal ventana) {
        intencionCompraDAO = new IntencionCompraDAO();
        clienteDAO = new ClienteDAO();
        bicicletaDAO = new BicicletaDAO();
        motocicletaElectricaDAO = new MotocicletaElectricaDAO();
        this.ventana = ventana;
    }

    //Creación del metodo intencionCompraMostrar
    public void intencionCompraMostrar() {
        ArrayList<IntencionCompraModel> intencionesCompras = intencionCompraDAO.leerIntencionCompra();
        ventana.getResultados().inicializarPanelMostrarIntencionCompra(intencionesCompras);
    }
    
    //Creación del metodo intencionCompraCrear
    public void intencionCompraCrear() {
        ArrayList<ClienteModel> clientes = clienteDAO.leerCliente();
        ArrayList<Vehiculo> vehiculos = new ArrayList<>(motocicletaElectricaDAO.leerMotocicletas());
        vehiculos.addAll(bicicletaDAO.leerBicicletas());
        ventanaFormularioIntencionCompra = ventana.getResultados().inicializarPanelFormularioIntencionCompra(clientes, vehiculos);
        ventanaFormularioIntencionCompra.getAgregarIntencionCompraBoton().addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        String comando = actionEvent.getActionCommand();

        switch (comando) {
            case "agregarIntencionCompra":
                agregarIntencionCompra();
                intencionCompraMostrar();
                break;
        }
        ventana.repaint();
    }
    
    //Creación del metodo agregarIntencionCompra
    public void agregarIntencionCompra() {
        String[] cliente = ventanaFormularioIntencionCompra.getComboBoxClientes().getSelectedItem().toString().split(": ");
        String[] vehiculo = ventanaFormularioIntencionCompra.getComboBoxVehiculos().getSelectedItem().toString().split(": ");
        if (vehiculo[0].equalsIgnoreCase("Bicicleta")){

            if(intencionCompraDAO.insertarIntencionCompra(new IntencionCompraModel(
                    new ClienteModel(cliente[0]),
                    new Vehiculo(vehiculo[1])), true)){
                ventana.mostrarInformacion("La intencion de compra fue ingresada");
            } else {
                ventana.mostrarInformacion("La intencion de compra no fue ingresada");
            }

        } else {
            if(intencionCompraDAO.insertarIntencionCompra(new IntencionCompraModel(
                    new ClienteModel(cliente[0]),
                    new Vehiculo(vehiculo[1])), false)){
                ventana.mostrarInformacion("La intencion de compra fue ingresada");
            } else {
                ventana.mostrarInformacion("La intencion de compra no fue ingresada");
            }
        }

    }
}
