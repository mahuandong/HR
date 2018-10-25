package edu.hebeu.controller;

import edu.hebeu.entity.Contract;
import edu.hebeu.entity.Wage;
import edu.hebeu.service.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/contract")
public class ContractConroller {

    @Autowired
    private ContractService contractService;

    @RequestMapping("contractList.do")
    public String selectAll(Model model){
        List<Contract> list = contractService.selectAll();
        model.addAttribute("aList",list);
        return "admin/contract_list";
    }

    @RequestMapping("/{id}/contractUpdate.do")
    public String update(Model model, @PathVariable Integer id){
        Contract contract = contractService.selectByPrimaryKey(id);
        model.addAttribute("contract",contract);
        return "admin/contract_update";
    }

    @RequestMapping("/{id}/update.do")
    public String update(@PathVariable Integer id, Integer employeeNumber, String laborContractTime,
                         Integer laborContractStaut, String trainingContractTime, Integer trainingContractStaut,
                         Integer secrecyStaut){
        Contract contract = new Contract();
        contract.setId(id);
        contract.setEmployeeNumber(employeeNumber);
        contract.setLaborContractTime(laborContractTime);
        contract.setLaborContractStaut(laborContractStaut);
        contract.setTrainingContractTime(trainingContractTime);
        contract.setTrainingContractStaut(trainingContractStaut);
        contract.setSecrecyStaut(secrecyStaut);
        contractService.updateByPrimaryKeySelective(contract);
        return "forward:/contract/contractList.do";
    }

    @RequestMapping("/toAdd.do")
    public String toAdd(){
        return "admin/contract_add";
    }

    @RequestMapping("/add.do")
    public String Add(Contract contract){
        contractService.insertSelective(contract);
        return "forward:/contract/contractList.do";
    }

    @RequestMapping("/{id}/delete.do")
    public String delete(@PathVariable Integer id){
        contractService.deleteByPrimaryKey(id);
        return "forward:/contract/contractList.do";
    }
}
