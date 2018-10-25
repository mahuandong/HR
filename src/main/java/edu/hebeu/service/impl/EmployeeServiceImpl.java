package edu.hebeu.service.impl;

import edu.hebeu.entity.Employee;
import edu.hebeu.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.hebeu.mapper.DepartmentMapper;
import edu.hebeu.mapper.PositionMapper;
import edu.hebeu.service.EmployeeService;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	private EmployeeMapper employeeMapper;

	@Override
	public Employee checkLogin(Employee record) {
		return this.employeeMapper.checkLogin(record);
	}

	@Override
	public List<Employee> selectAll() {
		return this.employeeMapper.selectAll();
	}

	@Override
	public Employee selectByEmployeeNumber(Integer employeeNumber) {
		return this.employeeMapper.selectByEmployeeNumber(employeeNumber);
	}

	@Override
	public int deleteByPrimaryKey(Integer id) {
		return this.employeeMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(Employee record) {
		return this.employeeMapper.insert(record);
	}

	@Override
	public int insertSelective(Employee record) {
		return this.employeeMapper.insertSelective(record);
	}

	@Override
	public Employee selectByPrimaryKey(Integer id) {
		return this.employeeMapper.selectByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKeySelective(Employee record) {
		return this.employeeMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(Employee record) {
		return 0;
	}
}
