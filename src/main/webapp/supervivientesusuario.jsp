<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<jsp:include page="plantillas/cabecera.jsp" />
<jsp:include page="plantillas/menu.jsp" />


<script> 
function vermas(id){
if(id=="mas"){
document.getElementById("desplegar").style.display="block";   
document.getElementById("mas").style.display="none"; 
}
else{
document.getElementById("desplegar").style.display="none";
document.getElementById("mas").style.display="inline";
}
}
</script>

<main class="container">
	<h1>${fn:length(supervivientes)}Supervivientes</h1>

	<form action="supervivienteslista" method="get">
		<div class="input-group">
			<div class="form-outline">
				<input type="search" name="filtro" value="${filtro}"
					class="form-control" placeholder="Nombre" />
			</div>
			<button type="submit" class="btn btn-primary">
				<i class="fas fa-search"></i>
			</button>
		</div>
	</form>
<div id="contenedor-cartas">
	<c:forEach var="pIteracion" items="${supervivientes}">
			<div class="card">
				<img src="${pIteracion.imagen}" alt="imagen avatar usuario" class="">
				<div class="card-body">
					<h5 class="card-title">${pIteracion.nombre}</h5>
					<p class="card-text">
						<c:set var = "string1" value = "${pIteracion.historia}" />
      					<c:set var = "string2" value = "${fn:substring(string1, 0, 448)}" />
						<p>${string2}...</p>
						<button type="button" class="btn btn-dark" data-bs-toggle="modal" data-bs-target="#exampleModal">
  						Leer mas.</button>
						<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
  							<div class="modal-dialog">
    							<div class="modal-content">
      								<div class="modal-header">
        								<h5 class="modal-title" id="exampleModalLabel">Modal title</h5>
        								<button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      								</div>
      								<div class="modal-body">
        								${pIteracion.historia}
      								</div>
      								<div class="modal-footer">
        								<button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cerrar</button>
      								</div>
    							</div>
  							</div>
						</div>				 
				</div>
			</div>
	</c:forEach>
</div>

</main>

<jsp:include page="plantillas/footer.jsp" />