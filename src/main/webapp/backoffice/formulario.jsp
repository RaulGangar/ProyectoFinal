<jsp:include page="../plantillas/cabecera.jsp"/>
<jsp:include page="../plantillas/menu.jsp"/>

<main class="container">

	 <h1>${titulo}</h1>
        <form action="backoffice/supervivientes-editar" method="post" class="w-50">

			<p class="text-warning">ID esta oculto</p>
            <input type="text" 
                   name="id"                   
                   id="id"
                   value="${superviviente.id}"
                   required            
                   readonly       
                   class="form-control">

            <label for="nombre" class="form-label">Nombre:</label>
            <input type="text" 
                   name="nombre"                   
                   id="nombre"
                   value="${superviviente.nombre}"
                   required 
                   autofocus 
                   class="form-control" 
                   placeholder="Nombre completo">

            <label for="apellidos" class="form-label">Historia:</label>
            <input type="text" 
                    name="historia" 
                    id="historia"
                    value="${superviviente.historia}"
                    required                      
                    class="form-control" 
                    placeholder="introduce la historia">
  
            <label for="avatar" class="form-label">Imagen:</label>
            <input type="text" 
                    name="imagen"
                    id="imagen" 
                    value="${superviviente.imagen}"
                    required                      
                    class="form-control" 
                    placeholder="url de la imagen para la imagenr">       

            <input type="submit" value="${ ( superviviente.id == 0 ) ? 'Crear' : 'Editar' }" class="btn btn-block btn-primary mt-4">
        </form>

</main> 

<jsp:include page="../plantillas/footer.jsp"/>