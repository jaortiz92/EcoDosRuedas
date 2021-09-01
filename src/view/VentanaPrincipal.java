package view;

import model.ClienteModel;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class VentanaPrincipal extends JFrame {

    private JMenuBar menuBar;
    private JMenu menuCliente;
    private JMenu menuBicicleta;
    private JMenu menuMotocicleta;
    private JMenu menuIntencionCompra;
    private JMenuItem menuMostrarCliente;
    private JMenuItem menuCrearCliente;
    private JMenuItem menuModificarCliente;
    private JMenuItem menuEliminarCliente;



    private VentanaMostrarCliente ventanaMostrarCliente;

    public VentanaPrincipal(){
        setTitle("EcoDosRuedas");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.BLUE);

        inicializarComponente();
        setResizable(true);
        setLocationRelativeTo(null);
        setVisible(true);

    }

    public void inicializarComponente(){
        menuBar = new JMenuBar();
        setJMenuBar(menuBar);


        agregarMenuClientes();


    }

    public void inicializarPanelMostrarClientes(ArrayList<ClienteModel> datosClientes){
        ventanaMostrarCliente = new VentanaMostrarCliente(datosClientes);
        getContentPane().add(ventanaMostrarCliente, BorderLayout.CENTER);

    }

    public void agregarMenuClientes(){
        menuCliente = new JMenu("Clientes");
        menuBar.add(menuCliente);

        menuMostrarCliente = new JMenuItem("Mostar Clientes");
        menuCliente.add(menuMostrarCliente);
        menuMostrarCliente.setActionCommand("CLIENTEMOSTAR");

        menuModificarCliente = new JMenuItem("Modificar Cliente");
        menuCliente.add(menuModificarCliente);
        menuModificarCliente.setActionCommand("CLIENTEMODIFICAR");

        menuEliminarCliente = new JMenuItem("Eliminar Cliente");
        menuCliente.add(menuEliminarCliente);
        menuEliminarCliente.setActionCommand("CLIENTEELIMINAR");

        menuCrearCliente = new JMenuItem("Crear Cliente");
        menuCliente.add(menuCrearCliente);
        menuCrearCliente.setActionCommand("CLIENTECREAR");
    }

    public JMenu getMenuCliente() {
        return menuCliente;
    }

    public JMenuItem getMenuMostrarCliente() {
        return menuMostrarCliente;
    }

    public JMenuItem getMenuCrearCliente() {
        return menuCrearCliente;
    }

    public JMenuItem getMenuModificarCliente() {
        return menuModificarCliente;
    }

    public JMenuItem getMenuEliminarCliente() {
        return menuEliminarCliente;
    }

    public VentanaMostrarCliente getVentanaMostrarCliente() {
        return ventanaMostrarCliente;
    }
}
