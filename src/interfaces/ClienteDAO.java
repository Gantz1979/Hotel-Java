package interfaces;

import java.sql.SQLException;



import java.util.List;


import beans.Cliente;




public interface ClienteDAO {
	
    public abstract int registrarCliente(Cliente cli)throws SQLException;
   
    public abstract List<Cliente > listarXnombre(String nombre) throws SQLException;
    
    
    
	public abstract  int actualizarCliente( Cliente cli)throws SQLException;
	public abstract int  eliminarCliente(int codigo)throws SQLException;
	

	
	
	
	
	
}
