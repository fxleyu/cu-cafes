package fx.leyu.learn.mybatis.imooc.db;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class DbAccess {
    
    public static SqlSession getSqlSession() throws IOException {
        // 通过配置信息获取数据库链接信息
        Reader reader = Resources.getResourceAsReader("fx/leyu/learn/mybatis/imooc/config/CustomizedSettingsMapperConfig.xml");
        // 通过配置信息构建一个SqlSessionFactory
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(reader);
        // 通过SqlSessionFactory打开一个数据库会话
        return factory.openSession();    
    }
}
