package integracion.Alumno;

import java.util.List;

import negocio.Alumno.TAlumno;
import negocio.Alumno.TRelleno;

public interface DAOAlumno {
	public int create(TAlumno a);

	public TAlumno read(int id);

	public int findByID(String id);

	public List<TAlumno> readAll();

	public int update(TAlumno a);

	public int delete(int id);
	
	public int isDeleted(int id);

	public int findByDNI(String dni);
	
	public boolean existeDNI(TAlumno a);
	
	public int rellenar(TRelleno r);
	// de momento
	public int getID();
	public List<TRelleno> readAllR(int id);
	
	public int pending(int idA);
}
