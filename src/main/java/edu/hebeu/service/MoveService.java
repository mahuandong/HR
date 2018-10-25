package edu.hebeu.service;

import java.util.List;

import com.baomidou.mybatisplus.service.IService;
import edu.hebeu.entity.Move;

public interface MoveService {
    List<Move> selectAll();

    int deleteByPrimaryKey(Integer id);

    int insert(Move record);

    int insertSelective(Move record);

    Move selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Move record);

    int updateByPrimaryKey(Move record);
}
