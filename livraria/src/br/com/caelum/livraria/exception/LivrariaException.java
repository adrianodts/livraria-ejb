package br.com.caelum.livraria.exception;

import javax.ejb.ApplicationException;

@ApplicationException(rollback=true)
public class LivrariaException extends RuntimeException
{
	private static final long serialVersionUID = -5831239369770405973L;
}