import org.apache.mina.core.buffer.IoBuffer;
import org.apache.mina.core.filterchain.IoFilter;
import org.apache.mina.core.filterchain.IoFilterAdapter;
import org.apache.mina.core.session.IoSession;

/**
 * Created by zhengchengbo on 2016/6/21.
 */
public class StringFilter  extends IoFilterAdapter{
    @Override
    public void messageReceived(NextFilter nextFilter, IoSession session, Object message) throws Exception {
        IoBuffer buffer= (IoBuffer) message;
        String tempString=new String(buffer.array(),"utf-8");
        super.messageReceived(nextFilter, session, tempString);
    }
}
