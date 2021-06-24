package com.estoque.ws;

import javax.xml.ws.WebFault;

@WebFault(name = "AutorizacaoFault") // Define nome do Fault no WSDL
public class AutorizacaoException extends Exception {
    //esse numero eh relacionado com a serializacao do java.io mas nao importa nesse contexto
    private static final long serialVersionUID = 1L;

    public AutorizacaoException(String msg) {
        super(msg);
    }

    public String getFaultInfo() { // Mensagem ao ser retornada no caso de Fault no WSDL
        return "Token invalido";
    }
}
