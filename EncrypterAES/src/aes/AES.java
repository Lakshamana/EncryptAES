package aes;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Scanner;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class AES {
    
    private byte[] key;
    private static final String ALGORITHM = "AES";
    public AES(byte[] key){
        this.key = key;
    }
    public byte[] encrypt(byte[] plainText) throws Exception
    {
        SecretKeySpec secretKey = new SecretKeySpec(key, ALGORITHM);
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);

        return cipher.doFinal(plainText);
    }

    /**
     * Decrypts the given byte array
     *
     * @param cipherText The data to decrypt
     */
    public byte[] decrypt(byte[] cipherText) throws Exception
    {
        SecretKeySpec secretKey = new SecretKeySpec(key, ALGORITHM);
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.DECRYPT_MODE, secretKey);
    
        return cipher.doFinal(cipherText);
    }

    public static void main(String[] args) throws FileNotFoundException {
        String path = "C:\\Users\\Guilherme\\Documents\\NetBeansProjects\\"
                + "Teste_GoogleDrive_UploadDownload\\src\\"
                + "teste_googledrive\\resources\\client_secret.json";
        File file = new File(path);
        String source = "";
        byte[] cipher;
        String dec = "";
        try {
            Scanner sc = new Scanner(file);
            while (sc.hasNextLine()) {
                source += sc.nextLine();
            }
        } catch (FileNotFoundException f) {
            f.printStackTrace();
        }
        
    }
}

