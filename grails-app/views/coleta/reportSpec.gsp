<%--
  Created by IntelliJ IDEA.
  User: ess
  Date: 25/11/15
  Time: 10:43
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta name="layout" content="main">
    <title>Criar relatorio de producao de residuo</title>
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
            <h1>Gerar relatorio</h1>
        </div>
        <div class="resize">
            <g:img uri="/images/ecopoints.jpg"/>
        </div>
        <ul>
            <li>
                <label>Mês para consulta:</label>
                 <g:field name="month" type="number" min="1" value="${reportSpec.month}" required=""/>
            </li>

        </ul>

        <div>
            <input name ="Ok "type="submit" value="Ok" class="action-button shadow animate green">
        </div>
    </div>
</g:form>
</body>
</html>