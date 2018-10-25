package edu.hebeu.mapper;

import edu.hebeu.entity.History;

import java.util.List;

public interface HistoryMapper {

    List<History> selectAll();

    List<History> selectRetire();

    int deleteByPrimaryKey(Integer id);

    int insert(History record);

    int insertSelective(History record);

    History selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(History record);

    int updateByPrimaryKey(History record);
}