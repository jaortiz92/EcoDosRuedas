package controller;

import access.ClienteDAO;
import model.ClienteModel;
import view.VentanaPrincipal;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Controller implements ActionListener {
    private VentanaPrincipal ventana;
    private ClienteDAO clienteDAO;

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
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        String comando = actionEvent.getActionCommand();
        if (comando.equals("CLIENTEMOSTAR")){
            ArrayList<ClienteModel> clientes = clienteDAO.leerCliente();
            ventana.getResultados().inicializarPanelMostrarClientes(clientes);
        }
        ventana.repaint();
    }
}
