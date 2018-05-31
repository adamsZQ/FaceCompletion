package cn.edu.hit.ir.service.impl;

import cn.edu.hit.ir.dao.LibMapper;
import cn.edu.hit.ir.entity.Lib;
import cn.edu.hit.ir.service.ILibService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author 袁明琛
 * @since 1.0 2018/5/15
 */
@Service("libService")
public class LibServiceImpl implements ILibService{

    @Resource
    private LibMapper libMapper;

    @Override
    public List<Lib> getAllLibsByRobotId(Integer robotId) {
        return libMapper.queryLibsByRobotId(robotId);
    }

    @Override
    public Lib getLib(Integer libId) {
        return libMapper.selectByPrimaryKey(libId);
    }

    @Override
    public void addLib(Lib lib) {
        libMapper.insertSelective(lib);
    }

    @Override
    public void deleteLib(Integer libId) {
        libMapper.deleteByPrimaryKey(libId);
    }

    @Override
    public void updateLib(Lib lib) {
        libMapper.updateByPrimaryKeySelective(lib);
    }
}
