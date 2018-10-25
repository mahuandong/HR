package edu.hebeu.service;

import edu.hebeu.entity.Contract;

import java.util.List;

public interface ContractService {

    List<Contract> selectAll();

    int deleteByPrimaryKey(Integer id);

    int insertSelective(Contract record);

    Contract selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Contract record);

}
