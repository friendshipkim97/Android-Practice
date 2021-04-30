package com.cookandroid.myapplication;

public class UserAccount {

    private String idToken; // Firebase Uid ( 고유 토큰정보)
    private String emailId; // 이메일 아이디
    private String password; // 비밀번호

    public UserAccount(){ // 파이어베이스는 빈생성자 만들어야 함
    }

    public String getEmailId() {return emailId; }
    public void setEmailId(String emailId) {this.emailId = emailId; }
    public String getPassword() {return password; }
    public void setPassword(String password) { this.password = password; }
    public String getIdToken() {return idToken; }
    public void setIdToken(String idToken) {this.idToken = idToken; }
}
