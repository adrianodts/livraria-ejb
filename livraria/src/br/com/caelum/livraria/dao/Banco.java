package br.com.caelum.livraria.dao;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;

import br.com.caelum.livraria.modelo.Autor;
import br.com.caelum.livraria.modelo.Livro;
import br.com.caelum.livraria.modelo.Usuario;


@Singleton
@Startup
public class Banco
{
	public static List<Livro> livros = new ArrayList<>();
	public static List<Autor> autores = new ArrayList<>();
	public static List<Usuario> usuarios = new ArrayList<>();

	@PostConstruct
	void aposCriacao() {
		System.out.println("Acabou de criar o banco");
	}

	private static int chave = 1;

	static {
		inicializaBanco();
	}

	public void save(Livro livro) {
		livro.setId(Integer.valueOf(chave++));
		livros.add(livro);
	}

	public List<Livro> listaLivros() {
		return livros;
	}

	public void save(Autor autor) {
		autor.setId(Integer.valueOf(chave++));
		autores.add(autor);
	}

	public List<Autor> listaAutores() {
		return autores;
	}

	public Autor buscaPelaId(Integer autorId)
	{
		for (Autor autor : autores) {
			if (autor.getId().equals(autorId)) {
				return autor;
			}
		}
		return null;
	}

	public Usuario buscaPeloNome(String nome) {
		for (Usuario usuario : usuarios) {
			if (usuario.getLogin().equals(nome)) {
				return usuario;
			}
		}

		return null;
	}

	private static void inicializaBanco() {
		Autor silveira = new Autor(Integer.valueOf(chave++), "Paulo Silveira");
		Autor cordeiro = new Autor(Integer.valueOf(chave++), "Gilliard Cordeiro");
		Autor coelho = new Autor(Integer.valueOf(chave++), "Hébert Coelho ");

		autores.add(silveira);
		autores.add(cordeiro);
		autores.add(coelho);

		livros.add(new Livro("Java 8 prático", silveira));
		livros.add(new Livro("Lógica de Programação", silveira));

		livros.add(new Livro("CDI: Integre as dependências", cordeiro));
		livros.add(new Livro("JSF e JPA", cordeiro));

		livros.add(new Livro("JPA Efficaz", coelho));
		livros.add(new Livro("JSF Efficaz", coelho));

		usuarios.add(new Usuario("admin", "pass"));
	}
}
