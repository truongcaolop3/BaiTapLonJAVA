package newpackage.controller;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Date;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import newpackage.dao.StudentDAO;
import newpackage.dao.StudentDAOImport;
import newpackage.model.Student;
import newpackage.service.StudentService;
import newpackage.service.StudentServiceImport;
import newpackage.until.ClassTableModel;
import newpackage.view.StudentFrame;

import javax.swing.table.TableRowSorter;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class MNStudentController implements StudentDAO {
	private JPanel jpnView ;
	private JButton btnAdd;
	private JTextField jtfFind;
	private DefaultTableModel model;
	private JTable table;
	private StudentService studentservice = null; 
	private String[] listColumn = {"STT" ,"Student ID" ,"Name" , "birthday" , "gender" ,"phone" , "address", "status"};
	
	private TableRowSorter<TableModel> rowSorter = null;
	public MNStudentController() {
		super();
	}
	public MNStudentController(JPanel jpnView, JButton btnAdd, JTextField jtfFind) {
		super();
		this.jpnView = jpnView;
		this.btnAdd = btnAdd;
		this.jtfFind = jtfFind;
		this.studentservice = new StudentServiceImport();
	}
	
	public DefaultTableModel getModel() {
		return model;
	}
	public JTable getTable() {
		return table;
	}

	public void setDateToTable() {
//		List<Student> listItem = studentservice.getList();
		StudentDAOImport sdi = new StudentDAOImport();
		List<Student> listItem = sdi.sortList();
		
		model = new ClassTableModel().setTableStudent(listItem, listColumn);
		table = new JTable(model);
		rowSorter = new TableRowSorter<>(table.getModel());
		table.setRowSorter(rowSorter);
		
		jtfFind.getDocument().addDocumentListener(new DocumentListener() {

	@Override
	public void insertUpdate(DocumentEvent e) {
		String text = jtfFind.getText();
		if (text.trim().length() == 0) {
			rowSorter.setRowFilter(null);
		}else {
			rowSorter.setRowFilter(javax.swing.RowFilter.regexFilter("(?i)" + text));
		}
		
	}

	@Override
	public void removeUpdate(DocumentEvent e) {
		String text = jtfFind.getText();
		if (text.trim().length() == 0) {
			rowSorter.setRowFilter(null);
		}else {
			rowSorter.setRowFilter(javax.swing.RowFilter.regexFilter("(?i)" + text));
		}
	}

	@Override
	public void changedUpdate(DocumentEvent e) {
		// TODO Auto-generated method stub
		
	}
			
		});
		
	table.addMouseListener(new MouseAdapter() {
	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getClickCount() == 2 && table.getSelectedRow() != -1) {
			DefaultTableModel model = (DefaultTableModel) table.getModel();
			int selectdRowIndex = table.getSelectedRow();
			
			//selectdRowIndex = table.convertColumnIndexToModel(selectdRowIndex);
//					System.out.println(selectdRowIndex);
			
			Student student = new Student();
			
			student.setStudent_id(model.getValueAt(selectdRowIndex, 1).toString());
			student.setName( model.getValueAt(selectdRowIndex, 2).toString());
			student.setBirthday((Date)model.getValueAt(selectdRowIndex, 3));
			student.setGender(model.getValueAt(selectdRowIndex, 4).toString());
			student.setPhone(model.getValueAt(selectdRowIndex, 5) != null ?
					model.getValueAt(selectdRowIndex, 5).toString() : null);
			student.setAddress(model.getValueAt( selectdRowIndex, 6) != null ?
					model.getValueAt(selectdRowIndex, 6).toString() : null);
			student.setStatus((boolean)model.getValueAt(selectdRowIndex, 7));
			
			StudentFrame frame = new StudentFrame(student);
			frame.setTitle("Information Student");
			frame.setResizable(false);
			frame.setLocationRelativeTo(null);
			frame.setVisible(true);
		}
		super.mouseClicked(e);
	}
	});
			
		table.getTableHeader().setFont(new Font("Arrial", Font.BOLD, 14));
		table.getTableHeader().setPreferredSize(new Dimension(100,50));
		table.setRowHeight(50);
		table.validate();
		table.repaint();
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.getViewport().add(table);
		scrollPane.setPreferredSize(new Dimension(1300,400));
		
		jpnView.removeAll();
        jpnView.setLayout(new BorderLayout());
        jpnView.add(scrollPane);
        jpnView.validate();
        jpnView.repaint();
	}
	
	public void setEvent() {
		btnAdd.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				StudentFrame frame = new StudentFrame(new Student());
				frame.setTitle("Enter Student Informatinon");
				frame.setLocationRelativeTo(null);
				frame.setResizable(false);
				frame.setVisible(true);
				new StudentDAOImport();
				
				}
			
		});
	
	}

	@Override
	public List<Student> getList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String Update(Student student) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String Insert(Student student) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String Delete(Student student) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Student> sortList() {
		// TODO Auto-generated method stub
		return null;
	}
}
