<%@page import="java.util.List"%>
<%@page import="beans.Habitacion"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>


<!DOCTYPE html>
<html lang="esS">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    

<link rel="stylesheet" href="css/bootstrapValidator.css">
<script src="js/jquery-1.10.2.min.js"></script>
<script src="js/bootstrapValidator.js"></script>



    <title>SB Admin 2 - Bootstrap Admin Theme</title>

    <!-- Bootstrap Core CSS -->
    <link href="bower_components/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">

    <!-- MetisMenu CSS -->
    <link href="bower_components/metisMenu/dist/metisMenu.min.css" rel="stylesheet">

    <!-- Timeline CSS -->
    <link href="dist/css/timeline.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="dist/css/sb-admin-2.css" rel="stylesheet">

    <!-- Morris Charts CSS -->
    <link href="bower_components/morrisjs/morris.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="bower_components/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
    
    

</head>






<body>
               
               
               
               
               
                  
             <!-- Permite la conexion -->
<sql:setDataSource driver="com.mysql.jdbc.Driver"
                   url="jdbc:mysql://localhost:3306/hotel"
                   user="root"
                   password=""
                   var="miConexion"/>

<!-- Se prepara el SQL -->
<sql:query  var="sql1" 
			sql="SELECT * FROM categoria_habitacion"
			dataSource="${miConexion}"/>
			
			
			<sql:query  var="sql2" 
			sql="SELECT * FROM tipo_habitacion"
			dataSource="${miConexion}"/>
			
			
			<sql:query  var="sql3" 
			sql="SELECT * FROM estado"
			dataSource="${miConexion}"/>

			
<!-- Se recorre los datos -->


    

    <div id="wrapper">

        <!-- Navigation -->
        <nav class="navbar navbar-default navbar-static-top" role="navigation" style="margin-bottom: 0">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="index.jsp">Sistema de Hotel</a>
            </div>
            <!-- /.navbar-header -->

            <ul class="nav navbar-top-links navbar-right">
                <li class="dropdown">
                    <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                        <i class="fa fa-user fa-fw"></i>  <i class="fa fa-caret-down"></i>
                    </a>
                    <ul class="dropdown-menu dropdown-messages">
                       
                        <li><a href="#"><i class="fa fa-user fa-fw"></i> Cuenta de usuario</a>
                        </li>
                        <li><a href="#"><i class="fa fa-gear fa-fw"></i> Configuración</a>
                        </li>
                        <li class="divider"></li>
                        <li><a href="login.jsp"><i class="fa fa-sign-out fa-fw"></i>Cerrar sesión</a>
                        </li>
                       
                    </ul>
                    <!-- /.dropdown-messages -->
                </li>
             
                <!-- /.dropdown -->
            </ul>
      
            <!-- /.navbar-top-links -->

            <div class="navbar-default sidebar" role="navigation">
                <div class="sidebar-nav navbar-collapse">
                    <ul class="nav" id="side-menu">
                        <li class="sidebar-search">
                            <div class="input-group custom-search-form">
                                <input type="text" class="form-control" placeholder="Search...">
                                <span class="input-group-btn">
                                <button class="btn btn-default" type="button">
                                    <i class="fa fa-search"></i>
                                </button>
                            </span>
                            </div>
                            <!-- /input-group -->
                        </li>
                        <li>
                            <a href="FrmReserva.jsp"><i class="fa fa-dashboard fa-fw"></i> Reserva </a>
                        </li>
                           <li>
                            <a href="Hospedaje.jsp"><i class="fa fa-dashboard fa-fw"></i> Hospedaje </a>
                        </li>
                        
                            <li>
                            <a href="FrmFacturacion.jsp"><i class="fa fa-dashboard fa-fw"></i>Facturación</a>
                        </li>
                    
                    
                        <li>
                            <a href="#"><i class="fa fa-sitemap fa-fw"></i> Mantenimiento<span class="fa arrow"></span></a>
                            <ul class="nav nav-second-level">
                                <li>
                                    <a href="MantenimientoHabitacion.jsp">Habitación</a>
                                </li>
                            <li>
                                    <a href="FrmMantenerCliente.jsp">Cliente</a>
                                </li>
                                <li>
                                    <a href="#">Servicios<span class="fa arrow"></span></a>
                                    <ul class="nav nav-third-level">
                                        <li>
                                            <a href="MantenimientoAlimento.jsp">Alimentos</a>
                                        </li>
                                        <li>
                                            <a href="MantenimientoServicioLlamadas.jsp">Llamadas</a>
                                        </li>
                                        <li>
                                            <a href="#">Lavandería </a>
                                        </li>
                                       
                                    </ul>
                                    <!-- /.nav-third-level -->
                                </li>
                            </ul>
                            <!-- /.nav-second-level -->
                        </li>
                    </ul>
                </div>
                <!-- /.sidebar-collapse -->
            </div>
            <!-- /.navbar-static-side -->
        </nav>

        <div id="page-wrapper">
         
            <!-- /.row -->
            
             <div class="row">
            <section>
                <div class="col-lg-8 col-lg-offset-1">
                    <div class="page-header">
                        <h2>Mantenimiento de Habitaciones</h2>
                    </div>

                    <ul class="nav nav-tabs">
                        <li class="active"><a href="#info-tab" data-toggle="tab">Mantenimiento de Habitacion <i class="fa"></i></a></li>
                        <li><a href="#address-tab" data-toggle="tab">Actualizar datos <i class="fa"></i></a></li>
                    </ul>

                    <form  class="form-horizontal" action="habitacion" style="margin-top: 20px;">
                    <input type="hidden" name="metodo" value="registrar">
                        <div class="tab-content">
                            <div class="tab-pane active" id="info-tab">
                             
                                     <div class="form-group">
                                    <label class="col-lg-3 control-label">Número de Piso</label>
                                    <div class="col-lg-5">
                                        <input type="text" class="form-control" name="txtPiso" />
                                    </div>
                             
                                    
                                </div>
                                
                                <div class="form-group">
                            <label class="col-lg-3 control-label">Categoria</label>
                            <div class="col-lg-5">
                                <select class="form-control" name="cboCategoria">
                                    
                                    <c:forEach var="fila1" items="${sql1.rows}" >
                                    <option value="<c:out value="${fila1.codigoCategoria}"/>">
                                    <c:out value="${fila1.nombreCategoria}"/>
                                    </option>
                                   
                                  </c:forEach>
                         
                                </select>
                            </div>
                            
                               
                        </div> 
                        
                             
                          <div class="form-group">
                            <label class="col-lg-3 control-label">Tipo de Habitacion</label>
                            <div class="col-lg-5">
                                <select class="form-control" name="cboTipo">
                                    
                                    <c:forEach var="fila2" items="${sql2.rows}" >
                                    <option value="<c:out value="${fila2.codigoTipo}"/>">
                                    <c:out value="${fila2.nombreTipo}"/>
                                    </option>
                                   
                                  </c:forEach>
                         
                                </select>
                            </div>
                            
                               
                        </div> 
                           <div class="form-group">
                            <label class="col-lg-3 control-label">Estado de habitación</label>
                            <div class="col-lg-5">
                                <select class="form-control" name="cboEstado">
                                    
                                    <c:forEach var="fila3" items="${sql3.rows}" >
                                    <option value="<c:out value="${fila3.codigoEstado}"/>">
                                    <c:out value="${fila3.nombreEstado}"/>
                                    </option>
                                   
                                  </c:forEach>
                         
                                </select>
                            </div>
                            
                               
                        </div> 
                        
                     
                            
                               
                        </div>  
                        
                        
                               <div class="form-group">
                                    <label class="col-lg-3 control-label">Precio por noche</label>
                                    <div class="col-lg-5">
                                        <input type="text" class="form-control" name="txtPrecio" />
                                    </div>
                                    
                                </div>
        <div class="form-group">
                            <div class="col-lg-5 col-lg-offset-3">
                                <button type="submit" class="btn btn-primary">Grabar</button>
                            </div>
                        </div>
                                
                                
                                
                            </div>
                            
                            <p align="center" ><a href="habitacion?metodo=listar"> + Listar</a>
                        
