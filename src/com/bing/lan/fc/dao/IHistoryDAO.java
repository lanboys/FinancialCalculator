package com.bing.lan.fc.dao;

import com.bing.lan.fc.domian.History;

import java.util.List;

public interface IHistoryDAO {

    public void save(History obj);

    public void update(History obj);

    public void delete(Long id);

    public History get(Long id);

    public List<History> list();
}
