package com.kodilla.hibernate.manytomany;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@NamedNativeQuery(
        name = "Company.retrieveCompaniesThatNamesStartWith",
        query = "SELECT * FROM COMPANIES " +
                "WHERE COMPANY_NAME REGEXP CONCAT(:FIRSTCHARS, '.*?')",
        resultClass = Company.class
)

@NamedQueries({
        @NamedQuery(
                name = "Company.retrieveCompaniesWithFirstThreeChars",
                query = "FROM Company WHERE SUBSTRING (name,1,3) = :CHARS"),
        @NamedQuery(
                name = "Company.retrieveCompaniesThatNamesContainString",
                query = "FROM Company WHERE name LIKE CONCAT('%',:ARG,'%')")
})


@Entity
@Table(name = "COMPANIES")
public class Company {
    private int id;
    private String name;
    private List<Employee> employees = new ArrayList<>();

    public Company() {
    }

    public Company(String name) {
        this.name = name;
    }

    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "COMPANY_ID")
    public int getId() {
        return id;
    }

    private void setId(int id) {
        this.id = id;
    }

    @NotNull
    @Column(name = "COMPANY_NAME")
    public String getName() {
        return name;
    }

    private void setName(String name) {
        this.name = name;
    }

    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "companies")
    public List<Employee> getEmployees() {
        return employees;
    }

    private void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
}
