package com.prologiccreations.storemanagement.controller.auth;

import com.prologiccreations.storemanagement.controller.super_classes.CrudController;
import com.prologiccreations.storemanagement.dto.Response;
import com.prologiccreations.storemanagement.model.auth.Role;
import com.prologiccreations.storemanagement.service.super_classes.auth.RoleService;
import com.prologiccreations.storemanagement.utils.PageUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("role/")
public class RoleController implements CrudController<Role, Long> {
    private final RoleService roleService;

    @Override
    public ResponseEntity<Response> storeData(Role data) {
        Response response = roleService.storeData(data);
        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<Response<Page<Role>>> getAll(Integer pageNumber, Integer pageSize, String sortDirection, String sortColumns) {
        Pageable pageable = PageUtil.getPageable(pageNumber, pageSize, sortDirection, sortColumns);
        Response<Page<Role>> response = roleService.getAll(pageable);
        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<Response<Role>> getOne(Long id) {
        Response<Role> response = roleService.getById(id);
        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<Response> delete(Long id) {
        Response response = roleService.delete(id);
        return ResponseEntity.ok(response);
    }
}
