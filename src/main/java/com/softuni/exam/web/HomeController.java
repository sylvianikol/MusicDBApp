package com.softuni.exam.web;

import com.softuni.exam.model.view.AlbumViewModel;
import com.softuni.exam.service.AlbumService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;
import java.util.stream.Collectors;

@Controller
public class HomeController {

    private final AlbumService albumService;
    private final ModelMapper modelMapper;

    public HomeController(AlbumService albumService, ModelMapper modelMapper) {
        this.albumService = albumService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/")
    public String index(HttpSession httpSession, Model model) {
        if (httpSession.getAttribute("user") == null) {
            return "index";
        }

        model.addAttribute("totalCopies", this.albumService.getTotalCopies());

        model.addAttribute("albums", this.albumService.getAllAlbums().stream()
                .map(p -> this.modelMapper.map(p, AlbumViewModel.class))
                .collect(Collectors.toUnmodifiableList()));

        return "home";
    }
}
