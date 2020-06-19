package ca.mcgill.ecse321.petshelter.mapper;

import ca.mcgill.ecse321.petshelter.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface IUserMapper {

    @Select("select * from users ")
    List<User> findAll();

    @Select("select * from users where userId = #{id}")
    User findById(Integer id);

    @Select("select * from users where username = #{username}")
    List<User> findByUsername(String username);

    @Options(useGeneratedKeys = true, keyProperty = "userId", keyColumn = "userId")
    @Insert("insert into users (username, password, email) values (#{username}, #{password}, #{email})")
    int insert(User user);
}
