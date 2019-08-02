package com.hy.controller;

import com.hy.service.storage.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author: wanghai
 * @Date:2019/7/11 10:36
 * @Copyright:reach-life
 * @Description:
 */
@RestController
public class FileUploadController {

    @Autowired
    private StorageService storageService;

    @GetMapping("/")
    public String listUploadedFiles(Model model) {
        model.addAttribute("files",storageService.loadAll().map(path -> MvcUriComponentsBuilder.fromMethodName(FileUploadController.class,"saveFile",path.getFileName().toString())
                .build().toString())
                .collect(Collectors.toList()));
        return "uploadForm";
    }

    @GetMapping("/files/{filename:.+}")
    @ResponseBody
    public ResponseEntity<Resource> serveFile(@PathVariable String filename) {

        Resource file = storageService.loadAsResource(filename);
        return ResponseEntity
                .ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\""+file.getFilename()+"\"")
                .body(file);
    }

    @PostMapping("/")
    public String handleFileUpload(@RequestParam("file") MultipartFile file,
                                   RedirectAttributes redirectAttributes) {

        storageService.store(file);
        redirectAttributes.addFlashAttribute("message",
                "You successfully uploaded " + file.getOriginalFilename() + "!");

        return "redirect:/";
    }


    @RequestMapping(value = "/fileUpload", method = RequestMethod.POST)
    @ResponseBody
    public ResultModel fileUpload(HttpServletRequest request) throws IOException {
        List<String> fileNameList = new ArrayList<>();
        // 创建一个通用的多部分解析器
        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(request.getSession()
                .getServletContext());
        // 判断 request 是否有文件上传,即多部分请求
        if (!multipartResolver.isMultipart(request)) {
            throw new BusinessException(GlobalResultStatusEnum.FAIL);
        }
        // 转换成多部分request
        MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
        // 取得request中的所有文件名
        Iterator<String> iter = multiRequest.getFileNames();
        String date = DateUtil.getDateFormat(new Date(), "yyyyMM");
        while (iter.hasNext()) {
            // 取得上传文件
            List<MultipartFile> files = multiRequest.getFiles(iter.next());
            if (files == null) {
                logger.error("没有文件信息");
                throw new BusinessException(GlobalResultStatusEnum.FAIL);
            }

            for (MultipartFile file : files) {
                // 取得当前上传文件的文件名称
                String fileName = FileUtils.create_nonce_str() + ".jpg";
                if (StringUtils.isBlank(fileName)) {
                    continue;
                }
                // 定义上传路径
                String uploadPath = imageUploadUrl + date + "/";
                FileUtils.createFolder(uploadPath);
                File localFile = new File(uploadPath + fileName);
                file.transferTo(localFile);
                fileNameList.add(imageViewUrl + date + "/" + fileName);
            }
        }
        return new ResultModel(fileNameList);
    }



    @ApiOperation(value = "多文件上传", notes = "支持多文件上传")
    @RequestMapping(value = "/filesUpload", method = RequestMethod.POST)
    @ResponseBody
    public ResultModel<List<String>> filesUpload(@RequestParam MultipartFile[] files) throws IOException {
        String date = DateUtil.getDateFormat(new Date(), "yyyyMM");
        List<String> fileNameList = new ArrayList<>();
        if (files == null) {
            logger.error("没有文件信息");
            throw new BusinessException(GlobalResultStatusEnum.FAIL);
        }
        for (MultipartFile file : files) {
            String fileName = file.getOriginalFilename();
            logger.info("上传的文件名为：" + fileName);
            if(StringUtils.isBlank(fileName)){
                logger.error("文件名获取错误!");
                throw new BusinessException(GlobalResultStatusEnum.FAIL);
            }
            // 获取文件的后缀名
            String suffixName = fileName.substring(fileName.lastIndexOf("."));
            logger.info("文件的后缀名为：" + suffixName);
            if(StringUtils.isBlank(suffixName)){
                logger.error("文件格式获取失败!");
                throw new BusinessException(GlobalResultStatusEnum.FAIL);
            }

            // 取得当前上传文件的文件名称
            fileName = FileUtils.create_nonce_str() + suffixName;
            // 定义上传路径
            String uploadPath = imageUploadUrl + date + "/";
            FileUtils.createFolder(uploadPath);
            File localFile = new File(uploadPath + fileName);
            file.transferTo(localFile);
            fileNameList.add(imageViewUrl + date + "/" + fileName);
        }
        return new ResultModel<>(fileNameList);
    }


}
