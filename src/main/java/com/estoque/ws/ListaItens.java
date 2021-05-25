package com.estoque.ws;

import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

// classe criada pois o JAX-B nao reconhece o List do Java
@XmlRootElement // Annotation para o JAX-B indentificar esta classe como um Root Element
@XmlAccessorType(XmlAccessType.FIELD) // Essa annotation define acesso pelo atributo, assim nao precisamos criar getters e setters
public class ListaItens {

	@XmlElement(name = "item")
	private List<Item> itens;

	public ListaItens(List<Item> itens) {
		this.itens = itens;
	}

	// construtor padrao
	ListaItens() {
	}
}