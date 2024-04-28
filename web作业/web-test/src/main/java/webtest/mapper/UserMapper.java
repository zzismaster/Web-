package webtest.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import webtest.entity.User;

@Mapper
public interface UserMapper {

    @Select("select count(*) from  uselogin where username = #{username} and password = #{password}")
    public int selectLogin(String username, String password);

    @Insert("insert into uselogin(username,password)"+"values (#{username},#{password})")
    public int insertUser(String username, String password);
}
