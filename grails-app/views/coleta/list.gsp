
<%@ page import="HistoricoDeColeta.Coleta" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'coleta.label', default: 'Coleta')}" />
		<title>Coleta List</title>
	</head>
	<body>
		<a href="#list-coleta" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-coleta" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<fieldset class="form">
				<g:form action="genReport">
				    <div class="fieldcontain">
				        Data para relatório
				        <g:datePicker name="q" value="${params.q}"
              				precision="day" years="${2000..2030}"/>
              			<g:datePicker name="q2" value="${params.q2}"
              				precision="day" years="${2000..2030}"/>		
				        <input type="submit" name="ok" value="Gerar Relatório" />
				    </div>
				</g:form>

				
				</fieldset>
			<table>
				<thead>
					<tr>
					
						<g:sortableColumn property="nome" title="${message(code: 'coleta.nome.label', default: 'Nome')}" />
					
						<g:sortableColumn property="data" title="${message(code: 'coleta.data.label', default: 'Data')}" />
					
						<g:sortableColumn property="volume" title="${message(code: 'coleta.volume.label', default: 'Volume')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${coletaInstanceList}" status="i" var="coletaInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${coletaInstance.id}">${fieldValue(bean: coletaInstance, field: "nome")}</g:link></td>
					
						<td><g:formatDate date="${coletaInstance.data}" /></td>
					
						<td>${fieldValue(bean: coletaInstance, field: "volume")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${coletaInstanceTotal}" />
			</div>
		</div>
	</body>
</html>
