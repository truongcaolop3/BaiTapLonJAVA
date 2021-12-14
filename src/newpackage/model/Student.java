/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newpackage.model;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author DELL
 */
public class Student implements Serializable {

    private String student_id;
    private String name;
    private Date birthday;
    private String gender;
    private String phone;
    private String address;
    private Boolean status;

    public Student() {
    }

    public Student(String student_id, String name, Date birthday, String gender, String phone, String address, Boolean status) {
        this.student_id = student_id;
        this.name =name;
        this.birthday = birthday;
        this.gender = gender;
        this.phone = phone;
        this.address = address;
        this.status = status;
    }

    public String getStudent_id() {
        return student_id;
    }

    public void setStudent_id(String student_id) {
        this.student_id = student_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

	@Override
	public String toString() {
		return  student_id + " " + name + " " + birthday + " " + gender
				+ " " + phone + " " + address + " " + status ;
	}

	
    
    
}
