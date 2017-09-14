package chat;
import java.rmi.*;
import java.rmi.server.*;

import javax.swing.JOptionPane;
 
public class StartServer {
	public static void main(String[] args) {
		try {
		 		
			String ip = JOptionPane.showInputDialog("Digite o IP: ");
			String port = JOptionPane.showInputDialog("\nDigite a porta: ");
		 	
			 	java.rmi.registry.LocateRegistry.createRegistry(Integer.parseInt(port));
			 	
			 	IServer server = new Server();			 				 				
			 	
				Naming.rebind("rmi://" + ip + ":" + port + "/chat", server);
				System.out.println("[Sistema] O servidor de chat esta utilizando o ip => " + ip + " na porta => " + port);
				
			}catch (Exception e) {
					System.out.println("Houve uma falha! " + e);
			}
	}
}