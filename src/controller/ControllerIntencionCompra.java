package controller;

import access.IntencionCompraDAO;
import model.IntencionCompraModel;
import view.VentanaPrincipal;

import java.util.ArrayList;

public class ControllerIntencionCompra {
    private VentanaPrincipal ventana;
    private IntencionCompraDAO intencionCompraDAO;

    ControllerIntencionCompra(VentanaPrincipal ventana){
        intencionCompraDAO = new IntencionCompraDAO();
        this.ventana = ventana;
    }

    public void intencionCompraMostrar(){
        ArrayList<IntencionCompraModel> intencionesCompras = intencionCompraDAO.leerIntencionCompra();
        ventana.getResultados().inicializarPanelMostrarIntencionCompra(intencionesCompras);
    }
}
