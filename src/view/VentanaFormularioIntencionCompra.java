package view;

import model.ClienteModel;
import model.Vehiculo;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Date;

public class VentanaFormularioIntencionCompra extends JPanel {
    private JLabel labeltitulo;
    private JLabel labelFecha;
    private JLabel labelAlias;
    private JLabel labelVehiculo;

    private JComboBox comboBoxClientes;
    private JComboBox comboBoxVehiculos;
    private ArrayList<ClienteModel> clientes;
    private ArrayList<Vehiculo> vehiculos;
    private JButton agregarIntencionCompraBoton;

    public VentanaFormularioIntencionCompra(ArrayList<ClienteModel> clientes, ArrayList<Vehiculo> vehiculos){
        this.clientes = clientes;
        this.vehiculos = vehiculos;
        inicializarComponentes();
        setVisible(true);
    }

    public void inicializarComponentes(){
        setLayout(new GridLayout(15, 3));
        addValoresJComboBox();

        JPanel aux0 = new JPanel();
        labeltitulo = new JLabel("Formulario para creación de intención de compra");
        labeltitulo.setFont(new Font("Arial", 1,20));
        aux0.add(labeltitulo);
        add(aux0);

        labelFecha = new JLabel(new Date().toString());
        add(labelFecha);

        JPanel aux1 = new JPanel();
        labelAlias = new JLabel("Alias");
        aux1.setLayout(new GridLayout(1, 5));
        aux1.add(labelAlias);
        aux1.add(comboBoxClientes);
        add(aux1);

        JPanel aux2 = new JPanel();
        labelVehiculo = new JLabel("Vehiculo");
        aux2.setLayout(new GridLayout(1, 5));
        aux2.add(labelVehiculo);
        aux2.add(comboBoxVehiculos);
        add(aux2);

        JPanel aux3 = new JPanel();
        agregarIntencionCompraBoton = new JButton("Agregra Intención de Compra");
        agregarIntencionCompraBoton.setActionCommand("agregarIntencionCompra");
        aux3.add(agregarIntencionCompraBoton);
        add(aux3);
    }

    private void addValoresJComboBox(){
        String[] listaClientes = new String[clientes.size()];
        String[] listaVehiculos = new String[vehiculos.size()];

        for(int i = 0; clientes.size() > i; i++){
            listaClientes[i] = clientes.get(i).stringAlias();
        }

        for(int i = 0; vehiculos.size() > i; i++){
            listaVehiculos[i] = vehiculos.get(i).stringFabricante();
        }

        comboBoxClientes = new JComboBox(listaClientes);
        comboBoxVehiculos = new JComboBox(listaVehiculos);

    }

    public JButton getAgregarIntencionCompraBoton() {
        return agregarIntencionCompraBoton;
    }

    public JComboBox getComboBoxClientes() {
        return comboBoxClientes;
    }

    public JComboBox getComboBoxVehiculos() {
        return comboBoxVehiculos;
    }
}
