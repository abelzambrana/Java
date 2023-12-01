/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import javax.persistence.Entity;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

  /**
 *
 * @author abell
 */
@Entity
@Table(name = "arg_prog_cliente")
@Getter @Setter
public class Cliente extends EntidadId{
    
    @Column(length = 150) //se le puede poner a los atributos propios, indico la longitud de la razon social max cant de caracteres 150
    private String razonSocial;
    
    @Column(nullable = false,unique = true) // a nivel relacional esta prohibido guardar un cliente con su cuit, y que sea unico no puedo repetir el cuit
    private long cuit; //con estas caracteristicas el cuit se comporta como una clave primaria sin serlo
    
    
    @ManyToMany(fetch = FetchType.LAZY, targetEntity=Especialidad.class, cascade = CascadeType.ALL)
    @JoinTable(name = "arg_prog_cliente_servicio", joinColumns=@JoinColumn(name="idcliente"), 
    inverseJoinColumns=@JoinColumn(name="idservicio"))
    private List<Servicio> servicios; // N a N, este no es una atributo propio, son objetos osea son asociaciones
    
    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL, fetch = FetchType.LAZY) //la columna de union es cliente, cascade tiene que ver con el ciclo de vida de los objetos
    // cuando guarde un cliente todas las operaciones que yo haga sobre los objetos reportesincidencias que esten asociados a este cliente tamb se van a persistir de forma automatica
    //fetch = FetchType.LAZY (meterialización perezosa)CDO OBTENGA UN CLIENTE en ese momento solo va obtener el objeto cliente no va obtener nada de los reportes de incidencia que tengo asociados
    //fetch = FetchType.EAGER (meterialización inmediata)cdo obtenga el objeto cliente tamb voy a obtener todos los objetos reportesincidencia asociados a ese cliente
    private List<ReporteIncidencia> reportesIncidencia; // 1 a N
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "iddatoscontacto")
    private DatosContacto datosContacto;//1 a 1

}
