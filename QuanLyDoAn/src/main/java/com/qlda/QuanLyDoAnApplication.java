package com.qlda;


import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.extensions.java6.auth.oauth2.AuthorizationCodeInstalledApp;
import com.google.api.client.extensions.jetty.auth.oauth2.LocalServerReceiver;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.client.util.store.FileDataStoreFactory;
import com.google.api.services.drive.Drive;
import com.google.api.services.drive.DriveScopes;
import com.google.api.services.drive.model.File;
import com.google.api.services.drive.model.FileList;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.List;


import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.qlda.Entity.TaiKhoan;
import com.qlda.Service.DriveManager;
import com.qlda.Service.GoogleDrive;

@SpringBootApplication
@ComponentScan({ "com.qlda.*" })
public class QuanLyDoAnApplication {


	    /**
	     * Creates an authorized Credential object.
	     * @param HTTP_TRANSPORT The network HTTP Transport.
	     * @return An authorized Credential object.
	     * @throws IOException If the credentials.json file cannot be found.
	     */
	
	public static void main(String[] args) throws IOException, GeneralSecurityException {
		SpringApplication.run(QuanLyDoAnApplication.class, args);
		//java.io.File uploadFile = new java.io.File("/Users/Tran Hau/Downloads/test2.txt");
		 
        // Create Google File:
 
		/*
		 * File googleFile = GoogleDrive.createGoogleFile(null, "text/plain",
		 * "newfile.txt", uploadFile);
		 * 
		 * System.out.println("Created Google file!");
		 * System.out.println("WebContentLink: " + googleFile.getWebContentLink() );
		 * System.out.println("WebViewLink: " + googleFile.getWebViewLink() );
		 * 
		 * System.out.println("Done!");
		 */
	}

}
