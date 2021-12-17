package newpackage.service;

import java.util.List;

import newpackage.model.Student;

public interface StudentService {
	public List<Student> getList();
	public String Insert(Student student);
	public String Update(Student student);
	public String Delete(Student student);
	public List<Student> sortList();
}
