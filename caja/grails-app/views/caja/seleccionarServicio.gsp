<html>
  <head>
	<meta name='layout' content="main">
	<title>Lista de clientes</title>
	</head>
	<body>
		<div id='overall' align="center">
			<g:form controller="Caja" action="caja">
				<g:select name="servicioId" from="${serviceList}" optionKey="service_id" optionValue="nombre"/>
				<g:hiddenField name="clinetId" value="${clinetId}"/>
				<g:field name="entero" value="" type="number" min="0"/>
				<g:field name="decimal" value="" type="number" min="0" max="99"/>
				<input value="mandar servicio" type="submit" >
			</g:form>
	 	</div>
	</body>
</html>	

<g:select id="cars.id" name="cars.id" from="${cars}" optionKey="carType" optionValue="car"/>
