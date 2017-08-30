package com.james.spring.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.nio.file.FileSystem;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;

import com.james.spring.service.StorageService;

@RestController
public class UploadController {

    @Autowired
    StorageService storageService;

    List<String> files = new ArrayList<String>();

    private final Path fileDir = Paths.get("uploadDir");

    @RequestMapping(value = "/uploadFiles", method = RequestMethod.POST)
    public HashMap<String, String> uploadFiles(HttpServletRequest request, HttpServletResponse response) {
        HashMap<String, String> returnData = new HashMap<String, String>();

        try {
            CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(request.getSession().getServletContext());
            if (multipartResolver.isMultipart(request)) {
                MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;

                if (!Files.exists(fileDir)) {
                    Files.createDirectories(fileDir);
                }

                Iterator<String> iter = multiRequest.getFileNames();

                while (iter.hasNext()) {
                    MultipartFile file = multiRequest.getFile((String) iter.next());
                    String fileName = file.getOriginalFilename();

                    if (null != file) {
                        Files.copy(file.getInputStream(), this.fileDir.resolve(fileName));
                    }
                }

                System.out.println("uploading files done!");
            }
        } catch (Exception e) {
            returnData.put("returnFlag", "fail");
            return returnData;
        }

        returnData.put("returnFlag", "ok");
        return returnData;
    }

    @RequestMapping(value = "/uploadFiles2", method = RequestMethod.POST)
    public HashMap<String, String> uploadFiles2(@RequestParam("file") MultipartFile[] files) {
        HashMap<String, String> returnData = new HashMap<String, String>();

        try {
            if (!Files.exists(fileDir)) {
                Files.createDirectories(fileDir);
            }

            for (int i = 0; i < files.length; i++) {
                String fileName = files[i].getOriginalFilename();

                byte[] bytes = files[i].getBytes();
                BufferedOutputStream buffStream = new BufferedOutputStream(new FileOutputStream(new File(fileDir +File.separator+ fileName)));
                buffStream.write(bytes);
                buffStream.close();
            }

            System.out.println("uploading files done!");
        } catch (Exception e) {
            returnData.put("returnFlag", "fail");
            return returnData;
        }

        returnData.put("returnFlag", "ok");
        return returnData;
    }

    @PostMapping("/gellallfiles")
    public String handleFileUpload(@RequestParam("file") MultipartFile file, Model model) {
        try {
            storageService.store(file);
            model.addAttribute("message", "You successfully uploaded " + file.getOriginalFilename() + "!");
            files.add(file.getOriginalFilename());
        } catch (Exception e) {
            model.addAttribute("message", "FAIL to upload " + file.getOriginalFilename() + "!");
        }
        return "listFiles";
    }

    @GetMapping("/gellallfiles")
    public String getListFiles(Model model) {
        model.addAttribute("files",
                        files.stream().map(fileName -> MvcUriComponentsBuilder.fromMethodName(UploadController.class, "getFile", fileName).build().toString()).collect(Collectors.toList()));
        model.addAttribute("totalFiles", "TotalFiles: " + files.size());
        return "listFiles";
    }

    @GetMapping("/files/{filename:.+}")
    @ResponseBody
    public ResponseEntity<Resource> getFile(@PathVariable String filename) {
        Resource file = storageService.loadFile(filename);
        return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"").body(file);
    }
}