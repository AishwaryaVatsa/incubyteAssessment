package com.test.incubyte.utils;

import java.util.UUID;


public class RandomEmailUtility {


    /**
     * Generates a random email ID
     * @param domain the email domain
     * @return a randomly generated email ID
     */
    public static String generateRandomEmail(String domain) {
        String uniqueID = UUID.randomUUID().toString().substring(0, 8);
        return "user_" + uniqueID + "@" + domain;
    }

    /**
     * Generates a random email ID with domain test.com
     * @return a randomly generated email ID
     */
    public static String generateRandomEmail() {
        return generateRandomEmail("test.com");
    }
}
