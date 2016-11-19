<html>
  <head>
	<meta name='layout' content="main">
	<title>Lista de clientes</title>
	</head>
	<body>
		<div id='overall' style="margin-left:10px">
		<div style="margin-right:10px">
		<table border="1" >
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
	  </div>
		</div>	 	
	</body>
</html>	