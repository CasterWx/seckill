package com.seckill.mapper;

import com.seckill.param.Person;
import java.util.List;

/**
 * @author CasterWx  AntzUhl
 * @site https://github.com/CasterWx
 * @company Henu
 * @create 2019-04-21-16:40
 */
public interface PersonMapper {
    public Person querypersonbyid(int id);
    public List<Person> querypersonbyname(String name);
    public void insertpersonperson(Person person);
    public void deletebyid(int id);
    public void updatebyperson(Person person);
}
