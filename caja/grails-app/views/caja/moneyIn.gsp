<html>
<head>
<meta name='layout' content="main">
<title>Ingrese el monto</title>
</head>
<body>
	<div id='overall' align="center">
		<g:form controller="Caja" action="caja">
			<g:hiddenField name="clinetId" value="${clinetId}" />
			<g:field name="entero" value="" type="number" value="0" min="0" />
			<g:field name="decimal" value="" type="number" value="0" min="0"
				max="99" />
			<input value="mandar servicio" type="submit">
		</g:form>
	</div>
</body>
</html>
