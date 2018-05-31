package cn.edu.hit.ir.service;

import cn.edu.hit.ir.entity.Answer;
import cn.edu.hit.ir.entity.Qa;

import java.util.List;

/**
 * @author 袁明琛
 * @since 1.0 2018/5/15
 */
public interface IParseService {
    //检查文件内容是否符合规范
    public int checkFormat(String text);

    //解析单个文件，返回QA节点数组
    public List<Qa> parseXml(String text);

    //解析多个文件，返回QA节点数组
    public List<Qa> parseXml(List<String> textList);

    //根据输入状态匹配回答
    public List<Answer> matchAnswer(List<Qa> qas,String inState,String query);



}
