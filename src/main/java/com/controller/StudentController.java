package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bean.StudentBean;
import com.dao.StudentDao;

@Controller
public class StudentController {

	@Autowired
	StudentDao studentDao;
	
	@GetMapping("/addstudent")
	public String newStudent()
	{
		return "NewStudent";
	}

	@PostMapping("/savestudent")
	public String saveStudent(StudentBean student)
	{
		System.out.println("!!!");
		studentDao.addStudent(student);
		System.out.println("Data inserted");
		return "NewStudent";
	}
	@GetMapping("/getallstudents")
	public String getAllStudents(Model model)
	{
		List<StudentBean> students=studentDao.getAllStudents();
		model.addAttribute("students", students);
		return "ListStudents";
	}
	@GetMapping("/deletestudent")
	public String deletestudent(@RequestParam("studentId") int studentId)
	{
		studentDao.deleteStudent(studentId);
		return "redirect:/getallstudents";
	}
	@GetMapping("/editstudent")
	public String editstudent(@RequestParam("studentId") int studentId,Model model)
	{
		StudentBean student = studentDao.getStudentById(studentId);
		model.addAttribute("student", student);
		return "EditStudent";
	}
}
