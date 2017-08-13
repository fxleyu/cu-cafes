package fx.leyu.project.jdata2017.domain.mapper;

import java.util.List;

import fx.leyu.project.jdata2017.domain.User;

public interface UserMapper {
    int insertUser(User user);
    List<User> getAllUsers();
}
