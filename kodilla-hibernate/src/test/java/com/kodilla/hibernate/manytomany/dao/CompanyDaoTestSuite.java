package com.kodilla.hibernate.manytomany.dao;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.Employee;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CompanyDaoTestSuite {
    @Autowired
    private CompanyDao companyDao;

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
        Assert.assertNotEquals(0,softwareMachineId);
        Assert.assertNotEquals(0,dataSolutionId);
        Assert.assertNotEquals(0,techFutureId);

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