/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author David 
 */
public class ClienteModel {
    private String Alias;
    private String Nombre;
    private String Apellido;
    private String Email;
    private int    Celular;
    private String Contraseña;
    private String FechaNacimiento;
    
    public ClienteModel(String Alias, String Nombre, String Apellido, String Email, int Celular, String Contraseña, String FechaNacimiento){
        this.Alias           = Alias;
        this.Nombre          = Nombre;
        this.Apellido        = Apellido;
        this.Email           = Email;
        this.Celular         = Celular;
        this.Contraseña      = Contraseña;
        this.FechaNacimiento = FechaNacimiento;
    }
    /*Mirar cuales getters y setters crear y como crear el toString*/
}
