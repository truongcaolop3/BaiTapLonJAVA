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
public class Class implements Serializable{
    private String class_id ;
    private String course_id ;
    private String student_id ;
    private Date register_date ;
    private Boolean status ;

    public Class() {
    }

    public Class(String class_id, String course_id, String student_id, Date register_date, Boolean status) {
        this.class_id = class_id;
        this.course_id = course_id;
        this.student_id = student_id;
        this.register_date = register_date;
        this.status = status;
    }

    public String getClass_id() {
        return class_id;
    }

    public void setClass_id(String class_id) {
        this.class_id = class_id;
    }

    public String getCourse_id() {
        return course_id;
    }

    public void setCourse_id(String course_id) {
        this.course_id = course_id;
    }

    public String getStudent_id() {
        return student_id;
    }

    public void setStudent_id(String student_id) {
        this.student_id = student_id;
    }

    public Date getRegister_date() {
        return register_date;
    }

    public void setRegister_date(Date register_date) {
        this.register_date = register_date;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
    
            
}
