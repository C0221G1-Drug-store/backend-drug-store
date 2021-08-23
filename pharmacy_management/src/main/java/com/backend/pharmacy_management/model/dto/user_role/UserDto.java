package com.backend.pharmacy_management.model.dto.user_role;

import com.backend.pharmacy_management.model.entity.employee.Employee;
import jdk.nashorn.internal.runtime.regexp.joni.Regex;
import net.bytebuddy.implementation.bind.annotation.Empty;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class UserDto {

    private Long userId;
    private String userName;
    private String userCode;
    @NotEmpty(message = "Tên tài khoản không được để trống!")
    @Size(min = 5,max = 20,message = "Tên tài khoản phải lớn hơn 5 và nhỏ hơn 20 kí tự!")
    @Pattern(regexp = "^[0-9a-zA-Z]*$",message = "Tên tài khoản không chứa kí tự đặc biệt!")
    private String accountName;
    private String encrytedPassword;
    private String enabled;
    private Employee employee;

    public UserDto() {
    }

    public UserDto(Long userId, String userName, String userCode, String accountName, String encrytedPassword, String enabled, Employee employee) {
        this.userId = userId;
        this.userName = userName;
        this.userCode = userCode;
        this.accountName = accountName;
        this.encrytedPassword = encrytedPassword;
        this.enabled = enabled;
        this.employee = employee;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getEncrytedPassword() {
        return encrytedPassword;
    }

    public void setEncrytedPassword(String encrytedPassword) {
        this.encrytedPassword = encrytedPassword;
    }

    public String getEnabled() {
        return enabled;
    }

    public void setEnabled(String enabled) {
        this.enabled = enabled;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
