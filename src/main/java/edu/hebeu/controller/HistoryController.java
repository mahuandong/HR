package edu.hebeu.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import edu.hebeu.entity.Employee;
import edu.hebeu.entity.History;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.baomidou.mybatisplus.plugins.Page;

import edu.hebeu.service.EmployeeService;
import edu.hebeu.service.HistoryService;
import edu.hebeu.util.MTimeUtil;

@Controller
@RequestMapping("/history")
public class HistoryController {

	@Autowired
	private HistoryService historyService;
	@Autowired
	private EmployeeService employeeService;
	
	@RequestMapping("/retireListPage.do")
	public String selectRetireByPage(Model model){
		List<History> page = historyService.selectRetire();
		model.addAttribute("page", page);
		return "admin/retire_list";
	}
	
	@RequestMapping("/{id}/detail.do")
	public String selectHistory(@PathVariable Integer id, Model model){
		History history = historyService.selectByPrimaryKey(id);
		model.addAttribute("history", history);
		return "admin/history_detail";
	}

	@RequestMapping("/{id}/toUpdate.do")
	public String toUpdate(Model model, @PathVariable Integer id){
		History history = historyService.selectByPrimaryKey(id);
		if (history.getStatus().equals("在职")) {
			Employee employee = employeeService.selectByEmployeeNumber(history.getEmployeeNumber());
			return "forward:/employee/"+ employee.getId() +"/toUpdate.do";
		}else{
			model.addAttribute("history", history);
			return "admin/history_update";
		}
	}
	
	@RequestMapping("/{id}/updateRetire.do")
	public String updateRetire(@PathVariable Integer id, Integer employeeNumber,
							   String name, String gender, String birthday, String telephone, String email,
							   String address, String photo, String education, String inTime, String outTime,
							   Integer departmentNumber, Integer positionNumber, String status, String home,
							   String notes, Integer idcard) throws ParseException {
		History history = new History();
		history.setId(id);
		history.setEmployeeNumber(employeeNumber);
		history.setName(name);
		history.setGender(gender);
		SimpleDateFormat sdf = new SimpleDateFormat( "yyyy-MM-dd");
		history.setBirthday(sdf.parse(birthday));
		history.setTelephone(telephone);
		history.setEmail(email);
		history.setAddress(address);
		history.setPhoto(photo);
		history.setEducation(education);
		history.setDepartmentNumber(departmentNumber);
		history.setPositionNumber(positionNumber);
		history.setStatus(status);
		history.setNotes(notes);
		history.setIdcard(idcard);
		history.setBirthday(MTimeUtil.stringParse(inTime));
		history.setBirthday(sdf.parse(outTime));
		history.setHome(home);
		historyService.updateByPrimaryKeySelective(history);
		return "forward:/history/retireListPage.do";
	}
	
	@RequestMapping("/listPage.do")
	public String selectListByPage(Model model){
		List<History> page = historyService.selectAll();
		model.addAttribute("page", page);
		return "admin/history_list";
	}
	
	@RequestMapping("/{id}/update.do")
	public String updateById(@PathVariable Integer id, Integer employeeNumber,
							 String name, String gender, String birthday, String telephone, String email,
							 String address, String photo, String education, String inTime, String outTime,
							 Integer departmentNumber, Integer positionNumber, String status, String home,
							 String notes, Integer idcard) throws ParseException {
		History history = new History();
		history.setId(id);
		history.setEmployeeNumber(employeeNumber);
		history.setName(name);
		history.setGender(gender);
		SimpleDateFormat sdf = new SimpleDateFormat( "yyyy-MM-dd");
		history.setBirthday(sdf.parse(birthday));
		history.setTelephone(telephone);
		history.setEmail(email);
		history.setAddress(address);
		history.setPhoto(photo);
		history.setEducation(education);
		history.setDepartmentNumber(departmentNumber);
		history.setPositionNumber(positionNumber);
		history.setStatus(status);
		history.setNotes(notes);
		history.setIdcard(idcard);
		history.setBirthday(MTimeUtil.stringParse(inTime));
		history.setBirthday(sdf.parse(outTime));
		history.setHome(home);
		historyService.updateByPrimaryKeySelective(history);
		return "forward:/history/listPage.do?pageNo=1";
	}
	
	@RequestMapping("/list.do")
	public String list(Model model){
		List<History> hList = historyService.selectAll();
		model.addAttribute("hList", hList);
		return "admin/history_list";
	}
}
