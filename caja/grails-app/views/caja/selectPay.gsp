<html>
  <head>
	<meta name='layout' content="main">
	<title>Seleccionar pago</title>
	</head>
	<body>
		<div id='overall' align="center">
			<g:form controller="Caja" action="caja">
				<g:select name="pay_id" from="${payList}" optionKey="id" optionValue="nombre" noSelection="['':'-seleccione pago-']" required="true"/>
				<g:hiddenField name="client_id" value="${clientId}"/>
				<g:field name="entero" type="number" placeholder="valor entero" required="true" autofocus="true" min="0" />
				<g:field name="decimal" type="number" value="0" min="0" max="99"/>
				<input value="mandar servicio" type="submit" >
			</g:form>
	 	</div>
	</body>
</html>	