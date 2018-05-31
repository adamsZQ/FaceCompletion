package cn.edu.hit.ir.service;

import cn.edu.hit.ir.entity.Lib;

import java.io.File;

/**
 * @author 袁明琛
 * @since 1.0 2018/5/15
 */
public interface IFileOperateService {
    //通过路径找到指定的文档，返回指定的文件
    public File getFile(String path);

    //通过文件路径下载文档
    public File downLoadFile(String path);

    //上传一个新的文件，关联倒一个机器人
    public boolean uploadFile(Integer robotId,File file);

    //更新一个文件的内容
    public boolean updateFile(String path,String newContent);
}
