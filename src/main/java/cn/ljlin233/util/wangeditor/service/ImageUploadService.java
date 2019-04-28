package cn.ljlin233.util.wangeditor.service;

import org.springframework.web.multipart.MultipartFile;

import cn.ljlin233.util.wangeditor.entity.ImageUpload;

/**
 * ImageUploadService
 */
public interface ImageUploadService {

    ImageUpload saveImages(MultipartFile[] imageFiles);

}