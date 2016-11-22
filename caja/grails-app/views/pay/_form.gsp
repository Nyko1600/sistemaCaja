<%@ page import="caja.Pay" %>



<div class="fieldcontain ${hasErrors(bean: payInstance, field: 'fecha', 'error')} required">
	<label for="fecha">
		<g:message code="pay.fecha.label" default="Fecha" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="fecha" required="" value="${payInstance?.fecha}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: payInstance, field: 'descripcion', 'error')} required">
	<label for="descripcion">
		<g:message code="pay.descripcion.label" default="Descripcion" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="descripcion" required="" value="${payInstance?.descripcion}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: payInstance, field: 'nombre', 'error')} required">
	<label for="nombre">
		<g:message code="pay.nombre.label" default="Nombre" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="nombre" required="" value="${payInstance?.nombre}"/>

</div>

