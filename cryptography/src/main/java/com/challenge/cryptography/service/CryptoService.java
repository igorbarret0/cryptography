package com.challenge.cryptography.service;

import org.springframework.stereotype.Service;


import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Service
public class CryptoService {

        public String decodeInfo(String info) {

            try {
                MessageDigest md = MessageDigest.getInstance("SHA-512");

                byte[] messageDigest = md.digest(info.getBytes());

                BigInteger no = new BigInteger(1, messageDigest);

                String infoHashed = no.toString(16);

                while (infoHashed.length() < 32) {
                    infoHashed = "0" + infoHashed;
                }

                return infoHashed;
            } catch (NoSuchAlgorithmException exception) {
                throw new RuntimeException(exception.getMessage());
            }


        }

        public boolean compareInfo(String info, String storedHash) {

            String infoHashed = decodeInfo(info);
            return infoHashed.equals(storedHash);
        }

}
