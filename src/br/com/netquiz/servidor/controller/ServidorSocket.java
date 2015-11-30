package br.com.netquiz.servidor.controller;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ServidorSocket {

	Logger logger = LogManager.getLogger(ClienteThread.class.getName());
	final int PORTASOCKET = 6789;

	BufferedReader requisicaoDoCliente;
	DataOutputStream responderOCliente;

	ArrayList<ClienteThread> arrayThreadDosClientes = new ArrayList<ClienteThread>();

	private ServerSocket conexaoServidorSocket;
	private Socket clienteSocket;

	public ServidorSocket() {
		try {
			conexaoServidorSocket = new ServerSocket(PORTASOCKET);
			logger.info("Inicializando servico...");
			logger.info("O Servidor NETQUIZ esta aguardando conexoes... ");
			logger.info("Server network:" + conexaoServidorSocket.getInetAddress().getHostAddress() + ":" + PORTASOCKET);
		} catch (Exception erro) {
			logger.error(erro);
		}
	}

	public void adicionarThreadDoClienteNoArray(ClienteThread clienteThread) {
		arrayThreadDosClientes.add(clienteThread);
	}

	public void aceitarConexao() {
		try {
			clienteSocket = conexaoServidorSocket.accept();
		} catch (Exception erro) {
			logger.error(erro);
		}
	}

	public ArrayList<ClienteThread> getArrayThreadDosClientes() {
		return arrayThreadDosClientes;
	}

	public ServerSocket getConexaoServidorSocket() {
		return conexaoServidorSocket;
	}

	public Socket getClienteSocket() {
		return clienteSocket;
	}

}
