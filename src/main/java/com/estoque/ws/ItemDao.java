package com.estoque.ws;

import java.util.ArrayList;
import java.util.List;

// Classe Data Access Object da entidade Item, para realizar operações de pesquisa
public class ItemDao {

	private static List<Item> ITENS = new ArrayList<>();

	public ItemDao() {
		// populando alguns itens no estoque
		ITENS.add(new Item("MEA", "MEAN", "Livro", 5));
		ITENS.add(new Item("SEO", "SEO na Prática", "Livro", 4));
		ITENS.add(new Item("IP4", "IPhone 4 C", "Celular", 7));
		ITENS.add(new Item("GAL", "Galaxy Tab", "Tablet", 3));
		ITENS.add(new Item("MOX", "Moto X", "Celular", 6));
	}

	//métodos para cadastrar e procurar Item

	public List<Item> todosItens(List<Filtro> lista) {
		return ITENS;
	}
}