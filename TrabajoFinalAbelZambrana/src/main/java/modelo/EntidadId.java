/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.io.Serializable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.MappedSuperclass;

/**
 *
 * @author abell
 */
@MappedSuperclass //clase padre de las entidades osea del resto del modelo
@Inheritance(strategy = InheritanceType.JOINED) //es como se va comportar el modelo relacional cdo tenga que resolver la hererncia de java 
public abstract class EntidadId implements Serializable{// representa la clave primaria a nivel relacional, atributo que me va servir como clave primaria
    
    @Id   //con esto indico que id es clave primaria
    @GeneratedValue(strategy = GenerationType.IDENTITY) //con esto indico que id sera autonumerica, PK sera autonumerica  
    protected long id;
    //private long id;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
    
}
