package com.kalpana.atyourdoorstep.App;

import com.kalpana.atyourdoorstep.dao.EmployeeDao;
import com.kalpana.atyourdoorstep.entity.Employee;
import com.kalpana.atyourdoorstep.entity.EmployeeType;
import java.util.Date;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest {

    @Test
    public void shouldAnswerWithTrue() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("AtYourDoorStep");
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            EmployeeDao dao = new EmployeeDao(em);
            Employee emp = dao.insert(getEmployee());
            em.getTransaction().commit();
            System.out.println(emp.getEmployeeId());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
            emf.close();
        }
        assertTrue(true);
    }

    private Employee getEmployee() {
        Employee emp = new Employee();
        emp.setEmployeeJoiningDate(new Date());
        emp.setEmployeeSalary(11000L);
        emp.setEmployeeType(EmployeeType.PERMANENT);
        return emp;
    
    }
}
