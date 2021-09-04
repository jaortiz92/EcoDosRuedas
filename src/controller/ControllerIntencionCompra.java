package controller;

import access.BicicletaDAO;
import access.ClienteDAO;
import access.IntencionCompraDAO;
import access.MotocicletaElectricaDAO;
import model.*;
import view.VentanaPrincipal;

import java.util.ArrayList;

public class ControllerIntencionCompra {
    private VentanaPrincipal ventana;
    private IntencionCompraDAO intencionCompraDAO;
    private ClienteDAO clienteDAO;
    private BicicletaDAO bicicletaDAO;
    private MotocicletaElectricaDAO motocicletaElectricaDAO;

    ControllerIntencionCompra(VentanaPrincipal ventana){
        intencionCompraDAO = new IntencionCompraDAO();
        clienteDAO = new ClienteDAO();
        bicicletaDAO = new BicicletaDAO();
        motocicletaElectricaDAO = new MotocicletaElectricaDAO();
        this.ventana = ventana;
    }

    public void intencionCompraMostrar(){
        ArrayList<IntencionCompraModel> intencionesCompras = intencionCompraDAO.leerIntencionCompra();
        ventana.getResultados().inicializarPanelMostrarIntencionCompra(intencionesCompras);
    }

    public void intencionCompraCrear(){
        ArrayList<ClienteModel> clientes = clienteDAO.leerCliente();

        ArrayList<Vehiculo> vehiculos = new ArrayList<>(motocicletaElectricaDAO.leerMotocicletas());
        vehiculos.addAll(bicicletaDAO.leerBicicletas());
        ventana.getResultados().inicializarPanelFormularioIntencionCompra(clientes, vehiculos);

    }
}
