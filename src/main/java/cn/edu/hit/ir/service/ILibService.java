package cn.edu.hit.ir.service;

import cn.edu.hit.ir.entity.Lib;

import java.util.List;

/**
 * @author 袁明琛
 * @since 1.0 2018/5/15
 */
public interface ILibService {
    public List<Lib> getAllLibsByRobotId(Integer robotId);
    public Lib getLib(Integer libId);
    public void addLib(Lib lib);
    public void deleteLib(Integer libId);
    public void updateLib(Lib lib);
}
