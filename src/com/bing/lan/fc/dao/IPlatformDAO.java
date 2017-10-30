package com.bing.lan.fc.dao;

import com.bing.lan.fc.domian.Platform;

import java.util.List;

public interface IPlatformDAO {

    public void save(Platform obj);

    public void update(Platform obj);

    public void delete(Long id);

    public Platform get(Long id);

    public List list();
}
