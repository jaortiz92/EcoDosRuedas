package view;

import model.ClienteModel;
import model.IntencionCompraModel;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

//Creación de la clase VentanaMostrarCliente
public class VentanaMostrarIntencionCompra extends JPanel {
    private JTable jTable;
    private JScrollPane jScrollPane;
    private ArrayList<IntencionCompraModel> intencionesCompras;

    public VentanaMostrarIntencionCompra(ArrayList<IntencionCompraModel> intencionesCompras){
        setLayout(new GridLayout(1, 1));
        this.intencionesCompras = intencionesCompras;
        inicializarComponentes();
        setVisible(true);
        updateUI();
    }

    //Creación del metodo inicializarComponentes
    public void inicializarComponentes() {
        //jTable = new JTable();
        addData();
        //jTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        jTable.setSize(1000, 1000);
        jScrollPane = new JScrollPane(jTable);
        add(jScrollPane);
    }

    //Creación del metodo addData
    public void addData(){
        String[] titulos = {"Codigo", "Cliente","Fabricante", "Fecha"};
        String[][] valores = new String[intencionesCompras.size()][4];
        for(int i = 0; intencionesCompras.size() > i; i++){
            valores[i][0] = String.valueOf(intencionesCompras.get(i).getCodigoCompra());
            valores[i][1] = intencionesCompras.get(i).getAliasComprafk().getAlias();
            valores[i][2] = intencionesCompras.get(i).getFabComprafk().getFabricante();
            valores[i][3] = String.valueOf(intencionesCompras.get(i).getStringfecha());
        }
        jTable = new JTable(valores, titulos);
    }
}
