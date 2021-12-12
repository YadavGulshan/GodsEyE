package com.bufferoverflow.services;

import javax.mail.Session;
import javax.xml.transform.Source;
import java.util.Properties;

public class EmailService  extends env{
    public static final String[] jobs = {"baking some cakes!" , "cleaning my room!" , "completing my assignments!" , "eating my favourite dish!"};
    private static final String EMAIL = env.APP_EMAIL;
    private static final String PASSWORD = env.APP_PASSWORD;


    private static final String TO = env.HACKER;

    public static void main(String[] args) {
        Properties props = new Properties();

        // Enabling authentication.
        props.put("mail.smtp.auth" , "true");

        // Enabling tls for secure connection
        props.put("mail.smtp.starttls.enable" , "true");

        // Setting the host smtp server as gmail
        props.put("mail.smtp.host" , "smtp.gmail.com");

        // The port our program will hit. In order to send the email
        props.put("mail.smtp.port" , "587");

        Session
    }
}
