import org.apache.mina.core.buffer.IoBuffer;
        import org.apache.mina.core.service.IoHandlerAdapter;
        import org.apache.mina.core.session.IoSession;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhengchengbo on 2016/6/21.
 */
public class SocketHandlerOne extends IoHandlerAdapter {
    List<IoSession> list=new ArrayList<>();
    @Override
    public void sessionCreated(IoSession session) throws Exception {
        super.sessionCreated(session);
        System.out.println("我已经创建");
        list.add(session);
    }

    @Override
    public void messageSent(IoSession session, Object message) throws Exception {
        super.messageSent(session, message);
    }

    @Override
    public void messageReceived(IoSession session, Object message) throws Exception {
        super.messageReceived(session, message);
        String tempString= (String) message;
        if(tempString.trim().equals("quit")){
            session.close(true);
        }else{
            for(IoSession session1:list){
                session1.write(tempString);
            }
        }

    }

    @Override
    public void sessionClosed(IoSession session) throws Exception {
        super.sessionClosed(session);
        System.out.println("我已经关闭");
        list.remove(session);
    }
}
