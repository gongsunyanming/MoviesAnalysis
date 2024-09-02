package com.browse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

// 通道
@Service
public class AppService {

    @Autowired
    private AppDao appDao;

    public List<Map<String, Object>> getPart1() {
        return appDao.getpart1();
    }

    public List<Map<String, Object>> getPart2() {
        return appDao.getpart2();
    }

    public List<Map<String, Object>> getPart3() {
        return appDao.getpart3();
    }

    public List<Map<String, Object>> getPart4() {
        return appDao.getpart4();
    }

    public List<Map<String, Object>> getPart5() {
        return appDao.getpart5();
    }

    public List<Map<String, Object>> getPart6() {
        return appDao.getpart6();
    }

    public List<Map<String, Object>> getPart7() {
        return appDao.getpart7();
    }
}
