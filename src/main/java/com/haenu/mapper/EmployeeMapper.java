package com.haenu.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.haenu.entity.Employee;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author haenu
 * @version 1.0
 * @date 2023/02/23 17:59
 */
@Mapper
public interface EmployeeMapper extends BaseMapper<Employee> {
}
