package com.bridgelabz;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MultipleCompaniesTest {
    /*
    Apply TDD approach to add multiple Companies with each company containing multiple employees.
    Store the companies in a collection and apply stream api to find
    1> Average salary accross the companies
    2> Maximum salary accross the companies
    3> Sort the employees in a particular company based on salary in descending order(Use your own comparator)
     */



    @Test
    public void testAddCompany() {
        Company company = new Company("ABC Inc.");
        assertNotNull(company);
        Assertions.assertEquals("ABC Inc.", company.getName());
    }

    @Test
    public void testAddEmployeeToCompany() {
        Company company = new Company("ABC Inc.");
        Employee employee = new Employee(1, "Swapnil", 1000.0);
        company.addEmployee(employee);
        assertEquals(1, company.getEmployees().size());
        Assertions.assertEquals("Swapnil", company.getEmployees().get(0).getName());
    }

    @Test
    public void testFindMaxSalary() {
        Company company1 = new Company("ABC Inc.");
        company1.addEmployee(new Employee(1, "Swapnil", 1000.0));
        company1.addEmployee(new Employee(2, "Shubham", 2000.0));

        Company company2 = new Company("PQR Corp.");
        company2.addEmployee(new Employee(3, "Sarthak", 3000.0));
        company2.addEmployee(new Employee(4, "Kunal", 4000.0));

        List<Company> companies = Arrays.asList(company1, company2);

        double expected = 4000.0;
        double actual = MultipleCompanies.findMaximumSalary(companies);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testFindAverageSalary() {
        Company company1 = new Company("ABC Inc.");
        company1.addEmployee(new Employee(1, "Swapnil", 1000.0));
        company1.addEmployee(new Employee(2, "Shubham", 2000.0));

        Company company2 = new Company("PQR Corp.");
        company2.addEmployee(new Employee(3, "Sarthak", 3000.0));
        company2.addEmployee(new Employee(4, "Kunal", 4000.0));

        List<Company> companies = Arrays.asList(company1, company2);

        double expected = 2500.0;
        double actual = MultipleCompanies.findAverageSalary(companies);

        Assertions.assertEquals(expected, actual);
    }



        @Test
        public void testSortEmployeesBySalary () {
            Company company = new Company("ABC Inc.");
            company.addEmployee(new Employee(1, "Swapnil", 1000.0));
            company.addEmployee(new Employee(2, "Shubham", 2000.0));
            company.addEmployee(new Employee(3, "Sarthak", 3000.0));
            company.addEmployee(new Employee(4, "Kunal", 4000.0));

            List<Employee> expected = Arrays.asList(
                    new Employee(4, "Kunal", 4000.0),
                    new Employee(3, "Sarthak", 3000.0),
                    new Employee(2, "Shubham", 2000.0),
                    new Employee(1, "Swapnil", 1000.0)

            );

            List<Employee> actual = MultipleCompanies.sortEmployeesBySalary(company.getEmployees());

            Assertions.assertEquals(expected, actual);

    }
}
