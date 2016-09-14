package me.kippy.skypebot;

import com.samczsun.skype4j.Skype;
import com.samczsun.skype4j.SkypeBuilder;
import com.samczsun.skype4j.exceptions.ConnectionException;
import com.samczsun.skype4j.exceptions.InvalidCredentialsException;
import com.samczsun.skype4j.exceptions.NotParticipatingException;

public class Main {
	
	public static void main(String[] args) {
		
		Skype skype = new SkypeBuilder(Utilities.username, Utilities.password).withAllResources().build();
		
		try {
			skype.login();
		} catch (NotParticipatingException e) {
			e.printStackTrace();
		} catch (InvalidCredentialsException e) {
			e.printStackTrace();
		} catch (ConnectionException e) {
			e.printStackTrace();
		}
		
		try {
			skype.subscribe();
		} catch (ConnectionException e) {
			e.printStackTrace();
		}
		
		registerEvents(skype);
		
		System.out.println("Logged in!");
		
	}
	
	public static void registerEvents(Skype skype) {
		
		skype.getEventDispatcher().registerListener(new UserChat());
	}

}
