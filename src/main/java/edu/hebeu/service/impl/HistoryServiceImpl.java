package edu.hebeu.service.impl;

import java.util.List;

import edu.hebeu.entity.History;
import edu.hebeu.mapper.HistoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;

import edu.hebeu.entity.Department;
import edu.hebeu.entity.Position;
import edu.hebeu.mapper.DepartmentMapper;
import edu.hebeu.mapper.PositionMapper;
import edu.hebeu.service.HistoryService;

@Service
public class HistoryServiceImpl implements HistoryService{

    @Autowired
    private HistoryMapper historyMapper;

    @Override
    public List<History> selectAll() {
        return this.historyMapper.selectAll();
    }

    @Override
    public List<History> selectRetire() {
        return this.historyMapper.selectRetire();
    }


    @Override
    public int deleteByPrimaryKey(Integer id) {
        return this.historyMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(History record) {
        return 0;
    }

    @Override
    public int insertSelective(History record) {
        return this.historyMapper.insertSelective(record);
    }

    @Override
    public History selectByPrimaryKey(Integer id) {
        return this.historyMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(History record) {
        return this.historyMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(History record) {
        return 0;
    }
}
