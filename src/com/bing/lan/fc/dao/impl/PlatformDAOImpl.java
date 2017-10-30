package com.bing.lan.fc.dao.impl;

import com.bing.lan.fc.dao.IPlatformDAO;
import com.bing.lan.fc.domian.Platform;
import com.bing.lan.fc.jdbc.JdbcTemplate;

import java.util.ArrayList;
import java.util.List;

public class PlatformDAOImpl implements IPlatformDAO {

    @Override
    public void save(Platform obj) {

    }

    @Override
    public void update(Platform obj) {

    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public Platform get(Long id) {
        return null;
    }

    @Override
    public List list() {
        String sql = "SELECT * FROM `fc_platform`";
        return JdbcTemplate.list(sql, resultSet -> {

            List<Platform> list = new ArrayList<>();
            while (resultSet.next()) {
                Platform platform = new Platform(
                        resultSet.getString("id"),
                        resultSet.getString("platformName"));
                list.add(platform);
            }
            return list;
        });
    }
}
