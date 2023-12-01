/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.util.ArrayList;
import javax.persistence.Entity;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author abell
 */
@Entity //son las que se van convertir en tablas
@Table(name = "arg_prog_tecnico")     //tiene caracteristicas de la tabla a nivel relacional porej: el nombre que quiero que tenga a nivel relacional
@Getter @Setter
public class Tecnico extends Empleado{
    
    @OneToMany(mappedBy = "tecnico",  cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<ReporteIncidencia> reportesIncidencia; // 1 a N
    
    @ManyToMany(fetch = FetchType.LAZY, targetEntity=Especialidad.class, cascade = CascadeType.ALL)
    @JoinTable(name = "arg_prog_tecnico_especialidad", joinColumns=@JoinColumn(name="idtecnico"), 
    inverseJoinColumns=@JoinColumn(name="idespecialidad"))
    //@JoinTable es la tercer tabla 
    private List<Especialidad> especialidades; // N a N
    
    public void addEspecialidad(Especialidad especialidad) {
        if (this.especialidades == null) {// con esto evito el null pointer exception
            this.especialidades = new ArrayList<Especialidad>();
        }
        this.especialidades.add(especialidad);
    }
    
    
    
    /*@OneToMany(mappedBy = "tecnico", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<ReporteIncidencia> reportesIncidencia;//1 a N

    @OneToMany(mappedBy = "tecnico", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<TecnicoEspecialidad> tecnicoEspecialidades;// 1 a N

    
    public Tecnico() {}

    public Tecnico(String apellido, String nombre, int legajo, DatosContacto datosContacto) {
        super(apellido, nombre, legajo, datosContacto);
    }

    public void addEspecialidad(TecnicoEspecialidad tecnicoEspecialidad) {
        if (this.tecnicoEspecialidades == null) {
            this.tecnicoEspecialidades = new ArrayList<TecnicoEspecialidad>();
        }
        this.tecnicoEspecialidades.add(tecnicoEspecialidad);
    }*/
    
}
