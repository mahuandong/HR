package edu.hebeu.service;

import edu.hebeu.entity.Wage;

import java.util.List;

public interface WageService {
    List<Wage> selectAll();

    int insertSelective(Wage record);
}
