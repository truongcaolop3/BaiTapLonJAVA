package newpackage.service;

import java.util.List;

import newpackage.bean.ClassBean;
import newpackage.dao.StatisticDAOImport;

public class StatisticServiceImport implements StatisticService {

	public StatisticServiceImport() {
		super();
	}

	@Override
	public List<ClassBean> getLitsClass() {
		return (List<ClassBean>) new StatisticDAOImport().getLitsClass();
	}
	
}
