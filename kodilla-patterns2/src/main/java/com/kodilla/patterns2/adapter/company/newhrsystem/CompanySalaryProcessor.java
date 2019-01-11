package com.kodilla.patterns2.adapter.company.newhrsystem;

import java.math.BigDecimal;
import java.util.List;

public class CompanySalaryProcessor implements SalaryProcessor {
    @Override
    public BigDecimal calculateSalaries(List<Employee> employees) {
        return employees.stream()
                .map(employee -> {
                    System.out.println(employee);
                    return employee.getBaseSalary();
                })
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}
