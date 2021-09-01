package view;

import model.ClienteModel;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class VentanaResultados extends JPanel {
    private JPanel ventanaResultados;

    public VentanaResultados(){
        inicializarComponentes();
        setVisible(true);
    }

    public void inicializarComponentes(){
        setLayout(new FlowLayout());
        setBackground(Color.GRAY);
    }

    public void inicializarPanelMostrarClientes(ArrayList<ClienteModel> datosClientes){
        if (this.getComponentCount() != 0) remove(ventanaResultados);
        ventanaResultados = new VentanaMostrarCliente(datosClientes);
        add(ventanaResultados, BorderLayout.CENTER);
        updateUI();
    }
}
