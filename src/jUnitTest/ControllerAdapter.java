package jUnitTest;

import gui.Window;

import java.io.File;
import java.net.InetAddress;

import model.Contact;
import model.Message;
import controller.Controller;

public class ControllerAdapter implements ControllerAdapterInterface {
	
	private Controller controller;
	private Window vue;
	
	
	public ControllerAdapter(){
		this.vue = new Window();
		this.controller = null;
	}
	
	@Override
	public void setUserLocal(Contact userLocal) {
		this.vue.getUsernameContent().setText(userLocal.getUsername());
	}
	
	@Override
	public void initComponents() {
		this.controller = new Controller("Test",this.vue);
	}
	
	@Override
	public void connection() {
		this.controller.sayHello();
	}

	@Override
	public void disconnection() {
	  this.controller.udps.sendBye(this.controller.modele.getLocalUser().getUsername(), "All");
  	  this.controller.cleanUI();
  	  this.controller.modele.getRemoteUsers().clear();
  	  this.vue.setUIDisconnected();
  	  File dir = new File(System.getProperty("user.dir"));
  	  for(File file: dir.listFiles()){ 
  		    if (!file.isDirectory()) {
  		    	if(!file.getName().contains("tmp")){
  		    		file.delete();
  		    	}
  		    }
  	  }
  	  this.controller.modele.getLocalUser().setState(Contact.State.DISCONNECTED);
  	  this.controller.timer_check.stop();
  	  this.controller.udps.closeSocket();
  	  this.controller.udpr.closeSocket();
  	  this.controller.udpr.interruption();
  	  Thread.currentThread().interrupt();
	}
	
	@Override
	public Boolean isConnected(){
		Contact.State s = this.controller.modele.getLocalUser().getState();
		return s == Contact.State.CONNECTED;
	}
	
	@Override
	public Boolean isDisconnected(){
		Contact.State s = this.controller.modele.getLocalUser().getState();
		return s == Contact.State.DISCONNECTED;
	}
	
	
	@Override
	public void setStatus(Boolean connected){
		if (connected){
			this.controller.modele.getLocalUser().setState(Contact.State.CONNECTED);
		}else{
			this.controller.modele.getLocalUser().setState(Contact.State.DISCONNECTED);
		}
	}

	@Override
	public int getTimerCheckDelay() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void modelAddContact(Contact userRemote) {
		this.controller.modele.addRemoteUser(userRemote);
	}

	@Override
	public Boolean findRemoteUserFromModel(Contact userRemote) {
		Contact mcr = this.controller.modele.checkRemoteUserName(userRemote.getUsername());
		System.out.println("[CA]: "+this.controller.modele.getRemoteUsers().toString());
		return mcr!=null;
	}

	@Override
	public boolean isEmptyUserRemoteList() {
		return this.controller.modele.getRemoteUsers().isEmpty();
	}

	@Override
	public void userRemoteActionTimerHasExpired(Contact userRemote) {
		this.controller.aTimerHasExpired(userRemote.getUsername());
	}

	@Override
	public void receiveMessage(Message message, InetAddress ip) {
		this.controller.aMessageHasBeenReceived(ip);
		System.out.println("[CA]"+ip.toString() + " : " + message.toString());
	}
	
	@Override
	public void cleanUpEnvironment() {

	}
	
	public Controller getController(){
		return this.controller;
	}
	
	public Window getVue(){
		return this.vue;
	}

}
