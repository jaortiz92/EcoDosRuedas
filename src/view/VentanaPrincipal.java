package view;

import model.ClienteModel;

import javax.swing.*;
import java.awt.*;
import java.sql.Date;
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
    //Agregue los JMenuItem del JMenu de las bicicletas
    private JMenuItem menuMostrarBicicleta;
    private JMenuItem menuCrearBicicleta;
    private JMenuItem menuModificarBicicleta;
    private JMenuItem menuEliminarBicicleta;

    private VentanaResultados resultados;


    public VentanaPrincipal() {
        setTitle("EcoDosRuedas");
        setSize(1000, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.lightGray);
        setLayout(new GridLayout(1, 1));

        inicializarComponente();
        setResizable(true);
        setLocationRelativeTo(null);
        setVisible(true);

    }

    public void inicializarComponente() {
        menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        agregarMenus();

        resultados = new VentanaResultados();
        getContentPane().add(resultados);
    }

    public void agregarMenus() {
        menuCliente = new JMenu("Clientes");
        menuBar.add(menuCliente);
        addMenuCliente();
        addMenuBiciclta();
    }

    private void addMenuCliente() {
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

    private void addMenuBiciclta() {
        menuBicicleta = new JMenu("Bicicleta");
        menuBar.add(menuCliente);

        menuBicicleta = new JMenu("Bicicletas");
        menuBar.add(menuBicicleta);

        menuMostrarBicicleta = new JMenuItem("Mostar Bicicletas");
        menuBicicleta.add(menuMostrarBicicleta);
        menuMostrarBicicleta.setActionCommand("BICICLETAMOSTAR");

        menuModificarBicicleta = new JMenuItem("Modificar Bicicleta");
        menuBicicleta.add(menuModificarBicicleta);
        menuModificarBicicleta.setActionCommand("BICICLETAMODIFICAR");

        menuEliminarBicicleta = new JMenuItem("Eliminar Bicicleta");
        menuBicicleta.add(menuEliminarBicicleta);
        menuEliminarBicicleta.setActionCommand("BICICLETAELIMINAR");

        menuCrearBicicleta = new JMenuItem("Crear Bicicleta");
        menuBicicleta.add(menuCrearBicicleta);
        menuCrearBicicleta.setActionCommand("BICICLETACREAR");
    }

    public String leerDatoString(String mensaje) {
        return JOptionPane.showInputDialog(mensaje);
    }

    public void mostrarInformacion(String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje);
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

    public JMenuItem getMenuMostrarBicicleta() {
        return menuMostrarBicicleta;
    }

    public JMenuItem getMenuCrearBicicleta() {
        return menuCrearBicicleta;
    }

    public JMenuItem getMenuModificarBicicleta() {
        return menuModificarBicicleta;
    }

    public JMenuItem getMenuEliminarBicicleta() {
        return menuEliminarBicicleta;
    }

    public VentanaResultados getResultados() {
        return resultados;
    }

}
