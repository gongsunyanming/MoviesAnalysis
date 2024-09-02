package com.browse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class AppController {

    @Autowired
    private AppService appService;

    @RequestMapping("/getPart1")
    public Map<String, List> getPart1() {
        List<Map<String, Object>> list = appService.getPart1();
        List<String> keylist = new ArrayList<>();
        List<String> vallist = new ArrayList<>();
        for (Map<String, Object> map : list) {
            keylist.add(map.get("name").toString());
            vallist.add(map.get("value").toString());
        }
        Map<String, List> returnMap = new HashMap<>();
        returnMap.put("key", keylist);
        returnMap.put("val", vallist);
        return returnMap;
    }

    @RequestMapping("/getPart2")
    public Map<String, List> getPart2() {
        List<Map<String, Object>> list = appService.getPart2();
        List<String> keylist = new ArrayList<>();
        List<String> vallist = new ArrayList<>();
        for (Map<String, Object> map : list) {
            keylist.add(map.get("name").toString());
            vallist.add(map.get("value").toString());
        }
        Map<String, List> returnMap = new HashMap<>();
        returnMap.put("key", keylist);
        returnMap.put("val", vallist);
        return returnMap;
    }

    @RequestMapping("/getPart3")
    public Map<String, List> getPart3() {
        List<Map<String, Object>> list = appService.getPart3();
        List<String> keylist = new ArrayList<>();
        List<String> vallist = new ArrayList<>();
        for (Map<String, Object> map : list) {
            keylist.add(map.get("name").toString());
            vallist.add(map.get("value").toString());
        }
        Map<String, List> returnMap = new HashMap<>();
        returnMap.put("key", keylist);
        returnMap.put("val", vallist);
        return returnMap;
    }

    @RequestMapping("/getPart4")
    public Map<String, List> getPart4() {
        List<Map<String, Object>> list = appService.getPart4();
        List<String> keylist = new ArrayList<>();
        List<String> vallist = new ArrayList<>();
        for (Map<String, Object> map : list) {
            keylist.add(map.get("name").toString());
            vallist.add(map.get("value").toString());
        }
        Map<String, List> returnMap = new HashMap<>();
        returnMap.put("key", keylist);
        returnMap.put("val", vallist);
        return returnMap;
    }

    @RequestMapping("/getPart5")
    public Map<String, List> getPart5() {
        List<Map<String, Object>> list = appService.getPart5();
        List<String> keylist = new ArrayList<>();
        List<String> vallist = new ArrayList<>();
        for (Map<String, Object> map : list) {
            keylist.add(map.get("name").toString());
            vallist.add(map.get("value").toString());
        }
        Map<String, List> returnMap = new HashMap<>();
        returnMap.put("key", keylist);
        returnMap.put("val", vallist);
        return returnMap;
    }

    @RequestMapping("/getPart6")
    public Map<String, List> getPart6() {
        List<Map<String, Object>> list = appService.getPart6();
        List<String> keylist = new ArrayList<>();
        List<String> vallist = new ArrayList<>();
        for (Map<String, Object> map : list) {
            keylist.add(map.get("name").toString());
            vallist.add(map.get("value").toString());
        }
        Map<String, List> returnMap = new HashMap<>();
        returnMap.put("key", keylist);
        returnMap.put("val", vallist);
        return returnMap;
    }

    @RequestMapping("/getPart7")
    public Map<String, List> getPart7() {
        List<Map<String, Object>> list = appService.getPart7();
        List<String> keylist = new ArrayList<>();
        List<String> vallist = new ArrayList<>();
        for (Map<String, Object> map : list) {
            keylist.add(map.get("name").toString());
            vallist.add(map.get("value").toString());
        }
        Map<String, List> returnMap = new HashMap<>();
        returnMap.put("key", keylist);
        returnMap.put("val", vallist);
        return returnMap;
    }
}