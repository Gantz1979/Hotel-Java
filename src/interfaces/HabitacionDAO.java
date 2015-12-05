package interfaces;

import java.sql.SQLException;

import java.util.List;

import beans.Habitacion;

public interface HabitacionDAO {
	
	
	public abstract List<Habitacion>buscarHabitacionPorCategoria (int categoria) throws SQLException;
	public abstract List<Habitacion>buscarHabitacionPorTipo(int tipo)throws SQLException;
	public abstract List<Habitacion>buscarHabitacionPorTipoCategoria(int cat , int tip) throws SQLException;
 	public abstract int registrarHabitacion(Habitacion hab) throws SQLException;
	public abstract List<Habitacion>listarHabitacion () throws SQLException;
	public abstract int actualizarHabitacion(Habitacion hab) throws SQLException;
	public abstract int eliminarHabitacion(int x,  int codigo) throws SQLException;
}
