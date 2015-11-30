# **Introdução**

Este documento descreve o jogo de perguntas e respostas NetQuiz, desenvolvido como projeto da disciplina de Aplicações Distribuídas do curso de Sistemas de Informação da Universidade Federal de Goiás. O propósito do jogo é estabelecer uma conexão cliente/servidor multiusuário utilizando comuniação por Sockets, e apresentar funcionalidade e usabilidade reforçando os conceitos básicos de sistemas de computação distribuída.

## **Visão Geral do Documento**
Esta introdução fornece as informações necessárias para utilizar este documento, explicitando os objetivos e as convenções que foram adotadas no texto. As demais seções apresentam as especificações do sistema e estão organizadas como descrito abaixo:

- **Requisitos Funcionais**: Compreende o conjunto de requisitos funcionais do sistema a ser desenvolvido, descrevendo as suas prioridades.
- **Requisitos Não Funcioanais**: Contém os requisitos não funcionais do sistema a ser desenvolvido, descrevendo atríbutos de qualidade que o sistema deve possuir, ou restrições que ele deve satisfazer.

## **Prioridades dos Requisitos**
A atribuição de prioridade dos requisitos pode ser de 3 (três) tipos: `essencial`, `importante` e `desejável`. A prioridade dos requisitos pode ser usada no gerenciamente do escopo do projeto e na definição das prioridades para o desenvolvimento do sistema.

- **Essencial**: Requisito sem o qual o sistema não entra em funcionamento, são requisitos imprescindíveis e devem ser disponibilizados na implantação do sistema.
- **Importante**: Requisito sem o qual o sistema entra em funcionamento, mas de forma não satisfatória, não impedem a implantação do sistema, mas devem ser implementados o mais breve possível.
- **Desejável**: Requisito que, embora não implementado, ainda permite o sistema funcionar de modo satisfatório sem comprometer as funcionalidades básicas do sistema. Pode ser entregue a qualquer momento, sem prejuízo aos serviços oferecidos pelo sistema.

### **Requisitos Funcionais**
**[RF01]** O jogo será iniciado apenas quando os dois jogadores estiverem conectados.  
Prioridade:  

**[RF02]** O jogo será disputado por 2 (dois) jogaodres, esses jogadores serão 2 (dois) humanos ou 1 (um) humano e um 1 (um) robô.  
Prioridade:  

**[RF03]** O jogo terá 1 (um) jogador controlado pelo computador (BOT).  
Prioridade:  

**[RF04]** O jogador deverá escolher apenas uma questão por rodada.  
Prioridade:  

**[RF05]** A mesma questão não poderá ser escolhida pelo mesmo jogador e pelo seu adversário.  
Prioridade:  

**[RF06]** O jogador deverá aguardar o adversário terminar a rodada, para começar a sua rodada.  
Prioridade:  

**[RF07]** A cada rodada será exibida a pontuação dos jogadores.  
Prioridade:  

**[RF08]** A cada resposta correta o jogador ganhará 1 ponto.  
Prioridade:  

**[RF09]** A cada resposta incorreta jogador não ganhará ponto, a pontuação será 0 (zero).  
Prioridade:  

**[RF10]** O jogo terá 16 questões, cada jogador escolherá 8 (oito) questões.  
Prioridade:  

**[RF11]** Todas as questões serão numeradas.  
Prioridade:  

**[RF12]** Cada questão terá 4 (quatro) opções de respostas numeradas, de 1 (um) ao 4 (quatro, sendo possível escolher uma entre as alternativas.  
Prioridade:  

**[RF13]** Toda questão terá 1 (uma) resposta correta e 3 (três) incorretas.  
Prioridade:  

**[RF14]** As questões serão armazenadas no banco de dados, a cada partidas as questões e a ordem serão alteradas, não haverá questões especificas para cada numeração.  
Prioridade: 

**[RF15]** Ao final do jogo será informado a pontuação dos jogadores, qual jogador venceu e caso ambos acertem a mesma quantidade de questões haverá empate.  
Prioridade:  


### **Requisitos Não Funcionais**  
**[RNF01]** O jogo será iniciado em até 10 segundos após a conexão dos usuários.  
Prioridade:  

**[RNF01]** O jogo será desenvolvido na linguagem Java.  
Prioridade:  

**[RNF03]** Será utilizado o banco de dados MySQL.  
Prioridade:  

**[RNF04]** Será utilziado o GitLab, plataforma open source, para repositório da documentação e códigos do projeto.  
Prioridade:  

**[RNF05]** O jogo poderá ser jogado em qualquer sistema operacional.  
Prioridade:  

**[RNF06]** A conexão entre os jogadores será através do protocolo Socket.  
Prioridade:  
