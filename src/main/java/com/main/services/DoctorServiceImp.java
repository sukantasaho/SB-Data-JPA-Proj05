package com.main.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.main.entity.Doctor;
import com.main.repository.IDoctorRepository;
import com.main.view.IDoctorView;
import com.main.view.IView;

@Service("docService")
@Transactional
public class DoctorServiceImp implements IDoctorService 
{
	@Autowired
	private IDoctorRepository repo;

	@Override
	public <T extends IView> List<T> getByIncomeBetween(Float start, Float end, Class<T> clazz) 
	{
		 
		return repo.findByIncomeBetween(start, end, clazz);
	}

	@Override
	public List<IDoctorView> getBySpecializationIn(List<String> specializaton) 
	{
		 
		return repo.findBySpecializationIn(specializaton);
	}

	@Override
	public List<Doctor> displayByDoctorsIncomeRange(Float start, Float end) 
	{
		 
		return repo.searchByDoctorsIncomeRange(start, end);
	}

	@Override
	public List<Doctor> getAllDoctorsByName(String doc1, String doc2, String doc3) 
	{
		 
		return repo.getAllDoctorsByName(doc1, doc2, doc3);
	}

	@Override
	public List<Object[]> fetchAllDoctorsSalaryGreater(Float sal) 
	{
		 
		return repo.getAllDoctorsSalaryGreater(sal);
	}

	@Override
	public int getDoctorsNameCount() 
	{
		 
		return repo.fetchDoctorsNameCount();
	}

	@Override
	public Object getAggregateData()
	{
		 
		return repo.fetchAggregateData();
	}

	@Override
	public int hikeDoctorsIncomeBySpecialization(String sp, Float percentage)
	{
		 
		return repo.hikeDoctorsIncomeBySpecialization(sp, percentage);
	}

	@Override
	public int deleteeDoctorsByIncomeRange(Float start, Float end) 
	{
		 
		return repo.removeDoctorsByIncomeRange(start, end);
	}

	@Override
	public List<Object> countNoDoctorGroupByName() 
	{
		 
		return repo.countNoDoctorGroupByName();
	}
    
	
	 
}
