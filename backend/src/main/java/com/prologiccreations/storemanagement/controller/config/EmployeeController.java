package com.prologiccreations.storemanagement.controller.config;

import com.prologiccreations.storemanagement.controller.super_classes.CrudController;
import com.prologiccreations.storemanagement.dto.Response;
import com.prologiccreations.storemanagement.model.config.Employee;
import com.prologiccreations.storemanagement.service.super_classes.config.EmployeeService;
import com.prologiccreations.storemanagement.utils.PageUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("employee/")
public class EmployeeController implements CrudController<Employee, Long> {
    private final EmployeeService employeeService;

    @Override
    public ResponseEntity<Response> storeData(Employee data) {
        Response response = employeeService.storeData(data);
        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<Response<Page<Employee>>> getAll(Integer pageNumber, Integer pageSize, String sortDirection, String sortColumns) {
        Pageable pageable = PageUtil.getPageable(pageNumber, pageSize, sortDirection, sortColumns);
        Response<Page<Employee>> response = employeeService.getAll(pageable);
        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<Response<Employee>> getOne(Long id) {
        Response<Employee> response = employeeService.getById(id);
        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<Response> delete(Long id) {
        Response response = employeeService.delete(id);
        return ResponseEntity.ok(response);
    }
}
