package com.sbu.service.impl;

import com.sbu.dao.impl.CourseDAOImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sbu.dao.impl.StdDAOImpl;
import com.sbu.dao.impl.UserDAOImpl;
import com.sbu.dao.model.Course;
import com.sbu.dao.model.Department;
import com.sbu.dao.model.Employee;
import com.sbu.dao.model.Major;
import com.sbu.dao.model.Stdtable;
import com.sbu.dao.model.Term;
import com.sbu.dao.model.User;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.transaction.Transactional;

@Service
public class StdManagerImpl /*implements ProfManager*/ {

    public StdManagerImpl() {}

    @Autowired
    public StdDAOImpl stdDAOImpl;
    
    @Autowired
    public UserDAOImpl userDAOImpl;
    
    @Autowired
    public CourseDAOImpl courseDAOImpl;
    
    //@Override
    public Stdtable findStd(int id)
    {
        return stdDAOImpl.findUser(id);        
    }
    
    public void testAddCourse ()
    {
   /*     
        Course course = new Course(2,"nazarie", 1,1,1,1,1,1);
        //Course course2 = courseDAOImpl.findCourse(1);
        //course2.setId(12);
        Major major = courseDAOImpl.findMajor(1);
        Term term = courseDAOImpl.findTerm(9221);
        System.out.println("major name: "+ major.getMajor());
        System.out.println("term : "+term.getName());
        course.setMajor(major);
        course.setTerm(term);
        courseDAOImpl.insertcourse(course);
        
*/
        Course course = new Course("nazarie", 1, 1, 1, 1, 1, 1);
        Major major = courseDAOImpl.findMajor(1);
        course.setMajor(major);
        Term term = courseDAOImpl.findTerm(9221);
        course.setTerm(term);
        courseDAOImpl.insertcourse(course);
        System.out.println("course added");
		Employee employee = new Employee();
		employee.setEmail("someMail@gmail.com");
		employee.setFirstname("Prasad");
		employee.setLastname("kharkar");

		
		Department department = courseDAOImpl.findDep(1);
		System.out.println(department);

		employee.setDepartment(department);

		courseDAOImpl.inserEmp(employee) ;
		
       
    }
    @Transactional
    public boolean updateEmail(int id ,String email ,String username ,String pass ,String repeatPass)
    {
        System.out.println("in the update Email method in ProfManagerImpl");
        boolean updateEmail = stdDAOImpl.updateEmail(id ,email );
        System.out.println(updateEmail);
        System.out.println(pass +"------"+ repeatPass);
        if ( !pass.equals(repeatPass) )
            return false;
        boolean updatePass = userDAOImpl.updatePass(username, pass);
        
        System.out.println(updatePass);
        
        if (updatePass & updateEmail)
            return true;
        else
            return false;               
    }
}
