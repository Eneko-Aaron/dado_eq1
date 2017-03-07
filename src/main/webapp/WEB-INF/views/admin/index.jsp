<%@ include file="../includes/header.jsp"%>
<div id="contenedor">
	<h1>Gestión de usuarios</h1>

	<button type="button" class="btn btn-success" data-toggle="modal"data-target="#modalcrear">Crear</button>

	<table class="table">
		<thead>
			<tr>
				<th>ID</th>
				<th>Usuario</th>
				<th>Estado</th>
				<th></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${usuarios}" var="u">
				<tr>
					<td>${u.id}</td>
					<td>${u.nombre}</td>
					<td>
						<c:if test="${u.fechaBaja == null}">Alta</c:if> 
						<c:if test="${u.fechaBaja != null}">Baja</c:if>
					</td>
					<td>
						<button type="button" class="btn btn-info" data-toggle="modal" data-target="#modalmodificar_${u.id}">Modificar</button>
						<button type="button" class="btn btn-danger" data-toggle="modal" data-target="#modaleliminar_${u.id}">Eliminar</button>
						<c:if test="${u.fechaBaja == null}">
							<button type="button" class="btn btn-warning" data-toggle="modal" data-target="#modalbaja_${u.id}">Dar de Baja</button>
						</c:if> 
						<c:if test="${u.fechaBaja != null}">
							<button type="button" class="btn btn-success" data-toggle="modal" data-target="#modalalta_${u.id}">Dar de Alta</button>
						</c:if>		
					</td>
				</tr>
						
			</c:forEach>
		</tbody>
	</table>
	
	
	<!-- Modal crear -->
	<div id="modalcrear" class="modal fade" role="dialog">
		<div class="modal-dialog">

			<!-- Modal content-->
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h4 class="modal-title">Crear Usuario</h4>					
				</div>
				<!-- Formulario Crear -->
				<form:form method="POST" action="admin/crear" modelAttribute="usuario">
					<div class="modal-body">	
						<form:label path="nombre">Nombre</form:label>			
						<form:input path="nombre" class="form-control"></form:input>				
					</div>
					<div class="modal-footer">
						<form:button type="submit" class="btn btn-default">Crear</form:button>
					</div>
				</form:form>				
			</div>
		</div>
	</div>


	<c:forEach items="${usuarios}" var="u">
	<!-- Modal modificar -->
		<div id="modalmodificar_${u.id}" class="modal fade" role="dialog">
			<div class="modal-dialog">
				<!-- Modal content-->
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">&times;</button>
						<h4 class="modal-title">Modificar Usuario</h4>
					</div>
					<!-- Formulario Modificar -->
					<form:form method="POST" action="admin/modificar" modelAttribute="usuario">
						<div class="modal-body">
							<form:label path="id">Id</form:label>			
							<form:input path="id" value="${u.id}" readonly="true" class="form-control"></form:input>
							<form:label path="nombre">Nombre</form:label>			
							<form:input path="nombre" value="${u.nombre}" class="form-control"></form:input>
						</div>
						<div class="modal-footer">
							<form:button type="submit" class="btn btn-default" >Modificar</form:button>
						</div>
					</form:form>
				</div>
			</div>
		</div>
		
		<!-- Modal Eliminar -->
		<div id="modaleliminar_${u.id}" class="modal fade" role="dialog">
			<div class="modal-dialog">

				<!-- Modal content-->
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">&times;</button>
						<h4 class="modal-title">Eliminar Usuario</h4>					
					</div>
						<div class="modal-body">	
							<p>Seguro que desea <b>Eliminar</b> el usuario <b>${u.nombre}</b></p>		
						</div>
						<div class="modal-footer">
							<a href="admin/eliminar/${u.id}"><button type="button" class="btn btn-danger">Eliminar</button></a>
						</div>			
				</div>
			</div>
		</div>
		
		<!-- Modal Dar de Alta -->
		<div id="modalalta_${u.id}" class="modal fade" role="dialog">
			<div class="modal-dialog">

				<!-- Modal content-->
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">&times;</button>
						<h4 class="modal-title">Dar de Alta Usuario</h4>					
					</div>
						<div class="modal-body">	
							<p>Seguro que desea dar de <b>Alta</b> el usuario <b>${u.nombre}</b></p>		
						</div>
						<div class="modal-footer">
							<a href="admin/alta/${u.id}"><button type="button" class="btn btn-success">Dar de Alta</button></a>
						</div>			
				</div>
			</div>
		</div>
		
		<!-- Modal Dar de Baja -->
		<div id="modalbaja_${u.id}" class="modal fade" role="dialog">
			<div class="modal-dialog">

				<!-- Modal content-->
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">&times;</button>
						<h4 class="modal-title">Dar de Baja Usuario</h4>					
					</div>
						<div class="modal-body">	
							<p>Seguro que desea dar de <b>Baja</b> el usuario <b>${u.nombre}</b></p>		
						</div>
						<div class="modal-footer">
							<a href="admin/baja/${u.id}"><button type="button" class="btn btn-warning">Dar de Baja</button></a>
						</div>			
				</div>
			</div>
		</div>
	</c:forEach>

</div>
<%@ include file="../includes/footer.jsp"%>
