package view;

import model.ClienteModel;
import model.Vehiculo;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class VentanaFormularioIntencionCompra extends JPanel {
    private JLabel labelAlias;
    private JLabel labelVehiculo;
    private JComboBox comboBoxClientes;
    private JComboBox comboBoxVehiculos;
    private ArrayList<ClienteModel> clientes;
    private ArrayList<Vehiculo> vehiculos;

    public VentanaFormularioIntencionCompra(ArrayList<ClienteModel> clientes, ArrayList<Vehiculo> vehiculos){
        this.clientes = clientes;
        this.vehiculos = vehiculos;
        inicializarComponentes();
        setVisible(true);
    }

    public void inicializarComponentes(){
        setLayout(new GridLayout(2, 2));
        addValoresJComboBox();
        labelAlias = new JLabel("Alias");
        add(labelAlias);
        add(comboBoxClientes);

        labelVehiculo = new JLabel("Vehiculo");
        add(labelVehiculo);
        add(comboBoxVehiculos);
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


}
