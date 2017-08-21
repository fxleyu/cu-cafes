package fx.leyu.learn.mybatis.imooc.service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

import fx.leyu.learn.mybatis.imooc.bean.Message;
import fx.leyu.learn.mybatis.imooc.dao.MessageDao;

public class MessageService {
    
    @SuppressWarnings("unchecked")
    public List<Message> queryAllMessages() {
        try {
            return new MessageDao().queryMessageList();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return Collections.EMPTY_LIST;
    }
    
    public List<Message> queryAllMessagesByMybatis() {
        try {
            return new MessageDao().queryMessageListByMybatis();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return Collections.EMPTY_LIST;
    }
    
    public List<Message> queryMessageByMybatis(String command) {
        try {
            return new MessageDao().queryMessageByMybatis(command);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return Collections.EMPTY_LIST;
    }
    
    public void deleteMessageByMybatis(int id) {
        try {
            new MessageDao().deleteMessageByMybatis(id);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void deleteMessagesByMybatis(List<Integer> list) {
        try {
            new MessageDao().deleteMessagesByMybatis(list);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
