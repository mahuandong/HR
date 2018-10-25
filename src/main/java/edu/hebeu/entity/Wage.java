package edu.hebeu.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
@TableName("wage")
public class Wage extends Model<Wage> implements Serializable {

    private static final long serialVersionUID = 1L;
    @TableId
    private Integer id ;
    private String name;
    private Integer employeeNumber;
    private Float gangwei;
    private Float grade;
    private Float gongling;
    private Float xueli;
    private Float kaoqin;
    private Float shebao;
    private Float jixiao;
    private Float geren;
    private Float salary;
    private Integer month;
    private Integer year;
    @TableField(exist=false)
    private Employee employee;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getEmployeeNumber() {
        return employeeNumber;
    }

    public void setEmployeeNumber(Integer employeeNumber) {
        this.employeeNumber = employeeNumber;
    }

    public Float getGangwei() {
        return gangwei;
    }

    public void setGangwei(Float gangwei) {
        this.gangwei = gangwei;
    }

    public Float getGrade() {
        return grade;
    }

    public void setGrade(Float grade) {
        this.grade = grade;
    }

    public Float getGongling() {
        return gongling;
    }

    public void setGongling(Float gongling) {
        this.gongling = gongling;
    }

    public Float getXueli() {
        return xueli;
    }

    public void setXueli(Float xueli) {
        this.xueli = xueli;
    }

    public Float getKaoqin() {
        return kaoqin;
    }

    public void setKaoqin(Float kaoqin) {
        this.kaoqin = kaoqin;
    }

    public Float getShebao() {
        return shebao;
    }

    public void setShebao(Float shebao) {
        this.shebao = shebao;
    }

    public Float getJixiao() {
        return jixiao;
    }

    public void setJixiao(Float jixiao) {
        this.jixiao = jixiao;
    }

    public Float getGeren() {
        return geren;
    }

    public void setGeren(Float geren) {
        this.geren = geren;
    }

    public Float getSalary() {
        return salary;
    }

    public void setSalary(Float salary) {
        this.salary = salary;
    }

    public Integer getMonth() {
        return month;
    }

    public void setMonth(Integer month) {
        this.month = month;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }
}
