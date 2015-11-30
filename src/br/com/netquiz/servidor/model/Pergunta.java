package br.com.netquiz.servidor.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@NamedQueries({
	@NamedQuery(name="Pergunta.BuscarTodasPerguntas", 
				query="SELECT perg FROM Pergunta perg")
})

@Entity
@Table(name = "tb_pergunta")
public class Pergunta implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_pergunta;
	
	private String titulo_pergunta;
	
	@OneToMany(mappedBy = "pergunta")
	private List<Resposta> respostas;
	
	public Pergunta(String titulo_pergunta){
		this.titulo_pergunta = titulo_pergunta;
	}
	
	public Pergunta(){}
	
	public List<Resposta> getRespostas() {
		return respostas;
	}
	public void setRespostas(List<Resposta> respostas) {
		this.respostas = respostas;
	}
	public int getId_pergunta() {
		return id_pergunta;
	}
	public void setId_pergunta(int id_pergunta) {
		this.id_pergunta = id_pergunta;
	}
	public String getTitulo_pergunta() {
		return titulo_pergunta;
	}
	public void setTitulo_pergunta(String titulo_pergunta) {
		this.titulo_pergunta = titulo_pergunta;
	}
	public void adicionaRespostas(Resposta resposta){
		this.respostas.add(resposta);
		resposta.setPergunta(this);
	}
	
	
}
