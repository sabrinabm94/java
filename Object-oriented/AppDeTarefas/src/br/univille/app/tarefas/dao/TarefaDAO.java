package br.univille.app.tarefas.dao;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import br.univille.app.tarefas.modelo.Tarefa;

public class TarefaDAO {
	
	private Connection mConn;
	
	private List<Tarefa> lista;
	
	public TarefaDAO(){
		// Cria a coleção de tarefas.
		lista = new ArrayList<>();
		mConn = (new ConnectionFactory()).getConnection();
	}
	
	public void adicionar(Tarefa t){
		
		String sql = "insert into tarefa(nome,prioridade,data,feito) "
				    + "values(?,?,?,?);";
		
		try{
			
			PreparedStatement stmt = mConn.prepareStatement(sql);
			// troca os ? pelos valores da Tarefa.
			stmt.setString(1, t.getNome());
			stmt.setInt(2, t.getPrioridade());
			// Para salvar a Data no banco de dados
			// tem que usar o java.sql.Date
			stmt.setDate(3, new java.sql.Date(t.getData().getTime()));
			stmt.setBoolean(4, t.isFeito());
			
			stmt.execute();
			stmt.close();
			System.out.println("Gravado!");
			
		}catch (Exception e) {
			System.out.println("Erro "+e.getMessage());
			e.printStackTrace();
		}
		
	}
	
	public int obterQtde(){
		return lista.size();
	}
	
	public List<Tarefa> obterTodos(){
		List<Tarefa> lista = new ArrayList<>();
		String sql = "select * from tarefa ";
		try{
			PreparedStatement stmt = mConn.prepareStatement(sql);
			ResultSet result = stmt.executeQuery();
			while(result.next()){
				Tarefa t = new Tarefa();
				// obtem o valor da coluna nome
				t.setNome(result.getString("nome"));
				t.setPrioridade(result.getInt("prioridade"));
				t.setData(result.getDate("data"));
				t.setFeito(result.getBoolean("feito"));
				lista.add(t);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return lista;
	}
	
	public List<Tarefa> obterTarefaNaoRealizadas(){
		List<Tarefa> l = new ArrayList<>();
		for(Tarefa t : lista){
			if(!t.isFeito()){
				l.add(t);
			}
		}
		return l;
	}

}
