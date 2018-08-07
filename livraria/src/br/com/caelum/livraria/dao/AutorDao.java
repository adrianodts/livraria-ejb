package br.com.caelum.livraria.dao;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.caelum.livraria.modelo.Autor;

@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class AutorDao
{
	@PersistenceContext
	private EntityManager em;

	@PostConstruct
	void aposCriacao()
	{
		System.out.println("AutorDao foi criado");
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void salva(Autor autor) {
		System.out.printf("salvando Autor %s%n", new Object[] { autor.getNome() });

		em.persist(autor);
		System.out.printf("salvou Autor %s%n", new Object[] { autor.getNome() });
	}

	public java.util.List<Autor> todosAutores()
	{
		return em.createQuery("select a from Autor a", Autor.class).getResultList();
	}

	public Autor buscaPelaId(Integer autorId) {
		Autor autor = (Autor)em.find(Autor.class, autorId);
		return autor;
	}
}