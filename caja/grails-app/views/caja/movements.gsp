<html>
<head>
<meta name='layout' content="main">
<title>Lista de movimientos</title>
</head>
<body>
	<div id='overall' style="margin-left: 10px">
		<div style="margin-right: 10px">
		<div class="buttons">
          <span class="button">
          	<g:link action="listClient"><g:img dir="images/skin" file="house.png"/> Home</g:link>            
          	<g:link controller="User" action="logout"><g:img dir="images/skin" file="myLogout.ico" width="23" height="23"/> Log Out</g:link>            
          </span>
        </div>
			<table border="1">
				<thead>
					<tr>
						<th>Cuilt</th>
						<th>Pago</th>
						<th>Vencimineto</th>
						<th>Descripcion</th>
						<th>Fecha operacion</th>
						<th>Monto</th>
					</tr>
				</thead>
				<tbody>
					<g:each in="${objectArray}" status="i" var="object">
						<tr>
							<td>
								${object.cliente}
							</td>
							<td>
								${object.pago}
							</td>
							<td>
								${object.vencimineto}
							</td>
							<td>
								${object.descripcion}
							</td>
							<td>
								<g:formatDate format="dd-MM-yyyy" date="${object.registro}"/>
							</td>
							<td>
								<g:link action="edit" id="${object.id}">${object.monto}</g:link>
							</td>
							
						</tr>
					</g:each>
				</tbody>
			</table>				
		</div>
	</div>
</body>
</html>
