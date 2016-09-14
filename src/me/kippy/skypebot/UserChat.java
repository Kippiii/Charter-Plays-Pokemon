package me.kippy.skypebot;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import com.samczsun.skype4j.events.EventHandler;
import com.samczsun.skype4j.events.Listener;
import com.samczsun.skype4j.events.chat.message.MessageReceivedEvent;
import com.samczsun.skype4j.exceptions.ConnectionException;

public class UserChat implements Listener {
	
	@EventHandler
	public void onChat(MessageReceivedEvent e) {
		
		Robot r = null;
		try {
			r = new Robot();
		} catch (AWTException e1) {
			e1.printStackTrace();
		}
		
		if(e.getMessage().getContent().asPlaintext().equalsIgnoreCase("left") 
				|| e.getMessage().getContent().asPlaintext().equalsIgnoreCase("a")) {
			
			r.keyPress(KeyEvent.VK_LEFT);
			r.delay(100);
			r.keyRelease(KeyEvent.VK_LEFT);
			
		}else if(e.getMessage().getContent().asPlaintext().equalsIgnoreCase("right") 
				|| e.getMessage().getContent().asPlaintext().equalsIgnoreCase("d")) {
			
			r.keyPress(KeyEvent.VK_RIGHT);
			r.delay(100);
			r.keyRelease(KeyEvent.VK_RIGHT);
			
			
		}else if(e.getMessage().getContent().asPlaintext().equalsIgnoreCase("up") || e.getMessage().getContent().asPlaintext().equalsIgnoreCase("w")) {
			
			r.keyPress(KeyEvent.VK_UP);
			r.delay(100);
			r.keyRelease(KeyEvent.VK_UP);
			
		}else if(e.getMessage().getContent().asPlaintext().equalsIgnoreCase("down") || e.getMessage().getContent().asPlaintext().equalsIgnoreCase("s")) {
			
			r.keyPress(KeyEvent.VK_DOWN);
			r.delay(100);
			r.keyRelease(KeyEvent.VK_DOWN);
		
		}else if(e.getMessage().getContent().asPlaintext().equalsIgnoreCase("z") || e.getMessage().getContent().asPlaintext().equalsIgnoreCase("menu")) {
			
			r.keyPress(KeyEvent.VK_ENTER);
			r.delay(100);
			r.keyRelease(KeyEvent.VK_ENTER);
			
		}else if(e.getMessage().getContent().asPlaintext().equalsIgnoreCase("x") || e.getMessage().getContent().asPlaintext().equalsIgnoreCase("interact")) {
			
			r.keyPress(KeyEvent.VK_S);
			r.delay(100);
			r.keyRelease(KeyEvent.VK_S);
			
		}else{
			
			try {
				e.getChat().sendMessage("I don't understand!");
			} catch (ConnectionException e1) {
				e1.printStackTrace();
			}
			
		}
		
		System.out.println(e.getMessage().getContent());
		
	}

}
