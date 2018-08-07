package br.com.caelum.livraria.bean;

import br.com.caelum.livraria.modelo.Autor;
import java.util.List;
import javax.enterprise.inject.Model;
import javax.inject.Inject;

@Model
public class AutorBean
{
	private Autor autor = new Autor();
	
	@Inject
	private AutorService service;

	public Autor getAutor() { return autor; }

	public void cadastra()
	{
		service.adiciona(autor);
		autor = new Autor();
	}

	public List<Autor> getAutores() {
		return service.todosAutores();
	}
}