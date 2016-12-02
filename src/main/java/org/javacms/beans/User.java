package org.javacms.beans;

import java.util.Date;

public class User {
    private Integer userId;
    private String username;
    private String email;
    private String password;
    private Date registerTime;
    private String registerIp;
    private Date lastLoginTime;
    private Integer loginCount;
    private String resetKey;
    private String resetPwd;
    private Date errorTime;
    private Integer errorCount;
    private String errorIp;
    private byte activation;
    private String activationCode;

    public User() {
    }

    public Integer getUserId() {
        return userId;
    }
    public void setUserId(Integer userId) {
        this.userId = userId;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public Date getRegisterTime() {
        return registerTime;
    }
    public void setRegisterTime(Date registerTime) {
        this.registerTime = registerTime;
    }
    public String getRegisterIp() {
        return registerIp;
    }
    public void setRegisterIp(String registerIp) {
        this.registerIp = registerIp;
    }
    public Date getLastLoginTime() {
        return lastLoginTime;
    }
    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }
    public Integer getLoginCount() {
        return loginCount;
    }
    public void setLoginCount(Integer loginCount) {
        this.loginCount = loginCount;
    }
    public String getResetKey() {
        return resetKey;
    }
    public void setResetKey(String resetKey) {
        this.resetKey = resetKey;
    }
    public String getResetPwd() {
        return resetPwd;
    }
    public void setResetPwd(String resetPwd) {
        this.resetPwd = resetPwd;
    }
    public Date getErrorTime() {
        return errorTime;
    }
    public void setErrorTime(Date errorTime) {
        this.errorTime = errorTime;
    }
    public Integer getErrorCount() {
        return errorCount;
    }
    public void setErrorCount(Integer errorCount) {
        this.errorCount = errorCount;
    }
    public String getErrorIp() {
        return errorIp;
    }
    public void setErrorIp(String errorIp) {
        this.errorIp = errorIp;
    }
    public byte getActivation() {
        return activation;
    }
    public void setActivation(byte activation) {
        this.activation = activation;
    }
    public String getActivationCode() {
        return activationCode;
    }
    public void setActivationCode(String activationCode) {
        this.activationCode = activationCode;
    }
}
