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
public class Course implements Serializable {

    private String course_id;
    private String course_name;
    private Date start_year;
    private Date end_year;
    private boolean status;

    public Course() {
    }

    public Course(String course_id, String course_name, Date start_year, Date end_year, boolean status) {
        this.course_id = course_id;
        this.course_name = course_name;
        this.start_year = start_year;
        this.end_year = end_year;
        this.status = status;
    }

    public String getCourse_id() {
        return course_id;
    }

    public void setCourse_id(String course_id) {
        this.course_id = course_id;
    }

    public String getCourse_name() {
        return course_name;
    }

    public void setCourse_name(String course_name) {
        this.course_name = course_name;
    }

    public Date getStart_year() {
        return start_year;
    }

    public void setStart_year(Date start_year) {
        this.start_year = start_year;
    }

    public Date getEnd_year() {
        return end_year;
    }

    public void setEnd_year(Date end_year) {
        this.end_year = end_year;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
            
            
}
