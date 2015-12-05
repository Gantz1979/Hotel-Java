package services;

import java.sql.SQLException;
import java.util.List;

import beans.Habitacion;
import dao.Fabrica;
import interfaces.HabitacionDAO;

public class HabitacionService {

    Fabrica fabrica = Fabrica.obtenerTipo(Fabrica.MYSQL);
    HabitacionDAO dao = fabrica.getHabittacion();

public int registrar(Habitacion bean){
	  try {
		  
			return dao.registrarHabitacion(bean);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  
	  return 0;
   }
	

public int actualizar(Habitacion bean){
	  try {
		  
			return dao.actualizarHabitacion(bean);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  
	  return 0;
 }
	

public int eliminar(int x, int codigo){
	  try {
		  
			return dao.eliminarHabitacion(x,codigo);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  
	  return 0;
}

public List<Habitacion> listar(){
	try {
		return dao.listarHabitacion();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return null;
}



public List<Habitacion>buscarPorTipo(int tipo){
	
try {
	return dao.buscarHabitacionPorTipo(tipo);
} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
	
	
	return null;
}

public List<Habitacion>buscarPorCategoria(int categoria){
	
	try {
		return dao.buscarHabitacionPorCategoria(categoria);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	return null;
}


public List<Habitacion>buscarPorCat_Hab(int tip ,int cat){
	try {
		return dao.buscarHabitacionPorTipoCategoria(cat, tip);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	return null;
}

	
	
}
