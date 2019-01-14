package com.haoxuer.adminstore.controller.front;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.haoxuer.discover.qrcode.view.QRView;
import com.haoxuer.discover.web.controller.front.BaseController;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Scope("prototype")
@Controller
public class QrCodeController extends BaseController {
  
  public static final int SIZE = 100;

  @RequestMapping("/qrcode/{path}")
  public ModelAndView view(Model model, @PathVariable("path") String path){
    model.addAttribute("width",500);
    model.addAttribute("height",500);
    model.addAttribute("code",path);

    ModelAndView result=new ModelAndView();
    result.setView(new QRView());
    return result;
  }
}
