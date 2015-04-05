package com.sample

import com.amazonaws.AmazonClientException
import com.amazonaws.AmazonServiceException
import com.amazonaws.auth.profile.ProfileCredentialsProvider
import com.amazonaws.services.s3.AmazonS3
import com.amazonaws.services.s3.AmazonS3Client
import com.amazonaws.services.s3.model.GetObjectRequest
import com.amazonaws.services.s3.model.S3Object

public class S3GetObject {
	private static String bucketName = "uryyyyyyy-sandbox";
	private static String key        = "sample.png";
	//key = "folder/memo.md" とかもできる。

	public static void main() throws IOException {
		AmazonS3 s3Client = new AmazonS3Client(new ProfileCredentialsProvider());
		try {
			System.out.println("Downloading an object");
			S3Object s3object = s3Client.getObject(new GetObjectRequest(
					bucketName, key));
			System.out.println("Content-Type: "  +
					s3object.getObjectMetadata().getContentType())
			File file = toFile(s3object)
			println file.getName()

		} catch (AmazonServiceException ase) {
			System.out.println("Caught an AmazonServiceException, which" +
					" means your request made it " +
					"to Amazon S3, but was rejected with an error response" +
					" for some reason.");
			System.out.println("Error Message:    " + ase.getMessage());
			System.out.println("HTTP Status Code: " + ase.getStatusCode());
			System.out.println("AWS Error Code:   " + ase.getErrorCode());
			System.out.println("Error Type:       " + ase.getErrorType());
			System.out.println("Request ID:       " + ase.getRequestId());
		} catch (AmazonClientException ace) {
			System.out.println("Caught an AmazonClientException, which means"+
					" the client encountered " +
					"an internal error while trying to " +
					"communicate with S3, " +
					"such as not being able to access the network.");
			System.out.println("Error Message: " + ace.getMessage());
		}
	}

	static File toFile(S3Object s3Object) {
		InputStream reader = new BufferedInputStream(s3Object.getObjectContent());
		File file = new File("/home/shiba/Pictures/download.png");
		OutputStream writer = new BufferedOutputStream(new FileOutputStream(file));
		int read = -1;
		while ( ( read = reader.read() ) != -1 ) {
			writer.write(read);
		}
		writer.flush();
		writer.close();
		reader.close();
		file
	}
}