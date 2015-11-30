package br.com.netquiz.servidor.dao;

import java.util.ArrayList;

import javax.persistence.EntityManager;

import br.com.netquiz.servidor.factory.FabricaDeConexao;
import br.com.netquiz.servidor.model.Pergunta;

public class PerguntaDAO {
		
		public Boolean adiciona(Pergunta pergunta){
			EntityManager manager = FabricaDeConexao.getEntityManagerFactory().createEntityManager();
			try{
				manager.getTransaction().begin();			
				manager.persist(pergunta);
				manager.getTransaction().commit();
				return true;
			}catch(Exception e){
				return false;
			}finally{
				manager.close();
			}
		}
		
		public ArrayList<Pergunta> buscarPerguntasAleatorias(int limiteDeQuestoes){
			
		    String SQL_RANDON_LIMIT = 
		    				"SELECT * FROM tb_pergunta "
		    			   +"ORDER BY RAND() "
		    			   +"LIMIT "+limiteDeQuestoes;
			
			EntityManager manager = FabricaDeConexao.getEntityManagerFactory().createEntityManager();
			
			manager.getTransaction().begin();
			
			@SuppressWarnings("unchecked")
			ArrayList<Pergunta> arrayDePerguntas = (ArrayList<Pergunta>)
						manager.createNativeQuery(SQL_RANDON_LIMIT,Pergunta.class).
						getResultList();
			
			manager.getTransaction().commit();
			return arrayDePerguntas;
		}
}
