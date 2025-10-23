package poly.edu.controller;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import poly.edu.model.Staff;

@Controller
@RequestMapping("/staff")
public class StaffController {

    // ================= Bài 1: Databinding =================
	@RequestMapping("/create/form")
	public String createForm(Model model, @ModelAttribute("staff") Staff staff) {
	    model.addAttribute("message", "Vui lòng nhập thông tin nhân viên!");
	    return "demo/staff-create";
	}

	@PostMapping("/create/save")
	public String createSave(Model model,
	                         @Valid @ModelAttribute("staff") Staff staff,
	                         BindingResult result,
	                         @RequestParam("photo_file") MultipartFile photoFile) {
	    // Kiểm tra validation trước
	    if (result.hasErrors()) {
	        model.addAttribute("message", "Vui lòng sửa các lỗi sau!");
	        return "demo/staff-create";
	    }

	    // Nếu có upload ảnh, lưu tên ảnh vào thuộc tính photo
	    if (!photoFile.isEmpty()) {
	        staff.setPhoto(photoFile.getOriginalFilename());
	    }

	    model.addAttribute("message", "Xin chào " + staff.getFullname() + "!");
	    return "demo/staff-create";
	}


    // ================= Bài 2: Validation =================
	@Controller
	@RequestMapping("/validate")
	public class ValidateController {

	    @GetMapping("/form")
	    public String showForm(Model model) {
	        model.addAttribute("staff", new Staff());
	        return "demo/staff-validate"; // Tên file Thymeleaf: staff-validate.html
	    }

	    @PostMapping("/save")
	    public String save(@Valid @ModelAttribute("staff") Staff staff,
	                       BindingResult result,
	                       Model model) {
	        if (result.hasErrors()) {
	            model.addAttribute("message", "Có lỗi trong dữ liệu!");
	            return "demo/staff-validate";
	        }
	        model.addAttribute("message", "Lưu thành công!");
	        return "demo/staff-validate";
	    }
	}
}
