package com.project.portfolio.service;

import java.util.List;

public interface BaseRules {

    void checkDataList(List<?> list);
    String fixName(String name);
    void isExistsByName(String name);
    void isExistsByNameAndIdNot(String name, int id);
    void checkData(int id);
}
