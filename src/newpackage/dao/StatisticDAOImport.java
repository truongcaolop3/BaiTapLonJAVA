package newpackage.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import newpackage.bean.ClassBean;

public class StatisticDAOImport implements StatisticDAO{
	

	

//	public static void main(String[] args) {
//		StatisticDAOImport statisticDAOImport = new StatisticDAOImport();
//		System.out.println(statisticDAOImport.getLitsClass());
//	}


@Override
public List<ClassBean> getLitsClass() {
	Connection cons = BDConnect.getConnection();
    String sql = "SELECT register_date, COUNT(*) as so_luong FROM class GROUP BY register_date";
    List<ClassBean> list = new ArrayList<>();
    try {
        PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
        	ClassBean classBean = new ClassBean();
        	classBean.setNgaydangky(rs.getString("register_date"));
        	classBean.setSoluong_student(rs.getInt("so_luong"));
//        	System.out.println(classBean);
            list.add(classBean);
         }
        ps.close();
        cons.close();
        return list;
    } catch (Exception e) {
        e.printStackTrace();
    }
	return list;
	}

}
