/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import javax.persistence.Entity;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author abell
 */
@Entity
@Table(name = "arg_prog_reporte_incidencia")
@Getter @Setter
public class ReporteIncidencia extends EntidadId{
    
    @Column(nullable = false)
    @Temporal(TemporalType.DATE) //GUARDA LOS DIAS MES Y AÑO Y TAMBIEN LAS HORAS LOS MIN Y SEG
    private Date fechaAlta;
    
    @Column(nullable = false)
    private String descripcionProblema;
    
    @Column(nullable = false)
    private String tipoProblema; // basico, intermedio, complejo
    
    @ManyToOne
    @JoinColumn(name = "idservicio")
    private Servicio servicio; // N a 1
    
    @ManyToOne
    @JoinColumn(name = "idoperador")    
    private OperadorMesaAyuda operador; //N a 1 getter and setter(permiten obtener info y asignarla) no son necesarios con la libreria Lombok, esta libreia los oculta osea estan presentes
    @ManyToOne
    @JoinColumn(name = "idcliente", nullable = false)// la columna de union siempre va en el manytoone, por que sino se repite la PK
    // con nullable indico que un reporte de incidencia nunca se me puede guardar sino le seteo un cliente
    private Cliente cliente; // N a 1
    
    @ManyToOne
    @JoinColumn(name = "idtecnico", nullable = false)
    private Tecnico tecnico; // N a 1
    
    private int tiempoEstimadoResolucion;
    
    @Temporal(TemporalType.DATE)
    private Date fechaPosibleResolucion;
    
    private String estado; //pendiente, en proceso, resuelto, anulado
    private String observacionesTecnico;


    
}
