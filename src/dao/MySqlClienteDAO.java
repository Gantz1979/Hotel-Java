package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;








import util.ConexionDB;

import beans.Cliente;
import interfaces.ClienteDAO;

public class MySqlClienteDAO  implements ClienteDAO{
	
	
	@Override
	public int registrarCliente(Cliente cli) throws SQLException {
		
		int estado = -1;
		Connection cn=null;
		PreparedStatement pstm=null;
		try {
			cn=new ConexionDB().getConexion();
			
			String sql="insert into cliente values(null,?,?,?,?,?,?,?,?,?,?,?,?)";
			
			pstm=cn.prepareStatement(sql);
		
			pstm.setString(1, cli.getTipoDocumento());
			pstm.setString(2, cli.getNumeroDocumento());
			pstm.setString(3,cli.getNombreCliente());
			pstm.setString(4, cli.getApelllidoPaterno());
			pstm.setString(5, cli.getApellidoMaterno());
			pstm.setString(6, cli.getProfesion());
			pstm.setString(7,cli.getSexo());
			pstm.setString(8, cli.getDireccion());
			pstm.setString(9, cli.getCelular());
			pstm.setString(10, cli.getTelefono());
			pstm.setString(11, cli.getEmail());
			pstm.setString(12, cli.getFecha());
			
			estado=pstm.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally
		{
			try {
				if(pstm!=null)pstm.close();if(cn!=null)cn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return estado;
	}
		
		
		
		
		
		
		
		
		
		


	
	@Override
	public int actualizarCliente(Cliente cli) throws SQLException {
		int estado = -1;
		Connection cn=null;
		PreparedStatement pstm=null;
		try {
			cn=new ConexionDB().getConexion();
			
			String sql="----------------------------------";
			
			pstm=cn.prepareStatement(sql);
		
			pstm.setString(1, cli.getTipoDocumento());
			pstm.setString(2, cli.getNumeroDocumento());
			pstm.setString(3,cli.getNombreCliente());
			pstm.setString(4, cli.getApelllidoPaterno());
			pstm.setString(5, cli.getApellidoMaterno());
			pstm.setString(6, cli.getProfesion());
			pstm.setString(7,cli.getSexo());
			pstm.setString(8, cli.getDireccion());
			pstm.setString(9, cli.getCelular());
			pstm.setString(10, cli.getTelefono());
			pstm.setString(11, cli.getEmail());
			pstm.setString(12, cli.getFecha());
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally
		{
			try {
				if(pstm!=null)pstm.close();if(cn!=null)cn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return estado;
	}
		
		
		
	

	@Override
	public int eliminarCliente( int codigo) throws SQLException {
		String query = "DELETE FROM cliente  where codigoCliente=?";
		Connection con = null;
		PreparedStatement pstm = null;
		try {
			con = new  ConexionDB().getConexion();
			pstm = con.prepareStatement(query);
			pstm.setInt(1, codigo);
			int i = pstm.executeUpdate();
			if (i != 1) {
				throw new SQLException("No se pudo eliminar");
			}
			
     		
		
	} catch (Exception e) {
		e.printStackTrace();
	}
	finally
	{
		try {
			if(pstm!=null)pstm.close();
			if(con!=null)con.close();
		} catch (Exception e2) {
			e2.printStackTrace();
		}
		
	}
	return codigo;
	
	}











	@Override
	public List<Cliente> listarXnombre(String nombre) throws SQLException {
		  List<Cliente> salida = new ArrayList<Cliente>();
			
			Connection conn= null;
			PreparedStatement pstm = null;
			ResultSet rs = null;
			try {
				
				conn = new ConexionDB().getConexion();
				String sql ="SELECT * FROM cliente WHERE nombreCliente LIKE '%"
						 + nombre + "%'";
				pstm = conn.prepareStatement(sql);
				
				
				rs = pstm.executeQuery();
				Cliente a = null;
				while(rs.next()){
					a = new Cliente();
					a.setCodigoCliente(rs.getInt(1));
					a.setTipoDocumento(rs.getString(2));
					a.setNumeroDocumento(rs.getString(3));
					a.setNombreCliente(rs.getString(4));
					a.setApelllidoPaterno(rs.getString(5));
					a.setApellidoMaterno(rs.getString(6));
					a.setProfesion(rs.getString(7));
					a.setSexo(rs.getString(8));
					a.setDireccion(rs.getString(9));
					a.setCelular(rs.getString(10));
					a.setTelefono(rs.getString(11));
					a.setEmail(rs.getString(12));
					a.setFecha(rs.getString(13));
					salida.add(a);
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally{
				try {
					if(rs!= null) rs.close();
					if(pstm!= null) pstm.close();
					if(conn!= null) conn.close();
				} catch (Exception e2) {
				}
			}
			return salida;
		}


}









