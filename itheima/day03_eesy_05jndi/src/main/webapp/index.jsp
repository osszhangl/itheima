<%@ page import="java.io.InputStream" %>
<%@ page import="org.apache.ibatis.io.Resources" %>
<%@ page import="org.apache.ibatis.session.SqlSessionFactoryBuilder" %>
<%@ page import="org.apache.ibatis.session.SqlSessionFactory" %>
<%@ page import="org.apache.ibatis.session.SqlSession" %>
<%@ page import="com.itheima.dao.IUserDao" %>
<%@ page import="com.itheima.domain.User" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<html>
<body>
<h2>Hello Mr.Lin World!</h2>
<%
    InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");

    SqlSessionFactoryBuilder builder =new SqlSessionFactoryBuilder();
    SqlSessionFactory factory=builder.build(in);
    SqlSession sqlSession=factory.openSession();
    IUserDao userdao=sqlSession.getMapper(IUserDao.class);
    List<User> users = userdao.findAll();
    for (User user:users ){
        System.out.println(user);
    }
    sqlSession.close();
    in.close();
%>

</body>
</html>
