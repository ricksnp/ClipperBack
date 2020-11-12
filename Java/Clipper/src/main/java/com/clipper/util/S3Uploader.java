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
	
	private static final String k = "FDRHJTP5OERDYWG5AIKA";
	private static final String sk = "alFfEe0dQoojA6sxVK0qFdXJzrM9cmpSEp8Cs9Nz";

	private static String reverse(String str){
		StringBuffer sbr = new StringBuffer(str);
		sbr.reverse();

		return sbr.toString();
	}
	
	private static final String bucketName = "clipperrev";
	private static final BasicAWSCredentials creds = new BasicAWSCredentials(reverse(k), reverse(sk));
	private static final AmazonS3 s3 = AmazonS3Client
					.builder()
					.withRegion("us-east-1")
					.withCredentials(new AWSStaticCredentialsProvider(creds))
					.build();
	
	public S3Uploader() {}
	
	/**
	 * S3 Upload method, which generates a random string for the file name.
	 * @param bytes The byte array to be uploaded
	 * @return The name of the file
	 */
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
