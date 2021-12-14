package newpackage.controller;

import javax.swing.JButton;
import javax.swing.JTextField;

import newpackage.model.Student;

public class StudentControllor {
	private JButton btnSubmit;
	private JTextField jtfStudentID;
	private JTextField jtfStudentName;
	public StudentControllor(JButton btnSubmit, JTextField jtfStudentID, JTextField jtfStudentName) {
		super();
		this.btnSubmit = btnSubmit;
		this.jtfStudentID = jtfStudentID;
		this.jtfStudentName = jtfStudentName;
	}
	
	public void setView(Student student) {
		jtfStudentID.setText(student.getStudent_id());
		jtfStudentID.setText(student.getName());
		
	}
	
}
