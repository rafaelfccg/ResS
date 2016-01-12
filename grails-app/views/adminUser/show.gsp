
<%@ page import="user.AdminUser" %>
<!DOCTYPE html>
<html>
<head>
	<meta name="layout" content="main">
	<g:set var="entityName" value="${message(code: 'AdminUser.label', default: 'AdminUser')}" />
	<title>Show AdminUser</title>
</head>
<body>
<a href="#show-AdminUser" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
<div class="nav" role="navigation">
	<ul>
		<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
		<li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
		<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
	</ul>
</div>
<div id="show-AdminUser" class="content scaffold-show" role="main">
	<h1><g:message code="default.show.label" args="[entityName]" /></h1>
	<g:if test="${flash.message}">
		<div class="message" role="status">${flash.message}</div>
	</g:if>
	<ol class="property-list AdminUser">

		<g:if test="${adminUserInstance?.adminName}">
			<li class="fieldcontain">
				<span id="adminName-label" class="property-label"><g:message code="AdminUser.adminName.label" default="Admin Name" /></span>

				<span class="property-value" aria-labelledby="adminName-label"><g:fieldValue bean="${adminUserInstance}" field="adminName"/></span>

			</li>
		</g:if>

		<g:if test="${adminUserInstance?.adminCpf}">
			<li class="fieldcontain">
				<span id="adminCpf-label" class="property-label"><g:message code="AdminUser.adminCpf.label" default="Admin Cpf" /></span>

				<span class="property-value" aria-labelledby="adminCpf-label"><g:fieldValue bean="${adminUserInstance}" field="adminCpf"/></span>

			</li>
		</g:if>

		<g:if test="${adminUserInstance?.adminLogin}">
			<li class="fieldcontain">
				<span id="adminLogin-label" class="property-label"><g:message code="AdminUser.adminLogin.label" default="Admin Login" /></span>

				<span class="property-value" aria-labelledby="adminLogin-label"><g:fieldValue bean="${adminUserInstance}" field="adminLogin"/></span>

			</li>
		</g:if>

		<g:if test="${adminUserInstance?.adminPassword}">
			<li class="fieldcontain">
				<span id="adminPassword-label" class="property-label"><g:message code="AdminUser.adminPassword.label" default="Admin Password" /></span>

				<span class="property-value" aria-labelledby="adminPassword-label"><g:fieldValue bean="${adminUserInstance}" field="adminPassword"/></span>

			</li>
		</g:if>

		<g:if test="${adminUserInstance?.adminEmail}">
			<li class="fieldcontain">
				<span id="adminEmail-label" class="property-label"><g:message code="AdminUser.adminEmail.label" default="Admin Email" /></span>

				<span class="property-value" aria-labelledby="adminEmail-label"><g:fieldValue bean="${adminUserInstance}" field="adminEmail"/></span>

			</li>
		</g:if>

		<g:if test="${adminUserInstance?.adminPhone}">
			<li class="fieldcontain">
				<span id="adminPhone-label" class="property-label"><g:message code="AdminUser.adminPhone.label" default="Admin Phone" /></span>

				<span class="property-value" aria-labelledby="adminPhone-label"><g:fieldValue bean="${adminUserInstance}" field="adminPhone"/></span>

			</li>
		</g:if>

	</ol>
	<g:form>
		<fieldset class="buttons">
			<g:hiddenField name="id" value="${adminUserInstance?.id}" />
			<g:link class="edit" action="edit" id="${adminUserInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
			<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
		</fieldset>
	</g:form>
</div>
</body>
</html>
