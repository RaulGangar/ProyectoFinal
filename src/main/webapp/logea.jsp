<jsp:include page="plantillas/cabecera.jsp"/>
<jsp:include page="plantillas/menu.jsp"/>

    <div class="container w-50">

        <h1>Administracion</h1>

        <form action="login" method="post">
                <label for="nombre" class="form-label">Nombre:</label>
                <input type="text" 
                       name="nombre" 
                       id="nombre"
                       required 
                       autofocus 
                       class="form-control" 
                       placeholder="Nombre de Administrador">

                <label for="contraseina" class="form-label">contraseña:</label>
                <input type="password" 
                       name="contraseina" 
                       id="contraseina"
                       required 
                       class="form-control" 
                       placeholder="Password" >

                <input type="submit" value="Enviar" class="btn btn-block btn-dark mt-4">
        </form>


    </div>

 <jsp:include page="plantillas/footer.jsp"/>