package com.example.stripedemo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Controller
public class CanvasController {

    @GetMapping("/index")
    private String index2() {
        return "index2";
    }

    @PostMapping("/saveImage")
    private ResponseEntity saveImage(@RequestPart MultipartFile file) throws IOException {
        System.out.println("mfile = " + file.getOriginalFilename());
        String uploadDir = "c:\\Temp";
        String originalFilename = file.getOriginalFilename();
        File toFile = new File(uploadDir, originalFilename);
        file.transferTo(toFile);

        return ResponseEntity.ok().body("ok");
    }
}
