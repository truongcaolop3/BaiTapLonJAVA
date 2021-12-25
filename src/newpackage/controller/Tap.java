/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package newpackage.controller;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.MouseListener;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JPanel;
import newpackage.bean.DanhMucBean;
import newpackage.view.ClassJPanel;
import newpackage.view.DepartmentJPanel;
import newpackage.view.StatisticJpanel;
import newpackage.view.StudentJPanel;
import newpackage.view.TrangChuJPanel;


/**
 *
 * @author DELL
 */
public class Tap {
    private JPanel root ;
    private String kindSelected = "";
    
    private List<DanhMucBean> listItem = null;
    private TrangChuJPanel ttt;
    
    
    public  Tap(JPanel jpnroot ){
        this.root = jpnroot;
    }
    public void setView(JPanel jpnItem , JLabel jlbItem){
        kindSelected = "Trangchu" ;
        jpnItem.setBackground(new Color(0, 0, 255));
        jlbItem.setBackground(new Color(0, 0, 255));
        
        ttt = new TrangChuJPanel();
        root.removeAll();
        root.setLayout(new BorderLayout());
        root.add(ttt);
        
        root.validate();
        root.repaint();
        
    }
    public void setEvent(List<DanhMucBean> listItem ){
        this.listItem = listItem;
        for (DanhMucBean item : listItem){
            item.getJlb().addMouseListener(new LabelEvent(item.getKind(), item.getJbn() , item.getJlb()));
        }
    }
    class LabelEvent implements MouseListener{

        private JPanel node;
        private String kind ;
        
        private JPanel jpnItem ;
        private JLabel jlbitem ;

        public LabelEvent(String kind, JPanel jpnItem, JLabel jlbitem) {
            this.kind = kind;
            this.jpnItem = jpnItem;
            this.jlbitem = jlbitem;
        }
        
        @Override
        public void mouseClicked(java.awt.event.MouseEvent e) {
            switch (kind) {
                case "TrangChu":
                    node = new TrangChuJPanel();
                    break;
                case "Student":
                    node = new StudentJPanel();
                    break;
                case "Department":
                    node = new DepartmentJPanel();
                    break;
                case "Class":
                    node = new ClassJPanel();
                    break;
                case "Statistic":
                    node = new StatisticJpanel();
                    break;
                default:
                    node = new TrangChuJPanel();
                    break;
            }
            root.removeAll();
            root.setLayout(new BorderLayout());
            root.add(node);
            root.validate();
            root.repaint();
            setChanggeBackground(kind);
        }

        @Override
        public void mousePressed(java.awt.event.MouseEvent e) {
            kindSelected = kind;
            jpnItem.setBackground(new Color(0, 0, 255));
            jlbitem.setBackground(new Color(0, 0, 255));

        }

        @Override
        public void mouseReleased(java.awt.event.MouseEvent e) {

        }

        @Override
        public void mouseEntered(java.awt.event.MouseEvent e) {
            jpnItem.setBackground(new Color(0, 0, 255));
            jlbitem.setBackground(new Color(0, 0, 255));
        }

        @Override
        public void mouseExited(java.awt.event.MouseEvent e) {
            if (!kindSelected.equalsIgnoreCase(kind)) {
                jpnItem.setBackground(new Color(0, 0, 255));
                jlbitem.setBackground(new Color(0, 0, 255));
            }
        }

        private void setChanggeBackground(String kind) {
            for (DanhMucBean item : listItem) {
                if (item.getKind().equalsIgnoreCase(kind)) {
                    item.getJbn().setBackground(new Color(0, 0, 255));
                    item.getJlb().setBackground(new Color(0, 0, 255)); 
                }else {
                    item.getJbn().setBackground(new Color(51,51,204));
                    item.getJlb().setBackground(new Color(51,51,204));
                }
            }
        }
    }
}
