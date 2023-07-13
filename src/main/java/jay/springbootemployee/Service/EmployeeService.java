package jay.springbootemployee.Service;

import jay.springbootemployee.Models.Employee;
import jay.springbootemployee.Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    //CREATE
    public Employee createEmployee(Employee employee){
        return employeeRepository.save(employee);
    }

    //READ
    public List<Employee> getEmployees(){
        return employeeRepository.findAll();
    }

    //DELETE
    public void deleteEmployee(Long id){
        employeeRepository.deleteById(id);
    }

    //UPDATE
    public Employee updateEmployee(Long id, Employee employee){
        Employee emp = employeeRepository.findById(id).get();
        emp.setFirstName(employee.getFirstName());
        emp.setLastName(employee.getLastName());
        emp.setEmailId(employee.getEmailId());
        return employeeRepository.save(emp);
    }
}
