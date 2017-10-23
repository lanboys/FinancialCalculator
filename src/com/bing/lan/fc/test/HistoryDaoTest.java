package com.bing.lan.fc.test;

import com.bing.lan.fc.dao.impl.HistoryDAOImpl;
import com.bing.lan.fc.domian.History;

import org.junit.jupiter.api.Test;

import java.util.List;

public class HistoryDaoTest {

    public void save(History obj) {

    }

    public void update(History obj) {

    }

    public void delete(Long id) {

    }

    public History get(Long id) {
        return null;
    }

    @Test
    public List<History> testList() {
        HistoryDAOImpl historyDAO = new HistoryDAOImpl();
        historyDAO.list();


        System.out.print("------");

        return null;
    }
}
