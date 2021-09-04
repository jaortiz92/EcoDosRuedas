package view;

import model.*;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

//Creación de la clase VentanaResultados
public class VentanaResultados extends JPanel {
    private JPanel ventanaResultados;

    //Creación del metodo constructor
    public VentanaResultados(){
        inicializarComponentes();
        setVisible(true);
    }
    
    //Creación del metodo inicializarComponentes
    public void inicializarComponentes(){
        setLayout(new GridLayout(1, 1));
        setBackground(Color.lightGray);
    }

    //Creación del metodo inicializarPanelMostrarClientes
    public void inicializarPanelMostrarClientes(ArrayList<ClienteModel> datosClientes){
        if (this.getComponentCount() != 0) remove(ventanaResultados);
        ventanaResultados = new VentanaMostrarCliente(datosClientes);
        add(ventanaResultados);
        updateUI();
    }
    //Creación del metodo inicializarPanelMostrarBicicletas
    public void inicializarPanelMostrarBicicletas(ArrayList<BicicletaModel> datosBicicletas){
        if (this.getComponentCount() != 0) remove(ventanaResultados);
        ventanaResultados = new VentanaMostrarBicicleta(datosBicicletas);
        add(ventanaResultados);
        updateUI();
    }

    //Creación del metodo inicializarPanelMostrarMotocicletas
    public void inicializarPanelMostrarMotocicletas(ArrayList<MotocicletaElectricaModel> datosMotocicletasElectricas){
        if (this.getComponentCount() != 0) remove(ventanaResultados);
        ventanaResultados = new VentanaMostrarMotocicletaElectrica(datosMotocicletasElectricas);
        add(ventanaResultados);
        updateUI();
    }

    public void inicializarPanelMostrarIntencionCompra(ArrayList<IntencionCompraModel> intencionesCompras){
        if (this.getComponentCount() != 0) remove(ventanaResultados);
        ventanaResultados = new VentanaMostrarIntencionCompra(intencionesCompras);
        add(ventanaResultados);
        updateUI();
    }

    public void inicializarPanelFormularioIntencionCompra(ArrayList<ClienteModel> clientes, ArrayList<Vehiculo> vehiculos){
        if (this.getComponentCount() != 0) remove(ventanaResultados);
        ventanaResultados = new VentanaFormularioIntencionCompra(clientes, vehiculos);
        add(ventanaResultados);
        updateUI();
    }
}
