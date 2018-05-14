package br.univille.app.tarefas.modelo;
import java.util.Date;

public class Tarefa {
	private long id;
	private String nome;
	private int prioridade;
	private Date data;
	private boolean feito;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getPrioridade() {
		return prioridade;
	}
	public void setPrioridade(int prioridade) {
		this.prioridade = prioridade;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public boolean isFeito() {
		return feito;
	}
	public void setFeito(boolean feito) {
		this.feito = feito;
	}
	
	
}
