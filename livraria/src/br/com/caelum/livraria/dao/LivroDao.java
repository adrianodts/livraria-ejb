package br.com.caelum.livraria.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import br.com.caelum.livraria.modelo.Livro;

@Stateless
public class LivroDao
{
	@PersistenceContext
	private EntityManager em;

	public void salva(Livro livro)
	{
		em.persist(livro);
	}

	public List<Livro> todosLivros() {
		return em.createQuery("select l from Livro l", Livro.class).getResultList();
	}

	public List<Livro> getLivrosPeloNome(String nome) {
		TypedQuery<Livro> query = em.createQuery("select l from Livro l Where l.titulo like :pTitulo", Livro.class);
		query.setParameter("pTitulo", "%" + nome + "%");getClass();
		return query.getResultList();
	}

	public List<Livro> livrosPeloTitulo(String titulo) {
		TypedQuery<Livro> query = em.createQuery(
			"select l from Livro l where l.titulo like :pTitulo",
			Livro.class);
		query.setParameter("pTitulo", "%" + titulo + "%");
		return query.getResultList();
	}}
