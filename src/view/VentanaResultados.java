package view;

import model.ClienteModel;
import model.BicicletaModel;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class VentanaResultados extends JPanel {
    private JPanel ventanaResultados;

    public VentanaResultados(){
        inicializarComponentes();
        setVisible(true);
    }
    //Cambio de color a gris claro
    public void inicializarComponentes(){
        setLayout(new GridLayout(1, 1));
        setBackground(Color.lightGray);
        
    }

    public void inicializarPanelMostrarClientes(ArrayList<ClienteModel> datosClientes){
        if (this.getComponentCount() != 0) remove(ventanaResultados);
        ventanaResultados = new VentanaMostrarCliente(datosClientes);
        add(ventanaResultados);
        updateUI();
    }
    //Creacion del metodo para mostrar resultados de bicicleta
    public void inicializarPanelMostrarBicicletas(ArrayList<BicicletaModel> datosBicicletas){
        if (this.getComponentCount() != 0) remove(ventanaResultados);
        ventanaResultados = new VentanaMostrarBicicleta(datosBicicletas);
        add(ventanaResultados);
        updateUI();
    }
}
