package com.main.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.main.entity.Doctor;
import com.main.view.IDoctorView;
import com.main.view.IView;

 
 
public interface IDoctorRepository extends JpaRepository<Doctor, Integer>
{
     public <T extends IView> List<T> findByIncomeBetween(Float start, Float end, Class<T> clazz);
     public List<IDoctorView> findBySpecializationIn(List<String> specializaton);

		/*Query Method*/
     //@Query("FROM Doctor where income>?1 AND income<?2")
     @Query("FROM Doctor where income>:start AND income<:end")
     public List<Doctor> searchByDoctorsIncomeRange(Float start, Float end);
     
     @Query("FROM Doctor where docName in(:doc1,:doc2,:doc3)")
     public List<Doctor> getAllDoctorsByName(String doc1, String doc2, String doc3);
     
     @Query("SELECT docId, docName, income FROM Doctor where income>:sal")
     public List<Object[]> getAllDoctorsSalaryGreater(Float sal);
     
     @Query("SELECT count(distinct docName) FROM Doctor")
     public int fetchDoctorsNameCount();
     @Query("SELECT count(*),max(income),min(income), avg(income),sum(income) FROM Doctor")
     public Object fetchAggregateData();
     
     //Query method with non select query
     @Query("UPDATE Doctor set income=income+(income*:percentage/100.0) WHERE specialization=:sp")
     @Modifying
     public int hikeDoctorsIncomeBySpecialization(String sp, Float percentage);
     
     @Query("DELETE FROM Doctor WHERE income>=:start AND income<=:end")
     @Modifying
     public int removeDoctorsByIncomeRange(Float start, Float end);
     
     @Query("SELECT specialization, count(*) FROM Doctor GROUP BY specialization")
     public List<Object> countNoDoctorGroupByName();
     
}
