package br.com.caelum.livraria.dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import br.com.caelum.livraria.modelo.Usuario;

@Stateless
public class UsuarioDao
{
	@PersistenceContext
	private EntityManager em;

	public Usuario buscaPeloLogin(String login) throws Exception
	{
		Usuario usuario = null;
		try {
			usuario = (Usuario)em
				.createQuery("select u from Usuario u where u.login=:pLogin")
				.setParameter("pLogin", login).getSingleResult();
		}
		catch (NoResultException exception) {
			throw new Exception("Usuário não encontrado");
		}
		return usuario;
	}
}
