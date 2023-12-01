/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author abell
 */
@Entity
@Table(name = "arg_prog_datos_contacto")
@Getter @Setter
public class DatosContacto extends EntidadId {
    
  
    private long telefono;
    private long celular;
    @Column(length= 75)
    private String email;
    
    //@OneToOne(mappedBy = "empleado")
    //lo siguiente es para que sea bidireccional ver video clase 3: 1:18 hrs
    //@OneToOne(mappedBy = "datosContacto") //indica el nombre del atributo de la clase a la cual me estoy asociando que cumpla el rol de FK
    //@JoinColumn(name = "idempleado") no se coloca, esta mal por que ya defini que la FK iba estar en empleado
    //private Empleado empleado;
}
