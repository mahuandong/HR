package edu.hebeu.mapper;

import edu.hebeu.entity.Move;

import java.util.List;

public interface MoveMapper {

    List<Move> selectAll();

    int deleteByPrimaryKey(Integer id);

    int insert(Move record);

    int insertSelective(Move record);

    Move selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Move record);

    int updateByPrimaryKey(Move record);
}