package br.com.caelum.livraria.webservice;

import java.rmi.RemoteException;

public class App {

	public static void main(String[] args) throws RemoteException {

		LivrariaWS proxy = new LivrariaWSProxy();
		Livro[] livros = proxy.getLivrosPorTitulo("net");
	
		for (Livro livro : livros) {
			System.out.println("Livro: " + livro.getTitulo());
			System.out.println("Autor: " + livro.getAutor().getNome());
		}
	}
}
