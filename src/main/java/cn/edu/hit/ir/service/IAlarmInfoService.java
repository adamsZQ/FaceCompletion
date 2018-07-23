package cn.edu.hit.ir.service;

import cn.edu.hit.ir.entity.AlarmInfo;

import java.util.List;

public interface IAlarmInfoService {
    int deleteByPrimaryKey(Integer id);

    int insert(AlarmInfo record);

    int insertSelective(AlarmInfo record);

    AlarmInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AlarmInfo record);

    int updateByPrimaryKey(AlarmInfo record);

    List<AlarmInfo> selectByUserId(int userId);

}
