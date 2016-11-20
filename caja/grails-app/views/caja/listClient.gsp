<html>
<head>
<meta name='layout' content="main">
<title>Lista de clientes</title>
</head>
<body>
	<div id='overall' style="margin-left: 10px">
		<div style="margin-right: 10px">
			<table border="1">
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
								${client.client_id}
							</td>
							<td>
								${client.nombre}
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
							<td class="form-group text-center"><g:link
									action="seleccionarServicio"
									params="[client_id:client.client_id]" class="btn btn-warning"
									style="color:white;">Pago</g:link> <g:link
									action="ingresarDinero" params="[client_id:client.client_id]"
									class="btn btn-success" style="color:white;">Ingreso</g:link></td>
						</tr>
					</g:each>
				</tbody>
			</table>
			<g:form controller="Cliente" action="create">
				<input value="Nuevo cliente" type="submit">
			</g:form>
			<g:link action="create">crear</g:link>
		</div>
	</div>
</body>
</html>
