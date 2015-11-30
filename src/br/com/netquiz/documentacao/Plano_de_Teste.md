# **Plano de Teste**  

# **Objetivo**  

O documento do plano de teste de software tem o objetivo de executar o software de modo sistemático afim de encontrar `defeitos`, `erros` e `falhas`. E além disso os testes objetivam aumentar a confiabilidade do software desenvolvido, aumentado a probabildiade de que o jogo funcionará sem falhas durante um período de tempo.  

# **Sequência de teste**  

- **Teste 1**  

Abrir dois clientes telnet. 
Digitar a string de conexão nas duas janelas do console.  

Resultado esperado: Conexão dos dois jogadores através da string de conexão: telnet localhost 6789.  

Possível falha: Jogadores não se conectarem através do telnet. 

- **Teste 2**  

Após a conexão dos jogadores o jogo irá inicializar.  

Em uma janela será apresentado uma mensagem para o jogador aguardar a sua vez para realizar a jogada.  

Possível falha: Não exibir a mensagem para aguardar a vez para realizar a jogada e os dois jogadores se conectarem ao mesmo tempo.  

Resultado esperado: Exibir a mensagem para o jogador que está aguardando a sua vez para realizar a jogada.


- **Teste 3**  

Após a conexão dos jogadores o jogo irá inicializar. 

Uma janela será apresentado ao jogador. Nesta janela irá conter o menu, com os números das perguntas disponíveis. 

Possível falhas: Janela não exibir o menu de questões para o jogador.  

Resultado esperado: Exibir janela com menu de questões.  

- **Teste 4**  

Após o jogador escolher o número da questão será apresentado a questão com opções de escolha, de 1 a 4.  

Possível falha: Não apresentar as opções das questões.

Resultado esperado: Apresentar as opções da questões.  

- **Teste 5**  

Após a escolha da resposta, será apresentado a resposta correta e será inserida a pontuação conforme a resposta.  

Caso a resposta seja correta a pontuação será 1 (um), caso esteja incorreta será zero (0).  

Possíveis falhas: Não apresentar a resposta correta e a pontuação do jogador.  

Resultados esperados: Informar a reposta correta e informar a pontuação do jogador.  

- **Teste 6**  

Após o jogador 1 terminar a sua jogada, será a vez do jogador 2 realizar a sua jogada.  

Será exibido para o primeiro jogador mensagem para aguardar a sua vez, enquanto o segundo jogador realiza a jogada.

Possíveis falhas: Não ser exibida mensagem para aguardar ao jogador 1 e o jogador 2 não realizar a sua jogada.  

Resultados esperados: Exibir mensagem ao jogador 1 e o jogador 2 realizar a jogada. 

-  **Teste 7**  

Após o final das 8 rodadas será informada a pontuação total dos jogadores, o vencedor será o jogador que possuir a maior pontuação.

Possíveis falhas: Não infomar a pontuação dos jogadores e informar o vencedor.

Resultados esperados: Mostrar a pontuação dos jogadores e o vencedor. 
















