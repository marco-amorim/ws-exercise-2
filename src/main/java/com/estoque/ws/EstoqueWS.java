package com.estoque.ws;

import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

@WebService
public class EstoqueWS {

	private ItemDao dao = new ItemDao(); // chama o Data Access Object para ser usado na classe

	// Método sem usar o @ResponseWrapper
	//		@WebMethod(operationName = "todosOsItens") // Annotation para redefinir o nome da operation no WSDL, e assim tambem manipular a mensagem SOAP
	//		@WebResult(name = "itens") // Annotation para melhorar a resposta SOAP, ja que o return nao deve existir
	//		public ListaItens getItens(@WebParam(name = "filtros") Filtros filtros) { // Annotation @WebParam para mudar o nome de "arg0" para "filtros"
	//			System.out.println("Chamando getItens()");
	//			List<Filtro> lista = filtros.getLista();
	//			List<Item> itensResultado = dao.todosItens(lista);
	//			return new ListaItens(itensResultado); // Retorna bean que representa a Lista de Itens
	//		}

	// Método usando o @ResponseWrapper
	@WebMethod(operationName = "todosOsItens")
	@ResponseWrapper(localName = "itens") // Annotation para redefinir o nome do elemento que embrulha a mensagem na Resposta
	@WebResult(name = "item") // Com o @ResponseWrapper cada item deverá ser representado pela tag <item>, já que o nome do elemento pai será <itens>
	@RequestWrapper(localName = "listaItens") // Annotation para redefinir o nome do elemento que embrulha a mensagem na Requisição
	public List<Item> getItens(@WebParam(name = "filtros") Filtros filtros) {

		List<Filtro> lista = filtros.getLista();
		List<Item> result = dao.todosItens(lista);

		return result; // Com o @ResponseWrapper conseguimos retornar a interface de List do próprio Java sem o JAX-B ter problemas
	}

	@WebMethod(exclude = true) // Annotation para excluir metodos que nao queremos no nosso contrato WSDL
	public void outroMetodo() {
		//nao vai fazer parte do WSDL
	}
}