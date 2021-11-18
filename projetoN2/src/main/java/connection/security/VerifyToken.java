package connection.security;

import com.nimbusds.jose.JOSEException;
import com.nimbusds.jose.crypto.MACVerifier;
import com.nimbusds.jwt.SignedJWT;
import java.text.ParseException;
import java.time.Instant;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class VerifyToken {
    public static void main(String[] args) 
    {
        String s = null;
        try {
            var token = SignedJWT.parse("eyJraWQiOiIxMjMiLCJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJzZXJ2ZXIiLCJhdWQiOiJ1c2VyIiwic3ViIjoiNjFmNDBhZjEtZmNkMS00Mzk5LWIzZWQtNjFjYjRlN2MxZjc0IiwiZXhwIjoxNjM0NjkwNjk2fQ.b7Etoqna4bjF1cE7n2-6hiYTmwQeK3gGHB4DO7OXCqs");
            
            var alg = token.getHeader().getAlgorithm();
            var sub = token.getJWTClaimsSet().getSubject();
            var expire = token.getJWTClaimsSet().getExpirationTime();
            var signValid = token.verify(new MACVerifier("e9d8c4bb-e5b0-4237-ad9c-a0e9b00b6a0b"));
            
            var tokenValid = !expire.before(Date.from(Instant.now()));
            
            System.out.println(alg);
            System.out.println(sub);
            System.out.println(tokenValid);

        } catch (ParseException ex) {
            Logger.getLogger(VerifyToken.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JOSEException ex) {
            Logger.getLogger(VerifyToken.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
}
