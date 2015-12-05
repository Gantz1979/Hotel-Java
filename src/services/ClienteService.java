package services;

import interfaces.ClienteDAO;






import java.sql.SQLException;
import java.util.List;

import dao.Fabrica;
import beans.Cliente;





public class ClienteService {
	   Fabrica fabrica = Fabrica.obtenerTipo(Fabrica.MYSQL);
	    ClienteDAO dao = fabrica.getCliente();
	
	public int registrar(Cliente bean){
		  try {
			  
				return dao.registrarCliente(bean);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		  
		  return 0;
	   }
	
	public int actualiza(Cliente cli){
		  try {
			  
				return dao.actualizarCliente(cli);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		  
		  return 0;
	   }
	
	

	
	
	public int eliminar(int codigo){
		  try {
			  
				return dao.eliminarCliente(codigo);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		  
		  return 0;
	}

		
	public List<Cliente > listarXnombre(String nombre){
		try {
			return dao.listarXnombre(nombre);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}return null;
	}

	
	
}


