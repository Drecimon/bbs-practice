package cn.ljlin233.util.wangeditor.entity;

import java.util.ArrayList;

import lombok.Getter;
import lombok.Setter;

/**
 * ImageUpload
 */
@Setter
@Getter
public class ImageUpload {

    private int errno;

    private ArrayList<String> data;


    public ImageUpload() {
        this.errno = 0;
        this.data = new ArrayList<>();
    }

    public void addImage(String path) {
        data.add(path);
    }

    @Override
    public String toString() {
        return "ImageUpload [data=" + data + ", errno=" + errno + "]";
    }
    
}