package edu.hebeu.service.impl;

import edu.hebeu.entity.Wage;
import edu.hebeu.mapper.WageMapper;
import edu.hebeu.service.WageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("wageService")
public class WageServiceImpl implements WageService {

    @Autowired
    private WageMapper wageMapper;

    @Override
    public List<Wage> selectAll() {
        return this.wageMapper.selectAll();
    }

    @Override
    public int insertSelective(Wage record) {
        return this.wageMapper.insertSelective(record);
    }
}
