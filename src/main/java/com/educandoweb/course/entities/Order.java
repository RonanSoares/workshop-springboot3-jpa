package com.educandoweb.course.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

import com.educandoweb.course.entities.enums.OrderStatus;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity                    //Anotações JPA. trafegar objeto /BD relacional
@Table(name = "tb_order")  //Para o nome da tb Order não entrar em conflito com a palavra reservada order do SQL
public class Order implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)  
	private Long id;
	
	private Instant moment;
	// Macete para controlar os códigos do OrderStatus (Muda o tipo de OrderStatus para Integer)
	private Integer orderStatus;  

	@ManyToOne                             // Anotação Muitos p Um. Chave estrangeira.
	@JoinColumn(name = "client_id")        // Anotaçao para dar nome a chave estrangeira.
	private User client;                   // Associação com o Usuário(cliente)

	@OneToMany(mappedBy = "id.order")
	private Set<OrderItem> items = new HashSet<>();
	
	@OneToOne(mappedBy = "order", cascade = CascadeType.ALL)   // Mapea as duas entidades para ter o mesmo id.
	private Payment payment;               // Associação com classe Payment
	
	public Order() {
	}

	public Order(Long id, Instant moment, OrderStatus orderStatus, User client) {
		super();
		this.id = id;
		this.moment = moment;
		this.client = client;
		setOrderStatus(orderStatus);    // Chama a operação orderStatus
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

	public OrderStatus getOrderStatus() {
		return OrderStatus.valueOf(orderStatus);         // Pega o nr inteiro da classe e converte para orderStatus
	}

	public void setOrderStatus(OrderStatus orderStatus) { // Recebe um valor OrderStatus
		if (orderStatus != null) {
			this.orderStatus = orderStatus.getCode();     // Converte o valor OrderStatus para integer.
		}
	}
	
	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}
	
	// Método get do items. Criado manualmente. O Pedido agora conhece os seus items.
	public Set<OrderItem> getItems() {
		return items;
	}
	
	// Método para calcular o total do pedido. Q é a soma dos subTotais.
	public Double getTotal() {     // Para aparecer no Json subtotal, tem q colocar "get" getTotal
		double sum = 0.0;
		for (OrderItem x : items) {
			sum += x.getSubTotal();
		}
		return sum;
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
		Order other = (Order) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
