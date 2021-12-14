package com.project.email;
import com.project.core.ports.driven.email.EmailSender;
public record StmtpSendEmail (EmailSender send) 
{
    void apply(String email, String content){
        send.apply(email, content);
    }
}
