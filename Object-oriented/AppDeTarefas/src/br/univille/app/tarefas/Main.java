package br.univille.app.tarefas;

import java.util.Date;
import java.util.List;

import br.univille.app.tarefas.dao.ConnectionFactory;
import br.univille.app.tarefas.dao.TarefaDAO;
import br.univille.app.tarefas.modelo.Prioridade;
import br.univille.app.tarefas.modelo.Tarefa;
import br.univille.app.tarefas.view.ListarTarefasView;

public class Main {

	public static void main(String[] args) {
		
		TarefaDAO dao = new TarefaDAO();
		List<Tarefa> lista = dao.obterTodos();
		
		ListarTarefasView v = new ListarTarefasView();
		v.listar(lista);
		
		/*
		Tarefa t = new Tarefa();
		t.setNome("Testando insert pelo Java ");
		t.setData(new Date());
		t.setFeito(true);
		t.setPrioridade(Prioridade.BAIXA);
		dao.adicionar(t);
		
		
		/*
		t = new Tarefa();
		t.setNome("Listar todos os itens da coleção");
		t.setData(new Date());
		t.setFeito(true);
		t.setPrioridade(Prioridade.NORMAL);
		dao.adicionar(t);
		
		t = new Tarefa();
		t.setNome("Listar as tarefas não realizadas");
		t.setData(new Date());
		t.setFeito(true);
		t.setPrioridade(Prioridade.ALTA);
		dao.adicionar(t);
		
		t = new Tarefa();
		t.setNome("Listar as tarefas por prioridade");
		t.setData(new Date());
		t.setPrioridade(Prioridade.ALTA);
		dao.adicionar(t);
		
		List<Tarefa> l = dao.obterTodos();
		//TODO Listar as tarefas por prioridade
		// apenas baixa, alta, média
		
		ListarTarefasView w = new ListarTarefasView();
		v.listar(l);
		*/
	}

}
