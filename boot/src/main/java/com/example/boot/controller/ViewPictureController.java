package com.example.boot.controller;

import com.example.boot.domain.Picture;
import com.example.boot.service.PictureService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/view/pictures")
@RequiredArgsConstructor
public class ViewPictureController {

    private final PictureService pictureService;

    @GetMapping
    public String getAll(@ModelAttribute("picture") Picture picture, Model model) {
        model.addAttribute("pictures", pictureService.getAll());
        return "pictures";
    }
}
