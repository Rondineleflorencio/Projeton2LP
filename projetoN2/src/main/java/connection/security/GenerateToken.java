package connection.security;

import com.nimbusds.jose.JOSEException;
import com.nimbusds.jose.JOSEObjectType;
import com.nimbusds.jose.JWEHeader;
import com.nimbusds.jose.JWSAlgorithm;
import com.nimbusds.jose.JWSHeader;
import com.nimbusds.jose.KeyLengthException;
import com.nimbusds.jose.crypto.MACSigner;
import com.nimbusds.jwt.JWTClaimsSet;
import com.nimbusds.jwt.SignedJWT;
import java.time.Instant;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Supplier;

public class GenerateToken 
{
    public static void main(String[] args)
    {
        var supplier = new Supplier();
        
        supplier.setId(123);
        supplier.setContato("rondynelif@gmail.com");
        supplier.setName("joao");
        supplier.setPassword("1234");
        try {
            var header = new JWSHeader.Builder(JWSAlgorithm.HS256)
                    .type(JOSEObjectType.JWT)
                    .keyID("123")
                    .build();
            var playload = new JWTClaimsSet.Builder()
                    .issuer("server")
                    .audience("user")
                    .subject("123")
                    .expirationTime(new Date().from(Instant.now().plusSeconds(60*60*24)))
                    .build();
            var signedJwt = new SignedJWT(header, playload);

            signedJwt.sign(new MACSigner("e9d8c4bb-e5b0-4237-ad9c-a0e9b00b6a0b"));
            
            var jwt = signedJwt.serialize();
            System.out.println(jwt);

        } catch (KeyLengthException ex) {
            Logger.getLogger(GenerateToken.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JOSEException ex) {
            ex.printStackTrace();
        }
    }
}
