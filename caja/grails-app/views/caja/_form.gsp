<%@ page import="caja.Caja" %>



<div class="fieldcontain ${hasErrors(bean: cajaInstance, field: 'client_id', 'error')} required">
	<label for="client_id">
		<g:message code="caja.client_id.label" default="Clientid" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="client_id" type="number" value="${cajaInstance.client_id}" required=""/>

</div>

<div class="fieldcontain ${hasErrors(bean: cajaInstance, field: 'created', 'error')} required">
	<label for="created">
		<g:message code="caja.created.label" default="Created" />
		<span class="required-indicator">*</span>
	</label>
	<g:datePicker name="created" precision="day"  value="${cajaInstance?.created}"  />

</div>

<div class="fieldcontain ${hasErrors(bean: cajaInstance, field: 'monto', 'error')} required">
	<label for="monto">
		<g:message code="caja.monto.label" default="Monto" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="monto" value="${fieldValue(bean: cajaInstance, field: 'monto')}" required=""/>

</div>

<div class="fieldcontain ${hasErrors(bean: cajaInstance, field: 'pay_id', 'error')} required">
	<label for="pay_id">
		<g:message code="caja.pay_id.label" default="Payid" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="pay_id" type="number" value="${cajaInstance.pay_id}" required=""/>

</div>

