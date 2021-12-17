package newpackage.service;

import java.util.List;

import newpackage.dao.StudentDAO;
import newpackage.dao.StudentDAOImport;
import newpackage.model.Student;

public class StudentServiceImport implements StudentService{
	
	private StudentDAO studentDAO = null;
	
	
	public List<Student> getList() {
		return studentDAO.getList();
	}

	public StudentServiceImport() {
		super();
		studentDAO = new StudentDAOImport();
	}
	@Override
	public String Insert(Student student) {
		return studentDAO.Insert(student);
	}
	
	@Override
	public String Update(Student student) {
		return studentDAO.Update(student);
	}
	@Override
	public String Delete(Student student) {
		return studentDAO.Delete(student);
	}

	@Override
	public List<Student> sortList() {
		// TODO Auto-generated method stub
		return studentDAO.sortList();
	}




}
