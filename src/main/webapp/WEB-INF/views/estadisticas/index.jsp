<%@ include file="../includes/header.jsp"%>
<div id="contenedor">
	<div id="titulo">
		<h1>Estadisticas</h1>
	</div>
	<br>
	<c:if test="${fn:length(historial)!=0}">
	<div class="row">
		<div class="col-md-3"></div>
		<div class="col-md-6">
			<table class="table">
				<thead>
					<tr>
						<th>Nombre</th>
						<th>Fecha de la tirada</th>
					</tr>
				</thead>

				<tbody>
					<c:forEach items="${historial}" var="h">
						<tr class="info">
							<td>${h.u.nombre}</td>
							<td>${h.fecha}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
	</c:if>
	<c:if test="${fn:length(historial)==0}"> <h4 align="center">No se han realizado tiradas</h4> </c:if>
</div>


<%@ include file="../includes/footer.jsp"%>