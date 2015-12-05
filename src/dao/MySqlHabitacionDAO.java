package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import beans.Habitacion;
import interfaces.HabitacionDAO;
import util.ConexionDB;

public class MySqlHabitacionDAO  implements HabitacionDAO{



	@Override
	public int registrarHabitacion(Habitacion hab) throws SQLException {
		
		int estado=0;
		Connection conn=null;
		PreparedStatement pstm = null;
		
		try {
			
		  conn = new ConexionDB().getConexion();
		  String sql = "insert into habitacion values (null,?,?,null,?,?,?)";
				  pstm=conn.prepareStatement(sql);
				  pstm.setInt(1,hab.getCategoriaHabitacion());
				  pstm.setInt(2, hab.getTipoHabitacion());
				 // pstm.setString(3, hab.getNombreHabitacion());
				  pstm.setInt(3, hab.getNumeroPiso());
				  pstm.setDouble(4, hab.getPrecioPorNoche());
				  pstm.setInt(5,hab.getEstadoHabitacion());
			      estado=pstm.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				
				if(conn!=null)conn.close();
				if(pstm!=null)pstm.close();
				
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
		
		
		return estado;
	}
	

	@Override
	public List<Habitacion> listarHabitacion() throws SQLException {
		
		List<Habitacion>salida = new ArrayList<Habitacion>();
		Connection cn =null;
		PreparedStatement pstm=null;
		ResultSet rs=null;
		
		try {
			cn=new ConexionDB().getConexion();
			String sql ="select h.numeroHabitacion,ch.nombreCategoria,h.numeroPiso,h.precioPorNoche,e.nombreEstado,th.nombreTipo from habitacion h inner join estado e on h.estadoHabitacion = e.codigoEstado inner join  tipo_habitacion th on  h.tipoHabitacion = th.codigoTipo inner join categoria_habitacion ch on h.categoriaHabitacion = ch.codigoCategoria";
			pstm=cn.prepareStatement(sql);
		
			rs=pstm.executeQuery();
			Habitacion h =null;
			
			while (rs.next()) {
             h= new Habitacion();
         	h.setNumeroHabitacion(rs.getInt("numeroHabitacion"));
			h.setNombreCategoria(rs.getString("categoriaHabitacion"));
			h.setNombreTipo(rs.getString("tipoHabitacion"));
			//h.setNombreHabitacion(rs.getString("nombreHabitacion"));
			h.setNumeroPiso(rs.getInt("numeroHabitacion"));
			h.setPrecioPorNoche(rs.getDouble("precioPorNoche"));
			h.setNombreEstado(rs.getString("estadoHabitacion"));
			salida.add(h);
             	
			}
			
			
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
finally
{
	
	try {
		if(rs!= null) rs.close();
		if(pstm!= null) pstm.close();
		if(cn!= null) cn.close();
	
} catch (Exception e2) {
e2.printStackTrace();
}}
	
	
		
		return salida;
	}
	

	@Override
	public int actualizarHabitacion(Habitacion hab) throws SQLException {
		int estado=0;
		Connection conn=null;
		PreparedStatement pstm = null;
		
		try {
			
		  conn = new ConexionDB().getConexion();
		  String sql = "update habitacion set categoriaHabitacion=?,tipoHabitacion=?,nombreHabitacion=?,numeroPiso=?,precioPorNoche=?,estadoHabitaacion=? where numeroHabitacion=?";
				  pstm=conn.prepareStatement(sql);
				  pstm.setInt(1,hab.getCategoriaHabitacion());
				  pstm.setInt(2, hab.getTipoHabitacion());
				  pstm.setString(3, hab.getNombreHabitacion());
				  pstm.setInt(4, hab.getNumeroPiso());
				  pstm.setDouble(5, hab.getPrecioPorNoche());
				  pstm.setInt(6,hab.getEstadoHabitacion());
				  pstm.setInt(7, hab.getNumeroHabitacion());
			      estado=pstm.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				
				if(conn!=null)conn.close();
				if(pstm!=null)pstm.close();
				
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	
		return estado;
	}
	
	@Override
	public int eliminarHabitacion(int x,  int codigo) throws SQLException {
		int estado=0;
		Connection conn=null;
		PreparedStatement pstm = null;
		
		try {	
		  conn = new ConexionDB().getConexion();
		  String sql = "update habitacion set estadoHabitacion=? where numeroHabitacion=?";
				  pstm=conn.prepareStatement(sql);
				  pstm.setInt(1,x);
				  pstm.setInt(2,codigo);
			      estado=pstm.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				
				if(conn!=null)conn.close();
				if(pstm!=null)pstm.close();
				
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
		
		
		return estado;
	}

	@Override
	public List<Habitacion> buscarHabitacionPorCategoria(int categoria) throws SQLException {
		List<Habitacion>salida = new ArrayList<Habitacion>();
		Connection cn =null;
		PreparedStatement pstm=null;
		ResultSet rs=null;
	    
		try {
			cn=new ConexionDB().getConexion();
			String sql ="select numeroHabitacion from habitacion where codigoCategoria=?";
			
			pstm=cn.prepareStatement(sql);
			pstm.setInt(1, categoria);
			
			
			rs=pstm.executeQuery();
			Habitacion h =null;
			
			while (rs.next()) {
             h= new Habitacion();
         	h.setNumeroHabitacion(rs.getInt("numeroHabitacion"));
			h.setNombreCategoria(rs.getString("categoriaHabitacion"));
			h.setNombreTipo(rs.getString("tipoHabitacion"));
			//h.setNombreHabitacion(rs.getString("nombreHabitacion"));
			h.setNumeroPiso(rs.getInt("numeroHabitacion"));
			h.setPrecioPorNoche(rs.getDouble("precioPorNoche"));
			h.setNombreEstado(rs.getString("estadoHabitacion"));
			salida.add(h);
             	
			}
					
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
finally
{
	
	try {
		if(rs!= null) rs.close();
		if(pstm!= null) pstm.close();
		if(cn!= null) cn.close();
	
} catch (Exception e2) {
e2.printStackTrace();
}}
		
		return salida;
	}

	@Override
	public List<Habitacion> buscarHabitacionPorTipo(int tipo) throws SQLException {
		List<Habitacion>salida = new ArrayList<Habitacion>();
		Connection cn =null;
		PreparedStatement pstm=null;
		ResultSet rs=null;
		
		try {
			cn=new ConexionDB().getConexion();
			String sql ="";
			
			pstm=cn.prepareStatement(sql);
			pstm.setInt(1,tipo);
			
			
			rs=pstm.executeQuery();
			Habitacion h =null;
			
			while (rs.next()) {
             h= new Habitacion();
         	h.setNumeroHabitacion(rs.getInt("numeroHabitacion"));
			h.setNombreCategoria(rs.getString("categoriaHabitacion"));
			h.setNombreTipo(rs.getString("tipoHabitacion"));
			//h.setNombreHabitacion(rs.getString("nombreHabitacion"));
			h.setNumeroPiso(rs.getInt("numeroHabitacion"));
			h.setPrecioPorNoche(rs.getDouble("precioPorNoche"));
			h.setNombreEstado(rs.getString("estadoHabitacion"));
			salida.add(h);
             	
			}
					
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
finally
{
	
	try {
		if(rs!= null) rs.close();
		if(pstm!= null) pstm.close();
		if(cn!= null) cn.close();
	
} catch (Exception e2) {
e2.printStackTrace();
}}
		
		return salida;
	}

	

	@Override
	public List<Habitacion> buscarHabitacionPorTipoCategoria(int cat, int tip) throws SQLException {
		List<Habitacion>salida = new ArrayList<Habitacion>();
		Connection cn =null;
		PreparedStatement pstm=null;
		ResultSet rs=null;
		
		try {
			cn=new ConexionDB().getConexion();
			String sql ="select h.numeroHabitacion ,c.nombreCategoria,t.nombreTipo,h.numeroPiso,h.precioPorNoche,e.nombreEstado from habitacion h inner join categoria_habitacion c on h.categoriaHabitacion=c.codigoCategoria inner join tipo_Habitacion t on h.tipoHabitacion=t.codigoTipo inner join estado e on h.estadoHabitacion=e.codigoEstado where h.categoriaHabitacion =? and h.tipoHabitacion =?";
			
			pstm=cn.prepareStatement(sql);
			pstm.setInt(1, cat);
			pstm.setInt(2, tip);
			
			
			rs=pstm.executeQuery();
			Habitacion h =null;
			
			while (rs.next()) {
             h= new Habitacion();
         	h.setNumeroHabitacion(rs.getInt("numeroHabitacion"));
			h.setNombreCategoria(rs.getString("c.nombreCategoria"));
			h.setNombreTipo(rs.getString("t.nombreTipo"));
			//h.setNombreHabitacion(rs.getString("nombreHabitacion"));
		    h.setNumeroPiso(rs.getInt("h.numeroPiso"));
			h.setPrecioPorNoche(rs.getDouble("h.precioPorNoche"));
			h.setNombreEstado(rs.getString("e.nombreEstado"));
			salida.add(h);
             	
			}
					
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
finally
{
	
	try {
		if(rs!= null) rs.close();
		if(pstm!= null) pstm.close();
		if(cn!= null) cn.close();
	
} catch (Exception e2) {
e2.printStackTrace();
}}
		
		return salida;
	}

	}





