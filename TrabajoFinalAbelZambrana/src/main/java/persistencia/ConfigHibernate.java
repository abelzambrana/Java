
package persistencia;

import modelo.*;
import java.util.Iterator;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

public class ConfigHibernate {
   private static SessionFactory sessionFactory;

    public static void load(){

        try {
            AnnotationConfiguration config = new AnnotationConfiguration();
            config.setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/incidencias_db?useTimezone=true&serverTimezone=UTC");
            config.setProperty("hibernate.connection.driver_class", "com.mysql.cj.jdbc.Driver");
            config.setProperty("hibernate.connection.username", "root");
            config.setProperty("hibernate.connection.password", "Zambrana1025");
            config.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");//le indico el idioma, posgree mysql db2 etc
            config.setProperty("hibernate.show_sql", "true");//tiene que estar en true durante el desarrollo, cdo ejecuten acciones sobre hibernate todos los query que genere los va mostrar por consola
            //luego cdo este en preoduccion deberia estar en false para que no genere dichos query
            config.setProperty("hibernate.hbm2ddl.auto", "update" );//create-drop: borra la totalidad de la base de datos y la vuelve a generar sin datos, como quiero que trabaje hibernate
            //borra los datos, no es conveniente una vez que comenzamos a guardar informacion, update: ahora no borra nada, va actualizar lo nuevo que coloque
            config.setProperty("hibernate.c3p0.min_size","0");//estas tienen que ver con la cantidad de conexiones que quiero habilitar
            config.setProperty("hibernate.c3p0.max_size","7");
            config.setProperty("hibernate.c3p0.timeout","100");//pasado ese tiempo automaticamente detiene el query
            config.setProperty("hibernate.c3p0.max_elements","100");
            config.setProperty("hibernate.c3p0.idle_test_period","100");
            config.setProperty("hibernate.c3p0.autoCommitOnClose","true");//es para el manejo de la persistencia a nivel de transaccional 
            config.setProperty("hibernate.transaction.factory_class", "org.hibernate.transaction.JDBCTransactionFactory");

            config.addPackage("modelo");//le agrego las clases que componen mi modelo, que se van a convertir en tablas
            config.addAnnotatedClass(Empleado.class);
            config.addAnnotatedClass(Cliente.class);
            config.addAnnotatedClass(DatosContacto.class);
            //config.addAnnotatedClass(EntidadId.class);
            config.addAnnotatedClass(Especialidad.class);
            config.addAnnotatedClass(OperadorMesaAyuda.class);
            config.addAnnotatedClass(ReporteIncidencia.class);
            config.addAnnotatedClass(Servicio.class);
            config.addAnnotatedClass(Tecnico.class);
            
            sessionFactory = config.buildSessionFactory();
        }
        catch (Exception e) {
           System.out.println("Error: HibernateUtil.HibernateException: " + e.getMessage());
        }
        catch (Throwable ex) {
           ex.printStackTrace();
        }
    }

    public synchronized static Session openSession() {
        return getSessionFactory().openSession();
    }

    public static void closeSession(Session session) {
        session.close();
    }

    public synchronized static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            load();
        }

        return sessionFactory;
    }

    public synchronized static void closeSessionFactory() {
        try {
            if (sessionFactory != null) {
                sessionFactory.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sessionFactory = null;
        }
    }

    public boolean saveEntity(Session sezion, EntidadId entity) {
        Transaction tx = null;

        if (!sezion.getTransaction().isActive()) {
            tx = sezion.beginTransaction();
        }

        sezion.saveOrUpdate(entity);

        if (tx != null) {
            tx.commit();
        }

        return true;
    }

    public boolean deleteEntity(Session sezion, EntidadId entity) {
        Transaction tx = sezion.beginTransaction();

        sezion.delete(entity);

        tx.commit();

        return true;
    }

    public boolean updateEntity(Session sezion, EntidadId entity) {
        Transaction tx = null;

        if (!sezion.getTransaction().isActive()) {
            tx = sezion.beginTransaction();
        }

        sezion.update(entity);

        if (tx != null) {
            tx.commit();
        }

        return true;
    }

    public boolean deleteEntitys(Session sezion, List entities) {

        for (Iterator i = entities.iterator(); i.hasNext();) {
            EntidadId entity = (EntidadId) i.next();

            sezion.delete(entity);
        }

        return true;
    }

    public void destroy() {
        closeSessionFactory();
    }
}
