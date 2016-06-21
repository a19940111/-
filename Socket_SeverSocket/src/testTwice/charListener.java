package testTwice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.Socket;

public class charListener extends Thread {
	Socket socket=new Socket();
	public charListener(Socket socket){
		this.socket=socket;
	}
	@Override
	public void run() {
		try {
			BufferedReader br=new BufferedReader(
					new InputStreamReader(
							socket.getInputStream(),"GBK"));
			String line=null;
			while((line=br.readLine())!=null){
				charListenerManager.getManager().publish(this, line);
			}
			br.close();		
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}
	public void out(String out){
		try {
			socket.getOutputStream().write(out.getBytes("GBK"));
			
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
