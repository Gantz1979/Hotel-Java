<%@page import="java.util.List"%>
<%@ taglib prefix="c"   
		uri="http://java.sun.com/jsp/jstl/core" %>

<%@ taglib prefix="fmt"   
		uri="http://java.sun.com/jsp/jstl/fmt" %>
		





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
                        <li><a href="#"><i class="fa fa-gear fa-fw"></i> Configuraci�n</a>
                        </li>
                        <li class="divider"></li>
                        <li><a href="login.jsp"><i class="fa fa-sign-out fa-fw"></i>Cerrar sesi�n</a>
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
                            <a href="FrmFacturacion.jsp"><i class="fa fa-dashboard fa-fw"></i>Facturaci�n</a>
                        </li>
                    
                      
                
             
                        <li>
                            <a href="#"><i class="fa fa-sitemap fa-fw"></i> Mantenimiento<span class="fa arrow"></span></a>
                            <ul class="nav nav-second-level">
                                <li>
                                    <a href="MantenimientoHabitacion.jsp">Habitaci�n</a>
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
                                            <a href="#">Lavander�a </a>
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
         
            
            
             <div class="row">
            <section>
                <div class="col-lg-8 col-lg-offset-1">
                    <div class="page-header">
                        <h2>Mantenimiento de Clientes</h2>
                    </div>
   <div class="container">
        <div class="row">
            <section>
                <div class="col-lg-8 col-lg-offset-2">
                    <div class="page-header">
                        <h2>Mantenimiento de Clientes</h2>
                    </div>

                    <ul class="nav nav-tabs">
                        <li class="active"><a href="#info-tab" data-toggle="tab">Registro  de clientes <i class="fa"></i></a></li>
                        <li><a href="#ListaCliente-tab" data-toggle="tab">Lista Clientes <i class="fa"></i></a></li>
                    </ul>

                    <form action="cliente"  id="dataCliente" method="post" class="form-horizontal"  style="margin-top: 20px;">
                    
                        <div class="tab-content">
                            <div class="tab-pane active" id="info-tab">
                            
                            	<input type="hidden" name="metodo" value="registra" />
                            
                                <div class="form-group">
                                
                                <label class="col-lg-3 control-label">Tipo Doc.</label>
                                    <div class="col-lg-5">
                                    
                                        <select class="form-control" id="cbotipo" name="cbotipo">
                                            <option value="">Seleccione tipo de documento</option>
                                            <option value="DNI">DNI</option>
                                            <option value="PASAPORTE">PASAPORTE</option>
                                            <option value="RUC">RUC</option>
                                            <option value="MILITAR">MILITAR</option>
                                           </select>
                                    </div>
                                </div>
                                
                                
                                
                                
                                
                     
                                 <div class="form-group">
                                    <label class="col-lg-3 control-label">N�:</label>
                                    <div class="col-lg-5">
                                        <input type="text" id="txtnumero" class="form-control" name="txtnumero" />
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-lg-3 control-label">Nombre:</label>
                                    <div class="col-lg-5">
                                        <input type="text"   id="txtnombre" class="form-control" name="txtnombre" />
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-lg-3 control-label">Apellidos Paterno:</label>
                                    <div class="col-lg-5">
                                        <input type="text"  id="txtapellidopa" class="form-control" name="txtapellidopa" />
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-lg-3 control-label">Apellido Materno:</label>
                                    <div class="col-lg-5">
                                        <input type="text"   id="txtapellidoma"  class="form-control" name="txtapellidoma" />
                                    </div>
                                </div>
                                  <div class="form-group">
                                    <label class="col-lg-3 control-label">Profesi�n:</label>
                                    <div class="col-lg-5">
                                        <input type="text" id="txtprofesion" class="form-control" name="txtprofesion" />
                                    </div>
                                </div>
                                 <div class="form-group">
                                
                                <label class="col-lg-3 control-label">Sexo</label>
                                    <div class="col-lg-5">
                                        <select class="form-control" id="cbosexo" name="cbosexo"> <!-- /.name  llama ala validaciones del scrip  -->
                                            <option value="">Seleccione Sexo</option>
                                            <option value="Masculino">Masculino</option>
                                            <option value="Femenino">Femenino</option>
                                            
                                        </select>
                                    </div>
                                </div>
                                
                                 <div class="form-group">
                                    <label class="col-lg-3 control-label">Direcci�n:</label>
                                    <div class="col-lg-5">
                                        <input type="text" id="txtdireccion" class="form-control" name="txtdireccion" />
                                    </div>
                                </div>
                                 <div class="form-group">
                                    <label class="col-lg-3 control-label">Celular:</label>
                                    <div class="col-lg-5">
                                        <input type="text" id="txtcelular"    class="form-control" name="txtcelular" />
                                    </div>
                                </div>
                                 <div class="form-group">
                                    <label class="col-lg-3 control-label">Telefono:</label>
                                    <div class="col-lg-5">
                                        <input type="text" id="txttelefono" class="form-control" name="txttelefono" />
                                    </div>
                                </div>
                                 <div class="form-group">
                                    <label class="col-lg-3 control-label">Email:</label>
                                    <div class="col-lg-5">
                                        <input type="text" id="txtemail" class="form-control" name="txtemail" />
                                    </div>
                                </div>
                           
                             <div class="form-group">
                            <label class="col-lg-3 control-label">Dia/Mes/A�o:</label>
                            <div class="col-lg-5">
                            
                                <input type="date" id="txtfecha" class="form-control" name="txtfecha" />
                            </div>
                        </div>

                        <div class="form-group">
                            <div class="col-lg-5 col-lg-offset-3">
                               <button type="submit" class="btn btn-primary" name="envio" value="envio">Guardar</button>
                               
                                <button type="reset" class="btn btn-primary" name="limpiar" value="limpiar">Nuevo</button>
                                 <button type="button"  class="btn btn-primary" name="cancelar" value="limpiar">Cancelar</button>
                            </div>
                        </div>
                                 
                            </div>
                            <div class="tab-pane" id="ListaCliente-tab" >
                            
                                <div class="form-group" >
                                    <label class="col-lg-3 control-label">Nombre Completo</label>
                                    <div class="col-lg-5">
                                        <input type="text" class="form-control" name="filtro"   />
                                    </div>
                                </div><div class="form-group">
                            <div class="col-lg-5 col-lg-offset-3">
                               
                                 <button type="submit" class="btn btn-primary" name="operacion" value="filtrar"   style="width:110px">Buscar</button>
                            </div>
                        </div>
                            

                            
     <div class="table-responsive">
     <table class="table " >

         <thead>
         
         
   		    <tr>
   		    
   		    
			<th >C�digo</th>
   			<th >Tipo Doc</th>
    		<th >Nombre</th>
    		<th >ApellidosPaterno</th>
    		<th >ApellidosMaterno</th>
            <th >Profesi�n</th>
			<th >Sexo</th>
			<th >Direcci�n</th>
			<th>Celular</th>
            <th >Telefono</th>
            <th >Email</th>
            <th >Fecha</th>
            <th ></th>
            <th ></th>
             
     <c:forEach var="var"  items="${requestScope.clientes}" >
		<tr class="grilla_campo">
			<td>${var.codigoCliente}</td>
	

		

		
		 </tr>
		 </c:forEach>
			      
 </thead>
       


           
		    
		

   </table>
  
</div>   <!-- /.Termina table-responsive -->

</div>   <!-- /.Termina el panel-body -->
    
</div>   <!-- /.Termina panel -->
   
                
                     
</form>
</div>
</section>
</div>
</div><!-- /.Termina Contener -->

                </div>
                </section>

                  
            <!-- /.row -->
        </div>
        <!-- /#page-wrapper -->

    </div>
    <!-- /#wrapper -->

    <!-- jQuery -->
    <script src="bower_components/jquery/dist/jquery.min.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="bower_components/bootstrap/dist/js/bootstrap.min.js"></script>

    <!-- Metis Menu Plugin JavaScript -->
    <script src="bower_components/metisMenu/dist/metisMenu.min.js"></script>

    <!-- Morris Charts JavaScript -->
    <script src="bower_components/raphael/raphael-min.js"></script>
    <script src="bower_components/morrisjs/morris.min.js"></script>
    <script src="js/morris-data.js"></script>

    <!-- Custom Theme JavaScript -->
    <script src="dist/js/sb-admin-2.js"></script>
    </div>
    

</body>

</html>
