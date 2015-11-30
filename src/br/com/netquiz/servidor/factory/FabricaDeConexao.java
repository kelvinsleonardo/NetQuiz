package br.com.netquiz.servidor.factory;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class FabricaDeConexao {
		
	private static EntityManagerFactory fabrica = null;
	/**
	* Cria o Entity Manager caso não esteja criado.
	* @return EntityManagerFactory - Fabrica do Entity Manager
	*/
	public static EntityManagerFactory getEntityManagerFactory() {
		if(fabrica == null){				
			fabrica = Persistence.createEntityManagerFactory("netquiz");
		}
	
			return fabrica; 
	}
}
