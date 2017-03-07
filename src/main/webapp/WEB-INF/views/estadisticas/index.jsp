<%@ include file="../includes/header.jsp"%>
<div id="contenedor">
	<div id="titulo">
		<h1>Estadisticas</h1>
	</div>
	<table border=1 class="table">
		<thead>
			<tr>
				<th>Nombre</th>
				<th>Fecha de la tirada</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${historial}" var="h">
				<tr>
					<td>${h.u.nombre}</td>
					<td>${h.fecha}</td>

				</tr>
			</c:forEach>
		</tbody>

	</table>

</div>



<%@ include file="../includes/footer.jsp"%>
