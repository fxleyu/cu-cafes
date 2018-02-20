package fx.leyu.learn.mybatis.imooc.dao;

import java.util.List;

import fx.leyu.learn.mybatis.imooc.bean.Message;

public interface MessageInterface {
    List<Message> selectMessageByMybatis(Message message);
}
