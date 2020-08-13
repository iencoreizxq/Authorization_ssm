package com.service.impl;

import com.dao.IPermissionsDao;
import com.domain.Permission;
import com.service.IPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("permissionService")
@Transactional
public class PermissionServiceImpl implements IPermissionService {

    @Autowired
    private IPermissionsDao iPermissionsDao;

    @Override
    public List<Permission> findAll() throws Exception {
        return iPermissionsDao.findAll();
    }

    @Override
    public void save(Permission permission) throws Exception {
        iPermissionsDao.save(permission);
    }

    @Override
    public Permission findById(String permissionId) throws Exception {
        return iPermissionsDao.findById(permissionId);
    }

    @Override
    public void deleteById(String permissionId) throws Exception {
        iPermissionsDao.deletePermissionById(permissionId);
        iPermissionsDao.deleteFromRole_PermissionById(permissionId);
    }
}
