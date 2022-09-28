package com.foodApp.FoodApp.dto;


import io.swagger.annotations.ApiModelProperty;

public class Email {

    @ApiModelProperty(notes="email recipient",required = true)
    private String recipient;
    @ApiModelProperty(notes="email msgBody",required = true)
    private String msgBody;
    @ApiModelProperty(notes="email subject",required = true)
    private String subject;
    public String getRecipient() {
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
