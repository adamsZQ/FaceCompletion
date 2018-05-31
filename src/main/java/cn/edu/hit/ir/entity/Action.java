package cn.edu.hit.ir.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 袁明琛
 * @since 1.0 2018/5/3
 */
public class Action {
    private String actionName; //不可为空
    private List<Param> params = new ArrayList<>(); //可为空

    public Action() {
    }

    public Action(String actionName) {
        this.actionName = actionName;
    }

    public Action(String actionName, List<Param> params) {
        this.actionName = actionName;
        this.params = params;
    }

    public String getActionName() {
        return actionName;
    }

    public void setActionName(String actionName) {
        this.actionName = actionName;
    }

    public List<Param> getParams() {
        return params;
    }

    public void setParams(List<Param> params) {
        this.params = params;
    }
}
