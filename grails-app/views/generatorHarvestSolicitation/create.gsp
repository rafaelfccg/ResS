<%--
  Created by IntelliJ IDEA.
  User: danie_000
  Date: 6/24/2015
  Time: 10:05 PM
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="residueGenerator.HarvestSolicitation" %>
<html>
<head>
    <meta name="layout" content="main">
    <title>Criar solicitacao de coleta</title>
    <link href='http://fonts.googleapis.com/css?family=Pacifico' rel='stylesheet' type='text/css'>
    <style type="text/css">
        #mainContent{
            margin: 100px;
        }
        label{
            margin-top: 10px;
        }
        select{
            margin-left: 91px;
            border-radius: 5px;
        }

        input[type="text"]{
            border-radius: 5px;
        }

        .resize img{
            width:540px;
            height: auto;
        }

        .resize{
            text-align: center;
            margin-left: auto;
            margin-right: auto;
        }

        .animate
        {
            transition: all 0.1s;
            -webkit-transition: all 0.1s;
        }

        .action-button
        {
            position: relative;
            padding: 10px 40px;
            margin: 0px 10px 10px 0px;
            float: right;
            border-radius: 10px;
            font-family: 'Pacifico', cursive;
            font-size: 19px;
            color: #FFF;
            text-decoration: none;
        }

        .action-button:active
        {
            transform: translate(0px,5px);
            -webkit-transform: translate(0px,5px);
            border-bottom: 1px solid;
        }

        .green
        {
            background-color: #82BF56;
            border-bottom: 5px solid #669644;
            text-shadow: 0px -2px #669644;
        }

        ul{
            margin-top: 50px;
            list-style-type: none;
        }

    </style>
</head>
<body>

<g:form action="save">
    <div id = "mainContent" class ="content scaffold-create">
        <div class="headerText">
            <h1>Solicitação de coleta</h1>
        </div>
        <div class="resize">
        <g:img uri="/images/ecopoints.jpg"/>
        </div>
        <ul>
            <li>
                <label>Compania coletora:</label>
                <g:select name="harvesterId" from="${companyList}" value="${harvestSolicitationInstance.harvesterId}" optionKey="id" optionValue="name" />
            </li>
            <li>
                <label>Quantidade de residuo estimada</label>
                <g:textField name="estimatedAmountOfResidue" value="${harvestSolicitationInstance.estimatedAmountOfResidue}"/>
            </li>
        </ul>
        <g:hiddenField name="generatorId" value="${harvestSolicitationInstance.generatorId}" />
        <div>
            <input name ="Ok "type="submit" value="Ok" class="action-button shadow animate green">
        </div>
    </div>
</g:form>
</body>
</html>