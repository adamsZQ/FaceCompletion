package cn.edu.hit.ir.dao;


import cn.edu.hit.ir.entity.WantedOrder;

import java.util.List;

public interface WantedOrderMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(WantedOrder record);

    int insertSelective(WantedOrder record);

    WantedOrder selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(WantedOrder record);

    int updateByPrimaryKey(WantedOrder record);

    List<WantedOrder> selectAll();
}