package br.com.netquiz.servidor.core;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.netquiz.servidor.controller.ClienteThread;
import br.com.netquiz.servidor.controller.ServidorSocket;

public class Main {

	public static Logger logger = LogManager.getLogger(Main.class.getName());
	public static int clienteConectados = 0;

	public static void main(String[] args) {

		ServidorSocket servidorSocket = new ServidorSocket();

		while (true) {
			if (clienteConectados < 2) {
				servidorSocket.aceitarConexao();
				ClienteThread clienteThread = new ClienteThread(servidorSocket.getClienteSocket(), servidorSocket);
				servidorSocket.adicionarThreadDoClienteNoArray(clienteThread);
				String ip = servidorSocket.getClienteSocket().getInetAddress().getHostAddress();
				logger.info("Cliente " + (clienteConectados + 1) + " de IP: " + ip + " conectado com sucesso.");
				clienteThread.start();
				clienteConectados++;
			}

		}
	}
}
