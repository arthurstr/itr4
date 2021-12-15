package com.arthur;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class KeyGen {
    String Key;
    int ComputerMove;
    public void generate(int n) throws NoSuchAlgorithmException {

        SecureRandom random = SecureRandom.getInstanceStrong();
        byte[] values = new byte[32]; // 256 bit
        random.nextBytes(values);
        StringBuilder sb = new StringBuilder();
        ComputerMove = byteArrayToInt(values);
        for (byte b : values) {
            sb.append(String.format("%02x", b));
        }

        Key = sb.toString();
    }
    public static int byteArrayToInt(byte[] b)
    {
        int value = 0;
        for (int i = 0; i < 4; i++) {
            int shift = (4 - 1 - i) * 8;
            value += (b[i] & 0x000000FF) << shift;
        }
        return value;
    }
}
