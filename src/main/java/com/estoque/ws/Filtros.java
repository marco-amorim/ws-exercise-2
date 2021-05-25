package com.estoque.ws;

import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement()
@XmlAccessorType(XmlAccessType.FIELD)
// Classe que representa o filtro dos itens
public class Filtros {

	@XmlElement(name = "filtro") // Annotation que define o nome do elemento como "filtro"
	private List<Filtro> filtros;

	public List<Filtro> getLista() {
		return filtros;
	}

}