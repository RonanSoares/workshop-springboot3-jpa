package com.educandoweb.course.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity                    // Anotação para instruir o jpa a transformar o modelo objeto para relacional.
@Table(name = "tb_user")   // Especifica o nome da tabela no BD como tb_user, para não entrar em conflito
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id                                                  // Especifica o Id como chave primária.
	@GeneratedValue(strategy = GenerationType.IDENTITY)  // Para que o Id seja auto-incrementado.
	private Long id;
	private String name;
	private String email;
	private String phone;
	private String password;

	@JsonIgnore                                       // Para corrigir um erro de loop entre user e order
	@OneToMany(mappedBy = "client")                   // Um para muitos, mapeado com o client
	private List<Order> orders = new ArrayList<>();   // Associação com o pedido e já instancia. Cria só get
	
	public User() {
	}

	public User(Long id, String name, String email, String phone, String password) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.password = password;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	// Cria só o método get da lista. Pois a lista não pode ser trocada. Apenas add e remove elementos.
	public List<Order> getOrders() {
		return orders;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
