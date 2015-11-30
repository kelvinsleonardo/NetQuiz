package br.com.netquiz.servidor.util;

import java.io.IOException;
import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.netquiz.servidor.controller.ClienteThread;
import br.com.netquiz.servidor.model.Pergunta;

public class Impressao {

	public Logger logger = LogManager.getLogger(Impressao.class.getName());
	public ArrayList<ClienteThread> arrayClienteThread;

	public Impressao(ArrayList<ClienteThread> arrayClienteThread) {
		this.arrayClienteThread = arrayClienteThread;
	}

	public void erroOpcaoInexistente(int indexCliente) {
		try {
			arrayClienteThread.get(indexCliente).responderOCliente
					.writeBytes("\r\nOPCAO INEXISTENTE!" + "\n\rDIGITE NOVAMENTE O NUMERO: ");
		} catch (IOException e) {
			logger.error(e);
		}
	}

	public void erroPerguntaInvalida(int indexCliente) {
		try {
			arrayClienteThread.get(indexCliente).responderOCliente
					.writeBytes("\r\nESSA PERGUNTA JA FOI ESCOLHIDA, E NAO ESTA DISPONIVEL!"
							+ "\n\rESCOLHA UMA PERGUNTA VALIDA DE ACORDO COM O MENU: ");
		} catch (IOException e) {
			logger.error(e);
		}
	}

	public void processarEnviarResultadoFinal() {

		int Jogador1 = arrayClienteThread.get(0).pontuacao;
		int Jogador2 = arrayClienteThread.get(1).pontuacao;
		String nomeJogador1 = arrayClienteThread.get(0).nome;
		String nomeJogador2 = arrayClienteThread.get(1).nome;
		try {
			if (Jogador1 > Jogador2) {
				arrayClienteThread.get(0).responderOCliente
						.writeBytes("\r\nPARABENS " + nomeJogador1 + " VOCE GANHOU!\r\n");
				arrayClienteThread.get(1).responderOCliente
						.writeBytes("\r\nIXI " + nomeJogador2 + " VOCE PERDEU !\r\n");
			} else if (Jogador2 > Jogador1) {
				arrayClienteThread.get(1).responderOCliente
						.writeBytes("\r\nPARABENS " + nomeJogador2 + " VOCE GANHOU!\r\n");
				arrayClienteThread.get(0).responderOCliente
						.writeBytes("\r\nIXI " + nomeJogador1 + " VOCE PERDEU !\r\n");
			} else {
				for (ClienteThread cliente : arrayClienteThread) {
					cliente.responderOCliente.writeBytes("\r\nO JOGO FICOU EMPATADO\r\n");
				}
			}
		} catch (IOException e) {
			logger.error(e);
		}
	}

	public void mostrarRanking() {
		try {
			for (ClienteThread arrayCliente : arrayClienteThread) {

				arrayCliente.responderOCliente.writeBytes(
								  "========================================\r\n" 
								+ "|                RANKING                |\r\n"
								+ "|---------------------------------------|\r\n"
								+ "|   NOME DO JOGADOR |  PONTUACAO        |\r\n"
								+ "|---------------------------------------|\r\n");
				for (ClienteThread cliente : arrayClienteThread) {
					arrayCliente.responderOCliente.writeBytes(
							"|   " + cliente.nome + "\t\t" + cliente.pontuacao + "" + "               |\r\n");
				}
				arrayCliente.responderOCliente.writeBytes("|---------------------------------------|\r\n"
						+ "========================================\r\n");
			}
		} catch (IOException e) {
			logger.error(e);
		}
	}

	public void erroSomenteNumero(int indexCliente){
		try {
			arrayClienteThread.get(indexCliente).responderOCliente.writeBytes(
					"\r\nPOR FAVOR, DIGITE APENAS NUMEROS INTEIROS!\n\r" + "DIGITE NOVAMENTE O NUMERO ESCOLHIDO: ");
		} catch (IOException e) {
			logger.error(e);
		}
	}

	public void maximoQuestoes(int indexCliente){
		try {
			arrayClienteThread.get(indexCliente).responderOCliente
					.writeBytes("\r\nLIMITE MAXIMO DE QUESTOES QUE PODEM SER" + "ESCOLHIDAS(8) FOI ATINGIDO");
		} catch (IOException e) {
			logger.error(e);
		}
	}

	public void enviarMensagemSeAcertou(int indexCliente, Boolean acertou){
		
		try {
			if (acertou) {
			
				arrayClienteThread.get(indexCliente).responderOCliente.writeBytes(
						"\r\n---------------------\r\n" 
					   +"  RESPOSTA CORRETA!\r\n" 
						   +"---------------------\r\n");
			}
			else {
				arrayClienteThread.get(indexCliente).responderOCliente.writeBytes(
						"\r\n---------------------\r\n" 
					   +" RESPOSTA INCORRETA!\r\n" 
					   +"---------------------\r\n");
			}
		} catch (IOException e) {
			logger.error(e);
		}
	}

	public void enviarMenu(int indexCliente, ArrayList<Boolean> arrayPerguntasValidas){

		String menu = "============================\r\n" 
					+ "|     MENU DE PERGUNTAS     |\r\n"
					+ "|---------------------------|\r\n";
		int quebraDeLinha = 1;

		for (int contador = 0; contador < arrayPerguntasValidas.size(); contador++) {
			if (!arrayPerguntasValidas.get(contador)) {
				if (quebraDeLinha <= 4) {
					if (quebraDeLinha != 4) {
						menu += "  ";
						menu += contador + 1 + "\t";
						quebraDeLinha++;
					} else {
						menu += contador + 1 + "\n\r";
						quebraDeLinha = 1;
					}

				}
			}
		}

		menu += "\n\r|---------------------------|\r\n" 
			   +"|*Perguntas ja selecionadas |\r\n"
			   +"| nao podem ser escolhidas. |\r\n" 
			   +"============================\n\n\r\r"
			   +"Digite o numero da pergunta: ";
		try {
			arrayClienteThread.get(indexCliente).responderOCliente.writeBytes(menu);
		} catch (IOException e) {
			logger.error(e);
		}
	}

	public void enviarPergunta(int indexCliente, Pergunta pergunta){
		try {
			arrayClienteThread.get(indexCliente).responderOCliente.writeBytes("\r\r\n\n" + pergunta.getTitulo_pergunta()
					+ "\r\n1. "+ pergunta.getRespostas().get(0).getTitulo_resposta() 
					+ "\r\n2. "+ pergunta.getRespostas().get(1).getTitulo_resposta() 
					+ "\r\n3. "+ pergunta.getRespostas().get(2).getTitulo_resposta() 
					+ "\r\n4. "+ pergunta.getRespostas().get(3).getTitulo_resposta() 
					+ "\r\r\n\nEscolha a alternativa correta: ");
		} catch (IOException e) {
			logger.error(e);
		}
	}

	public void enviarEsperarJogada(int indexCliente){
		try {
			arrayClienteThread.get(indexCliente).responderOCliente
					.writeBytes("\r\nPor favor, aguarde a jogada do seu oponente...\r\n");
		} catch (IOException e) {
			logger.error(e);
		}
	}

	public int getInputInteiroDoCliente(int indexCliente){
		Boolean erro = true;
		int number = 0;
		do {
			try {
				number = Integer.parseInt(arrayClienteThread.get(indexCliente).requisicaoDoCliente.readLine());
				erro = false;
			} catch (Exception e) {
				erroSomenteNumero(indexCliente);
				logger.error(e);
			}
		} while (erro);

		return number;
	}
}
