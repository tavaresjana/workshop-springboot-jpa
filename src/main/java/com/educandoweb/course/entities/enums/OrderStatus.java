package com.educandoweb.course.entities.enums;

public enum OrderStatus {
	
	WAITING_PAYMENT(1),
	PAID(2),
	SHIPPED(3),
	DELIVERED(4), 
	CANCELED(5);
	
	private int code;
	
	private OrderStatus(int code) {
		this.code = code;
	}
	
	public int getCode() {
		return code;
	}
	
	public static OrderStatus valueOf(int code) {
		//um for percorrendo todos os valores do tipo enumerado (OrderStatus)
		for(OrderStatus value : OrderStatus.values()) {
			//se o value.getCode() for igual a um dos code (1,2,3,4,5) irá retornar a msg de um dos enums, caso contrário retona msg de erro
			if(value.getCode() == code ) {
				return value;
			}
		}
		throw new IllegalArgumentException("Invalid OrderStatus code");
	}
}
