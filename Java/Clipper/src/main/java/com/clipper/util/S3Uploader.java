package com.clipper.util;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.PutObjectRequest;

import javax.imageio.ImageIO;

public class S3Uploader {
	
	
	private static final String bucketName = "clipperrev";
	private static final BasicAWSCredentials creds = new BasicAWSCredentials("", "");
	private static final AmazonS3 s3 = AmazonS3Client
					.builder()
					.withRegion("us-east-1")
					.withCredentials(new AWSStaticCredentialsProvider(creds))
					.build();
	
	public S3Uploader() {}
	
	public static String upload(byte[] bytes) {
		String subDirectory = "Images/";
		String random = Utilities.getSaltString();
		String fileNameWithPath = subDirectory + random;
		
		 try {
		  File f = File.createTempFile("image", ".png"); 
	      BufferedImage img = ImageIO.read(new ByteArrayInputStream(bytes));
	      ImageIO.write(img, "png", f);
	
	      s3.putObject(new PutObjectRequest(bucketName, fileNameWithPath, f));	
	        
		} catch(IOException e){
			e.printStackTrace();
		}
		return random;
	}
}
