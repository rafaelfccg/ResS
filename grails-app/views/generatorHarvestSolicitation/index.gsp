
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="residueGenerator.ResidueGenerator" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main">
    <title>Solicitacao de coleta</title>
    <link href='http://fonts.googleapis.com/css?family=Pacifico' rel='stylesheet' type='text/css'>
    <style type="text/css">
    #mainContent{
        margin: 100px;
    }
    ul{
        margin-top: 50px;
        list-style-type: none;
    }
    .lb{
        font-weight: bold;
    }
    li{
        margin-top: 5px;
    }
    h1{
        border-bottom: none !important;
    }
    .animate
    {
        transition: all 0.1s;
        -webkit-transition: all 0.1s;
    }

    .action-button
    {
        height: 35px;
        position: relative;
        padding: 10px 40px;
        margin: 0px 10px 10px 0px;
        float: right;
        border-radius: 10px;
        font-family: 'Pacifico', cursive;
        font-size: 19px;
        color: #FFF !important;
        text-decoration: none;
    }

    .action-button:active
    {
        transform: translate(0px,5px);
        -webkit-transform: translate(0px,5px);
        border-bottom: 1px solid;
    }

    .confirm-button
    {
        height: 35px;
        position: relative;
        padding: 10px 40px;
        margin: 0px 10px 10px 0px;
        float: right;
        border-radius: 10px;
        font-family: 'Pacifico', cursive;
        font-size: 19px;
        color: #FFF !important;
        text-decoration: none;
    }

    .confirm-button:active
    {
        transform: translate(0px,5px);
        -webkit-transform: translate(0px,5px);
        border-bottom: 1px solid;
    }

    .green {
        background-color: #82BF56;
        border-bottom: 5px solid #669644;
        text-shadow: 0px -2px #669644;
    }
    .labelContent{
        text-align: center;
        border: 2px solid #BCD2BA;
        border-radius: 20px;
        padding-bottom: 50px;
        margin-bottom: 22px;
    }
    </style>
</head>
<body>

<g:form action="confirm">
    <div id = "mainContent" class ="content scaffold-create">
        <div class="headerText">
            <h1>Solicitação de coleta</h1>
        </div>
        <div class ="labelContent">
            <ul>
                <li>
                    <label class="lb"> Compania coletora: </label>
                    <label class="ct">${harvester}</label>
                </li>
                <li>
                    <label class="lb"> Data de solicitação:</label>
                    <label class="ct">${residueGeneratorInstance.harvestSolicitation.solicitationDate.format("dd/MM/YYYY")}</label>
                </li>
                <li>
                    <label class="lb">Status:</label>
                    <label class="ct">${residueGeneratorInstance.harvestSolicitation.status}</label>
                </li>
            </ul>
        </div>
        <div>
            <g:hiddenField name="generatorId" value="${residueGeneratorInstance.id}" />
            <a href="/ResS/Dashboard/"  class="action-button shadow animate green">Ok</a>
            <g:actionSubmit value="Confirm" class="confirm-button shadow animate green" action="confirm" onclick="return confirm('Are you sure?');" />
        </div>
    </div>
</g:form>
</body>
</html>