/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import modelo.Cliente;
import modelo.ReporteIncidencia;
import org.hibernate.Query;
import persistencia.ConfigHibernate;

/**
 *
 * @author abell
 */
public class GestorReporteIncidencia extends Gestor {

    public GestorReporteIncidencia() {
        sesion = ConfigHibernate.openSession();
    }
    
    public ReporteIncidencia getReporteIncidenciaXId(Long idReporteIncidencia){
        try {
        
            Query consulta = sesion.createQuery("FROM ReporteIncidencia WHERE id = :idReporteIncidencia");
            consulta.setParameter("idReporteIncidencia", idReporteIncidencia);

            ReporteIncidencia reporteIncidencia = (ReporteIncidencia) consulta.uniqueResult();
            return reporteIncidencia;
            
        } catch (RuntimeException e) {
            e.printStackTrace();
            return null;
        }
    }
    
    
}
