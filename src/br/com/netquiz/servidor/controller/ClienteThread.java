package br.com.netquiz.servidor.controller;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.netquiz.servidor.core.Main;
import br.com.netquiz.servidor.dao.PerguntaDAO;
import br.com.netquiz.servidor.model.Pergunta;
import br.com.netquiz.servidor.util.Impressao;
import br.com.netquiz.servidor.util.PerguntaUtil;

public class ClienteThread extends Thread {

	public Logger logger = LogManager.getLogger(ClienteThread.class.getName());

	public Socket conexaoSocket;
	public ServidorSocket servidorSocket;

	public final int QUANTIDADE_DE_PERGUNTAS = 16;
	public final int QUANTIDADE_DE_ALTERNATIVAS = 4;
	public int pontuacao = 0;
	public int numeroDeRodadas = 0;

	public String nome;

	public Boolean jogoComecou = false;
	public Boolean jogoTerminou = false;

	public ArrayList<ClienteThread> arrayClienteThread;
	public ArrayList<Boolean> arrayPerguntasValidas;

	public BufferedReader requisicaoDoCliente;
	public DataOutputStream responderOCliente;
	public PerguntaUtil perguntaUtil;
	public PerguntaDAO pergundaDAO;

	public ClienteThread(Socket conexao, ServidorSocket servidorSocket) {
		try {
			this.conexaoSocket = conexao;
			this.servidorSocket = servidorSocket;
			requisicaoDoCliente = new BufferedReader(new InputStreamReader(conexao.getInputStream()));
			responderOCliente = new DataOutputStream(conexao.getOutputStream());
		} catch (Exception erro) {
			logger.error(erro);
		}
	}

