package services;

import java.sql.SQLException;
import java.util.List;

import beans.DetalleReserva;
import beans.Reserva;
import dao.Fabrica;
import interfaces.ReservaDAO;

public class ReservaService {
	Fabrica fabrica= Fabrica.obtenerTipo(Fabrica.MYSQL);
	ReservaDAO dao =fabrica.getReserva();
	
	
	public int registraReserva(Reserva reserva ,List<DetalleReserva> detalleReserva){
		
		try {
			return  dao.registrarReserva(reserva, detalleReserva);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return 0;
	}
	
	

}
