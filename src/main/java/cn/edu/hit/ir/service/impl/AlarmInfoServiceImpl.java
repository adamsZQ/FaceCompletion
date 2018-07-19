package cn.edu.hit.ir.service.impl;

import cn.edu.hit.ir.dao.AlarmInfoMapper;
import cn.edu.hit.ir.entity.AlarmInfo;
import cn.edu.hit.ir.service.IAlarmInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("alarmService")
public class AlarmInfoServiceImpl implements IAlarmInfoService {

    @Resource
    AlarmInfoMapper alarmInfoMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return alarmInfoMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(AlarmInfo record) {
        return alarmInfoMapper.insert(record);
    }

    @Override
    public int insertSelective(AlarmInfo record) {
        return alarmInfoMapper.insertSelective(record);
    }

    @Override
    public AlarmInfo selectByPrimaryKey(Integer id) {
        return alarmInfoMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(AlarmInfo record) {
        return alarmInfoMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(AlarmInfo record) {
        return alarmInfoMapper.updateByPrimaryKey(record);
    }
}
