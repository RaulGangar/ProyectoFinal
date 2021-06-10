<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<nav class="navbar navbar-expand-lg navbar-dark bg-primary">
   <div class="container-fluid">
     <a class="navbar-brand" href="index.jsp">Dead By Daylight</a>
     <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavDropdown" aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
       <span class="navbar-toggler-icon"></span>
     </button>
     
     <div class="collapse navbar-collapse" id="navbarNavDropdown">
       <ul class="navbar-nav">
       
         <c:if test="${usuario_logeado == null }">
	         <li class="nav-item">
	           <a class="nav-link ${ (param.page eq 'login') ? 'active' : '' }" 
	              href="logea.jsp?page=login">Login</a>
	         </li>
         </c:if>
         
          <c:if test="${usuario_logeado != null }">
	         <li class="nav-item">
	           <b>${usuario_logeado.nombre}</b>
	           <a class="nav-link" 
	              href="logout">Cerrar Sesi�n</a>
	         </li>
         </c:if>
         
         <!-- visible solo para ADMINISTRADORES -->
         <c:if test="${usuario_logeado.rol == 2 }">
	         <li class="nav-item">
	           <a class="nav-link ${ (param.page eq 'supervivientes') ? 'active' : '' }" 
	              href="backoffice/supervivientes-listar">Supervivientes</a>
	         </li>
	         
         </c:if>

         <li class="nav-item">
           <a class="nav-link" 
              href="calculadora.jsp">Asesinos</a>
         </li>
         
         <li class="nav-item">
           <a class="nav-link" 
              href="supervivienteslista">Supervivientes</a>
         </li>
         
       </ul>
     </div>
   </div>
</nav>

 
<c:if test="${mensaje != null}" >
	<div class="alert alert-${mensajeTipo} alert-dismissible fade show" role="alert">
	  ${mensaje}
	  <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
	</div>
	
	
	<% 
	    //despues de pintar el mensaje, eliminarlo para que no se guarde en session
	    session.setAttribute("mensaje", null); 
		session.setAttribute("mensajeTipo", null);
	%>
	
</c:if>	
 
 