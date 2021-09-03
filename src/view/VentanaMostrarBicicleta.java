package view;

import model.BicicletaModel;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

//Creación de la clase VentanaMostrarBicicleta
public class VentanaMostrarBicicleta extends JPanel {
    private JTable jTable;
    private JScrollPane jScrollPane;
    
    //Creación del metodo constructor VentanaMostrarBicicleta
    public VentanaMostrarBicicleta(ArrayList<BicicletaModel> datosBicicletas) {
        setLayout(new GridLayout(1, 1));
        inicializarComponentes(datosBicicletas);
        setVisible(true);
        updateUI();

    }
    
    //Creación del metodo inicializarComponentes
    public void inicializarComponentes(ArrayList<BicicletaModel> datosBicicleta) {
        //jTable = new JTable();
        addData(datosBicicleta);
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
    public void addData(ArrayList<BicicletaModel> datosBicicletas) {
        String[] titulos = {"Fabricante", "Precio Unitario", "Año de Lanzamiento"};
        String[][] valores = new String[datosBicicletas.size()][4];
        for (int i = 0; datosBicicletas.size() > i; i++) {
            valores[i][0] = datosBicicletas.get(i).getFabricante();
            valores[i][1] = Integer.toString(datosBicicletas.get(i).getPrecioUnitario());
            valores[i][2] = Integer.toString(datosBicicletas.get(i).getAno());
        }
        jTable = new JTable(valores, titulos);
    }
}