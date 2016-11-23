
<%@ page import="caja.Caja" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'caja.label', default: 'Caja')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-caja" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-caja" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
			<thead>
					<tr>
					
						<g:sortableColumn property="client_id" title="${message(code: 'caja.client_id.label', default: 'Clientid')}" />
					
						<g:sortableColumn property="created" title="${message(code: 'caja.created.label', default: 'Created')}" />
					
						<g:sortableColumn property="monto" title="${message(code: 'caja.monto.label', default: 'Monto')}" />
					
						<g:sortableColumn property="pay_id" title="${message(code: 'caja.pay_id.label', default: 'Payid')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${cajaInstanceList}" status="i" var="cajaInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${cajaInstance.id}">${fieldValue(bean: cajaInstance, field: "client_id")}</g:link></td>
					
						<td><g:formatDate date="${cajaInstance.created}" /></td>
					
						<td>${fieldValue(bean: cajaInstance, field: "monto")}</td>
					
						<td>${fieldValue(bean: cajaInstance, field: "pay_id")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${cajaInstanceCount ?: 0}" />
			</div>
		</div>
	</body>
</html>
