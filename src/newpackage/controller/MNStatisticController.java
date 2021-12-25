package newpackage.controller;

import java.awt.CardLayout;
import java.awt.Dimension;
import java.util.List;

import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;

import newpackage.bean.ClassBean;
import newpackage.service.StatisticService;
import newpackage.service.StatisticServiceImport;

public class MNStatisticController {
	
	private StatisticService statisticService;
	
	public MNStatisticController() {
		statisticService = new StatisticServiceImport();
	}
	public void setDateToChart1(JPanel jpnItem) {
		List<ClassBean> listItemBeans = statisticService.getLitsClass();
		if(listItemBeans != null) {
			DefaultCategoryDataset dataset = new DefaultCategoryDataset();
			for (ClassBean Item :listItemBeans) {
				dataset.addValue(Item.getSoluong_student(), "Student", Item.getNgaydangky());
				
				
			}
			JFreeChart chart = ChartFactory.createBarChart("THỐNG KÊ SỐ LƯỢNG SINH VIÊN ĐĂNG KÝ",
											"Thời Gian", "số Lượng", dataset);
			
			ChartPanel chartPanel = new ChartPanel(chart);
			chartPanel.setPreferredSize(new Dimension(jpnItem.getWidth(), 500));
			
			jpnItem.removeAll();
			jpnItem.setLayout(new CardLayout());
			jpnItem.add(chartPanel);
			jpnItem.validate();
			jpnItem.repaint();
		}

	}
	
}
