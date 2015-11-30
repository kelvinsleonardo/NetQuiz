# Tutorial de execução e como jogar

NetQuiz é um jogo de perguntas e respostas que estabelece comunicação cliente/servidor multiusuário utilizando comunicação por Sockets. Para sua correta execução são necessárias as seguintes ferramentas:

  - Eclipse/Netbeans IDE
  - Servidor MySQL
  - 2 clientes telnet

### Instalação

- Primeiro é necessário a instalação do servidor [MySQL](https://dev.mysql.com/downloads/mysql/5.5.html).
- Após a instalação, é necessário criar um banco chamado "netquiz" em minúsculo.
- O usuário do banco deve ser "root" e a senha "root".
- Em seguida execute o script ```netquiz.sql``` para criar as tabelas e popular o banco com as perguntas e respostas.
- Na IDE Eclipse, ir em ```File > Import```, selecionar a opção ```Git - Projects from Git```, ```Clone Url``` e inserir a url do projeto no gitlab.
- Na IDE Netbeans, ir em ```Team > Git> Clone``` e inserir a url do projeto no gitlab.
- Feito isso será clonado o projeto no repositório local.

### Execução
Inicialize o servidor Main.java no pacote "br.com.netquiz.servidor.core", em seguida abrir 2 clientes do telnet e digitar a seguinte string de conexão nas duas janelas de console:
```sh
$ telnet localhost 6789
```
Após isso o jogo irá inicializar. Como o jogo é por turnos, em uma das janelas o jogo irá apresentar a mensagem pedindo para aguardar, e na outra irá ser apresentado um menu com opções de escolha do número da pergunta desejada. 

Jogador 1:
```
- Será apresentado uma lista com a numeração das perguntas, após escolher a pergunta desejada o servidor envia a pergunta e o jogador deve digitar a opção correspondente à resposta correta.
```
Jogador 2:
```
- Aguarde jogador 1 realizar sua jogada.
```
Após a escolha da resposta, o servidor valida se a resposta está correta e inserir a pontuação de acordo com sua resposta.

Após verificar se o primeiro jogador pontuou ou não, será a vez do segundo jogador realizar sua jogada, uma mensagem será apresentada para o primeiro jogador aguardar enquanto o segundo jogador efetua sua jogada.

O vencedor será quem ao final das rodadas possuir a maior pontuação.


