package cn.ljlin233.util.wangeditor.service;


import java.io.File;
import java.io.FileInputStream;
import java.nio.file.Files;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItem;
import org.apache.commons.io.IOUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import cn.ljlin233.config.RootConfig;
import cn.ljlin233.config.WebConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { RootConfig.class, WebConfig.class })
@WebAppConfiguration
/**
 * ImageUploadServiceTest
 */
public class ImageUploadServiceTest {

    
    @Autowired
    private ImageUploadService imageUploadService;


    @Test
    public void testImageService() throws Exception {
        
		File file = new File("C:/Users/ljlin/Desktop/neko.jpg");
		
		FileItem fileItem = new DiskFileItem(
				"formFieldName",
				Files.probeContentType(file.toPath()),
				false,
				file.getName(),
				(int) file.length(),
				file.getParentFile());
	
		IOUtils.copy(new FileInputStream(file), fileItem.getOutputStream());
		
		MultipartFile cMultiFile = new CommonsMultipartFile(fileItem);

		MultipartFile[] files = new MultipartFile[1];
		files[0] = cMultiFile;
		//assertEquals("image/jpeg", cMultiFile.getContentType());
        imageUploadService.saveImages(files);
    
    }

}