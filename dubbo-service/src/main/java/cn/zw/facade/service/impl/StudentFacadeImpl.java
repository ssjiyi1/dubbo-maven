package cn.zw.facade.service.impl;

import cn.zw.dto.Page;
import cn.zw.entity.Student;
import cn.zw.facade.service.StudentFacade;
import cn.zw.service.impl.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description 学生服务类的实现
 * @auther 'Amos'
 * @created 2016/8/24  14:57
 */
@Service("studentFacadeImpl")
public class StudentFacadeImpl implements StudentFacade {


    @Autowired
    private StudentService studentService;

    public void setStudentService(StudentService studentService) {
        this.studentService = studentService;
    }

    @Override
    public void insertStudent(Student student) {
        studentService.insertStudent(student);
    }

    @Override
    public List<Student> findAll() {
        return studentService.findAll();
    }

    @Override
    public Student selectOne(Long id) {
        return studentService.selectOne(id);
    }

    @Override
    public Page<Student> pageStudent(int page, int pageSize) {
        return studentService.pageStudent(page, pageSize);
    }

    @Override
    public Student findByName(String name) {
        return studentService.findByName(name);
    }
}