<%
     List<Habitacion> hab=(List<Habitacion>)request.getAttribute("data");
%>              
                            
                            
        <div class="form-group">
           <div class="col-lg-12">      
                              
		 <table class="table">
			 <thead>
			     <tr>
			        <th>N° Habitacion</th>
			        <th>Categoria</th>
			        <th>Piso</th>
			        <th>Precio</th>
			        <th>Estado</th>     
			        <th>Tipo</th>
			        
			       
			      </tr>
			 </thead>
			 
		<% if(hab!=null) {
			
			for(Habitacion h:hab){
		%>	 
			 
			 
			 <tr>
			 
			 <td><%=h.getNumeroHabitacion()%></td>
             <td><%=h.getNombreCategoria()%></td>
             <td><%=h.getNumeroPiso()%></td>
             <td><%=h.getPrecioPorNoche()%></td>
             <td><%=h.getNombreEstado()%></td>
             <td><%=h.getNombreTipo()%></td>
			 
			 
			 </tr>
			 
			 
	<%
		}
			
			}
	%>		 
			 
		
		</table>
		
	</div>

           </div>    
                            
                            
     
                    
     
                    </form>
   
     </div>  
     
           
                   
                                </section>
                </div>

        </div>
            

                  
            <!-- /.row -->
        </div>
        <!-- /#page-wrapper -->

    
    <!-- /#wrapper -->

    <!-- jQuery -->
    <script src="bower_components/jquery/dist/jquery.min.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="bower_components/bootstrap/dist/js/bootstrap.min.js"></script>

    <!-- Metis Menu Plugin JavaScript -->
    <script src="ower_components/metisMenu/dist/metisMenu.min.js"></script>

    <!-- Morris Charts JavaScript -->
    <script src="bower_components/raphael/raphael-min.js"></script>
    <script src="bower_components/morrisjs/morris.min.js"></script>
    <script src="js/morris-data.js"></script>

    <!-- Custom Theme JavaScript -->
    <script src="dist/js/sb-admin-2.js"></script>
    
    
      <!-- DataTables JavaScript -->
    <script src="bower_components/datatables/media/js/jquery.dataTables.min.js"></script>
    <script src="bower_components/datatables-plugins/integration/bootstrap/3/dataTables.bootstrap.min.js"></script>

    <!-- Custom Theme JavaScript -->
  

    <!-- Page-Level Demo Scripts - Tables - Use for reference -->
    <script>
    $(document).ready(function() {
        $('#dataTables-example').DataTable({
                responsive: true
        });
    });
    </script>
 
    
    
    
    
    
    
    
    
    
    

</body>






</html>
