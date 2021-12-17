package newpackage.controller;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;

import newpackage.model.Student;
import newpackage.service.StudentService;
import newpackage.service.StudentServiceImport;
import newpackage.view.StudentFrame;

public class StudentControllor {
	private JButton btnSubmit;
	private JButton btnDelete;
	private JTextField jtfStudentID;
	private JTextField jtfStudentName;
	private JDateChooser jDateBirthday;
	private JComboBox jComboBoxGender;
	private	JTextField jtfPhone;
	private JTextField jtfAddress;
	private JCheckBox jCheckBoxStatus;
	private JLabel JlbMsg;
	
	private	Student student = null ;
	private StudentService studentService = null;
	
	

	public StudentControllor(JButton btnSubmit, JTextField jtfStudentID, JTextField jtfStudentName,
			JDateChooser jDateBirthday, JComboBox jComboBoxGender, JTextField jtfPhone, JTextField jtfAddress,
			JCheckBox jCheckBoxStatus, JLabel jlbMsg, JButton btnDelete) {
		super();
		this.btnSubmit = btnSubmit;
		this.jtfStudentID = jtfStudentID;
		this.jtfStudentName = jtfStudentName;
		this.jDateBirthday = jDateBirthday;
		this.jComboBoxGender = jComboBoxGender;
		this.jtfPhone = jtfPhone;
		this.jtfAddress = jtfAddress;
		this.jCheckBoxStatus = jCheckBoxStatus;
		JlbMsg = jlbMsg;
		this.btnDelete = btnDelete;
		
		this.studentService = new StudentServiceImport();
	}
	public void setView(Student student) {
		this.student = student;
		
		jtfStudentID.setText(student.getStudent_id());
		jtfStudentName.setText(student.getName());
		jDateBirthday.setDate(student.getBirthday());
		jComboBoxGender.setSelectedItem(student.getGender());
		jtfPhone.setText(student.getPhone());
		jtfAddress.setText(student.getAddress());
		jCheckBoxStatus.setSelected(student.getStatus()); 
		
	}
	public void setEvent() {
		btnSubmit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (jtfStudentName.getText().length() == 0 || jDateBirthday.getDate() == null) {
					JlbMsg.setText("column Name and Birthday not NULL !");
					
				}else {
					student.setName(jtfStudentName.getText());
					student.setBirthday(jDateBirthday.getDate());
					student.setGender((String) jComboBoxGender.getSelectedItem());
					student.setPhone(jtfPhone.getText());
					student.setAddress(jtfAddress.getText());
					student.setStatus(jCheckBoxStatus.isSelected());
					studentService.Update(student);
	
					String lastID ;
					lastID = studentService.Update(student);
					if (lastID  != "") {
						student.setStudent_id(lastID);
						jtfStudentID.getSelectedText();
						JlbMsg.setText("Data update successful !");
						
					}
					StudentFrame frame = new StudentFrame(student);
					frame.setVisible(false);
				}
				// thoat 2 click
				
			}

		});
		
		btnDelete.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (jtfStudentName.getText().length() == 0 || jDateBirthday.getDate() == null) {
					JlbMsg.setText("column Name and Birthday not NULL !");
					
				}else {
					student.setName(jtfStudentName.getText());
					student.setBirthday(jDateBirthday.getDate());
					student.setGender((String) jComboBoxGender.getSelectedItem());
					student.setPhone(jtfPhone.getText());
					student.setAddress(jtfAddress.getText());
					student.setStatus(jCheckBoxStatus.isSelected());
					studentService.Delete(student);
					JlbMsg.setText("Data delete successful !");
					StudentFrame frame = new StudentFrame(student);
					frame.setVisible(false);
				}
			}

		});
	
		
		
	}
}
