package com.sample

import com.amazonaws.AmazonClientException
import com.amazonaws.AmazonServiceException
import com.amazonaws.auth.profile.ProfileCredentialsProvider
import com.amazonaws.services.s3.AmazonS3Client
import com.amazonaws.services.s3.model.*

public class S3Remove  {

	static String bucketName = "uryyyyyyy-sandbox";
	static String keyName    = "sample.png";
	static AmazonS3Client s3Client;

	public static void main(String[] args) throws IOException {
		s3Client = new AmazonS3Client(new ProfileCredentialsProvider());
		try {
			// Make the bucket version-enabled.
			enableVersioningOnBucket(s3Client, bucketName);

			s3Client.deleteObject(bucketName, keyName)

		} catch (AmazonServiceException ase) {
			System.out.println("Caught an AmazonServiceException.");
			System.out.println("Error Message:    " + ase.getMessage());
			System.out.println("HTTP Status Code: " + ase.getStatusCode());
			System.out.println("AWS Error Code:   " + ase.getErrorCode());
			System.out.println("Error Type:       " + ase.getErrorType());
			System.out.println("Request ID:       " + ase.getRequestId());
		} catch (AmazonClientException ace) {
			System.out.println("Caught an AmazonClientException.");
			System.out.println("Error Message: " + ace.getMessage());
		}

	}

	static void enableVersioningOnBucket(AmazonS3Client s3Client,
	                                     String bucketName) {
		BucketVersioningConfiguration config = new BucketVersioningConfiguration()
				.withStatus(BucketVersioningConfiguration.ENABLED);
		SetBucketVersioningConfigurationRequest setBucketVersioningConfigurationRequest = new SetBucketVersioningConfigurationRequest(
				bucketName, config);
		s3Client.setBucketVersioningConfiguration(setBucketVersioningConfigurationRequest);
	}

	static String putAnObject(String keyName) {
		String content = "This is the content body!";
		String key = "ObjectToDelete-" + new Random().nextInt();
		ObjectMetadata metadata = new ObjectMetadata();
		metadata.setHeader("Subject", "Content-As-Object");
		metadata.setHeader("Content-Length", content.length());
		PutObjectRequest request = new PutObjectRequest(bucketName, key,
				new ByteArrayInputStream(content.getBytes()), metadata)
				.withCannedAcl(CannedAccessControlList.AuthenticatedRead);
		PutObjectResult response = s3Client.putObject(request);
		return response.getVersionId();
	}
}