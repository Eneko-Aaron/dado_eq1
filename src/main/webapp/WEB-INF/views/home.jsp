<%@ include file="includes/header.jsp"%>
<div id="contenedor">

	<div id="titulo">
		<h1>¡¡DADO DE LA FORTUNA!!</h1>
	</div>

	<div id="dado">
		<img src="resources/img/dado.gif" /> <br> 
		<a href="lanzar" class="btn btn-primary btn-lg active" role="button" aria-pressed="true">Lanzar dado</a>
	</div>
	<br>
	<c:if test="${usuario!= null}">
		<div id="alerta">
			<div class="alert alert-success">

			El afortunado en leer es: <strong>${usuario.nombre}</strong>
			</div>
		</div>
	</c:if>
	
	<div id="ranking">
		<img id="imgranking" src="resources/img/ranking.png" /> <br>
		<br>
		<table border=1 class="table">
			<thead>
				<tr>
					<th>Nombre</th>
					<th>Tirada</th>
					<th>Fecha</th>
					<th></th>
				</tr>
			</thead>
			<tbody>

				<c:forEach items="${ranking}" var="r">
					<tr>
						<td>${r.nombre}</td>
						<td>${r.numTiradas}</td>
						<td><c:forEach var="tirada" items="${r.tiradas}" end="0">
								<c:out value="${tirada.fecha}" />
							</c:forEach></td>
						<td><button type="button" class="btn btn-info" data-toggle="modal" data-target="#modaltiradas_${r.id}">Ver Todas</button></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<div id="estadisticas">
	<h1>Estadisticas</h1>
		<a href="estadisticas"><img id="grafico" src="resources/img/stats.png"></a>
	</div>
	<c:forEach items="${ranking}" var="r">
		<div id="modaltiradas_${r.id}" class="modal fade" role="dialog">
			<div class="modal-dialog">

				<!-- Modal content-->
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">&times;</button>
						<h4 class="modal-title">Tiradas de ${r.nombre}</h4>					
					</div>
						<div class="modal-body">	
							<ul>
									<c:forEach var="tirada" items="${r.tiradas}">
										<li>${tirada.fecha}</li>
									</c:forEach>
							</ul>
						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-info" data-dismiss="modal">Cerrar</button>
						</div>			
				</div>
			</div>
		</div>
	</c:forEach>
</div>

<%@ include file="includes/footer.jsp"%>