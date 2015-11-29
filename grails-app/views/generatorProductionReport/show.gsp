
<%@ page import="generatorProductionReport.GeneratorProductionReport" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main">
    <g:set var="entityName" value="${message(code: 'residueGenerator.label', default: 'ResidueGenerator')}" />
    <title>Generator Production Report</title>
</head>
<body>
<a href="#show-residueGenerator" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
<div class="nav" role="navigation">
    <ul>
        <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
        <li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
    </ul>
</div>
<div id="show-generatorReport" class="content scaffold-list" role="main">
    <h1>Generatpr Reports</h1>
    <g:if test="${flash.message}">
        <div class="message" role="status">${flash.message}</div>
    </g:if>
    <table>
        <thead>
        <tr>

            <g:sortableColumn property="nameGenerator" title="${message(code: 'residueGenerator.nameGenerator.label', default: 'Name')}" />

            <g:sortableColumn property="average" title="${message(code: 'residueGenerator.type.label', default: 'Average')}" />

            <g:sortableColumn property="standardDev" title="${message(code: 'residueGenerator.addressGenerator.label', default: 'standardDev')}" />

            <g:sortableColumn property="isHigher" title="${message(code: 'residueGenerator.averageDailyMeals.label', default: 'isHigher')}" />
        </tr>
        </thead>
        <g>
            <g:each in="${generatorProductionReportInstance.avgProduction}" status="i" var="avg">

                <tr class="${(i % 2) == 0 ? 'even' : 'odd'}">

                    <td>${fieldValue(bean: generatorProductionReportInstance.names[i])}</td>

                    <td>${fieldValue(bean:generatorProductionReportInstance.avg[i])}</td>

                    <td>${fieldValue(bean: generatorProductionReportInstance.stdProduction[i])}</td>

                    <td>${fieldValue(bean: generatorProductionReportInstance.isHigher[i])}</td>

                </tr>
            </g:each>
        </tbody>
    </table>

    
</div>
</body>
</html>
