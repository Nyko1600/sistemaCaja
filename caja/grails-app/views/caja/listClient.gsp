<html>
<head>
<meta name='layout' content="main">
<title>Lista de clientes</title>
</head>
<body>
	<div id='overall' style="margin-left: 10px">
        <g:if test="${flash.message}">
 	       <div class="message">${flash.message}</div>
      	</g:if>
		<div style="margin-right: 10px">
			<div class="row">
				<div  class="col-md-10">
					<table>
						<thead>
							<tr>
								<th>Client_id</th>
								<th>Nombre</th>
								<th>Apellido</th>
								<th>Doc</th>
								<th>Saldo</th>
								<th>Selecccionar</th>
							</tr>
						</thead>
						<tbody>
							<g:each in="${clientList}" status="i" var="client">
								<tr>
									<td>
										${client.id}
									</td>
									<td>
										<g:link controller="Client" action="show" id="${client.id}" style="color:blue;">${client.nombre}</g:link>
									</td>
									<td>
										${client.apellido}
									</td>
									<td>
										${client.doc}
									</td>
									<td>
										${client.saldo}
									</td>
									<td class="form-group text-center">
										<g:link action="selectPay" params="[client_id:client.id]" class="btn btn-warning" style="color:white;">Pago</g:link> 
										<g:link action="moneyIn" params="[client_id:client.id]" class="btn btn-success" style="color:white;">Ingreso</g:link>
										<g:link action="movements" params="[client_id:client.id]" class="btn btn-primary" style="color:white;">Movimientos</g:link>
									</td>
								</tr>
							</g:each>
						</tbody>
					</table>
				</div>
				<div  class="col-md-2" style="margin-top: 40px">
					<g:link controller="Client" action="create" class="btn btn-default	 btn-block" style="color:black">Nuevo cliente</g:link> 
					<g:link controller="Pay" action="index" class="btn btn-default btn-block" style="color:black">Gestion pagos</g:link> 
					<g:link controller="User" action="index" class="btn btn-danger btn-block" style="color:white">ABM usuarios</g:link> 
					<g:link controller="User" action="logout" style="background:#555555!important; color:white" class="btn btn-default btn-block">Salir</g:link> 
				</div>
			</div>
		</div>
	</div>
</body>
</html>
