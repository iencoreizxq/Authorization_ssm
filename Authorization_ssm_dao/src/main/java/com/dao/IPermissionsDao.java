package com.dao;

import com.domain.Permission;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface IPermissionsDao {

    @Select("select * from permission where id in (select permissionId from role_permission where roleId = #{roleId})")
    public List<Permission> findPermissionByRoleId(String roleId) throws Exception;


    @Select("select * from permission")
    List<Permission> findAll() throws Exception;

    @Insert("insert into permission (permissionName,url) values(#{permissionName},#{url})")
    void save(Permission permission) throws Exception;

    @Select("select * from permission where id = #{permissionId}")
    Permission findById(String permissionId);

    @Delete("delete from permission where id = #{permission}")
    void deletePermissionById(String permissionId);

    @Delete("delete from role_permission where permissionId = #{permissionId}")
    void deleteFromRole_PermissionById(String permissionId);
}
