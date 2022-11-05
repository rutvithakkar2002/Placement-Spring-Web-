package com.dao;

import java.util.List;

import org.checkerframework.common.reflection.qual.NewInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.bean.StudentBean;

@Repository
public class StudentDao {

	@Autowired
	JdbcTemplate stmt;

	public void addStudent(StudentBean student) {

		stmt.update(
				"insert into student (firstname,lastname,email,gender,ssc,hsc,bachelorcgpa,university,branch,contactnum) values (?,?,?,?,?,?,?,?,?,?)",
				student.getFirstname(), student.getLastname(), student.getEmail(), student.getGender(),
				student.getSsc(), student.getHsc(), student.getBachelorcgpa(), student.getUniversity(),
				student.getBranch(), student.getContactnum());

		//// insert update delete ========> update
	}

	public List<StudentBean> getAllStudents() {
		List<StudentBean> students = stmt.query("select * from student",
				new BeanPropertyRowMapper<StudentBean>(StudentBean.class));
		return students;
	}

	public void deleteStudent(int studentId) {
		// TODO Auto-generated method stub
		stmt.update("delete from student where studentid=?",studentId);
	}

	public StudentBean getStudentById(int studentId) {
		// TODO Auto-generated method stub
		
		return stmt.queryForObject("select from student where studentid=?",new BeanPropertyRowMapper<StudentBean>(StudentBean.class), new Object[] {studentId});
	}

}
