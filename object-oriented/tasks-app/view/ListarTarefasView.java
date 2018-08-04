package br.univille.app.tarefas.view;

import java.text.SimpleDateFormat;
import java.util.List;

import br.univille.app.tarefas.modelo.Tarefa;

public class ListarTarefasView {
	
	public void listar(List<Tarefa> lista){
		SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy");
		System.out.println("==============================");
		System.out.println(" Tarefa\t\t\t\t\tData\t\tFeito\tPrioridade");
		System.out.println("==============================");
		for(Tarefa t : lista){
			System.out.println(t.getNome() 
					+ "\t" 
					+ f.format(t.getData())
					+ "\t"
					+ t.isFeito()
					+ "\t"
					+ t.getPrioridade());
		}
	}
	

}
