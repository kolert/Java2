package lv.javaguru.java2.functions;

import org.apache.tomcat.util.codec.binary.Base64;

import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.SecureRandom;

public class PasswordFunctions {

    private static final int iterations = 20*1000;
    private static final String saltString = "hjkh42kj3h4jk23h4jkh23jkh234jk23h";
    private static final int desiredKeyLen = 256;

    public static String getSaltedHash(String password) throws Exception {
        byte[] salt = saltString.getBytes(StandardCharsets.UTF_8);
        // store the salt with the password
        return hash(password, salt);
    }

    /** Checks whether given plaintext password corresponds
     to a stored salted hash of the password. */
    public static boolean check(String password, String stored) throws Exception{
        String hashOfInput = hash(password, saltString.getBytes(StandardCharsets.UTF_8));
        return hashOfInput.equals(stored);
    }

    // using PBKDF2 from Sun, an alternative is https://github.com/wg/scrypt
    // cf. http://www.unlimitednovelty.com/2012/03/dont-use-bcrypt.html
    private static String hash(String password, byte[] salt) throws Exception {
        if (password == null || password.length() == 0)
            throw new IllegalArgumentException("Empty passwords are not supported.");
        SecretKeyFactory f = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
        SecretKey key = f.generateSecret(new PBEKeySpec(
                password.toCharArray(), salt, iterations, desiredKeyLen)
        );
        return Base64.encodeBase64String(key.getEncoded());
    }
}
