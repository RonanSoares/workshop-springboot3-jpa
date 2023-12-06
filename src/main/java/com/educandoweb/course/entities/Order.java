package com.educandoweb.course.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity										//Anotações JPA. trafegar objeto /BD relacional
@Table(name = "tb_order")					//Para o nome da tb Order não entrar em conflito com a palavra reservada order do SQL
public class Order implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id														
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	// Anotação para garantir que o instant seja mostrado no json no formato de String no ISO 8601.
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
	private Instant moment;
	
	@ManyToOne												// Anotação Muitos p Um. Chave estrangeira. 
	@JoinColumn(name = "client_id")							// Anotaçao para dar nome a chave estrangeira.
	private User client;                                    // Associação com o Usuário(cliente)
	
	public Order() {										// Construtor padrão
	}

	public Order(Long id, Instant moment, User client) {    // Construtor com argumentos.
		super();
		this.id = id;
		this.moment = moment;
		this.client = client;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Instant getMoment() {
		return moment;
	}

	public void setMoment(Instant moment) {
		this.moment = moment;
	}

	public User getClient() {
		return client;
	}

	public void setClient(User client) {
		this.client = client;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		return Objects.equals(id, other.id);
	}
	
	
	

}
