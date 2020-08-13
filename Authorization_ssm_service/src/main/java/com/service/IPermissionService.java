package com.service;

import com.domain.Permission;

import java.util.List;

public interface IPermissionService {

    public List<Permission> findAll() throws Exception;

    void save(Permission permission) throws Exception;

    Permission findById(String permissionId) throws Exception;

    void deleteById(String permissionId) throws Exception;
}
