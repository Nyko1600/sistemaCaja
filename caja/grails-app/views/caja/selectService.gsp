<html>
  <head>
	<meta name='layout' content="main">
	<title>Seleccionar Servicio</title>
	</head>
	<body>
		<div id='overall' align="center">
			<g:form controller="Caja" action="caja">
				<g:select name="service_id" from="${serviceList}" optionKey="id" optionValue="nombre"/>
				<g:hiddenField name="client_id" value="${clientId}"/>
				<g:field name="entero" value="" type="number" value="0" min="0"/>
				<g:field name="decimal" value="" type="number" value="0" min="0" max="99"/>
				<input value="mandar servicio" type="submit" >
			</g:form>
	 	</div>
	</body>
</html>	
