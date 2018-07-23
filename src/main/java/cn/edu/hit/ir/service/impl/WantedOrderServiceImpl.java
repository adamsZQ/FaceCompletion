package cn.edu.hit.ir.service.impl;

import cn.edu.hit.ir.dao.WantedOrderMapper;
import cn.edu.hit.ir.entity.WantedOrder;
import cn.edu.hit.ir.service.IWantedOrderService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("wantedOrderService")
public class WantedOrderServiceImpl implements IWantedOrderService {

    @Resource
    WantedOrderMapper wantedOrderMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return wantedOrderMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(WantedOrder record) {
        return wantedOrderMapper.insert(record);
    }

    @Override
    public int insertSelective(WantedOrder record) {
        return wantedOrderMapper.insertSelective(record);
    }

    @Override
    public WantedOrder selectByPrimaryKey(Integer id) {
        return wantedOrderMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(WantedOrder record) {
        return wantedOrderMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(WantedOrder record) {
        return wantedOrderMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<WantedOrder> selectAll() {
        return wantedOrderMapper.selectAll();
    }
}
