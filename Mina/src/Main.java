import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.filter.codec.textline.TextLineCodecFactory;
import org.apache.mina.filter.statistic.ProfilerTimerFilter;
import org.apache.mina.transport.socket.nio.NioSocketAcceptor;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.logging.SocketHandler;

/**
 * Created by zhengchengbo on 2016/6/21.
 */
public class Main {
    public static void main(String[] args) {
        NioSocketAcceptor acceptor=new NioSocketAcceptor();
        acceptor.getFilterChain().addLast("lastCodecFilter",new ProtocolCodecFilter(new TextLineCodecFactory()));
        acceptor.setHandler(new SocketHandlerOne());
        try {
            acceptor.bind(new InetSocketAddress(8083));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
