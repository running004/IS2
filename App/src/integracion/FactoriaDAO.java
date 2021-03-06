package integracion;

import integracion.Alumno.DAOAlumno;
import integracion.Profesor.DAOProfesor;
import integracion.Sesion.DAOSesion;
import integracion.Sucursal.DAOSucursal;
import integracion.Vehiculo.DAOVehiculo;
import integracion.Test.DAOTest;

public abstract class FactoriaDAO {
    private static FactoriaDAO instance;

    public static FactoriaDAO getInstance() {

        if(instance==null) {
            instance = new FactoriaDAOIMP();
        }

        return instance;
    }

    public abstract DAOVehiculo generateDAOVehiculo();
    public abstract DAOSucursal generateDAOSucursal();
	public abstract DAOAlumno generateDAOAlumno();
	public abstract DAOProfesor generateDAOProfesor();
	public abstract DAOTest generateDAOTest();
	public abstract DAOSesion generateDAOSesion();
}