import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.nio.channels.AsynchronousSocketChannel;
import java.util.concurrent.ExecutionException;

public class Server_Socket {
	public void getServerTwo(){
		try {
			AsynchronousServerSocketChannel server=AsynchronousServerSocketChannel.open();
			server.bind(new InetSocketAddress(8082));
			while(true){
				AsynchronousSocketChannel channel=server.accept().get();
				new ClientSocket(channel);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
