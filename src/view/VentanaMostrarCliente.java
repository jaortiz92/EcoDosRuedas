package view;

import model.ClienteModel;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

//Creación de la clase VentanaMostrarCliente
public class VentanaMostrarCliente extends JPanel {
    private JTable jTable;
    private JScrollPane jScrollPane;
    
    //Creación del metodo constructor VentanaMostrarCliente
    public VentanaMostrarCliente(ArrayList<ClienteModel> datosClientes){
        setLayout(new GridLayout(1, 1));
        inicializarComponentes(datosClientes);
        setVisible(true);
        updateUI();
    }
    
    //Creación del metodo inicializarComponentes
    public void inicializarComponentes(ArrayList<ClienteModel> datosClientes){
        addData(datosClientes);
        //jTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        jTable.setSize(1000, 1000);
        jScrollPane = new JScrollPane(jTable);
        add(jScrollPane);
    }
    
    //Getters y Setters
    public JTable getjTable() {
        return jTable;
    }

    public void setjTable(JTable jTable) {
        this.jTable = jTable;
    }
    
    //Creación del metodo addData
    public void addData(ArrayList<ClienteModel> datosClientes){

        String[] titulos = {"Alias", "Nombre", "Apellidos", "Email", "Celular", "Fecha de Nacimiento"};
        String[][] valores = new String[datosClientes.size()][6];
        for(int i = 0; datosClientes.size() > i; i++){
            valores[i][0] = datosClientes.get(i).getAlias();
            valores[i][1] = datosClientes.get(i).getNombre();
            valores[i][2] = datosClientes.get(i).getApellido();
            valores[i][3] = datosClientes.get(i).getEmail();
            valores[i][4] = datosClientes.get(i).getCelular();
            valores[i][5] = String.valueOf(datosClientes.get(i).getFechaNacimiento());
        }
        jTable = new JTable(valores, titulos);
    }
}
