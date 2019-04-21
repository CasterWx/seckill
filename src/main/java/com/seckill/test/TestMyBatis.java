package com.seckill.test;

import com.seckill.param.Person;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author CasterWx  AntzUhl
 * @site https://github.com/CasterWx
 * @company Henu
 * @create 2019-04-21-15:48
 */
public class TestMyBatis {

    public SqlSessionFactory getFactory() throws IOException {
        String filepath = "SqlMappingConfig.xml" ;
        InputStream in = Resources.getResourceAsStream(filepath);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in) ;
        return sqlSessionFactory ;
    }

    @Test
    public void testInsert() throws IOException {
        Person person = new Person() ;
        person.setName("清水2");
        person.setAddress("开封");
        person.setAge(21);
        person.setBirthday("2018-05-21-20:21");
        SqlSessionFactory factory = getFactory() ;
        SqlSession sqlSession = factory.openSession() ;
        sqlSession.insert("test1.insertpersonperson",person) ;
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testQueryId() throws IOException {
        SqlSession sqlSession = getFactory().openSession() ;
        Person person = sqlSession.selectOne("test1.querypersonbyid",1);
        System.out.println(person);
        sqlSession.close();
    }

    @Test
    public void testQueryName() throws IOException {
        SqlSession sqlSession = getFactory().openSession() ;
        List<Person> personList = sqlSession.selectList("test1.querypersonbyname","青");
        for(Person person : personList){
            System.out.println(person);
        }
        sqlSession.close();
    }

    @Test
    public void testDeleteId() throws IOException {
        SqlSession sqlSession = getFactory().openSession() ;
        sqlSession.delete("test1.deletebyid",1);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testUpdateId() throws IOException {
        SqlSession sqlSession = getFactory().openSession() ;
        Person person = new Person() ;
        person.setId(2);
        person.setName("清水");
        person.setAddress("开封");
        person.setAge(21);
        person.setBirthday("2018-05-21-20:21");
        sqlSession.update("test1.updatebyperson",person);
        sqlSession.commit();
        sqlSession.close();
    }

}
