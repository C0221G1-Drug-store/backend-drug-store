package com.backend.pharmacy_management.model.service.user;

import com.backend.pharmacy_management.model.dto.user_role.UserDto;
import com.backend.pharmacy_management.model.entity.employee.Employee;
import com.backend.pharmacy_management.model.entity.user_role.Role;
import com.backend.pharmacy_management.model.entity.user_role.User;

import com.backend.pharmacy_management.model.repository.employeeRepository.EmployeeRepository;


import com.backend.pharmacy_management.model.repository.userRepository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import java.util.*;

@Service
public class UserService implements IUserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Page<User> findAll(Pageable pageable) {
        return userRepository.findAll(pageable);
    }

    @Override
    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    public Page<User> findAllByProperty(Pageable pageable, String keyWord, Long property, Integer roleId) {
        return userRepository.findAllUserByProperty(pageable, "%" + keyWord + "%", property, roleId);
    }

    @Override
    public Iterable<User> findAllNoPage() {
        return userRepository.findAll();
    }

    @Override
    public Map<String, Object> update( UserDto putData, BindingResult bindingResult, Long id) {
        Map<String, Object> result = new HashMap<>();
        User user = userRepository.findById(id).orElse(null);
        Employee employee = employeeRepository.findById(user.getEmployee().getEmployeeId()).orElse(null);
        try {
            //VALIDATE DATA;
            List<String> errors = new ArrayList<>();
            if (bindingResult.hasErrors()) {
                bindingResult.getAllErrors().forEach(ob -> {
                    errors.add(ob.getDefaultMessage());
                });
                result.put("status", false);
                result.put("msg", "UPDATE FAILED");
                result.put("errors", errors);
                return result;
            }

            //CHECK BY ID -> XEM CO TON TAI K?
            if (user == null) {
                result.put("status", false);
                result.put("msg", "UPDATE FAILED");
                errors.add("Người dùng không tồn tại");
                result.put("errors", errors);
                return result;
            }

            //CHECK CONFLICT UNIQUE USERNAME
            if (!putData.getAccountName().equals(user.getAccountName()) && isConfictAccount(putData)) {
                result.put("status", false);
                result.put("msg", "UPDATE FAILED");
                errors.add("Tên tài khoản đã tồn tại");
                result.put("errors", errors);
                return result;
            }

        } catch (Exception e) {
            result.put("status", false);
            result.put("msg", "UPDATE FAILED");

        }
        user.setId(id);
        user.setAccountName(putData.getAccountName());
        user.setPassword(putData.getPassword());
        user.setRoles(putData.getRoles());
        userRepository.save(user);
        employee.setAccountName(putData.getAccountName());
        for (Role role:putData.getRoles()) {
            if (role.getId()==1){
                employee.setPosition("Người dùng");
            } else if (role.getId()==2){
                employee.setPosition("Nhân Viên");
            } else if (role.getId()==3){
                employee.setPosition("Quản Lý");
            }
        }
        employeeRepository.save(employee);
        result.put("status", true);
        result.put("msg", "Cập nhật tài khoản thành công!!!");
        result.put("account",user);
        return result;
    }


    public boolean isConfictAccount(UserDto userDto) {
        User user = userRepository.findByAccountName(userDto.getAccountName());
        return user != null;
    }

}
