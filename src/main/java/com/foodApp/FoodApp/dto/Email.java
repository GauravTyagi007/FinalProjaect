package com.foodApp.FoodApp.dto;

public class Email {

    private String recipient;
    private String msgBody;
    private String subject;
    public String getRecipient()
    {
        return recipient;
    }
    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }
    public String getMsgBody() {
        return msgBody;
    }
    public void setMsgBody(String msgBody) {
        this.msgBody = msgBody;
    }
    public String getSubject() {
        return subject;
    }
    public void setSubject(String subject) {
        this.subject = subject;
    }
    public Email() {
        super();
    }
    public Email(String recipient, String msgBody, String subject) {
        super();
        this.recipient = recipient;
        this.msgBody = msgBody;
        this.subject = subject;
    }

}
