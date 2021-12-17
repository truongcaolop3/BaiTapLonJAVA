package newpackage.dao;

import java.util.List;

import newpackage.model.Student;

public interface StudentDAO {
	public List<Student> getList();
	public String Insert(Student student);
	public String Update(Student student);
	public String Delete(Student student);
	public List<Student> sortList();
}
