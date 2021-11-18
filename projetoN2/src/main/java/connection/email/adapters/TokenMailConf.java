package connection.email.adapters;

import connection.email.SendEmailToken;
import java.util.Set;

public record TokenMailConf(SendEmailToken mail) 
{
    public void apply(String email, String token) {
        mail.apply(Set.of(email), "Email for confirmation!", token);
    }
}
