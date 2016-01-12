<%@ page import="user.AdminUser" %>

<div class="fieldcontain ${hasErrors(bean: adminUser, field: 'adminName', 'error')}  required">
    <label for="adminName">
        <g:message code="adminUser.adminName.label" default="Name" />
        <span class="required-indicator">*</span>
    </label>
    <g:textField name="adminName" required="" value="${adminUserInstance?.adminName}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: adminUserInstance, field: 'adminCpf', 'error')} required">
    <label for="adminCpf">
        <g:message code="adminUser.adminCpf.label" default="CPF" />
        <span class="required-indicator">*</span>
    </label>
    <g:textField name="adminCpf" required="" value="${adminUserInstance?.adminCpf}" valueMessagePrefix="adminUser.adminCpf"/>
</div>

<div class="fieldcontain ${hasErrors(bean: adminUserInstance, field: 'adminLogin', 'error')} required">
    <label for="adminLogin">
        <g:message code="adminUser.adminLogin.label" default="Login" />
        <span class="required-indicator">*</span>
    </label>
    <g:textField name="adminLogin" required="" value="${adminUserInstance?.adminLogin}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: adminUserInstance, field: 'adminPassword', 'error')} required">
    <label for="adminPassword">
        <g:message code="adminUser.adminPassword.label" default="Password" />
        <span class="required-indicator">*</span>
    </label>
    <g:passwordField name="adminPassword" minSize="6" value="${adminUserInstance.adminPassword}" required=""/>
</div>

<div class="fieldcontain ${hasErrors(bean: adminUserInstance, field: 'adminEmail', 'error')} required">
    <label for="adminEmail">
        <g:message code="adminUser.adminEmail.label" default="E-mail" />
        <span class="required-indicator">*</span>
    </label>
    <g:textField name="adminEmail" value="${adminUserInstance.adminEmail}" required=""/>
</div>

<div class="fieldcontain ${hasErrors(bean: adminUserInstance, field: 'adminPhone', 'error')} required">
    <label for="adminPhone">
        <g:message code="adminUser.adminPhone.label" default="Phone" />
        <span class="required-indicator">*</span>
    </label>
    <g:textField name="adminPhone" required="" value="${adminUserInstance?.adminPhone}"/>
</div>
