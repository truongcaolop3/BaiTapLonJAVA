package newpackage.service;

import java.util.List;

import newpackage.dao.StudentDAO;
import newpackage.model.Student;

public class StudentServiceImport implements StudentService{
	
	private StudentDAO studentDAO = null;
	
	
	public List<Student> getList() {
		// TODO Auto-generated method stub
		return null;
	}

	public StudentServiceImport() {
		super();
	}
	
	public StudentServiceImport(StudentDAO studentDAO) {
		super();
		this.studentDAO = studentDAO;
	}

	
}
