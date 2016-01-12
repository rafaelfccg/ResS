Feature: Deletar pontos de coleta
  As a membro da empresa coletora
  I want to deletar pontos de coleta
  so that eles sejam apagados do sistema
@ignore
  Scenario: Delete interrompido
    Given Estou na pagina de editar do ponto "RU"
    When Desisto de deletar um ponto recusando a mensagem de confirmação
    Then O ponto continua no sistema
@ignore
  Scenario: Deletar ponto de coleta
    Given Estou na pagina de editar do ponto "RU"
    When deleto o ponto aceitando a mensagem de confirmação
    Then a deleção é confirmada

