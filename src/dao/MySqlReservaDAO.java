package dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


import beans.DetalleReserva;
import beans.Reserva;
import interfaces.ReservaDAO;
import util.ConexionDB;

public class MySqlReservaDAO  implements ReservaDAO{

	@Override
	public int registrarReserva(Reserva reserva, List<DetalleReserva> detalleReserva) throws SQLException {
		int contador =-1;
		Connection cn =null;
		PreparedStatement pstm1 =null,pstm2=null,pstm3=null;
		ResultSet rs =null;
		try {
			
	         cn= new ConexionDB().getConexion();
		     cn.setAutoCommit(false);
			
			String sql1 ="select max(codgioReserva) from RESERVA ";
			pstm1=cn.prepareStatement(sql1);
			rs=pstm1.executeQuery();
			rs.next();
			int boleta =rs.getInt(1)+1;
			
			
			String sql2 ="";
			pstm2=cn.prepareStatement(sql2);
		
			pstm2.setInt(1, boleta);
			pstm2.setInt(2, reserva.getCodigoCliente());
			pstm2.setInt(3,reserva.getCodigoEmpleado());
			pstm2.setDate(4, reserva.getFechaInicio());
			pstm2.setDate(5, reserva.getFechaSalida());
			pstm2.setInt(6, reserva.getEstadoReserva());
			
			pstm2.executeUpdate();
			
			
			String sql3 ="";
			pstm3=cn.prepareStatement(sql3);
			
			for(DetalleReserva d :detalleReserva){
				pstm3.setInt(1, boleta);
				pstm3.setInt(2, d.getNumeroHabitacion());
			//	pstm3.setInt(3, d.getCategoriaHabitacion());
				//pstm3.setInt(4, d.getTipoHabitacion());
				//pstm3.setString(3, d.getHuesped());
				pstm3.setDouble(4, d.getPrecioPorNoche());
				pstm3.executeUpdate();
		
				
			}
			
			cn.commit();
			
			
		} catch (Exception e) {
			
			try {
				cn.rollback();
	} 
			catch (SQLException e1) 
			{
				e1.printStackTrace();
			}
			e.printStackTrace();
			
		}
		
		finally{
			
			try {
				
			if(cn!=null) cn.close();
			if(pstm1!=null ) pstm1.close();
			if(pstm2!=null) pstm2.close();
			if(pstm3!=null)pstm3.close();
			if(rs!=null) rs.close();
		
		} catch (SQLException e2) {
			e2.printStackTrace();
		}}
		
		return contador;
	}

}
