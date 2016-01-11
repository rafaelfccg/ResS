
<%@ page import="user.AdminUser" %>
<!DOCTYPE html>
<html>
<head>
	<meta name="layout" content="main">
	<g:set var="entityName" value="${message(code: 'adminUser.label', default: 'AdminUser')}" />
	<title>List Admin User</title>
</head>
<body>
<a href="#list-adminUser" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
<div class="nav" role="navigation">
	<ul>
		<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
		<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
	</ul>
</div>
<div id="list-adminUser" class="content scaffold-list" role="main">
	<h1><g:message code="default.list.label" args="[entityName]" /></h1>
	<g:if test="${flash.message}">
		<div class="message" role="status">${flash.message}</div>
	</g:if>
	<table>
		<thead>
		<tr>

			<g:sortableColumn property="adminName" title="${message(code: 'adminUser.adminName.label', default: 'Admin Name')}" />

			<g:sortableColumn property="adminCpf" title="${message(code: 'AdminUser.adminCpf.label', default: 'Admin Cpf')}" />

			<g:sortableColumn property="adminLogin" title="${message(code: 'AdminUser.adminLogin.label', default: 'Admin Login')}" />

			<g:sortableColumn property="adminPassword" title="${message(code: 'AdminUser.adminPassword.label', default: 'Admin Password')}" />

			<g:sortableColumn property="adminEmail" title="${message(code: 'AdminUser.adminEmail.label', default: 'Admin Email')}" />

			<g:sortableColumn property="adminPhone" title="${message(code: 'AdminUser.adminPhone.label', default: 'Admin Phone')}" />

		</tr>
		</thead>
		<tbody>
		<g:each in="${adminUserInstanceList}" status="i" var="adminUserInstance">
			<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">

				<td><g:link action="show" id="${adminUserInstance.id}">${fieldValue(bean: adminUserInstance, field: "adminName")}</g:link></td>

				<td>${fieldValue(bean: adminUserInstance, field: "adminCpf")}</td>

				<td>${fieldValue(bean: adminUserInstance, field: "adminLogin")}</td>

				<td>${fieldValue(bean: adminUserInstance, field: "adminPassword")}</td>

				<td>${fieldValue(bean: adminUserInstance, field: "adminEmail")}</td>

				<td>${fieldValue(bean: adminUserInstance, field: "adminPhone")}</td>

			</tr>
		</g:each>
		</tbody>
	</table>
	<div class="pagination">
		<g:paginate total="${adminUserInstanceTotal}" />
	</div>
</div>
</body>
</html>
