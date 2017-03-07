# Proyecto Dado

Proyecto web 2.5 desarrollado con Java6 y Spring3.
i18n Euskera, Castellano e Ingles.

![Alt text](documentacion/screenshot.png?raw=true "imagen de proyecto")

## Requisitos:

	Es necesario tener instalado el siguiente entorno para poder ejecutar la app
	-Java JDK 6 o superior
	-SGBD mysql 5.0.8 o superior
	-Servidor de aplicaciones tomcat 6 o superior.

## Instalacion:

	-Importar scrip de la carpeta deploy/install.sql
	-Desplegar deploy/dado/.war en tomcat
	-Acceder mediante  la url "http://localhost:8080/dado"
	
	Si desea cambiar las credenciales de la base de datos, modificar el fichero src/main/resources/database.properties y volver a generar el .war.
	
