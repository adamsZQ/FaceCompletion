package cn.edu.hit.ir.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 袁明琛
 * @since 1.0 2018/5/3
 */
public class Qa {

    private String inState = ""; //可没有，默认为""，接收所有状态
    private List<String> querys = new ArrayList<>(); //不可为空
    private List<Action> actions = new ArrayList<>();//可为空
    private List<Answer> answers = new ArrayList<>();//不可为空

    public Qa(List<String> querys, List<Answer> answers) {
        this.querys = querys;
        this.answers = answers;
    }

    public Qa(String inState, List<String> querys, List<Action> actions, List<Answer> answers) {
        this.inState = inState;
        this.querys = querys;
        this.actions = actions;
        this.answers = answers;
    }

    public String getInState() {
        return inState;
    }

    public void setInState(String inState) {
        this.inState = inState;
    }

    public List<String> getQuerys() {
        return querys;
    }

    public void setQuerys(List<String> querys) {
        this.querys = querys;
    }

    public List<Action> getActions() {
        return actions;
    }

    public void setActions(List<Action> actions) {
        this.actions = actions;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }
}
