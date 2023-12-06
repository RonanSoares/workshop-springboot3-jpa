package com.educandoweb.course.entities.enums;

public enum OrderStatus {
	
	AGUARDANDO_PAGAMENTO(1),         //Acrescentado os códigos manualmente, para que a ordem não seja modificada.
	PAGO(2),
	ENVIADO(3),
	ENTREGUE(4),
	CANCELADO(5);
	
	private int code;                // Variável code para receber o código.
	
	private OrderStatus(int code){   // Construtor.
		this.code = code;
	}
	
	// Método público para acessar o code
	public int getCode() {
		return code;
	}
	
	// Método estático para converter um valor numérico para enumerado. Estático não precisa instanciar
	public static OrderStatus valueOf(int code) {
		for(OrderStatus value : OrderStatus.values()) {   // Percorre o OrderStatus e compara com o code
			if(value.getCode() == code) {
				return value;
			}
		}
		throw new IllegalArgumentException("Código do StatusPedido inválido!!");
	}
}
