package com.educandoweb.course.entities;

import java.io.Serializable;
import java.util.Objects;

import com.educandoweb.course.entities.pk.OrderItemPK;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_order_item")
public class OrderItem implements Serializable{	
	
	private static final long serialVersionUID = 1L;
	
	@EmbeddedId                                  // No caso de chave composta a anotação é EmbeddedId
	private OrderItemPK id = new OrderItemPK();  // Atributo identificador correspondente a chave primária. Chaves compostas tem que instanciar
	private Integer quantity;
	private Double price;
	
	public OrderItem() {		
	}
	
	// Construtor o id não entra. É acrescentado manualmente o Order e Product
	public OrderItem(Order order, Product product, Integer quantity, Double price) {
		super();
		id.setOrder(order);      // Atribui o Order nesse Item de pedido(OrderItem)
		id.setProduct(product);  // Atribui o Product nesse Item de pedido(OrderItem)
		this.quantity = quantity;
		this.price = price;
	}
	
	// Cria manualmente o Get Order
	@JsonIgnore                // Para resolver a questão de mão dupla entre Pedido x Items de pedido
	public Order getOrder() {
		return id.getOrder();
	}
	
	// Cria manualmente o Set Order
	public void setOrder(Order order) {
		id.setOrder(order);
	}
	
	// Cria manualmente o Get Product
	public void getProduct(Product product) {
		id.setProduct(product);
	}
		
	// Cria manualmente o Set Product
	public void setProduct(Product product) {
		id.setProduct(product);
	}
		
	
	// Métodos Get e Set, id também não entra
	public Integer getQuantity() {
		return quantity;
	}
	
	

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}
	
	// Métodos HasCode e Equals. Apenas o id que identifica o OrderItem
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
		OrderItem other = (OrderItem) obj;
		return Objects.equals(id, other.id);
	}
	
	
	
}
