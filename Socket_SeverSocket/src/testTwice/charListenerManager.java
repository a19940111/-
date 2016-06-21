package testTwice;

import java.util.Vector;

public class charListenerManager {
	private charListenerManager(){
		
	}
	private static final charListenerManager cm=new charListenerManager();
	public static  charListenerManager getManager(){
		return cm;
	}
	Vector<charListener> vector=new Vector<charListener>();
	public void addCharListener(charListener listener){
		vector.add(listener);
	}
	public void publish(charListener listener,String line){
		for(int i=0;i<vector.size();i++){
			charListener temp=vector.get(i);
			if(!listener.equals(temp)){
				temp.out(line);
			}
		}
	}
}
