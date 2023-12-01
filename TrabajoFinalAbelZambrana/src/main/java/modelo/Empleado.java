/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToOne;
import javax.persistence.Transient;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author abell
 */
//A nivel relacional solo puedo tener 1 a 1, 1 a N, N a 1
// N a N no la puedo tener a nivel relacional, por que no se puede repetir la PK, por eso aparece la tercer tabla asociativa 

@MappedSuperclass
@Getter @Setter
public abstract class Empleado extends EntidadId{
    
    /*protected String apellido;
    protected String nombre;
    
    @Column(unique = true)
    protected int legajo; 
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "iddatoscontacto")//a nivel relacional cdo se convierta en un campo, se llamara iddatoscontacto, si no pongo este @ creara la fk como datoscontacto 
    protected DatosContacto datosContacto; // 1 a 1*/
    
    protected String apellido;
    protected String nombre;
    @Column(unique = true)
    protected int legajo;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "iddatoscontacto")
    protected DatosContacto datosContacto;// 1 a 1
    
    
    //@Transient
    //protected String nombreCompleto; 
    /*
    public Empleado(){}
    
    public Empleado(String apellido, String nombre, int legajo, DatosContacto datosContacto) {
        this.apellido = apellido;
        this.nombre = nombre;
        this.legajo = legajo;
        this.datosContacto = datosContacto;
    }
    
    public String getNombreCompleto(){
        return this.apellido + " " + this.nombre;
    }*/
    
    
}
