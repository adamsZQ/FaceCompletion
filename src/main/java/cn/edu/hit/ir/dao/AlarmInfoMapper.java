package cn.edu.hit.ir.dao;

import cn.edu.hit.ir.entity.AlarmInfo;

import java.util.List;

public interface AlarmInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AlarmInfo record);

    int insertSelective(AlarmInfo record);

    AlarmInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AlarmInfo record);

    int updateByPrimaryKey(AlarmInfo record);

    List<AlarmInfo> selectByUserId(int userId);
}