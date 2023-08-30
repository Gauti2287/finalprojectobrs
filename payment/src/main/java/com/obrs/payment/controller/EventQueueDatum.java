package com.obrs.payment.controller;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EventQueueDatum
{
    String type;   // CREDENTIAL | USERDETAIL | ORDER
    String message;
    String payload; // Actual Object Stringified to Json
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getPayload() {
		return payload;
	}
	public void setPayload(String payload) {
		this.payload = payload;
	}
}