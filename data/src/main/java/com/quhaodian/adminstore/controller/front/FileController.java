/*
 * 
 * 
 * 
 */
package com.quhaodian.adminstore.controller.front;

import com.quhaodian.plug.data.service.StorageService;
import com.quhaodian.plug.data.vo.FileInfo;
import org.apache.commons.fileupload.FileItemStream;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FileUtils;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.support.DefaultMultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * Controller - 文件处理
 */
@Controller
@RequestMapping("/file")
public class FileController {

    @Autowired
    StorageService storageService;

    public String uploadLocal(FileInfo.FileType fileType, MultipartFile multipartFile) {
        return storageService.uploadLocal(fileType, multipartFile);
    }

    /**
     * 上传
     */
    @ResponseBody
    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public FileResponse upload(FileInfo.FileType fileType, MultipartFile file, HttpServletResponse response) {

        FileResponse result = new FileResponse();
        Map<String, Object> data = new HashMap<String, Object>();
        String url = storageService.upload(fileType, file);
        result.setUrl(url);
        return result;
    }

    @ResponseBody
    @RequestMapping(value = "/ueupload")
    public ResponseEntity<Map<String, Object>> ueUpload( HttpServletRequest request, HttpServletResponse response) {
        JSONObject result = new JSONObject();
        String action = request.getParameter("action");
        if ("config".equals(action)) {
            result.put("imageActionName", "uploadimage");
            result.put("imageFieldName", "upfile");
            result.put("imageMaxSize", 2048000);
            result.put("imageCompressEnable", true);
            result.put("imageCompressBorder", 1600);
            result.put("imageInsertAlign", "none");
            result.put("imageUrlPrefix", "");
            JSONArray array = new JSONArray();
            array.put(".png");
            array.put(".jpg");
            array.put(".jpeg");
            array.put(".gif");
            array.put(".bmp");
            result.put("imageAllowFiles", array);
        } else if ("uploadimage".equals(action)) {
            boolean isAjaxUpload = request.getHeader( "X_Requested_With" ) != null;

            if (!ServletFileUpload.isMultipartContent(request)) {
               // return new BaseState(false, AppInfo.NOT_MULTIPART_CONTENT);
            }
            FileItemStream fileStream = null;

            ServletFileUpload upload = new ServletFileUpload(
                    new DiskFileItemFactory());

            if ( isAjaxUpload ) {
                upload.setHeaderEncoding( "UTF-8" );
            }
            if (request instanceof DefaultMultipartHttpServletRequest){
                DefaultMultipartHttpServletRequest request1=(DefaultMultipartHttpServletRequest)request;
                MultipartFile file=  request1.getFile("upfile");

                String url = storageService.upload(FileInfo.FileType.image, file);
                result.put("url",url);
                result.put("size",""+file.getSize());
                result.put("original",""+file.getOriginalFilename());
                result.put("title",""+file.getOriginalFilename());
            }
            result.put("state","SUCCESS");

            result.put("type",".jpg");
        } else {

        }


        return new ResponseEntity<Map<String, Object>>(result.toMap(), HttpStatus.OK);
    }
    private static File getTmpFile() {
        File tmpDir = FileUtils.getTempDirectory();
        String tmpFileName = (Math.random() * 10000 + "").replace(".", "");
        return new File(tmpDir, tmpFileName);
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