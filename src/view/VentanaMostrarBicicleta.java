//CREACION DE LA VENTANA MOSTRAR BICICLETA TAL COMO LA DE CLIENTE

package view;

import model.BicicletaModel;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

public class VentanaMostrarBicicleta extends JPanel {
    private JTable jTable;
    private JScrollPane jScrollPane;

    public VentanaMostrarBicicleta(ArrayList<BicicletaModel> datosBicicletas) {
        setLayout(new GridLayout(1, 1));
        inicializarComponentes(datosBicicletas);
        setVisible(true);
        updateUI();

    }

    public void inicializarComponentes(ArrayList<BicicletaModel> datosBicicleta) {
        //jTable = new JTable();
        addData(datosBicicleta);
        //jTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        jTable.setSize(800, 500);
        jScrollPane = new JScrollPane(jTable);
        add(jScrollPane, BorderLayout.CENTER);
    }

    public JTable getjTable() {
        return jTable;
    }

    public void setjTable(JTable jTable) {
        this.jTable = jTable;
    }

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