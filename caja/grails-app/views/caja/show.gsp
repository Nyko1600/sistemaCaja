
<%@ page import="caja.Caja" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'caja.label', default: 'Caja')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-caja" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-caja" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list caja">
			
				<g:if test="${cajaInstance?.client_id}">
				<li class="fieldcontain">
					<span id="client_id-label" class="property-label"><g:message code="caja.client_id.label" default="Clientid" /></span>
					
						<span class="property-value" aria-labelledby="client_id-label"><g:fieldValue bean="${cajaInstance}" field="client_id"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${cajaInstance?.created}">
				<li class="fieldcontain">
					<span id="created-label" class="property-label"><g:message code="caja.created.label" default="Created" /></span>
					
						<span class="property-value" aria-labelledby="created-label"><g:formatDate date="${cajaInstance?.created}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${cajaInstance?.monto}">
				<li class="fieldcontain">
					<span id="monto-label" class="property-label"><g:message code="caja.monto.label" default="Monto" /></span>
					
						<span class="property-value" aria-labelledby="monto-label"><g:fieldValue bean="${cajaInstance}" field="monto"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${cajaInstance?.pay_id}">
				<li class="fieldcontain">
					<span id="pay_id-label" class="property-label"><g:message code="caja.pay_id.label" default="Payid" /></span>
					
						<span class="property-value" aria-labelledby="pay_id-label"><g:fieldValue bean="${cajaInstance}" field="pay_id"/></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form url="[resource:cajaInstance, action:'delete']" method="DELETE">
				<fieldset class="buttons">
					<g:link class="edit" action="edit" resource="${cajaInstance}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
