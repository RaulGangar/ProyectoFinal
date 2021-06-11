<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri = "http://java.sun.com/jsp/jstl/functions"  %>

<jsp:include page="../plantillas/cabecera.jsp"/>
<jsp:include page="../plantillas/menu.jsp"/>

 <main class="container">
    <h1>${fn:length(asesinos)} Asesinos</h1>
    <a href="backoffice/asesinos-editar?id=0">Nuevo Asesino</a>
    
    <form action="backoffice/asesinos-listar" method="get">
	    <div class="input-group">
		  <div class="form-outline">
		    <input type="search" name="filtro"
		           value="${filtro}" 
		           class="form-control"		           
		           placeholder="Nombre"/>	    
		  </div>
		  <button type="submit" class="btn btn-primary">
		    <i class="fas fa-search"></i>
		  </button>
		</div>
	</form>
    
   
    <table class="table table-striped table-hover">
        <thead>
          <tr>
            <th scope="col">#</th>
            <th scope="col">Imagen</th>
            <th scope="col">Nombre</th>
            <th scope="col">Historia</th>
            <th scope="col">Editar</th>
            <th scope="col">Eliminar</th>
          </tr>
        </thead>
        <tbody>
        <!-- 
        	recorrer atributo con la lista de particpantes y pintar TR
        	items="$ { asesinos}" => Nombre del atributo que nos envia en controlador
        	var="pIteracion"           => nombre de la variable que iteramos que es un Participante 
        
        	${p.nombre} es lo mismo que p.getNombre(), es una forma abreviada
        	
        	for ( Participante pIteracion : asesinos )
        
        -->
        
	        <c:forEach var="pIteracion" items="${asesinos}">
	          <tr>
	            <th scope="row">${pIteracion.id}</th>
	            <td><img src="${pIteracion.imagen}" alt="imagen avatar usuario" class=""/></td>
	            <td>${pIteracion.nombre}</td>
	            <td>${pIteracion.historia}</td>
	            <td><a href="backoffice/asesinos-editar?id=${pIteracion.id}" class="btn btn-outline-primary">Editar</a></td>
	            <td><a onclick="confirmarEliminacion('${pIteracion.nombre}')" class="btn btn-outline-danger" href="backoffice/asesinos-eliminar?id=${pIteracion.id}">Eliminar</a></td>
	          </tr>
	         </c:forEach> 
	         
        <!-- terminamos de recorrer -->
        </tbody>
      </table>
      
      <script>
      	
      	function confirmarEliminacion(nombre){
      		
      		if ( window.confirm("¿ Quieres Eliminar a " + nombre + " ?") ){
      			console.debug('eliminamos');
      		}else {
      			event.preventDefault(); // prevenir que el ancla haga su funcion
      			console.debug('No Eliminamos');
      		}
      		
      	}
      
      </script>
        
</main> 

<jsp:include page="../plantillas/footer.jsp"/>