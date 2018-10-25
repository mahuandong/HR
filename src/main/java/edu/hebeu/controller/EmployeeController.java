package edu.hebeu.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import edu.hebeu.entity.Employee;
import edu.hebeu.entity.History;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;

import edu.hebeu.entity.Department;
import edu.hebeu.entity.Position;
import edu.hebeu.service.DepartmentService;
import edu.hebeu.service.EmployeeService;
import edu.hebeu.service.HistoryService;
import edu.hebeu.service.PositionService;
import edu.hebeu.util.MTimeUtil;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	@Autowired
	private DepartmentService departmentService;
	@Autowired
	private PositionService positionService;
	@Autowired
	private HistoryService historyService;
	
	@RequestMapping("/login.do")
	public String toLogin(){
		return "login";
	}
	
	@RequestMapping("/checkLogin.do")
	public String checkLogin(HttpSession session,Integer employeeNumber ,String password){
		Employee employee = new Employee();
		employee.setEmployeeNumber(employeeNumber);
		employee.setPassword(password);
		Employee employee2 =  employeeService.checkLogin(employee);
		if (employee2 != null) {
            session.setAttribute("loged", employee2);
			String level = employee2.getPositionName();
			if (level.equals("人事部主任")) {
				return "admin/index1";
			}else if (level.equals("人事部员工")) {
				return "admin/index2";
			}else if (level.equals("部门主任")) {
				return "admin/index3";
			}else {
				return "admin/index4";
			}
		}else{
			return "login";
		}
	}
	
	@RequestMapping("/welcome.do")
	public String toWelcome(){
		return "welcome";
	}

	@RequestMapping("/listPage.do")
	public String selectList(Model model){
		List<Employee> employeesList = employeeService.selectAll();
		model.addAttribute("page", employeesList);
		return "admin/employee_list";
	}

	@RequestMapping("/addwagelist.do")
	public String selectWageList(Model model){
		List<Employee> employeesList = employeeService.selectAll();
		model.addAttribute("employeesList", employeesList);
		return "admin/wage_addlist";
	}
	
	@RequestMapping("/{id}/detial.do")
	public String selectEmployee(@PathVariable Integer id, Model model){
		Employee employee = employeeService.selectByPrimaryKey(id);
		model.addAttribute("employee", employee);
		return "admin/employee_detail";
	}
	
	@RequestMapping("/toAdd.do")
	public String toAdd(Model model){
		List<History> eList = historyService.selectAll();
		model.addAttribute("employeeNumber",eList.get(0).getEmployeeNumber()+1);
		List<Department> dList = departmentService.selectList(new EntityWrapper<Department>());
		model.addAttribute("dList", dList);
		List<Position> pList = positionService.selectList(new EntityWrapper<Position>());
		model.addAttribute("pList", pList);
		return "admin/employee_add";
	}
	
	@RequestMapping("/add.do")
	public String add(Integer employeeNumber, String name, String gender, String birthday, String telephone,
					  String email, String address, String photo, String education,
					  String departmentName,  String positionName,
					  String inTime, String password, String notes, Integer idcard) throws ParseException {
		Employee employee = new Employee();
		employee.setEmployeeNumber(employeeNumber);
		employee.setName(name);
		employee.setGender(gender);
		SimpleDateFormat sdf = new SimpleDateFormat( "yyyy-MM-dd");
		employee.setBirthday(sdf.parse(birthday));
		employee.setTelephone(telephone);
		employee.setEmail(email);
		employee.setAddress(address);
		employee.setPhoto(photo);
		employee.setEducation(education);
		employee.setDepartmentName(departmentName);
		employee.setPositionName(positionName);
		employee.setPassword(password);
		employee.setNotes(notes);
		employee.setIdcard(idcard);
		employee.setBirthday(MTimeUtil.stringParse(inTime));
		employeeService.insertSelective(employee);
		return "forward:/employee/listPage.do";
	}
	
	@RequestMapping("/{id}/toUpdate.do")
	public String toUpdate(Model model, @PathVariable Integer id){
		Employee employee = employeeService.selectByPrimaryKey(id);
		model.addAttribute("employee", employee);
		List<Department> dList = departmentService.selectList(new EntityWrapper<Department>());
		model.addAttribute("dList", dList);
		List<Position> pList = positionService.selectList(new EntityWrapper<Position>());
		model.addAttribute("pList", pList);
		return "admin/employee_update";
	}
	
	@RequestMapping("/{id}/update.do")
	public String updateById(@PathVariable Integer id,Integer employeeNumber, String name, String gender, String birthday, String telephone,
							 String email, String address, String photo, String education,
							 String password, String notes, Integer idcard) throws ParseException {
		Employee employee = new Employee();
		employee.setId(id);
		employee.setEmployeeNumber(employeeNumber);
		employee.setName(name);
		employee.setGender(gender);
		SimpleDateFormat sdf = new SimpleDateFormat( "yyyy-MM-dd");
		employee.setBirthday(sdf.parse(birthday));
		employee.setTelephone(telephone);
		employee.setEmail(email);
		employee.setAddress(address);
		employee.setPhoto(photo);
		employee.setEducation(education);
		employee.setPassword(password);
		employee.setNotes(notes);
		employee.setIdcard(idcard);
		employeeService.updateByPrimaryKeySelective(employee);
		return "forward:/employee/listPage.do";
	}
	
	@RequestMapping("/{id}/delete.do")
	public String deleteById(@PathVariable Integer id){
		employeeService.deleteByPrimaryKey(id);
		return "forward:/employee/listPage.do";
	}
	
	@RequestMapping("/oneself/{id}/detial.do")
	public String selectEmployee2(@PathVariable Integer id, Model model){
		Employee employee = employeeService.selectByPrimaryKey(id);
		model.addAttribute("employee", employee);
		return "admin/oneself_detail";
	}
	
	@RequestMapping("/oneself/{id}/toUpdate.do")
	public String toUpdate2(Model model, @PathVariable Integer id){
		Employee employee = employeeService.selectByPrimaryKey(id);
		model.addAttribute("employee", employee);
		return "admin/oneself_update";
	}

	@RequestMapping("/logout.do")
	public String logout(HttpSession session){
		session.removeAttribute("loged");
		return "login";
	}
		
}
