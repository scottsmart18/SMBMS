package com.davidniu.service.role;


import com.davidniu.dao.BaseDao;
import com.davidniu.service.role.RoleService;
import com.davidniu.dao.BaseDao;
import com.davidniu.dao.role.RoleDao;
import com.davidniu.dao.role.RoleDaoImpl;
import com.davidniu.pojo.Role;

import java.sql.Connection;
import java.util.List;

public class RoleServiceImpl implements RoleService {

    private RoleDao roleDao;

    public RoleServiceImpl() {
        roleDao = new RoleDaoImpl();
    }

    /**
     * 获取角色列表
     *
     * @return
     */
    @Override
    public List<Role> getRoleList() {
        Connection connection = null;
        List<Role> roleList = null;
        try {
            connection = BaseDao.getConnection();
            roleList = roleDao.getRoleList(connection);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            BaseDao.closeResource(connection, null, null);
        }
        return roleList;
    }

}
