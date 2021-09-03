package view;

import model.ClienteModel;

import javax.swing.*;
import java.awt.*;
import java.sql.Date;
import java.util.ArrayList;

//Creación de la clase VentanaPrincipal
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
    private JMenuItem menuBuscarClienteAlias;
    private JMenuItem menuMostrarBicicleta;
    private JMenuItem menuCrearBicicleta;
    private JMenuItem menuModificarBicicleta;
    private JMenuItem menuEliminarBicicleta;
    private JMenuItem menuBuscarBicicletaFabricante;

    private VentanaResultados resultados;

    //Creación del metodo constructor VentanaPrincipal
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

    //Creación del metodo inicializarComponente
    public void inicializarComponente() {
        menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        agregarMenus();

        resultados = new VentanaResultados();
        getContentPane().add(resultados);
    }

    //Creación del metodo agregarMenus
    public void agregarMenus() {
        menuCliente = new JMenu("Clientes");
        menuBar.add(menuCliente);
        addMenuCliente();
        addMenuBicicleta();
    }
    
    //Creación del metodo addMenuCliente
    private void addMenuCliente() {
        menuMostrarCliente = new JMenuItem("Mostar Clientes");
        menuCliente.add(menuMostrarCliente);
        menuMostrarCliente.setActionCommand("CLIENTEMOSTAR");

        menuBuscarClienteAlias = new JMenuItem("Buscar Cliente por Alias");
        menuCliente.add(menuBuscarClienteAlias);
        menuBuscarClienteAlias.setActionCommand("CLIENTEBUSCARALIAS");

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

    //Creación del metodo addMenuBicicleta
    private void addMenuBicicleta() {
        menuBicicleta = new JMenu("Bicicleta");
        menuBar.add(menuCliente);

        menuBicicleta = new JMenu("Bicicletas");
        menuBar.add(menuBicicleta);

        menuMostrarBicicleta = new JMenuItem("Mostar Bicicletas");
        menuBicicleta.add(menuMostrarBicicleta);
        menuMostrarBicicleta.setActionCommand("BICICLETAMOSTAR");

        menuBuscarBicicletaFabricante = new JMenuItem("Buscar Bicicleta por Fabricante");
        menuBicicleta.add(menuBuscarBicicletaFabricante);
        menuBuscarBicicletaFabricante.setActionCommand("BICICLETABUSCARFABRICANTE");

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

    //Creación del metodo ieerDatoString
    public String leerDatoString(String mensaje) {
        return JOptionPane.showInputDialog(mensaje);
    }

    //Creación del metodo mostrarInformacion
    public void mostrarInformacion(String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje);
    }

    //Creación de los Getters
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

    public JMenuItem getMenuBuscarClienteAlias() {
        return menuBuscarClienteAlias;
    }

    public JMenuItem getMenuBuscarBicicletaFabricante() {
        return menuBuscarBicicletaFabricante;
    }

    public VentanaResultados getResultados() {
        return resultados;
    }

}
