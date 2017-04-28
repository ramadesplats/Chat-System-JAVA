package jUnitTest;

import java.net.InetAddress;

import controller.Controller;
import gui.Window;
import model.Contact;
import model.Message;

public interface ControllerAdapterInterface {
	
	void setUserLocal(Contact userLocal);
	void initComponents();
	void connection();
	void disconnection();
	
	Boolean isConnected();
	Boolean isDisconnected();
	void setStatus(Boolean connected);
	
	int getTimerCheckDelay();

	void modelAddContact(Contact userRemote);
	Boolean findRemoteUserFromModel(Contact userRemote);
	boolean isEmptyUserRemoteList();

	void userRemoteActionTimerHasExpired(Contact userRemote);

	void receiveMessage(Message message, InetAddress ip);

	void cleanUpEnvironment();

	public Controller getController();	
	public Window getVue();
	
}
