package br.com.netquiz.servidor.util;


import br.com.netquiz.servidor.model.Pergunta;

public class PerguntaUtil {

	public Boolean validarResposta(int numeroAlternativa, Pergunta pergunta){
		if(pergunta.getRespostas().get(numeroAlternativa-1).getValido()){
			return true;
		}
		return false;
	}
	
}
