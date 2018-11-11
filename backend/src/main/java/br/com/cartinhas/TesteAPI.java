package br.com.cartinhas;

import br.com.cartinhas.service.APIService;

public class TesteAPI {
	
	public static void main(String[] args) {
		APIService api = new APIService();
		api.getList(null);
	}

}
