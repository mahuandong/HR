package edu.hebeu.service.impl;

import edu.hebeu.entity.Contract;
import edu.hebeu.mapper.ContractMapper;
import edu.hebeu.service.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContractServiceImpl implements ContractService {

    @Autowired
    private ContractMapper contractMapper;

    @Override
    public List<Contract> selectAll() {
        return this.contractMapper.selectAll();
    }

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return this.contractMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insertSelective(Contract record) {
        return this.contractMapper.insertSelective(record);
    }

    @Override
    public Contract selectByPrimaryKey(Integer id) {
        return this.contractMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Contract record) {
        return this.contractMapper.updateByPrimaryKeySelective(record);
    }
}
