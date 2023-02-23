package com.haenu.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.haenu.entity.Employee;
import com.haenu.mapper.EmployeeMapper;
import com.haenu.service.EmployeeService;
import org.springframework.stereotype.Service;

/**
 * @author haenu
 * @version 1.0
 * @date 2023/02/23 18:01
 */
@Service
public class EmployeeServiceImpl extends ServiceImpl<EmployeeMapper, Employee> implements EmployeeService {
}
