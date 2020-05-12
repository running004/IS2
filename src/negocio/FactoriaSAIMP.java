package negocio;

import negocio.Alumno.SAalumno;
import negocio.Alumno.SAalumnoImp;
import negocio.Profesor.SAProfesor;
import negocio.Profesor.SAProfesorImp;
import negocio.Sucursal.SASucursal;
import negocio.Sucursal.SASucursalIMP;
import negocio.Vehiculo.SAVehiculo;
import negocio.Vehiculo.SAVehiculoImp;

public class FactoriaSAIMP extends FactoriaSA {


    @Override
    public SAVehiculo generateSAVehiculo() {
        // TODO Auto-generated method stub
        return new SAVehiculoImp();
    }

    @Override
    public SASucursal generateSASucursal() {
        // TODO Auto-generated method stub
        return new SASucursalIMP();
    }

    @Override
	public SAalumno generateSAalumno() {
		// TODO Auto-generated method stub
		return new SAalumnoImp();
	}

	@Override
	public SAProfesor generateSAProfesor() {
		return new SAProfesorImp();
	}
}