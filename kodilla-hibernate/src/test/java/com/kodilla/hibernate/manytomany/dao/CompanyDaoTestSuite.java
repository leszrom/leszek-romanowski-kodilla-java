package com.kodilla.hibernate.manytomany.dao;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.Employee;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CompanyDaoTestSuite {
    @Autowired
    private CompanyDao companyDao;

    @Autowired
    private EmployeeDao employeeDao;

    @Test
    public void testNamedQueries() {
        //Given
        Company softwareMachine = new Company("Software Machine");
        Company softSolution = new Company("Soft Solution");
        Company silverMachine = new Company("Silver Machine");

        Employee johnSmith = new Employee("John", "Smith");
        Employee krisSmith = new Employee("Kris", "Smith");
        Employee annFive = new Employee("Ann", "Five");
        Employee billBlue = new Employee("Bill", "Blue");

        softwareMachine.getEmployees().add(johnSmith);
        softwareMachine.getEmployees().add(krisSmith);
        softwareMachine.getEmployees().add(annFive);
        softwareMachine.getEmployees().add(billBlue);
        softSolution.getEmployees().add(johnSmith);
        softSolution.getEmployees().add(annFive);
        silverMachine.getEmployees().add(krisSmith);

        johnSmith.getCompanies().add(softwareMachine);
        johnSmith.getCompanies().add(softSolution);
        krisSmith.getCompanies().add(softwareMachine);
        krisSmith.getCompanies().add(silverMachine);
        annFive.getCompanies().add(softwareMachine);
        annFive.getCompanies().add(softSolution);
        billBlue.getCompanies().add(softwareMachine);

        companyDao.save(softwareMachine);
        int id = softwareMachine.getId();

        //When
        List<Employee> mrSmiths = employeeDao.retrieveEmployeesWithLastName("Smith");
        List<Company> softCompanies = companyDao.retrieveCompaniesThatNamesStartWith("soft");
        List<Company> threeCharsCompanies = companyDao.retrieveCompaniesWithFirstThreeChars("sil");

        //Then
        try {
            Assert.assertEquals(2, mrSmiths.size());
            Assert.assertEquals(2, softCompanies.size());
            Assert.assertEquals(1, threeCharsCompanies.size());
        } finally {
            //CleanUp
            companyDao.delete(id);
        }
    }

    @Test
    public void testSaveManyToMany() {
        //Given
        Company softwareMachine = new Company("Software Machine");
        Company dataSolution = new Company("Data Solution");
        Company techFuture = new Company("Tech Future");

        Employee johnSmith = new Employee("John", "Smith");
        Employee annFive = new Employee("Ann", "Five");
        Employee billBlue = new Employee("Bill", "Blue");

        softwareMachine.getEmployees().add(johnSmith);
        dataSolution.getEmployees().add(annFive);
        dataSolution.getEmployees().add(billBlue);
        techFuture.getEmployees().add(johnSmith);
        techFuture.getEmployees().add(billBlue);

        johnSmith.getCompanies().add(softwareMachine);
        johnSmith.getCompanies().add(techFuture);
        annFive.getCompanies().add(dataSolution);
        billBlue.getCompanies().add(dataSolution);
        billBlue.getCompanies().add(techFuture);

        //When
        companyDao.save(softwareMachine);
        companyDao.save(dataSolution);
        companyDao.save(techFuture);

        int softwareMachineId = softwareMachine.getId();
        int dataSolutionId = dataSolution.getId();
        int techFutureId = techFuture.getId();

        //Then
        Assert.assertNotEquals(0, softwareMachineId);
        Assert.assertNotEquals(0, dataSolutionId);
        Assert.assertNotEquals(0, techFutureId);

        //CleanUp
        try {
            companyDao.delete(softwareMachineId);
            companyDao.delete(dataSolutionId);
            companyDao.delete(techFutureId);
        } catch (Exception e) {
            // nothing
        }
    }
}