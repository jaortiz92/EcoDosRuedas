package controller;

import access.BicicletaDAO;
import model.BicicletaModel;
import view.VentanaPrincipal;

import java.util.ArrayList;

public class ControllerBicicleta {
    private VentanaPrincipal ventana;
    private BicicletaDAO bicicletaDAO;

    public ControllerBicicleta(VentanaPrincipal ventana){
        bicicletaDAO = new BicicletaDAO();
        this.ventana = ventana;
    }

    //Creación del metodo bicicletaMostrar
    public void bicicletaMostar(){
        ArrayList<BicicletaModel> bicicletas = bicicletaDAO.leerBicicletas();
        ventana.getResultados().inicializarPanelMostrarBicicletas(bicicletas);
    }

    //Creación del metodo bicicletaEliminar
    public void bicicletaEliminar(){
        String fabricanteBici;
        fabricanteBici = ventana.leerDatoString("Ingresar Fabricante de la bicicleta:");
        if (bicicletaDAO.borrarBicicleta(fabricanteBici)) {
            ventana.mostrarInformacion("Se eliminó la bicicleta\n");
        }
        else {
            ventana.mostrarInformacion("No se eliminó la bicicleta\n");
        }
    }

    //Creación del metodo bicicletaCrear
    public String bicicletaCrear(){
        String fabricanteBici;
        int precioUnitarioBici;
        int ano;
        fabricanteBici = ventana.leerDatoString("Ingresar marcar de bicicleta:\n");
        precioUnitarioBici = Integer.parseInt(ventana.leerDatoString("Ingresar precio:\n"));
        ano = Integer.parseInt(ventana.leerDatoString("Ingresar año:\n"));
        BicicletaModel bicicleta = new BicicletaModel(fabricanteBici, precioUnitarioBici, ano);
        if (bicicletaDAO.insertarBicicleta(bicicleta)) {
            ventana.mostrarInformacion("Se agregó la bicicleta\n");
        } else {
            ventana.mostrarInformacion("No se agregó la bicicleta\n");
        }
        return fabricanteBici;
    }

    //Creación del metodo bicicletaModificar
    public String bicicletaModificar(){
        String fabricanteBici;
        int precioUnitarioBici;
        int ano;
        fabricanteBici = ventana.leerDatoString("Ingresar marcar de bicicleta a modificar:\n");
        precioUnitarioBici = Integer.parseInt(ventana.leerDatoString("Ingresar precio:\n"));
        ano = Integer.parseInt(ventana.leerDatoString("Ingresar año:\n"));
        BicicletaModel bicicleta = new BicicletaModel(fabricanteBici, precioUnitarioBici, ano);
        if (bicicletaDAO.modificarBicicleta(bicicleta)) {
            ventana.mostrarInformacion("Se modifico la bicicleta\n");
        } else {
            ventana.mostrarInformacion("No se modifico la bicicleta\n");
        }
        return fabricanteBici;
    }

    //Creación del metodo bicicletaBuscarFabricante
    public void bicicletaBuscarFabricante(String fabricanteBici){
        ArrayList<BicicletaModel> bicicletas = bicicletaDAO.buscarBicicletas(fabricanteBici);
        ventana.getResultados().inicializarPanelMostrarBicicletas(bicicletas);
    }

    //Sobrecarga del metodo bicicletaBuscarFabricante
    public void bicicletaBuscarFabricante(){
        String fabricanteBici = ventana.leerDatoString("Ingresar fabricante de bicicleta a buscar:\n");
        ArrayList<BicicletaModel> bicicletas = bicicletaDAO.buscarBicicletas(fabricanteBici);
        ventana.getResultados().inicializarPanelMostrarBicicletas(bicicletas);
    }
}
