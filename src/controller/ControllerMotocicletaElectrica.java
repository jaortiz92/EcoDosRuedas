package controller;

import access.MotocicletaElectricaDAO;
import model.MotocicletaElectricaModel;
import view.VentanaPrincipal;

import java.util.ArrayList;

public class ControllerMotocicletaElectrica {
    private VentanaPrincipal ventana;
    private MotocicletaElectricaDAO motocicletaElectricaDAO;

    public ControllerMotocicletaElectrica(VentanaPrincipal ventana){
        motocicletaElectricaDAO = new MotocicletaElectricaDAO();
        this.ventana = ventana;
    }



    //Creación del metodo motocicletaMostar
    public void motocicletaMostar(){
        ArrayList<MotocicletaElectricaModel> motocicletas = motocicletaElectricaDAO.leerMotocicletas();
        ventana.getResultados().inicializarPanelMostrarMotocicletas(motocicletas);
    }

    //Creación del metodo motocicletaEliminar
    public void motocicletaEliminar(){
        String fabricanteMoto;
        fabricanteMoto = ventana.leerDatoString("Ingresar Fabricante de la motocicleta:");
        if (motocicletaElectricaDAO.borrarMotocicleta(fabricanteMoto)) {
            ventana.mostrarInformacion("Se eliminó la motocicleta\n");
        }
        else {
            ventana.mostrarInformacion("No se eliminó la motocicleta\n");
        }
    }

    //Creación del metodo motocicletaCrear
    public String motocicletaCrear(){
        String fabricanteMoto;
        int precioUnitarioMoto;
        int autonomia;
        String provMotorfk;

        fabricanteMoto = ventana.leerDatoString("Ingresar marcar de motocicleta:\n");
        precioUnitarioMoto = Integer.parseInt(ventana.leerDatoString("Ingresar precio:\n"));
        autonomia = Integer.parseInt(ventana.leerDatoString("Ingresar autonomia:\n"));
        provMotorfk = ventana.leerDatoString("Ingresar fabricante del motor:\n");
        MotocicletaElectricaModel motocicleta = new MotocicletaElectricaModel(fabricanteMoto, precioUnitarioMoto, autonomia, provMotorfk);
        if (motocicletaElectricaDAO.insertarMotocicletaElectrica(motocicleta)) {
            ventana.mostrarInformacion("Se agregó la motocicleta\n");
        } else {
            ventana.mostrarInformacion("No se agregó la motocicleta\n");
        }
        return fabricanteMoto;
    }

    //Creación del metodo motocicletaModificar
    public String motocicletaModificar(){
        String fabricanteMoto;
        int precioUnitarioMoto;
        int autonomia;
        String provMotorfk;
        fabricanteMoto = ventana.leerDatoString("Ingresar marcar de motocicleta a modificar:\n");
        precioUnitarioMoto = Integer.parseInt(ventana.leerDatoString("Ingresar precio:\n"));
        autonomia = Integer.parseInt(ventana.leerDatoString("Ingresar autonomia:\n"));
        provMotorfk = ventana.leerDatoString("Ingresar fabricante del motor:\n");
        MotocicletaElectricaModel motocicleta = new MotocicletaElectricaModel(fabricanteMoto, precioUnitarioMoto, autonomia, provMotorfk);
        if (motocicletaElectricaDAO.modificarMotocicletaElectrica(motocicleta)) {
            ventana.mostrarInformacion("Se modifico la motocicleta\n");
        } else {
            ventana.mostrarInformacion("No se modifico la motocicleta\n");
        }
        return fabricanteMoto;
    }

    //Creación del metodo motocicletaBuscarFabricante
    public void motocicletaBuscarFabricante(String fabricanteMoto){
        ArrayList<MotocicletaElectricaModel> motocicletas = motocicletaElectricaDAO.buscarMotocicleta(fabricanteMoto);
        ventana.getResultados().inicializarPanelMostrarMotocicletas(motocicletas);
    }

    //Sobrecarga del metodo motocicletaBuscarFabricante
    public void motocicletaBuscarFabricante(){
        String fabricanteMoto = ventana.leerDatoString("Ingresar fabricante de motocicleta a buscar:\n");
        ArrayList<MotocicletaElectricaModel> motocicletas = motocicletaElectricaDAO.buscarMotocicleta(fabricanteMoto);
        ventana.getResultados().inicializarPanelMostrarMotocicletas(motocicletas);
    }
}
