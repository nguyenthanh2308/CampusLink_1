package com.example.controller;

import java.util.List;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.dao.NganhDao;
import com.example.dao.TruongDao;
import com.example.model.GraduateForm;
import com.example.model.Nganh;
import com.example.model.Truong;
import com.example.service.StudentService;

@Controller
@RequestMapping("/graduate")
public class StudentController {

    @Autowired
    private TruongDao truongDao;
    @Autowired
    private NganhDao nganhDao;
    @Autowired
    private StudentService studentService;

    @ModelAttribute("allTruong")
    public List<Truong> getTruong() {
        return truongDao.getAll();
    }

    @ModelAttribute("allNganh")
    public List<Nganh> getNganh() {
        return nganhDao.getAll();
    }

    @GetMapping("/form")
    public String showForm(Model model) {
        model.addAttribute("graduateForm", new GraduateForm());
        return "form";
    }

    @PostMapping("/save")
    public String submit(
        @Valid @ModelAttribute("graduateForm") GraduateForm form,
        BindingResult br,
        Model model) {

        if (br.hasErrors()) {
            // Re-populate selects
            model.addAttribute("allTruong", truongDao.getAll());
            model.addAttribute("allNganh", nganhDao.getAll());
            return "form";
        }

        studentService.registerGraduate(
            form.getSinhVien(),
            form.getTotNghiep()
        );
        return "redirect:/graduate/success";
    }

    @GetMapping("/success")
    public String success() {
        return "success";
    }
}