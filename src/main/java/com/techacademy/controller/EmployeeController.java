package com.techacademy.controller;

import javax.transaction.Transactional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.techacademy.entity.Employee;
import com.techacademy.service.EmployeeService;



@Controller
@RequestMapping("employee")
public class EmployeeController {

    private final EmployeeService service;

    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

    /** 一覧画面を表示 */
    @GetMapping("/emplist")
    public String getList(Model model) {
        // 全件検索結果をModelに登録
        model.addAttribute("employeelist", service.getEmployeeList());
        // employeecontrol/emplist.htmlに画面遷移
        return "employeecontrol/emplist";
    }

    /** 登録画面を表示 */
    @GetMapping("/register")
    public String getRegister(@ModelAttribute Employee employee) {
        // employeecontrol/empregister.htmlに登録画面に遷移
        return "employeecontrol/empregister";
    }

    /** 登録処理 */
    @PostMapping("/register")
    public String postRegister(Employee employee) {
        // User登録
        service.saveEmployee(employee);
        // 一覧画面にリダイレクト
        return "redirect:/employee/emplist";
    }



    /** 詳細画面を表示 */
    @GetMapping("/detail/{id}/")
    public String getEmployee(@PathVariable("id") Integer id, Model model) {
        // Modelに登録
        model.addAttribute("employeedetail", service.getEmployee(id));
        // User更新画面に遷移
        return "employeecontrol/empdetail";
    }

    /** 編集画面を表示 */
    @GetMapping("/edit/{id}")
    public String editEmployee(@PathVariable("id") Integer id, Model model) {
        // Modelに登録
        model.addAttribute("employeeedit", service.getEmployee(id));
        // User更新画面に遷移
        return "employeecontrol/empedit";
    }




}
