package br.com.caelum.livraria.login;

import br.com.caelum.livraria.bean.MenuBean;
import br.com.caelum.livraria.dao.UsuarioDao;
import br.com.caelum.livraria.modelo.Usuario;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;


@Named
@RequestScoped
public class LoginBean
{
	private Usuario usuario = new Usuario();
	
	@Inject
	UsuarioDao dao;
	
	@Inject
	UsuarioLogadoBean usuarioLogado;
	
	@Inject
	MenuBean menu;

	public Usuario getUsuario()
	{
		return usuario;
	}

	public String efetuaLogin()
	{
		Usuario usuarioEncontrado = null;
		try {
			usuarioEncontrado = dao.buscaPeloLogin(usuario.getLogin());

			if ((usuarioEncontrado != null) && (possuiMesmaSenha(usuarioEncontrado))) {
				usuarioLogado.logar(usuarioEncontrado);
				return menu.paginaLivros();
			}

			criaMensagem("Usuário não encontrado!");
			limparForm();
		}
		catch (Exception e)
		{
			criaMensagem(e.getMessage());
		}
		return "";
	}

	public String efetuaLogout() {
		usuarioLogado.deslogar();
		return menu.paginaLogin();
	}

	private void limparForm()
	{
		usuario = new Usuario();
	}

	private void criaMensagem(String mensagem) {
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, mensagem, ""));
	}

	private boolean possuiMesmaSenha(Usuario usuarioEncontrado) {
		return usuarioEncontrado.getSenha().equals(usuario.getSenha());
	}
}
