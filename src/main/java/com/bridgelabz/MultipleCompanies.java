package com.bridgelabz;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class MultipleCompanies {
    public static double findAverageSalary(List<Company> companies) {
        return companies.stream()
                .flatMap(company -> company.getEmployees().stream())
                .mapToDouble(Employee::getSalary)
                .average()
                .orElse(0.0);
    }

    public static double findMaximumSalary(List<Company> companies) {
        return companies.stream()
                .flatMap(company -> company.getEmployees().stream())
                .mapToDouble(Employee::getSalary)
                .max()
                .orElse(0.0);
    }

    public static List<Employee> sortEmployeesBySalary(List<Employee> employees) {
        return employees.stream()
                .sorted(Comparator.comparingDouble(Employee::getSalary).reversed())
                .collect(Collectors.toList());
    }
}
