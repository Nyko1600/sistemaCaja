<%@ page import="caja.Client" %>



<div class="fieldcontain ${hasErrors(bean: clientInstance, field: 'apellido', 'error')} required">
	<label for="apellido">
		<g:message code="client.apellido.label" default="Apellido" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="apellido" required="" value="${clientInstance?.apellido}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: clientInstance, field: 'doc', 'error')} required">
	<label for="doc">
		<g:message code="client.doc.label" default="Doc" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="doc" type="number" value="${clientInstance.doc}" required=""/>

</div>

<div class="fieldcontain ${hasErrors(bean: clientInstance, field: 'nombre', 'error')} required">
	<label for="nombre">
		<g:message code="client.nombre.label" default="Nombre" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="nombre" required="" value="${clientInstance?.nombre}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: clientInstance, field: 'saldo', 'error')} required">
	<label for="saldo">
		<g:message code="client.saldo.label" default="Saldo" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="saldo" value="${fieldValue(bean: clientInstance, field: 'saldo')}" required=""/>

</div>

