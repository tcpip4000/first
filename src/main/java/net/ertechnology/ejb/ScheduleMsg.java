package net.ertechnology.ejb;

import javax.ejb.Schedule;
import javax.ejb.Stateless;

@Stateless
public class ScheduleMsg {
	
	//@Schedule(second="*/10", minute="*", hour="*")
	public void printMessage() {
		System.out.println(">>> Periodic message");
	}
}
