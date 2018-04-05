/*
 * 
 * 
 * 
 */
package com.quhaodian.adminstore.controller.admin;

import com.quhaodian.plug.data.service.StorageService;
import com.quhaodian.plug.data.vo.FileInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * Controller - 文件处理
 * 
 * 
 * 
 */
@Controller
@RequestMapping("/admin/file")
public class FileAction {

    @Autowired
    StorageService storageService;

	public String uploadLocal(FileInfo.FileType fileType, MultipartFile multipartFile) {
		return storageService.uploadLocal(fileType,multipartFile);
	}

	/**
	 * 上传
	 */
	@ResponseBody
	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	public FileResponse upload(FileInfo.FileType fileType, MultipartFile file, HttpServletResponse response) {

        FileResponse result=new FileResponse();
		Map<String, Object> data = new HashMap<String, Object>();
		String url = storageService.upload(fileType, file);
        result.setUrl(url);
		return result;
	}


	public static class FileResponse implements Serializable {

        private int code;


        private String msg;


        private String url;

        public int getCode() {
            return code;
        }

        public void setCode(int code) {
            this.code = code;
        }

        public String getMsg() {
            return msg;
        }

        public void setMsg(String msg) {
            this.msg = msg;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }
}