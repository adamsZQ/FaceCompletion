package cn.edu.hit.ir.service.impl;

import cn.edu.hit.ir.entity.Answer;
import cn.edu.hit.ir.entity.Qa;
import cn.edu.hit.ir.service.IParseService;

import java.util.List;

/**
 * @author 袁明琛
 * @since 1.0 2018/5/15
 */
public class ParseServiceImpl implements IParseService{
    @Override
    public int checkFormat(String text) {
        //返回的是错误类型，0表示无错误
        return 0;
    }

    @Override
    public List<Qa> parseXml(String text) {

        return null;
    }

    @Override
    public List<Qa> parseXml(List<String> textList) {
        return null;
    }

    @Override
    public List<Answer> matchAnswer(List<Qa> qas, String inState, String query) {
        return null;
    }
}
