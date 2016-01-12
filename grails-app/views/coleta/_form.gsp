<%@ page import="HistoricoDeColeta.Coleta" %>



<div class="fieldcontain ${hasErrors(bean: coletaInstance, field: 'nome', 'error')} ">
	<label for="nome">
		<g:message code="coleta.nome.label" default="Nome" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="nome" value="${coletaInstance?.nome}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: coletaInstance, field: 'data', 'error')} required">
	<label for="data">
		<g:message code="coleta.data.label" default="Data" />
		<span class="required-indicator">*</span>
	</label>
	<g:datePicker name="data" precision="day"  value="${coletaInstance?.data}"  />
</div>

<div class="fieldcontain ${hasErrors(bean: coletaInstance, field: 'volume', 'error')} required">
	<label for="volume">
		<g:message code="coleta.volume.label" default="Volume" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="volume" type="number" value="${coletaInstance.volume}" required=""/>
</div>

<div class="fieldcontain ${hasErrors(bean: coletaInstance, field: 'senha', 'error')} ">
	<label for="senha">
		<g:message code="coleta.nome.label" default="Senha (autenticação)" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="senha" value="${coletaInstance?.senha}"/>
</div>

