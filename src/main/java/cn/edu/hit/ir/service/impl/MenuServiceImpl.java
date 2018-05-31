package cn.edu.hit.ir.service.impl;

import cn.edu.hit.ir.dao.MenuMapper;
import cn.edu.hit.ir.entity.Menu;
import cn.edu.hit.ir.service.IMenuService;
import cn.edu.hit.ir.utils.MenuUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 袁明琛
 * @since 1.0 2018/5/13
 */
@Service("menuService")
public class MenuServiceImpl implements IMenuService {

    @Resource
    private MenuMapper menuMapper;
    @Override
    public List<Menu> selectAll() {
        List<Menu> menus = new ArrayList<>();
        List<Menu> subMenus = new ArrayList<>();
        Menu menu;
        Menu subMenu;

        menu = new Menu("1","0","功能菜单","","&#xe716;");
        subMenu = new Menu("1.1","1","人脸还原","system/faceCompletion");
        subMenus.add(subMenu);
        subMenu = new Menu("1.2","1","人脸比对","system/faceCompare");
        subMenus.add(subMenu);
        subMenu = new Menu("1.3","1","信息发布","system/addMessage");
        subMenus.add(subMenu);
        subMenu = new Menu("1.4","1","报警信息","system/alertRecord");
        subMenus.add(subMenu);
        subMenu = new Menu("1.5","1","通缉令信息","system/Message");
        subMenus.add(subMenu);
        MenuUtil.addMenu(menus,menu,subMenus);

        subMenus = new ArrayList<>();
        return menus;
    }
}
