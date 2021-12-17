package newpackage.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import newpackage.controller.MNStudentController;
import newpackage.model.Student;
import newpackage.view.StudentFrame;
import newpackage.view.StudentJPanel;

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
	
	public List<Student> sortList() {
		try {
		Connection con = BDConnect.getConnection();
		String sql = "SELECT * FROM student ORDER BY student_id DESC";
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
	
	
	public String Insert(Student student) {
		try {
			Connection conn = BDConnect.getConnection();
			String sql = "INSERT INTO student(student_id, name, birthday, gender, phone, address, status) VALUES(?, ?, ?, ?, ?, ?, ?) ";
			PreparedStatement ps = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
			ps.setString(1, student.getStudent_id());
            ps.setString(2, student.getName());
            ps.setDate(3, new Date(student.getBirthday().getTime()) );
            ps.setString(4, student.getGender());
            ps.setString(5, student.getPhone());
            ps.setString(6, student.getAddress());
            ps.setBoolean(7, student.getStatus());
            ps.execute();
            ResultSet rs = ps.getGeneratedKeys();
            String generatedKey = null ;
            if (rs.next()) {
                generatedKey = rs.getString(1);
            }
            StudentFrame frame = new StudentFrame(student);
            frame.setVisible(false);
            ps.close();
            conn.close();
            return generatedKey;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "";
	}
	
	public String Update(Student student) {
		try {
            Connection cons = BDConnect.getConnection();
//            String sql = "INSERT INTO student(student_id, name, birthday, gender, phone, address, status) VALUES(?, ?, ?, ?, ?, ?, ?) ";
//            		+ "UPDATE student_id = VALUES(student_id), name = VALUES(name), birthday = VALUES(birthday), gender = VALUES(gender), phone = VALUES(phone), address = VALUES(address), status = VALUES(status)"
//            		+ "WHERE student_id = VALUES (student_id);";
            String sql = "UPDATE student SET name=?, birthday=?, gender=?, phone=?, address=?, status=? WHERE student_id=?";
            PreparedStatement ps = cons.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            //if (student.getStudent_id() != null) {
            	ps.setString(7, student.getStudent_id());
                ps.setString(1, student.getName());
                ps.setDate(2, new Date(student.getBirthday().getTime()) );
                ps.setString(3, student.getGender());
                ps.setString(4, student.getPhone());
                ps.setString(5, student.getAddress());
                ps.setBoolean(6, student.getStatus());
                ps.execute();
//                MNStudentController ms = new MNStudentController(null, null, null);
                
            //}
            
            ResultSet rs = ps.getGeneratedKeys();
            String generatedKey = null ;
            if (rs.next()) {
                generatedKey = rs.getString(1);
            }
            ps.close();
            cons.close();
            return generatedKey;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
		return "";
    }
	
	public String Delete(Student student) {
		try {
			Connection conn = BDConnect.getConnection();
			String sql = "DELETE FROM student WHERE student_id=?";
			PreparedStatement ps = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
			ps.setString(1, student.getStudent_id());
			ps.execute();
		 ResultSet rs = ps.getGeneratedKeys();
            String generatedKey = null ;
            if (rs.next()) {
                generatedKey = rs.getString(1);
            }
            ps.close();
            conn.close();
            return generatedKey;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "";
	}
	
	public static void main(String[] args) {
		StudentDAO studentdao = new StudentDAOImport();
		
		System.out.println(studentdao.getList());
	}

}
