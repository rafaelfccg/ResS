<%@ page import="residueGenerator.ResidueGenerator" %>

<!-- #if($RegisterAResidueGenerator) -->
<div class="fieldcontain ${hasErrors(bean: residueGeneratorInstance, field: 'username', 'error')} required ">
	<label for="username">
		<g:message code="residueGenerator.username.label" default="Username" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="username" maxlength="40" required="" value="${residueGeneratorInstance?.username}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: residueGeneratorInstance, field: 'password', 'error')} required ">
	<label for="password">
		<g:message code="residueGenerator.password.label" default="Password" />
		<span class="required-indicator">*</span>
	</label>
	<g:passwordField  name="password" maxlength="40" required="" value="${residueGeneratorInstance?.password}"/>

</div>
<!--#end -->

<div class="fieldcontain ${hasErrors(bean: residueGeneratorInstance, field: 'nameGenerator', 'error')} ">
	<label for="nameGenerator">
		<g:message code="residueGenerator.nameGenerator.label" default="Name" />

	</label>
	<g:textField name="nameGenerator" value="${residueGeneratorInstance?.nameGenerator}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: residueGeneratorInstance, field: 'type', 'error')} required">
	<label for="type">
		<g:message code="residueGenerator.type.label" default="Type" />
		<span class="required-indicator">*</span>
	</label>
	<g:select name="type" from="${residueGeneratorInstance.constraints.type.inList}" required="" value="${residueGeneratorInstance?.type}" valueMessagePrefix="residueGenerator.type"/>
</div>

<div class="fieldcontain ${hasErrors(bean: residueGeneratorInstance, field: 'addressGenerator', 'error')} required">
	<label for="addressGenerator">
		<g:message code="residueGenerator.addressGenerator.label" default="Address" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="addressGenerator" maxlength="40" required="" value="${residueGeneratorInstance?.addressGenerator}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: residueGeneratorInstance, field: 'averageDailyMeals', 'error')} required">
	<label for="averageDailyMeals">
		<g:message code="residueGenerator.averageDailyMeals.label" default="Average Daily Meals" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="averageDailyMeals" type="number" min="0" value="${residueGeneratorInstance.averageDailyMeals}" required=""/>
</div>

<div class="fieldcontain ${hasErrors(bean: residueGeneratorInstance, field: 'averageMonthlyMeals', 'error')} required">
	<label for="averageMonthlyMeals">
		<g:message code="residueGenerator.averageMonthlyMeals.label" default="Average Monthly Meals" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="averageMonthlyMeals" type="number" min="0" value="${residueGeneratorInstance.averageMonthlyMeals}" required=""/>
</div>

<div class="fieldcontain ${hasErrors(bean: residueGeneratorInstance, field: 'cnpj', 'error')} required">
	<label for="cnpj">
		<g:message code="residueGenerator.cnpj.label" default="Cnpj" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="cnpj" required="" value="${residueGeneratorInstance?.cnpj}"/>
</div>
