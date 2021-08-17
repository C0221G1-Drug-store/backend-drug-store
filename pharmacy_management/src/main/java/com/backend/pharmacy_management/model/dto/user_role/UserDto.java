package com.backend.pharmacy_management.model.dto.user_role;

public class UserDto {
    private Long userId;
    private String userName;
    private String userCode;
    private String accountName;
    private String encrytedPassword;
    private String enabled;

    public UserDto() {
    }

    public UserDto(String userName, String userCode, String accountName, String encrytedPassword, String enabled) {
        this.userName = userName;
        this.userCode = userCode;
        this.accountName = accountName;
        this.encrytedPassword = encrytedPassword;
        this.enabled = enabled;
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
}
