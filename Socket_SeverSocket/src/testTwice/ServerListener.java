package testTwice;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerListener  extends Thread {

	@Override
	public void run() {
		super.run();
		try {
			ServerSocket server=new ServerSocket(12323);
			while(true){
				Socket socket=server.accept();
				charListener  listener=new charListener(socket);
				listener.start();
				charListenerManager.getManager().addCharListener(listener);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
