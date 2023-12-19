package com.educandoweb.course.entities.enums;

public enum OrderStatus {

	WAITING_PAYMENT(1), //Acrescentado os códigos manualmente, para que a ordem não seja modificada.
	PAID(2),
	SHIPPED(3),
	DELIVERED(4),
	CANCELED(5);

	private int code;                // Variável code para receber o código.
	
	// Método público para acessar o code
	private OrderStatus(int code) {  // Construtor.
		this.code = code;
	}

	public int getCode() {
		return code;
	}
	
	// Método estático para converter um valor numérico para enumerado. Estático não precisa instanciar
	public static OrderStatus valueOf(int code) {
		for (OrderStatus value : OrderStatus.values()) {   /// Percorre o OrderStatus e compara com o code
			if (value.getCode() == code) {
				return value;
			}
		}
		throw new IllegalArgumentException("Invalid OrderStatus code");
	}
}
