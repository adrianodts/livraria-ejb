package br.com.caelum.livraria.interceptador;

import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

public class LogInterceptador {
	
	@AroundInvoke
	public Object intercepta(InvocationContext context) throws Exception {
		long millis = System.currentTimeMillis();

		Object o = context.proceed();

		String classe = context.getTarget().getClass().getSimpleName();
		String metodo = context.getMethod().getName();

		System.out.printf("#{%s.%s()}%n", new Object[] { classe, metodo });
		System.out.println("Tempo gasto: " + (System.currentTimeMillis() - millis));

		return o;
	}
}