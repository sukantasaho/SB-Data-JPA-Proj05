package com.main;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.main.services.IDoctorService;
import com.main.view.IResultView1;
import com.main.view.IResultView2;

@SpringBootApplication
public class SbDataJpaProj03Application
{

	public static void main(String[] args) 
	{
		   ApplicationContext ctx = SpringApplication.run(SbDataJpaProj03Application.class, args);
		   IDoctorService service = ctx.getBean("docService", IDoctorService.class);
		   //invoke the business logic
		    
		       //fetch doctor records by using static scalar projection
			/* service.getBySpecializationIn(List.of("Nurology","Dermitology")).forEach(doc->System.out.println(doc.getDocName()+"  "+doc.getIncome()));;*/
		     //fetch doctor records by using dynamic scalar projection
			/*service.getByIncomeBetween(20000f, 40000f, IResultView1.class).forEach(doc->System.out.println(doc.getDocName()+"  "+doc.getSpecialization()));;*/
		  
		      
		      //Working with query method
				/* service.displayByDoctorsIncomeRange(23000f, 50000f).forEach(System.out::println);*/
		      //fetch doctors records by passing multiple doctor name
				/* service.getAllDoctorsByName("Saroj", "SK Sahoo", "GK").forEach(System.out::println);*/
		        
		   
				/*service.fetchAllDoctorsSalaryGreater(40000f).forEach(row->{
					for(Object obj : row)
					{
						System.out.println(obj+"  ");
					}
					System.out.println();
				});*/
		   //agregate query
			/*System.out.println(service.getDoctorsNameCount());*/
		   //get Aggregate Data
			/* Object[] obj = (Object[]) service.getAggregateData();
			 System.out.println("Total Doctor Records Fetched : "+obj[0]);
			 System.out.println("Highest Doctor Salary        : "+obj[1]);
			 System.out.println("Lowest Doctor Salary         : "+obj[2]);
			 System.out.println("Average Doctor Salary        : "+obj[3]);
			 System.out.println("Total Doctor Salary          : "+obj[4]);*/
		   
		   //Update non-select query
			/* int i =  service.hikeDoctorsIncomeBySpecialization("Nurology", 10f);
			 System.out.println(i);*/
		   //delete non-select query
			/*int i = service.deleteeDoctorsByIncomeRange(23000f, 40000f);
			if(i>1)
			  System.out.println(i+"-records is deleted");
			else if(i==1)
			  System.out.println(i+"-record is deleted");
			else
			System.out.println("no record is deleted");*/
		   
		    List<Object> obj = service.countNoDoctorGroupByName();
		    for(Object o : obj)
		    {
		    	System.out.println(o);
		    }
		    
		   
		      ((ConfigurableApplicationContext) ctx).close();
	}

}
