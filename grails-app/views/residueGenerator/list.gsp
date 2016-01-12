
<%@ page import="residueGenerator.ResidueGenerator" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'residueGenerator.label', default: 'ResidueGenerator')}" />
		<title>Residue Generator List</title>
	</head>
	<body>
		<a href="#list-residueGenerator" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-residueGenerator" class="content scaffold-list" role="main">
			<h1>Residue Generator List</h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
				<thead>
					<tr>
					
						<g:sortableColumn property="nameGenerator" title="${message(code: 'residueGenerator.nameGenerator.label', default: 'Name')}" />
					
						<g:sortableColumn property="type" title="${message(code: 'residueGenerator.type.label', default: 'Type')}" />
					
						<g:sortableColumn property="addressGenerator" title="${message(code: 'residueGenerator.addressGenerator.label', default: 'Address')}" />
					
						<g:sortableColumn property="averageDailyMeals" title="${message(code: 'residueGenerator.averageDailyMeals.label', default: 'Avg Daily Meals')}" />
					
						<g:sortableColumn property="averageMonthlyMeals" title="${message(code: 'residueGenerator.averageMonthlyMeals.label', default: 'Avg Monthly Meals')}" />
					
						<g:sortableColumn property="cnpj" title="${message(code: 'residueGenerator.cnpj.label', default: 'Cnpj')}" />
					
					</tr>
				</thead>
				<g>
				<g:each in="${residueGeneratorInstanceList}" status="i" var="residueGeneratorInstance">

					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${residueGeneratorInstance.id}">${fieldValue(bean: residueGeneratorInstance, field: "nameGenerator")}</g:link></td>
					
						<td>${fieldValue(bean: residueGeneratorInstance, field: "type")}</td>
					
						<td>${fieldValue(bean: residueGeneratorInstance, field: "addressGenerator")}</td>
					
						<td>${fieldValue(bean: residueGeneratorInstance, field: "averageDailyMeals")}</td>
					
						<td>${fieldValue(bean: residueGeneratorInstance, field: "averageMonthlyMeals")}</td>
					
						<td>${fieldValue(bean: residueGeneratorInstance, field: "cnpj")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>

			<div class="pagination">
				<g:paginate total="${residueGeneratorInstanceTotal}" />
			</div>
		</div>
	</body>
</html>
