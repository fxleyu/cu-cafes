package fx.leyu.learn.mybatis.imooc.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import fx.leyu.learn.mybatis.imooc.bean.Message;
import fx.leyu.learn.mybatis.imooc.db.DbAccess;
import fx.leyu.learn.mybatis.imooc.util.SqlUtils;

public class MessageDao {
    
    private Connection connection = SqlUtils.getDatabaseConnection();
    
    private static final String QUERY_ALL_MESSAGES  = "select id, command, description, content from message";
    
    public List<Message> queryMessageList() throws SQLException {
        List<Message> result = new LinkedList<>();
        
        PreparedStatement preStatement = connection.prepareStatement(QUERY_ALL_MESSAGES);
        ResultSet resultSet = preStatement.executeQuery();
        while (resultSet.next()) {
            Message message = new Message();
            message.setId(resultSet.getInt(1));
            message.setCommand(resultSet.getString(2));
            message.setDescription(resultSet.getString(3));
            message.setContent(resultSet.getString(4));
            result.add(message);
        }
        
        return result;
    }
    
    public List<Message> queryMessageListByMybatis() throws SQLException, IOException {
        SqlSession session = DbAccess.getSqlSession();
        return session.selectList("selectAllMessages");
    }
    
    public List<Message> queryMessageByMybatis(String command) throws SQLException, IOException {
        Message message = new Message();
        message.setCommand(command);
        SqlSession session = DbAccess.getSqlSession();
        return session.selectList("selectMessageByMessage", message);
    }
    
    public void deleteMessageByMybatis(int id) throws IOException{
        SqlSession session = DbAccess.getSqlSession();
        session.delete("deleteMessage", id);
        // 确认
        session.commit();
    }

    public void deleteMessagesByMybatis(List<Integer> list) throws IOException {
        SqlSession session = DbAccess.getSqlSession();
        session.delete("deleteMessages", list);
        // 确认
        session.commit();
    }
}
