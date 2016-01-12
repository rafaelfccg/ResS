<!DOCTYPE html>
<html>
<head>
	<meta name="layout" content="main"/>
	<title>ResS</title>
	<style type="text/css" media="screen">

	#forkongithub a{
		background:#ff6680;
		color:#fff;
		text-decoration:none;
		font-family:arial,sans-serif;
		text-align:center;
		font-weight:bold;
		padding:5px 40px;
		font-size:1rem;
		line-height:2rem;
		position:relative;
		transition:0.5s;
	}

	#forkongithub a:hover{
		background:#ffe666;
		color:#fff;
	}

	#forkongithub a::before,#forkongithub a::after{
		content:"";
		width:100%;
		display:block;
		position:absolute;
		top:1px;
		left:0;
		height:1px;
		background:#fff;
	}

	#forkongithub a::after{
		bottom:1px;
		top:auto;
	}

	@media screen and (min-width:800px){

		#forkongithub{
			position:absolute;
			display:block;
			top:0;
			right:0;
			width:200px;
			overflow:hidden;
			height:200px;
			z-index:9999;
		}

		#forkongithub a{
			width:200px;
			position:absolute;
			top:60px;
			right:-60px;
			transform:rotate(45deg);
			-webkit-transform:rotate(45deg);
			-ms-transform:rotate(45deg);
			-moz-transform:rotate(45deg);
			-o-transform:rotate(45deg);
			box-shadow:4px 4px 10px rgba(0,0,0,0.8);
		}
	}
	.container{
		width: 100%;
		text-align: center;
		height: 100%;
	}

	.areaContainer{
		min-height: 11em;
		border-style: groove;
		border-width: thin;
		overflow: auto;
		border-left-style: none;
		border-right-style: none;
	}

	.area span {
		vertical-align: middle;
		line-height: normal;
		margin: 1em;
	}

	.area {
		background-color: #555555;
		color:#66ccff;
		float: left;
		text-align:center;
		line-height: 153px;
		margin: 0.75em;
		border-radius: 10px;
	}

	#status ul {
		font-size: 0.9em;
		list-style-type: none;
		margin-bottom: 0.6em;
		padding: 0;
	}

	#status li {
		line-height: 1.3;
	}

	#status h1 {
		text-transform: uppercase;
		font-size: 1.1em;
		margin: 0 0 0.3em;
	}

	h2 {
		margin-top: 1em;
		margin-bottom: 0.3em;
		font-size: 1em;
	}

	p {
		line-height: 1.5;
		margin: 0.25em 0;
	}

	#controller-list ul {
		list-style-position: inside;
	}

	#controller-list li {
		line-height: 1.3;
		list-style-position: inside;
		margin: 0.25em 0;
	}

	@media screen and (max-width: 480px) {
		#page-body h1 {
			margin-top: 0;
		}
	}
	</style>

</head>
<body>

<script type="text/javascript">
	$(document).ready(function(){

		$('.area').mouseenter(function() {
			$(this).animate({
				height: '+=10px',
				width: '+=10px',
				marginRight: '-=10px',
				marginBottom: '-=10px'
			});
			$(this).css("background-color","#101010");
		});

		$('.area').mouseleave(function() {
			$(this).animate({
				height:'-=10px',
				width:'-=10px',
				marginRight: '+=10px',
				marginBottom: '+=10px'
			});
			$(this).css("background-color","#555555");
		});

	});
</script>

<span id="forkongithub">
	<a href="https://github.com/pauloborba/ResS" id="forkongithublink">Fork me on GitHub</a>
</span>

<div style="min-height: 100%;">

	<div class="container">
		<img src="${resource(dir: 'images', file: 'ChemicalLab.png')}" alt="ChemicalLab" style="width:100%"/>
		<h1 style="font-size:1.5em">Available Areas:</h1>
	</div>

	<div class="areaContainer">
		<g:each var="c" in="${grailsApplication.controllerClasses.sort { it.fullName } }">
			<g:if test="${c.name != 'Dbdoc'}">
				<g:if test="${c.logicalPropertyName.toLowerCase()== "generatorharvestsolicitation"}">
					<g:link controller="${c.logicalPropertyName}"  id="1">
						<div class="area" id="${c.name}">
							<span>
								${c.name.replaceAll("([A-Z])",' $1')}
							</span>
						</div>
					</g:link>
				</g:if>
                <g:else>
				<g:link controller="${c.logicalPropertyName}">
					<div class="area" id="${c.name}">
						<span>
							${c.name.replaceAll("([A-Z])",' $1')}
						</span>
					</div>
				</g:link>
                </g:else>
			</g:if>
		</g:each>
	</div>
</div>
</body>
</html>
