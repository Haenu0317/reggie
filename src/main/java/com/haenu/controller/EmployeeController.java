package com.haenu.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.haenu.commmon.R;
import com.haenu.entity.Employee;
import com.haenu.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author haenu
 * @version 1.0
 * @date 2023/02/23 18:04
 */
@Slf4j
@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;


    @PostMapping("/login")
    public R<Employee> login(HttpServletRequest request, @RequestBody Employee employee) {
        String password = employee.getPassword();
        password = DigestUtils.md5DigestAsHex(password.getBytes());
        LambdaQueryWrapper<Employee> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Employee::getUsername, employee.getUsername());
        Employee one = employeeService.getOne(queryWrapper);
        if (null == one) {
            return R.error("登录失败,未找到该用户");
        }
        if (!one.getPassword().equals(password)) {
            return R.error("登录失败");
        }
        if (one.getStatus() == 0) {
            return R.error("帐号已禁用");
        }
        request.getSession().setAttribute("employee", one.getId());
        return R.success(one);
    }
}
