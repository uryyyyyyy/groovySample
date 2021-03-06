package com.sample

import com.amazonaws.AmazonClientException
import com.amazonaws.AmazonServiceException
import com.amazonaws.auth.profile.ProfileCredentialsProvider
import com.amazonaws.services.s3.AmazonS3
import com.amazonaws.services.s3.AmazonS3Client
import com.amazonaws.services.s3.model.PutObjectRequest

public class S3Upload {
	private static String bucketName     = "uryyyyyyy-sandbox";
	private static String keyName        = "sample.png";
	//keyName = "hoge/hoge/sample.png" とかやってもそのフォルダを勝手に作ってくれる。
	//TODO 上書きされるっけ？
	private static String uploadFileName = "/home/shiba/Pictures/moke.png";

	public static void main() throws IOException {
		AmazonS3 s3client = new AmazonS3Client(new ProfileCredentialsProvider());
		try {
			System.out.println("Uploading a new object to S3 from a file\n");
			File file = new File(uploadFileName);
			s3client.putObject(new PutObjectRequest(
					bucketName, keyName, file));

		} catch (AmazonServiceException ase) {
			System.out.println("Caught an AmazonServiceException, which " +
					"means your request made it " +
					"to Amazon S3, but was rejected with an error response" +
					" for some reason.");
			System.out.println("Error Message:    " + ase.getMessage());
			System.out.println("HTTP Status Code: " + ase.getStatusCode());
			System.out.println("AWS Error Code:   " + ase.getErrorCode());
			System.out.println("Error Type:       " + ase.getErrorType());
			System.out.println("Request ID:       " + ase.getRequestId());
		} catch (AmazonClientException ace) {
			System.out.println("Caught an AmazonClientException, which " +
					"means the client encountered " +
					"an internal error while trying to " +
					"communicate with S3, " +
					"such as not being able to access the network.");
			System.out.println("Error Message: " + ace.getMessage());
		}
	}
}
