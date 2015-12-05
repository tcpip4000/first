package net.ertechnology.ejb;

import javax.ejb.Stateless;
import javax.enterprise.event.Observes;

import net.ertechnology.entity.WebOrder;

@Stateless
public class SendSms {
	
	public void SendData(@Observes WebOrder weborder) {
		System.out.println("Sending sms message...");
	}
}
