package com.kodilla.hibernate.manytomany.facade;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.Employee;
import com.kodilla.hibernate.manytomany.dao.CompanyDao;
import com.kodilla.hibernate.manytomany.dao.EmployeeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public final class EmploymentFacade {
    private EmployeeDao employeeDao;
    private CompanyDao companyDao;

    @Autowired
    public EmploymentFacade(EmployeeDao employeeDao, CompanyDao companyDao) {
        this.employeeDao = employeeDao;
        this.companyDao = companyDao;
    }

    public List<Employee> findEmployeeContaining(String anyString) {
        return employeeDao.retrieveEmployeesThatNamesContainString(anyString);
    }

    public List<Company> findCompaniesContaining(String anyString) {
        return companyDao.retrieveCompaniesThatNamesContainString(anyString);
    }
}
