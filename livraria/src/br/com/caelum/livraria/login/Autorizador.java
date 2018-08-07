package br.com.caelum.livraria.login;

import javax.el.ELResolver;
import javax.faces.application.NavigationHandler;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

public class Autorizador implements PhaseListener
{
	private static final long serialVersionUID = 1L;

	public void afterPhase(PhaseEvent event)
	{
		FacesContext context = event.getFacesContext();

		if ("/login.xhtml".equals(context.getViewRoot().getViewId())) {
			return;
		}

		javax.el.ELContext elContext = context.getELContext();
		ELResolver elResolver = context.getApplication().getELResolver();
		UsuarioLogadoBean usuarioLogado = (UsuarioLogadoBean)elResolver.getValue(elContext, null, "usuarioLogadoBean");


		if (!usuarioLogado.isLogado())
		{
			NavigationHandler handler = context.getApplication()
					.getNavigationHandler();
			handler.handleNavigation(context, null, "login?faces-redirect=true");


			context.renderResponse();
		}
	}


	public void beforePhase(PhaseEvent event) {}


	public PhaseId getPhaseId()
	{
		return PhaseId.RESTORE_VIEW;
	}
}