package newpackage.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import newpackage.model.Student;

public class StudentDAOImport implements StudentDAO{
	
	@Override
	public List<Student> getList() {
		try {
		Connection con = BDConnect.getConnection();
		String sql = "select * from student";
		List<Student> listItem = new ArrayList<>();
        PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            Student student = new Student();
            student.setStudent_id(rs.getString("student_id"));
            student.setName(rs.getString("name"));
            student.setBirthday(rs.getDate("birthday"));
            student.setGender(rs.getString("gender"));
            student.setAddress(rs.getString("address"));
            student.setPhone(rs.getString("phone"));
            student.setStatus(rs.getBoolean("status"));
        
	    	listItem.add(student);
            }
            ps.close();
            rs.close();
            con.close();
            return listItem;
        } catch (Exception e) {	
            e.printStackTrace();
        }
		return null;
        
	}
	public static void main(String[] args) {
		StudentDAO studentdao = new StudentDAOImport();
		
		System.out.println(studentdao.getList());
	}

}
