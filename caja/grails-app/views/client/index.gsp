
<%@ page import="caja.Client" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'client.label', default: 'Client')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-client" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
	          	<li><g:link controller="User" action="logout"><g:img dir="images/skin" file="myLogout.ico" width="23" height="23"/> Log Out</g:link></li>            
			</ul>
		</div>
		<div id="list-client" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
			<thead>
					<tr>
					
						<g:sortableColumn property="apellido" title="${message(code: 'client.apellido.label', default: 'Apellido')}" />
					
						<g:sortableColumn property="doc" title="${message(code: 'client.doc.label', default: 'Doc')}" />
					
						<g:sortableColumn property="nombre" title="${message(code: 'client.nombre.label', default: 'Nombre')}" />
					
						<g:sortableColumn property="saldo" title="${message(code: 'client.saldo.label', default: 'Saldo')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${clientInstanceList}" status="i" var="clientInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${clientInstance.id}">${fieldValue(bean: clientInstance, field: "apellido")}</g:link></td>
					
						<td>${fieldValue(bean: clientInstance, field: "doc")}</td>
					
						<td>${fieldValue(bean: clientInstance, field: "nombre")}</td>
					
						<td>${fieldValue(bean: clientInstance, field: "saldo")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${clientInstanceCount ?: 0}" />
			</div>
		</div>
	</body>
</html>
