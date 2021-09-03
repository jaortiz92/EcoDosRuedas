package view;

import model.BicicletaModel;
import model.MotocicletaElectricaModel;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

//Creación de la clase VentanaMostrarMotocicletaElectrica
public class VentanaMostrarMotocicletaElectrica extends JPanel {
    private JTable jTable;
    private JScrollPane jScrollPane;

    //Creación del metodo constructor VentanaMostrarMotocicletaElectrica
    public VentanaMostrarMotocicletaElectrica(ArrayList<MotocicletaElectricaModel> datosMotocicletasElectricas) {
        setLayout(new GridLayout(1, 1));
        inicializarComponentes(datosMotocicletasElectricas);
        setVisible(true);
        updateUI();

    }
    
    //Creación del metodo inicializarComponentes
    public void inicializarComponentes(ArrayList<MotocicletaElectricaModel> datosMotocicletasElectricas) {
        //jTable = new JTable();
        addData(datosMotocicletasElectricas);
        //jTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        jTable.setSize(800, 500);
        jScrollPane = new JScrollPane(jTable);
        add(jScrollPane, BorderLayout.CENTER);
    }
    
    //Getters y Setters
    public JTable getjTable() {
        return jTable;
    }

    public void setjTable(JTable jTable) {
        this.jTable = jTable;
    }
    
    //Creación del metodo addData
    public void addData(ArrayList<MotocicletaElectricaModel> datosMotocicletasElectricas) {
        String[] titulos = {"Fabricante", "Precio Unitario", "Autonomia", "Proveedor Motor"};
        String[][] valores = new String[datosMotocicletasElectricas.size()][4];
        for (int i = 0; datosMotocicletasElectricas.size() > i; i++) {
            valores[i][0] = datosMotocicletasElectricas.get(i).getFabricante();
            valores[i][1] = Integer.toString(datosMotocicletasElectricas.get(i).getPrecioUnitario());
            valores[i][2] = Integer.toString(datosMotocicletasElectricas.get(i).getAutonomia());
            valores[i][3] = datosMotocicletasElectricas.get(i).getProvMotorfk();
        }
        jTable = new JTable(valores, titulos);
    }
}