package com.project.portfolio.service.user;

import com.project.portfolio.repository.user.UserRepository;
import com.project.portfolio.service.BaseRules;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class UserRules implements BaseRules {
    private final UserRepository userRepository;
    @Override
    public void checkDataList(List<?> list) {

    }

    @Override
    public String fixName(String name) {
        return name;
    }

    @Override
    public void isExistsByName(String name) {

    }

    @Override
    public void isExistsByNameAndIdNot(String name, int id) {

    }

    @Override
    public void checkData(int id) {

    }
}
