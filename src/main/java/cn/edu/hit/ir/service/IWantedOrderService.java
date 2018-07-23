package cn.edu.hit.ir.service;

import cn.edu.hit.ir.entity.WantedOrder;

import java.util.List;

public interface IWantedOrderService {
    int deleteByPrimaryKey(Integer id);

    int insert(WantedOrder record);

    int insertSelective(WantedOrder record);

    WantedOrder selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(WantedOrder record);

    int updateByPrimaryKey(WantedOrder record);

    List<WantedOrder> selectAll();
}
