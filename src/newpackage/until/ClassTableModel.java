package newpackage.until;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;

import newpackage.dao.BDConnect;
import newpackage.dao.StudentDAOImport;

import newpackage.model.Student;

public class ClassTableModel extends StudentDAOImport{
	// 
	public DefaultTableModel setTableStudent(List<Student> listItem, String[] listColumn) {
        int columns = listColumn.length;
        DefaultTableModel dtm = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false;
            }

            @Override
            public Class<?> getColumnClass(int columnIndex) {
                return columnIndex == 7 ? Boolean.class : String.class;
            }
        };
        
        listItem = getList();
        
        
        dtm.setColumnIdentifiers(listColumn);
        Object[] objects;
        int num = listItem.size();
        Student student = null;
        for (int i = 0; i < num; i++) {
        	student = listItem.get(i);
			objects =  new Object[columns];
			objects[0] = (i+1);
			objects[1] = student.getStudent_id();
			objects[2] = student.getName();
			objects[3] = student.getBirthday();
			objects[4] = student.getGender();
			objects[5] = student.getPhone();
			objects[6] = student.getAddress();
			objects[7] = student.getStatus();
			dtm.addRow(objects);
        }
        return dtm;
    }
//	public DefaultTableModel setTableStudent(List<Student> listItem, String[] listColumn) {
//		
//		DefaultTableModel dtm = new DefaultTableModel() {
//			@Override
//			public boolean isCellEditable(int row, int column) {
//				return false;
//			}
//		};
//		dtm.setColumnIdentifiers(listColumn);
//		int columns = listColumn.length;
//		Object[] objects = null;
//		int rows = listItem.size();
//		System.out.println("rows= " + rows);
//		if (rows > 0) {
//			for ( int i = 0 ; i< rows;i++) {
//				Student student = listItem.get(i);
//				objects =  new Object[columns];
//				objects[0] = (i+1);
//				objects[1] = student.getStudent_id();
//				objects[2] = student.getName();
//				objects[3] = student.getBirthday();
//				objects[4] = student.getGender();
//				objects[5] = student.getPhone();
//				objects[6] = student.getAddress();
//				objects[7] = student.getStatus();
//				dtm.addRow(objects);
//			}
//		}
//		
//		return dtm;
//	}
}
