package cn.zw.service.impl;

import cn.zw.dao.StudentDao;
import cn.zw.dto.Page;
import cn.zw.entity.Student;
import cn.zw.service.IStudentService;
import com.github.pagehelper.PageHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator
 * on 2016/5/30
 * 18:00.
 */
@Service
public class StudentService implements IStudentService {

    private static Logger LOGGER = LoggerFactory.getLogger(StudentService.class);

    @Autowired
    private StudentDao studentDao;

    public StudentService() {
        System.out.println(studentDao);
    }

    public void insertStudent(Student student) {
        studentDao.insert(student);
    }

    public List<Student> findAll() {
        return studentDao.findAllStudent();
    }

    @Override
    public Student selectOne(Long id) {
        return null;
    }

    @Override
    public Page<Student> pageStudent(int page, int pageSize) {
        LOGGER.info("enter page student---page:"+page);
        com.github.pagehelper.Page studentPage = PageHelper.startPage(page, pageSize);
        studentDao.findAllStudent();
        return new Page(studentPage);
    }

    @Override
    public Student findByName(String name) {
      return studentDao.findByName(name);
    }


}
