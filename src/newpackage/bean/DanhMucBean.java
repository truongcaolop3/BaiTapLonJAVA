/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package newpackage.bean;

import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author DELL
 */
public class DanhMucBean {
    private String kind;
    private JPanel jbn;
    private JLabel jlb ;

    public DanhMucBean() {
    }

    public DanhMucBean(String kind, JPanel jbn, JLabel jlb) {
        this.kind = kind;
        this.jbn = jbn;
        this.jlb = jlb;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public JPanel getJbn() {
        return jbn;
    }

    public void setJbn(JPanel jbn) {
        this.jbn = jbn;
    }

    public JLabel getJlb() {
        return jlb;
    }

    public void setJlb(JLabel jlb) {
        this.jlb = jlb;
    }

    
     
}
