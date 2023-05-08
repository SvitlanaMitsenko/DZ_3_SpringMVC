package org.example.models;


import java.io.Serializable;

public class Message implements Serializable {

    private String userName;
    private String email;
    private String subject;
    private String messageText;
    public Message(String name, String email, String subject, String messageText) {
        //super();
        this.userName = name;
        this.email = email;
        this.subject= subject;
        this.messageText = messageText;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getMessageText() {
        return messageText;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }
}
