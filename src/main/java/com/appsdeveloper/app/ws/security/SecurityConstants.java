package com.appsdeveloper.app.ws.security;

import org.springframework.core.env.Environment;

import com.appsdeveloper.app.ws.mobileappws.SpringApplicationContext;

public class SecurityConstants {

    public static final long EXPIRATION_TIME = 864000000; // 10 days
    public static final String TOKEN_PREFIX = "Bearer";
    public static final String HEADER_STRING = "Authorization";
    public static final String SIGN_UP_URL = "/users";

    public static String TOKEN_SECRET;

    public static String getTokenSecret(){
        Environment environment = (Environment) SpringApplicationContext.getBean("environment");
        return environment.getProperty("tokenSecret");
    }
    // public String getTokenSecret() {
    //     return env.getProperty("tokenSecret");
    // }
    // @Value("${tokenSecret}")
    // public static final String TOKEN_SECRET;
    //  = "eyJhbGciOiJIUzUxMiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiIxMjM0NTY3ODkwIiwibmFtZSI6IkpvaG4gRG9lIiwiaWF0IjoxNTE2MjM5MDIyfQ.ayKnYDcgaSFz3Bj6G1v5FiZK5iNuGczwX-ZY9KtTj7Tm9tRKgONa1qRlMQUvDcRL1rSKG_z1xNwC0zYEBhD_Sw";
}