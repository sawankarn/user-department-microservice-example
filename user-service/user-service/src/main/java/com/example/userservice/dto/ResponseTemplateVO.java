package com.example.userservice.dto;

import com.example.userservice.entity.User;
import lombok.Data;

@Data
public class ResponseTemplateVO {
    private User user;
    private Department department;
}