	@Override
	public void run() {
		try {
			arrayClienteThread = servidorSocket.getArrayThreadDosClientes();

			if (Main.clienteConectados == 1) {
				responderOCliente.writeBytes("\nPor favor aguarde seu oponente conectar!\n");
				logger.info("Aguardando jogador 2 se conectar...");
			}
			while (!jogoComecou) {

				if (Main.clienteConectados == 2) {
					logger.info("Solicitando configurações iniciais do sistema");
					for (ClienteThread cliente : arrayClienteThread) {
						cliente.responderOCliente.writeBytes("\r\nInicializando o jogo, aguarde por favor...\r\n");

					}
					for (ClienteThread cliente : arrayClienteThread) {
						cliente.responderOCliente.writeBytes("Iniciando Configuracoes...\r\n" + "Digite seu nome: ");
						cliente.nome = cliente.requisicaoDoCliente.readLine().toUpperCase();
						cliente.responderOCliente
								.writeBytes("Solicitando configuracao inicial do oponente, por favor aguarde...\r\n");
					}
					for (ClienteThread cliente : arrayClienteThread) {
						cliente.responderOCliente
								.writeBytes("Carregando configuracoes do sistema, por favor aguarde...\r\n");

					}
					jogoComecou = true;
					logger.info("Jogo iniciado.");
				}
			}

			perguntaUtil = new PerguntaUtil();
			pergundaDAO = new PerguntaDAO();
			arrayPerguntasValidas = new ArrayList<Boolean>(Arrays.asList(new Boolean[QUANTIDADE_DE_PERGUNTAS]));
			Collections.fill(arrayPerguntasValidas, Boolean.FALSE);
			ArrayList<Pergunta> arrayPerguntas = pergundaDAO.buscarPerguntasAleatorias(QUANTIDADE_DE_PERGUNTAS);
			Impressao impressao = new Impressao(arrayClienteThread);

			int contador = 0;
			while (contador < arrayClienteThread.size() && !jogoTerminou) {
				if (contador % 2 == 0) {
					logger.info("Jogada do jogador 1");
					impressao.enviarEsperarJogada(contador + 1);
					impressao.enviarMenu(contador, arrayPerguntasValidas);

					int opcaoDaPergunta = 0;

					do {
						opcaoDaPergunta = impressao.getInputInteiroDoCliente(contador);

						if (opcaoDaPergunta > QUANTIDADE_DE_PERGUNTAS || opcaoDaPergunta < 1) {
							impressao.erroOpcaoInexistente(contador);
						} else if (arrayPerguntasValidas.get(opcaoDaPergunta - 1)) {
							impressao.erroPerguntaInvalida(contador);
						}

					} while (opcaoDaPergunta > QUANTIDADE_DE_PERGUNTAS || opcaoDaPergunta < 1
							|| arrayPerguntasValidas.get(opcaoDaPergunta - 1));

					arrayPerguntasValidas.set(opcaoDaPergunta - 1, true);

					impressao.enviarPergunta(contador, arrayPerguntas.get(opcaoDaPergunta - 1));

					int opcaoDaResposta = 0;
					do {
						opcaoDaResposta = impressao.getInputInteiroDoCliente(contador);
						;

						if (opcaoDaResposta > QUANTIDADE_DE_ALTERNATIVAS || opcaoDaResposta < 1) {
							impressao.erroOpcaoInexistente(contador);
							impressao.enviarPergunta(contador, arrayPerguntas.get(opcaoDaPergunta - 1));
						}

					} while (opcaoDaResposta > QUANTIDADE_DE_ALTERNATIVAS || opcaoDaResposta < 1);

					Boolean acertou = perguntaUtil.validarResposta(opcaoDaResposta,
							arrayPerguntas.get(opcaoDaPergunta - 1));

					if (acertou) {
						arrayClienteThread.get(contador).setPontuacao();
						impressao.mostrarRanking();
					}

					impressao.enviarMensagemSeAcertou(contador, acertou);

					contador++;
					numeroDeRodadas++;

				}

				else {
					logger.info("Jogada do jogador 2");
					impressao.enviarEsperarJogada(contador - 1);
					impressao.enviarMenu(contador, arrayPerguntasValidas);

					int opcaoDaPergunta = 0;
					do {
						opcaoDaPergunta = impressao.getInputInteiroDoCliente(contador);

						if (opcaoDaPergunta > QUANTIDADE_DE_PERGUNTAS || opcaoDaPergunta < 1) {
							impressao.erroOpcaoInexistente(contador);
						} else if (arrayPerguntasValidas.get(opcaoDaPergunta - 1)) {
							impressao.erroPerguntaInvalida(contador);
						}
					} while (opcaoDaPergunta > QUANTIDADE_DE_PERGUNTAS || opcaoDaPergunta < 1
							|| arrayPerguntasValidas.get(opcaoDaPergunta - 1));

					arrayPerguntasValidas.set(opcaoDaPergunta - 1, true);
					impressao.enviarPergunta(contador, arrayPerguntas.get(opcaoDaPergunta - 1));

					int opcaoDaResposta = 0;
					do {
						opcaoDaResposta = impressao.getInputInteiroDoCliente(contador);

						if (opcaoDaResposta > QUANTIDADE_DE_ALTERNATIVAS || opcaoDaResposta < 1) {
							impressao.erroOpcaoInexistente(contador);
							impressao.enviarPergunta(contador, arrayPerguntas.get(opcaoDaPergunta - 1));
						}

					} while (opcaoDaResposta > QUANTIDADE_DE_ALTERNATIVAS || opcaoDaResposta < 1);

					Boolean acertou = perguntaUtil.validarResposta(opcaoDaResposta,
							arrayPerguntas.get(opcaoDaPergunta - 1));

					if (acertou) {
						arrayClienteThread.get(contador).setPontuacao();
						impressao.mostrarRanking();
					}

					impressao.enviarMensagemSeAcertou(contador, acertou);

					contador--;
					numeroDeRodadas++;
				}

				if (numeroDeRodadas == QUANTIDADE_DE_PERGUNTAS) {
					jogoTerminou = true;
					impressao.processarEnviarResultadoFinal();
				}
			}
			System.exit(0);
		} catch (Exception erro) {
			logger.error(erro);
		}
	}

	public void setPontuacao() {
		this.pontuacao = pontuacao + 1;

	}

}
