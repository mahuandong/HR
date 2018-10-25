package edu.hebeu.service.impl;

import java.util.List;

import edu.hebeu.entity.Move;
import edu.hebeu.mapper.MoveMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;

import edu.hebeu.entity.Department;
import edu.hebeu.entity.Overtime;
import edu.hebeu.mapper.DepartmentMapper;
import edu.hebeu.service.MoveService;

@Service("moveService")
public class MoveServiceImpl implements MoveService{

    @Autowired
    private MoveMapper moveMapper;

    @Override
    public List<Move> selectAll() {
        return this.moveMapper.selectAll();
    }

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return this.moveMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Move record) {
        return 0;
    }

    @Override
    public int insertSelective(Move record) {
        return this.moveMapper.insertSelective(record);
    }

    @Override
    public Move selectByPrimaryKey(Integer id) {
        return this.moveMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Move record) {
        return this.moveMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Move record) {
        return 0;
    }
}
