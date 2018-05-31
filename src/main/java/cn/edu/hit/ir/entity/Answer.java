package cn.edu.hit.ir.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 袁明琛
 * @since 1.0 2018/5/3
 */
public class Answer {
    private String content; //不可为空
    private List<Param> filters = new ArrayList<>();//可为空
    private String OutState = ""; //可为空

    public Answer(String content) {
        this.content = content;
    }

    public Answer(String content, List<Param> filters, String outState) {
        this.content = content;
        this.filters = filters;
        OutState = outState;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public List<Param> getFilters() {
        return filters;
    }

    public void setFilters(List<Param> filters) {
        this.filters = filters;
    }

    public String getOutState() {
        return OutState;
    }

    public void setOutState(String outState) {
        OutState = outState;
    }


}
