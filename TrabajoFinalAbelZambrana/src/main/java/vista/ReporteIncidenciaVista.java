/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista;

import java.util.Scanner;
import modelo.Cliente;
import modelo.DatosContacto;
import modelo.OperadorMesaAyuda;
import modelo.ReporteIncidencia;
import modelo.Servicio;

/**
 *
 * @author abell
 */
public class ReporteIncidenciaVista {
    
    public ReporteIncidencia cargarClienteNuevo(){
        
        ReporteIncidencia reporteIncidencia = new ReporteIncidencia();
        
        System.out.println("Ingrese la fecha del Reporte de Incidencia");
        reporteIncidencia.setfechaAlta(new Scanner(System.in).nextDate());
        
        System.out.println("Ingrese la descripcion de problema");
        reporteIncidencia.setdescripcionProblema(new Scanner(System.in).nextLine());
        
        System.out.println("Ingrese el tipo de problema");
        reporteIncidencia.settipoProblema(new Scanner(System.in).nextLine());
        
        System.out.println("Ingrese el servicio");
        reporteIncidencia.setservicio(new Scanner(System.in).nextLine());

        return reporteIncidencia;
    
    }
    
    public Cliente modificarCliente(Cliente cliente){
        
        ReporteIncidencia reporteIncidencia = new ReporteIncidencia();
        
        System.out.println("Ingrese la fecha del Reporte de Incidencia");
        reporteIncidencia.setfechaAlta(new Scanner(System.in).nextDate());
        
        System.out.println("Ingrese la descripcion de problema");
        reporteIncidencia.setdescripcionProblema(new Scanner(System.in).nextLine());
        
        System.out.println("Ingrese el tipo de problema");
        reporteIncidencia.settipoProblema(new Scanner(System.in).nextLine());
        
        System.out.println("Ingrese el servicio");
        reporteIncidencia.setservicio(new Scanner(System.in).nextLine());

        return reporteIncidencia;

    
    }
    
}
