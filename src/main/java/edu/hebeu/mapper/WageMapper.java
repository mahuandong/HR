package edu.hebeu.mapper;

import edu.hebeu.entity.Wage;

import java.util.List;

public interface WageMapper {

    List<Wage> selectAll();

    int insertSelective(Wage record);
}
