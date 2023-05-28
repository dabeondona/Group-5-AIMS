package com.mycompany.japps;

public class Session {
    
    private static int sessionToken = 0;
    
    public static void setSessionToken(int id) {
        sessionToken = id;
    }
    
    public static int getSessionToken() {
        return sessionToken;
    }
    
}
