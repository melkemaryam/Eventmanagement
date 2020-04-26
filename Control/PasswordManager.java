package Control;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class PasswordManager {

    public static String hashingPassword(String passToHash) throws NoSuchAlgorithmException {

        MessageDigest messageDig = MessageDigest.getInstance("SHA-256");

        byte[] messageDigest = messageDig.digest(passToHash.getBytes());

        BigInteger num = new BigInteger(1, messageDigest);

        StringBuilder strBuilder = new StringBuilder();
        strBuilder.append(num.toString(16));

        while (strBuilder.length() < 32) {
            strBuilder.insert(0, "0");
        }

        return strBuilder.toString();
    }
}
