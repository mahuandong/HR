package edu.hebeu.controller;

import edu.hebeu.entity.Attendance;
import edu.hebeu.entity.Employee;
import edu.hebeu.entity.Wage;
import edu.hebeu.service.AttendanceService;
import edu.hebeu.service.EmployeeService;
import edu.hebeu.service.WageService;
import edu.hebeu.util.MTimeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/wage")
public class WageConterller {

    @Autowired
    private WageService wageService;
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private AttendanceService attendanceService;

    @RequestMapping("WageList.do")
    public String selectAll(Model model){
        List<Wage> list = wageService.selectAll();
        model.addAttribute("aList",list);
        return "admin/wage_list";
    }

    @RequestMapping("/{id}/wageAdd.do")
    public String insertSelective(@PathVariable Integer id, Model model){
        Employee employee = employeeService.selectByPrimaryKey(id);
        model.addAttribute("employee", employee);
        Attendance parameter = new Attendance();
        parameter.setEmployeeNumber(employee.getEmployeeNumber());
        Integer mouth = MTimeUtil.nowMonth();
        Integer nowYear = MTimeUtil.nowYear();
        parameter.setMouth(mouth);
        parameter.setYear(nowYear);
        Integer late = attendanceService.Late(parameter);
        Integer overtime = attendanceService.Overtime(parameter);
        model.addAttribute("late", late);
        model.addAttribute("overtime",overtime);
        return "admin/wage_add";
    }

    @RequestMapping("/add.do")
    public String add(Wage wage) {
        wageService.insertSelective(wage);
        return "forward:/wage/WageList.do";
    }
}
