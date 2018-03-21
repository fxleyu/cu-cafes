package fx.leyu.project.jdata2017.acquisition;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import fx.leyu.project.jdata2017.domain.Action;
import fx.leyu.project.jdata2017.domain.Comment;
import fx.leyu.project.jdata2017.domain.Product;
import fx.leyu.project.jdata2017.domain.User;
import fx.leyu.project.jdata2017.domain.mapper.ProductMapper;
import fx.leyu.project.jdata2017.domain.mapper.UserMapper;

public class Main {

    public static void main(String[] args) throws IOException {
        String resource = "fx/leyu/jdata/builder/MapperConfig.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        
        System.out.println("START");
        // INSERT the User
        //insertUser(sqlSession);
        // INSERT the Product
        //insertProduct(sqlSession);
        // INSERT the comment
        //insertComment(sqlSession);
        // INSERT the action
        insertAction(sqlSession, "data/JData_Action_201602/JData_Action_201602.csv");
        insertAction(sqlSession, "data/JData_Action_201603/JData_Action_201603_extra.csv");
        insertAction(sqlSession, "data/JData_Action_201603/JData_Action_201603.csv");
        insertAction(sqlSession, "data/JData_Action_201604/JData_Action_201604.csv");
        
        sqlSession.close();
        System.out.println("Game Over!");
    }
    
    public static void insertAction(SqlSession sqlSession, String path) throws FileNotFoundException {
        Scanner scanner = new Scanner(new FileInputStream(path));
        
        int i = 0;
        System.out.println(scanner.nextLine());
        while (scanner.hasNextLine()) {
            String string = scanner.nextLine();
            String[] strs = string.split(",");
            sqlSession.insert("fx.leyu.jdata.domain.mapper.ActionMapper.insertAction", new Action(strs));
            i++;
            if (i % 5000 == 0) {
                System.out.println("have completed the  " + i);
                sqlSession.commit();
            }
        }
        sqlSession.commit();
        
        scanner.close();
    }
    
    public static void insertComment(SqlSession sqlSession) throws FileNotFoundException {
        Scanner scanner = new Scanner(new FileInputStream("data/JData_Comment/JData_Comment.csv"));
        
        int i = 0;
        System.out.println(scanner.nextLine());
        while (scanner.hasNextLine()) {
            String string = scanner.nextLine();
            String[] strs = string.split(",");
            sqlSession.insert("fx.leyu.jdata.domain.mapper.CommentMapper.insertComment", new Comment(strs));
            i++;
            if (i % 5000 == 0) {
                System.out.println("have completed the  " + i);
                sqlSession.commit();
            }
        }
        sqlSession.commit();
        
        scanner.close();
    }

    public static void insertUser(SqlSession sqlSession) throws FileNotFoundException {
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        Scanner scanner = new Scanner(new FileInputStream("data/JData_User/JData_User.csv"), "gbk");
        
        int i = 0;
        System.out.println(scanner.nextLine());
        while (scanner.hasNextLine()) {
            String string = scanner.nextLine();
            String[] strs = string.split(",");
            userMapper.insertUser(new User(strs));
            i++;
            if (i % 5000 == 0) {
                System.out.println("have completed the  " + i);
                sqlSession.commit();
            }
        }
        sqlSession.commit();
        
        scanner.close();
    }
    
    public static void insertProduct(SqlSession sqlSession) throws FileNotFoundException {
        ProductMapper productMapper = sqlSession.getMapper(ProductMapper.class);
        Scanner scanner = new Scanner(new FileInputStream("data/JData_Product/JData_Product.csv"), "gbk");
        
        int i = 0;
        System.out.println(scanner.nextLine());
        while (scanner.hasNextLine()) {
            String string = scanner.nextLine();
            String[] strs = string.split(",");
            productMapper.insertProduct(new Product(strs));
            i++;
            if (i % 5000 == 0) {
                System.out.println("have completed the  " + i);
                sqlSession.commit();
            }
        }
        sqlSession.commit();
        
        scanner.close();
    }

}
