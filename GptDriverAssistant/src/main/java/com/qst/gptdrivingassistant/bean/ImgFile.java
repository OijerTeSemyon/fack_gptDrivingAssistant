package com.qst.gptdrivingassistant.bean;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;

public class ImgFile {
    private File imgfile = new File("");
    public ImgFile() {

	}

    public void setImgfile(File imgfile) {
        this.imgfile = imgfile;
    }

    public File getImgfile() {
        return imgfile;
    }
}
