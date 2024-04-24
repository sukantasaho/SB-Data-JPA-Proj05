package com.main.services;

import java.util.List;

import com.main.entity.Doctor;
import com.main.view.IDoctorView;
import com.main.view.IView;

public interface IDoctorService 
{
	 public <T extends IView> List<T> getByIncomeBetween(Float start, Float end, Class<T> clazz);
	 public List<IDoctorView> getBySpecializationIn(List<String> specializaton);
	 public List<Doctor> displayByDoctorsIncomeRange(Float start, Float end);
	 public List<Doctor> getAllDoctorsByName(String doc1, String doc2, String doc3);
	 public List<Object[]> fetchAllDoctorsSalaryGreater(Float sal);
	 public int getDoctorsNameCount();
	 public Object getAggregateData();
	 public int hikeDoctorsIncomeBySpecialization(String sp, Float percentage);
	 public int deleteeDoctorsByIncomeRange(Float start, Float end);
	 public List<Object> countNoDoctorGroupByName();
}
