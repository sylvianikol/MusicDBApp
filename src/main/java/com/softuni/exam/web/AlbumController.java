package com.softuni.exam.web;

import com.softuni.exam.model.binding.AlbumAddBindingModel;
import com.softuni.exam.model.service.AlbumServiceModel;
import com.softuni.exam.model.service.UserServiceModel;
import com.softuni.exam.model.view.AlbumViewModel;
import com.softuni.exam.service.AlbumService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@RequestMapping("/albums")
public class AlbumController {

    private final AlbumService albumService;
    private final ModelMapper modelMapper;

    @Autowired
    public AlbumController(AlbumService albumService, ModelMapper modelMapper) {
        this.albumService = albumService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/add")
    public String add(Model model, HttpSession httpSession) {
        if (httpSession.getAttribute("user") == null) {
            return "redirect:/users/login";
        }

        if (!model.containsAttribute("albumAddBindingModel")) {
            model.addAttribute("albumAddBindingModel", new AlbumAddBindingModel());
            model.addAttribute("addError", false);
        }

        return "add-album";
    }

    @PostMapping("/add")
    public String addConfirm(@Valid AlbumAddBindingModel albumAddBindingModel,
                             BindingResult bindingResult,
                             RedirectAttributes redirectAttributes,
                             HttpSession httpSession) {

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("albumAddBindingModel", albumAddBindingModel);
            redirectAttributes.addFlashAttribute(
                    "org.springframework.validation.BindingResult.albumAddBindingModel",
                    bindingResult);

            return "redirect:add";
        }

        String userId = ((UserServiceModel) httpSession.getAttribute("user")).getId();
        boolean isAdded = this.albumService.add(this.modelMapper
                .map(albumAddBindingModel, AlbumServiceModel.class), userId);

        if (!isAdded) {
            redirectAttributes.addFlashAttribute("albumAddBindingModel", albumAddBindingModel);
            redirectAttributes.addFlashAttribute("addError", true);

            return "redirect:add";
        }

        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String details(@PathVariable String id, HttpSession httpSession, Model model) {
        if (httpSession.getAttribute("user") == null) {
            return "redirect:/users/login";
        }

        this.albumService.deleteById(id);

        return "redirect:/";
    }
}
