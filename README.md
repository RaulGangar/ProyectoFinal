# Dead By Daylight Database

Proyecto Web **Java EE** siguiendo el patrón de **MVC** contra una base de datos **sqlite**
CMS para gestionar diferentes tablas de la base de datos.


![screenshot 1]( https://github.com/RaulGangar/ProyectoFinal/blob/master/Captura1.JPG)


## Técnologia

- Maven 4.0.0
- Java 8
- Java Servlet Api 3.1.0
- JSP 2.2
- JSTL 1.2
- Bootstrap 5.0.0
- FontAwesome 5.15.3


Para ver mas detalles sobre las depencias (jars) de este proyecto mirar el [pom.xml](https://github.com/RaulGangar/ProyectoFinal/blob/master/pom.xml)

## Instalación Proyecto

Abrir eclipse y usar la opción de **Import > Existing Maven Project**
Seleccionar la carpeta donde se ha bajado el proyecto para que encuentre el fichero **pom.xml**
Esperar unos segundos a que configure el proyecto


## configuración de la bbdd

La base de datos es el fichero **cms.db**
Para realizar la conexion a la base de datos deberemos cmbiar el siguiente fichero **src\main\java\com\elorrieta\cms\modelo\dao\ConnectionHelper.java**
Solo debemos cambiar la siguiente variable con la ruta de la base de datos.
`
private static final String DIRECCION_BBDD = "jdbc:sqlite:C:\\desarrolloJava\\workspace\\cms\\dbd.db";
`


![entidad relacion]( https://github.com/RaulGangar/ProyectoFinal/blob/master/Captura2.JPG)



## Ejecutar Proyecto

Tratandose de un proyecto web emplearemos un servidor de aplicacione, en nuestro caso sera Apache Tomcat 8.5.

Podemos navegar entre asesinos y supervivientes desde el menu de la cabecera.
Si queremos modificar algo de asesinos y supervivientes deberemos entrar en los paneles de Administracion desde *Iniciar sesion*
Habra un unico rol, Administrador:

-Administrador   **[admin,admin]** : Permisos Totales para cambiar cualquier asesino y superviviente.

#### UI de superviviente para administrador con rol = 2
![UI para usuario administrador](https://github.com/RaulGangar/ProyectoFinal/blob/master/Captura3.JPG)
#### UI de asesino para administrador con rol = 2
![UI para usuario administrador](https://github.com/RaulGangar/ProyectoFinal/blob/master/Captura4.JPG)

#### UI de asesino para cualquier visitante de la pagina
![UI para usuario normal](https://github.com/RaulGangar/ProyectoFinal/blob/master/Captura5.JPG)
#### UI de superviviente para cualquier visitante de la pagina
![UI para usuario normal](https://github.com/RaulGangar/ProyectoFinal/blob/master/Captura6.JPG)

## Estructura Clases del proyecto

Recomendamos consultar la documentacion **JavaDoc API**
 
Model Vista Controlador

- **vista** puedes encontrar las JSPs, css, imagenes, js en `src/main/webapp`
- **modelo** Los DAOs se encargan de conectar Java con la base de datos son los encargados de las consultas SQL `src/main/java/com/elorrieta/cms/modelo`
- **controlador** Controladores o Servlets `src/main/java/com/elorrieta/cms/controladores`

![estructura proyecto]( https://github.com/RaulGangar/ProyectoFinal/blob/master/Captura7.JPG)