package edu.hebeu.service;

import com.baomidou.mybatisplus.service.IService;
import edu.hebeu.entity.Employee;

import java.util.List;

public interface EmployeeService {

	Employee checkLogin(Employee record);

	List<Employee> selectAll();

	Employee selectByEmployeeNumber(Integer employeeNumber);

	int deleteByPrimaryKey(Integer id);

	int insert(Employee record);

	int insertSelective(Employee record);

	Employee selectByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(Employee record);

	int updateByPrimaryKey(Employee record);
}
