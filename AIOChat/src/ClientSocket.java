import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;

public class ClientSocket {
	ByteBuffer buffer=ByteBuffer.allocate(1024);
	public ClientSocket(AsynchronousSocketChannel channel){
		channel.read(buffer, channel,new CompletionHandler<Integer, AsynchronousSocketChannel>() {

			@Override
			public void completed(Integer result, AsynchronousSocketChannel attachment) {
				if(result==-1){
					System.out.println("读取完毕");
					
				}else{
					buffer.flip();
					try {
						String tempString=new String(buffer.array(),0,buffer.remaining(),"gbk");
						
						if(tempString.trim().equals("quit")){
							attachment.close();
						}
						System.out.println(tempString.trim());
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					buffer.clear();
					channel.read(buffer,attachment,this);
				}
				
			}

			@Override
			public void failed(Throwable exc, AsynchronousSocketChannel attachment) {
				// TODO Auto-generated method stub
				
			}
		});

			
	}
}
