<!DOCTYPE html>
<html >
<head>
    <meta charset="UTF-8">
    <title>ResS - login</title>
    <link rel="stylesheet" type="text/css" href="../css/login.css"/>
    <g:javascript plugin="jquery"/>
    <g:javascript plugin="jquery-ui"/>
    <script>
        $(document).ready(function(){

        });

        function clickLink(){
            var link = $('.hiddenDashboard');
            link[0].click();
        }
    </script>
</head>

<body>
<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
    <div class="container">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="/ResS/">Home</a>
        </div>
        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav">
                <li>
                    <g:link  controller="home" action="login">Login</g:link>
                </li>
                <li>
                    <a href="#services">Sobre</a>
                </li>
            </ul>
        </div>
        <!-- /.navbar-collapse -->
    </div>
    <!-- /.container -->
</nav>
<div class="body"></div>
<div class="grad"></div>
<div class="header">
    <div>Re<span>sS</span></div>
</div>
<br>
<div class="login">
<!--input type="text" placeholder="username" name="user"><br>
    <input type="password" placeholder="password" name="password"><br>
    <input type="button" value="Login" onclick="clickLink()"-->

    <g:if test="${flash.message}">
        <div class="alert alert-error" style="display: block">${flash.message}</div>
    </g:if>
    <g:form action="logar" method="post">

        <input type="text" class="cnpj" placeholder="CNPJ" name="cnpj" ><br>
        <input type="password"  class="pass" placeholder="password" name="password" ><br>
        <input type="submit" name="_action_logar" value="Login">
    </g:form>
</div>

<script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>

</body>
</html>
