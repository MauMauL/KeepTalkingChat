package chat;

import java.rmi.*;
import java.rmi.server.UnicastRemoteObject;
import java.util.*;
 
public class Server  extends UnicastRemoteObject implements IServer
{
	private static final long serialVersionUID = 3172230332137305316L;
	private Vector v = new Vector();	

	public Server() throws RemoteException
	{
		
	}
	
	public boolean login(IClient ic) throws RemoteException
	{	
		System.out.println(ic.getName() + "  got connected....");	
		ic.tell("You have Connected successfully.");
		publish(ic.getName()+ " has just connected.");
		v.add(ic);
		return true;		
	}
	
	public void publish(String s) throws RemoteException{
	    System.out.println(s);
		for(int i=0;i<v.size();i++){
		    try{
		    	IClient tmp = (IClient)v.get(i);
			tmp.tell(s);
		    }catch(Exception e){
		    	//problem with the client not connected.
		    	//Better to remove it
		    }
		}
	}
 
	public Vector getConnected() throws RemoteException{
		return v;
	}
}