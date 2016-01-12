# ResS_Project

Grails 2.1.5
ChromeDriver 2.1.5
JDK 1.7.0_65 SDK 7
Cucumber 0.10.0
Geb 0.9.2
Selenium 2.39.0

-------------------------------------------------------------------------------------------------------------------

Mark as Test Source todas as subpastas imediatas de test (não as subpastas das subpastas)
Em GebConfig.groovy setar caminho do chromeDriver no File (2.1.5)

-------------------------------------------------------------------------------------------------------------------

Arquivos Modificados:

conf.BuildConfig
cucumber.support.env.groovy
cucumber.CucumberGebSupport.gdsl
functional.GebConfig.groovy
conf.spring.CucumberConfig.groovy
-------------------------------------------------------------------------------------------------------------------

P/ testar:  test-app -Dgeb.env=chrome functional:cucumber

-------------------------------------------------------------------------------------------------------------------

<h2>Integração com o Travis-ci</h2> <br />
Entre em [Travis-CI](https://travis-ci.org/) <br />
Selecione o botão no canto superior direito "Sign in with github" <br />
Clique em seu nome no canto superior direito <br />
Pressione o botão cinza "Sync" caso seus repositórios não estejam aparecendo <br />
Caso os repositórios não aparecam, dê log out e entre novamente <br />
Escolha o repositório que deseja testar, no caso o Ress, e clique no botão cinza para que ele se torne verde <br />
Faça um commit qualquer para ativar a build do travis <br />
Caso você queira ver mais do stacktrace utilize "--verbose" logo após o comando "--stacktrace" no arquivo .travis.yml do seu repositório <br />
Para receber emails sobre se a build passou ou não, ative seu email no perfil do github <br />

-------------------------------------------------------------------------------------------------------------------

Produção: http://frozen-earth-8120.herokuapp.com/

-------------------------------------------------------------------------------------------------------------------

<h2>Regras para contribuir</h2> <br />

- Gerenciar atividades de desenvolvimento e teste através do PivotalTracker (https://www.pivotaltracker.com/n/projects/1443592);
- Integrar PivotalTracker e GitHub a fim de ser possível identificar os commits associados à uma tarefa;
- Padrão para mensagem de commit: <b>[#ID] message</b> e <b>[completed #ID] message</b>, sendo <b>ID</b> o identificador da tarefa no PivotalTracker;
- Tarefa de funcionalidade = User story do tipo feature do PivotalTracker;
- Tarefa de teste = User story do tipo chore do PivotalTracker;
- Padrão para título de tarefa de teste no PivotalTracker: <b>Test #ID_FEATURE</b>;
- Caso as tarefas de funcionalidade e teste sejam realizadas pela mesma pessoa, pode ser definida uma user story única no PivotalTracker para ambas;
- Commits que não estiverem relacionados à uma funcionalidade específica não devem ter ID;
- Um commit pode estar relacionado à mais de uma tarefa, o que significa que sua mensagem pode conter mais de um ID. Formato: <b>[#ID_1 #ID_2]</b>, sendo <b>ID_1</b> o identificador da tarefa 1 e <b>ID_2</b> o identificador da tarefa 2. 

Em caso de dúvidas, entrar em contato com <b>Thaís Burity</b> (https://github.com/thaisabr).
