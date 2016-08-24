package cn.zw.service;

import cn.zw.dto.Page;
import cn.zw.entity.Student;

import java.util.List;

/**
 * @description 学生相关类接口
 * @auther 'Amos'
 * @created 2016/8/4  15:29
 */
public interface IStudentService {

    /**
     * 添加学生
     *
     * @param student 学生对象
     */
    void insertStudent(Student student);

    /**
     * 查询所有的学生
     *
     * @return
     */
    List<Student> findAll();

    /**
     *  通过ID查询学生
     * @param id 学生ID
     * @return
     */
    Student selectOne(Long id);


    Page<Student> pageStudent(int page, int pageSize);

    /**
     *  登陆
     * @param name 用户名
     * @return sig
     */
    Student findByName(String name);

}
