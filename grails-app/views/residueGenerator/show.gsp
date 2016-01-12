
<%@ page import="residueGenerator.ResidueGenerator" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'residueGenerator.label', default: 'ResidueGenerator')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-residueGenerator" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-residueGenerator" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list residueGenerator">
			
				<g:if test="${residueGeneratorInstance?.nameGenerator}">
				<li class="fieldcontain">
					<span id="nameGenerator-label" class="property-label"><g:message code="residueGenerator.nameGenerator.label" default="Name Generator" /></span>
					
						<span class="property-value" aria-labelledby="nameGenerator-label"><g:fieldValue bean="${residueGeneratorInstance}" field="nameGenerator"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${residueGeneratorInstance?.type}">
				<li class="fieldcontain">
					<span id="type-label" class="property-label"><g:message code="residueGenerator.type.label" default="Type" /></span>
					
						<span class="property-value" aria-labelledby="type-label"><g:fieldValue bean="${residueGeneratorInstance}" field="type"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${residueGeneratorInstance?.addressGenerator}">
				<li class="fieldcontain">
					<span id="addressGenerator-label" class="property-label"><g:message code="residueGenerator.addressGenerator.label" default="Address Generator" /></span>
					
						<span class="property-value" aria-labelledby="addressGenerator-label"><g:fieldValue bean="${residueGeneratorInstance}" field="addressGenerator"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${residueGeneratorInstance?.averageDailyMeals}">
				<li class="fieldcontain">
					<span id="averageDailyMeals-label" class="property-label"><g:message code="residueGenerator.averageDailyMeals.label" default="Average Daily Meals" /></span>
					
						<span class="property-value" aria-labelledby="averageDailyMeals-label"><g:fieldValue bean="${residueGeneratorInstance}" field="averageDailyMeals"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${residueGeneratorInstance?.averageMonthlyMeals}">
				<li class="fieldcontain">
					<span id="averageMonthlyMeals-label" class="property-label"><g:message code="residueGenerator.averageMonthlyMeals.label" default="Average Monthly Meals" /></span>
					
						<span class="property-value" aria-labelledby="averageMonthlyMeals-label"><g:fieldValue bean="${residueGeneratorInstance}" field="averageMonthlyMeals"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${residueGeneratorInstance?.cnpj}">
				<li class="fieldcontain">
					<span id="cnpj-label" class="property-label"><g:message code="residueGenerator.cnpj.label" default="Cnpj" /></span>
					
						<span class="property-value" aria-labelledby="cnpj-label"><g:fieldValue bean="${residueGeneratorInstance}" field="cnpj"/></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form>
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${residueGeneratorInstance?.id}" />
					<g:link class="edit" action="edit" id="${residueGeneratorInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
