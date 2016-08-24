package cn.zw.dao;

import cn.zw.entity.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Administrator
 * on 2016/5/30
 * 17:32.
 */
public interface StudentDao {

    int insert(Student student);

    List<Student> findAllStudent();

    Student findByName(@Param("name") String name);

}
