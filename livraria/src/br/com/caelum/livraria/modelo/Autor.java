package br.com.caelum.livraria.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Autor
{
	@Id
	@GeneratedValue(strategy=javax.persistence.GenerationType.IDENTITY)
	private Integer id;
	private String nome;

	public Autor() {}

	public Autor(Integer id, String nome)
	{
		this.id = id;
		this.nome = nome;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
}