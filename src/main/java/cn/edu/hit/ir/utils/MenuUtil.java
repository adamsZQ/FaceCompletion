package cn.edu.hit.ir.utils;

import cn.edu.hit.ir.entity.Menu;

import java.util.List;

/**
 * @author 袁明琛
 * @since 1.0 2018/5/13
 */
public class MenuUtil {

    public static List<Menu> addMenu(List<Menu> menus,Menu menu,List<Menu> subMenus){
        menus.add(menu);
        menu.setSubMenus(subMenus);
        return menus;
    }
}
