package br.com.netquiz.servidor.dao;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.netquiz.servidor.factory.FabricaDeConexao;
import br.com.netquiz.servidor.model.Pergunta;
import br.com.netquiz.servidor.model.Resposta;

public class RespostaDAO {

	public Boolean adicionar(Resposta resposta, Pergunta pergunta){
		EntityManager manager = FabricaDeConexao.getEntityManagerFactory().createEntityManager();
		try{
			manager.getTransaction().begin();			
			resposta.setPergunta(pergunta);
			manager.persist(resposta);
			manager.getTransaction().commit();
			return true;
		}catch(Exception e){
			return false;
		}finally{
			manager.close();
		}
	}
	
	public ArrayList<Resposta> buscarRespostasDaPergunta(Pergunta pergunta){
		EntityManager manager = FabricaDeConexao.getEntityManagerFactory().createEntityManager();
		TypedQuery<Resposta> typedQuery = manager.createNamedQuery("Resposta.PesquisarPeloCodigoDaPergunta",Resposta.class);
		typedQuery.setParameter("id_pergunta",pergunta.getId_pergunta());
		ArrayList<Resposta> respostasArrayList = (ArrayList<Resposta>) typedQuery.getResultList();  // Pega resultado
		return respostasArrayList;
	}
	
	
}
