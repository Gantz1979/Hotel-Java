package beans;

public class DetalleReserva {
	
private int	codigoReserva ;
private int	numeroHabitacion; 
//private int	categoriaHabitacion;   
//private int	tipoHabitacion ;
//private String	huesped ;
private double	precioPorNoche;
public DetalleReserva(int codigoReserva, int numeroHabitacion,
		 double precioPorNoche) {
	this.codigoReserva = codigoReserva;
	this.numeroHabitacion = numeroHabitacion;
//	this.categoriaHabitacion = categoriaHabitacion;
	//this.tipoHabitacion = tipoHabitacion;
	//this.huesped = huesped;
	this.precioPorNoche = precioPorNoche;
}
public int getCodigoReserva() {
	return codigoReserva;
}
public void setCodigoReserva(int codigoReserva) {
	this.codigoReserva = codigoReserva;
}
public int getNumeroHabitacion() {
	return numeroHabitacion;
}
public void setNumeroHabitacion(int numeroHabitacion) {
	this.numeroHabitacion = numeroHabitacion;
}



public double getPrecioPorNoche() {
	return precioPorNoche;
}
public void setPrecioPorNoche(double precioPorNoche) {
	this.precioPorNoche = precioPorNoche;
} 
	

}
