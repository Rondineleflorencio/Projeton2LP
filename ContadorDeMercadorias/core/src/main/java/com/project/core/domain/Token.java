package com.project.core.domain;

import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.RandomStringUtils;
import java.time.LocalDateTime;

@Getter
@Setter
public class Token 
{
    private String value;
    private LocalDateTime expiredAt;
    
    public Token(){}
    
    public Token(int val)
    {
        this.expiredAt = LocalDateTime.now().plusMinutes(50);
        this.value = RandomStringUtils.randomAlphabetic(val);
    }
    
    public boolean hasExpired()
    {
        return this.expiredAt.isBefore(LocalDateTime.now());
    }
    
    public boolean notexpired()
    {
        return !hasExpired();
    }

}
