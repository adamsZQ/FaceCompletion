package cn.edu.hit.ir.service.impl;

import cn.edu.hit.ir.service.IFileOperateService;

import java.io.File;

/**
 * @author 袁明琛
 * @since 1.0 2018/5/15
 */
public class FileOperateService implements IFileOperateService{
    @Override
    public File getFile(String path) {
        File file = new File(path);
        return file;
    }

    @Override
    public File downLoadFile(String path) {
        //下载文件
        return null;
    }

    @Override
    public boolean uploadFile(Integer robotId, File file) {
        //上传文件，然后在lib中增加一条记录
        return false;
    }

    @Override
    public boolean updateFile(String path, String newContent) {
        //更新文件，覆盖原有的内容
        return false;
    }
}
