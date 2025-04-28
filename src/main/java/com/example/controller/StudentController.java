package com.example.controller;

import java.util.List;
import java.util.Map;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.dao.NganhDao;
import com.example.dao.TruongDao;
import com.example.model.GraduateForm;
import com.example.model.Nganh;
import com.example.model.Truong;
import com.example.service.StudentService;
import com.example.model.SinhVien;
import com.example.dao.SinhVienDao;

@Controller
@RequestMapping("/graduate")
public class StudentController {

    @Autowired
    private TruongDao truongDao;
    @Autowired
    private NganhDao nganhDao;
    @Autowired
    private StudentService studentService;
    @Autowired 
    private SinhVienDao svDao;
  
 // Form 1: tìm cơ bản
    @GetMapping("/search-basic")
    public String showBasicForm(Model model) {
        model.addAttribute("keyword", "");
        return "search_basic";
    }

    @PostMapping("/search-basic")
    public String doBasicSearch(
            @RequestParam("keyword") String keyword,  // <-- ghi rõ "keyword"
            Model model) {

        List<SinhVien> list = svDao.searchBasic(keyword);
        model.addAttribute("resultBasic", list);
        return "search_basic";
    }

    // Form 2: tìm tốt nghiệp & việc làm
    @GetMapping("/search-graduate")
    public String showGraduateForm(Model model) {
        model.addAttribute("cmnd", "");
        return "search_graduate";
    }

    @PostMapping("/search-graduate")
    public String doGraduateSearch(
            @RequestParam("cmnd") String cmnd,  // <-- ghi rõ "cmnd"
            Model model) {

        List<Map<String,Object>> list = svDao.searchGraduate(cmnd);
        model.addAttribute("resultGraduate", list);
        return "search_graduate";
    }
    
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