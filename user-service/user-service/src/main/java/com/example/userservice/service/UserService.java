package com.example.userservice.service;

import com.example.userservice.dto.Department;
import com.example.userservice.dto.ResponseTemplateVO;
import com.example.userservice.entity.User;
import com.example.userservice.feign.DepartmentFeign;
import com.example.userservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

//    @Autowired
//    RestTemplate restTemplate;

    @Autowired
    private DepartmentFeign departmentFeign;


    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public ResponseTemplateVO getUserWithDepartment(Long userid) {
        ResponseTemplateVO responseTemplateVO = new ResponseTemplateVO();
        User user = userRepository.findByUserId(userid);
        Department department =  departmentFeign.findByDepartmentId(user.getUserId());
//                restTemplate.getForObject("http://localhost:9001/department/"+user.getUserId(), Department.class);
        responseTemplateVO.setUser(user);
        responseTemplateVO.setDepartment(department);
        return responseTemplateVO;
    }
}
