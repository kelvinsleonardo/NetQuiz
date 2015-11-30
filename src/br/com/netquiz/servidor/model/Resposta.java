package br.com.netquiz.servidor.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@NamedQueries({
	@NamedQuery(name="Resposta.PesquisarPeloCodigoDaPergunta", 
				query="SELECT resp FROM Resposta resp JOIN resp.pergunta perg WHERE perg.id_pergunta = :id_pergunta")
})


@Entity
@Table(name = "tb_resposta")
public class Resposta {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_resposta;
	
	private String titulo_resposta;
	
	@ManyToOne
	@JoinColumn(name= "id_pergunta",referencedColumnName = "id_pergunta")
	private Pergunta pergunta;
	
	private Boolean valido;
	
	public Pergunta getPergunta() {
		return pergunta;
	}
	public void setPergunta(Pergunta pergunta) {
		this.pergunta = pergunta;
	}
	public int getId_resposta() {
		return id_resposta;
	}
	public void setId_resposta(int id_resposta) {
		this.id_resposta = id_resposta;
	}
	public String getTitulo_resposta() {
		return titulo_resposta;
	}
	public void setTitulo_resposta(String titulo_resposta) {
		this.titulo_resposta = titulo_resposta;
	}
	
	public Boolean getValido() {
		return valido;
	}
	public void setValido(Boolean valido) {
		this.valido = valido;
	}
	
}
