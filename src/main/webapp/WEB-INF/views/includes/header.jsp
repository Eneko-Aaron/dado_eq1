<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<%@ page session="false" %>

<html>
<head>
	<title>Dado</title>
	<base href="/dado-eq1/" />
	<link href="http://getbootstrap.com/dist/css/bootstrap.min.css" rel="stylesheet" />
	<link href="https://cdn.datatables.net/1.10.13/css/jquery.dataTables.min.css" rel="stylesheet">
	<!-- Custom -->
	<link href="resources/css/custom.css" rel="stylesheet">
</head>
<body>
<nav class="navbar navbar-inverse">
   <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      <ul class="nav navbar-nav">
        <li class="active"><a href="">Dado</a></li>
        <li><a href="estadisticas">Estadisticas</a></li>
      </ul>
    </div>
</nav>
 