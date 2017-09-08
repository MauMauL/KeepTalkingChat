package chat;

import java.rmi.*;
import java.util.*;

public interface IClient {
	
	public void tell (String name)throws RemoteException ;
	public String getName()throws RemoteException ;

}
