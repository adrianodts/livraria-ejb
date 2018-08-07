package br.com.caelum.livraria.bean;

import br.com.caelum.livraria.dao.AutorDao;
import br.com.caelum.livraria.modelo.Autor;
import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class AutorService
{
	@Inject
	AutorDao dao;

	public void adiciona(Autor autor)
	{
		dao.salva(autor);
	}

	public java.util.List<Autor> todosAutores()
	{
		return dao.todosAutores();
	}
}