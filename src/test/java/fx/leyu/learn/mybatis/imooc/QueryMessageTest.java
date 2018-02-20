package fx.leyu.learn.mybatis.imooc;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

import fx.leyu.learn.mybatis.imooc.bean.Message;
import fx.leyu.learn.mybatis.imooc.service.MessageService;

public class QueryMessageTest {

    @Test
    public void test() {
        List<Message> messages = new MessageService().queryAllMessages();
        for (Message message : messages ) {
            System.out.println(message);
        }
    }
    
    @Test
    public void testMybatis() {
        List<Message> messages = new MessageService().queryAllMessagesByMybatis();
        for (Message message : messages ) {
            System.out.println(message);
        }
    }
    
    @Test
    public void testMybatiss() {
        List<Message> messages = new MessageService().queryMessageByMybatis("笑话");
        for (Message message : messages ) {
            System.out.println(message);
        }
    }
    
    @Test
    public void testDeleteMessageByMybatis() {
        new MessageService().deleteMessageByMybatis(1);
    }
    
    @Test
    public void testDeleteMessagesByMybatis() {
        List<Integer> list = Arrays.asList(new Integer[]{2,3});
        new MessageService().deleteMessagesByMybatis(list);
    }

}
