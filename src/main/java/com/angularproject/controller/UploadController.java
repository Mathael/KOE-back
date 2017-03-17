package com.angularproject.controller;

import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author Leboc Philippe.
 */
@RestController
@CrossOrigin("*")
@RequestMapping(value = "/upload", produces = "application/json")
public class UploadController {

    private static final String UPLOAD_FOLDER = "/images/heroes/";

    @RequestMapping(value = "/{fileType}/{heroId}", method = RequestMethod.POST)
    public void uploadFile(@PathVariable("heroId") String heroId, @PathVariable("fileType") String fileType, @RequestParam("file") MultipartFile multipartFile) throws IOException {
        Assert.hasLength(heroId, "Hero id is null or empty");
        Assert.hasLength(fileType, "fileType parameter is null or empty");
        Assert.notNull(multipartFile, "File is null");

        final Path path = Paths.get("./"+heroId+"_"+fileType+".png");
        System.out.println("Path : " + path.toString());
        Files.write(path, multipartFile.getBytes());
    }
}
