package edu.hebeu.mapper;

import edu.hebeu.entity.Contract;

import java.util.List;

public interface ContractMapper {

    List<Contract> selectAll();

    int deleteByPrimaryKey(Integer id);

    int insert(Contract record);

    int insertSelective(Contract record);

    Contract selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Contract record);

    int updateByPrimaryKey(Contract record);
}