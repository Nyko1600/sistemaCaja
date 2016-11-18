<html>
  <head>
	<title>Lista de clientes</title>
	  <g:javascript library="jquery" />
	</head>
	<body>
	  <table border="1">
	    <thead>
	      <tr>
	        <th>Client_id</th>
			<th>Nombre</th>
			<th>Apellido</th>
			<th>Doc</th>
			<th>Saldo</th>
	  	  </tr>
	  	</thead>
	  	<tbody>
	  	  <g:each in="${clientList}" status="i" var="client">
	  	  <tr>
	  	  	<td>${client.client_id}</td>
	  	  	<td>${client.nombre}</td>
	  	  	<td>${client.apellido}</td>
	  	  	<td>${client.doc}</td>
	  	  	<td>${client.saldo}</td>
	  	  </tr>
	  	  </g:each>
	  	</tbody>
	  </table>
	</body>
</html>