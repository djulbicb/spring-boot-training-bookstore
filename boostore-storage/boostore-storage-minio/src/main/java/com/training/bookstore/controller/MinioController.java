package com.training.bookstore.controller;

import com.training.bookstore.api.Endpoint;
import com.training.bookstore.EndpointConfiguration;
import io.minio.*;
import io.minio.errors.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.*;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

@RestController
@RequestMapping("/api/minio/")
public class MinioController {

    @Autowired
    EndpointConfiguration configuration;

    @RequestMapping("/write")
    public String write(@RequestBody MinioModel model) throws IOException, InvalidKeyException, InvalidResponseException, InsufficientDataException, NoSuchAlgorithmException, ServerException, InternalException, XmlParserException, ErrorResponseException {
        Endpoint minio = configuration.getMinio();

        MinioClient client = MinioClient.builder()
                .endpoint(minio.getLocation())
                .credentials(minio.getUsername(), minio.getPassword())
                .build();

        ifBucketDoesntExistCreateIt(model.getBucketName(), client);

        byte[] bytes = model.getContent().getBytes();
        client.putObject(
                PutObjectArgs.builder()
                        .bucket(model.getBucketName())
                        .object(model.getIdentifier())
                        .stream(new StringBufferInputStream(model.getContent()), bytes.length, -1)
                        .contentType("application/json")
                        .build());

        return "Minio Wrote";
    }

    private void ifBucketDoesntExistCreateIt(String bucketName, MinioClient client) throws IOException, java.rmi.ServerException, InsufficientDataException, jdk.nashorn.internal.runtime.regexp.joni.exception.InternalException, InvalidResponseException, InvalidKeyException, NoSuchAlgorithmException, XmlParserException, ErrorResponseException, io.minio.errors.ServerException, io.minio.errors.InternalException {
        boolean found =  client.bucketExists(BucketExistsArgs.builder().bucket(bucketName).build());
        if (!found) {
            client.makeBucket(MakeBucketArgs.builder().bucket(bucketName).build());
        }
    }

    public String byteToString(InputStream inputStream) throws IOException {
        //creating an InputStreamReader object
        InputStreamReader isReader = new InputStreamReader(inputStream);
        //Creating a BufferedReader object
        BufferedReader reader = new BufferedReader(isReader);
        StringBuffer sb = new StringBuffer();
        String str;
        while((str = reader.readLine())!= null){
            sb.append(str);
        }
        return sb.toString();
    }

    @RequestMapping("/read")
    public String read(@RequestBody MinioModel model) throws IOException, ServerException, InsufficientDataException, InternalException, InvalidResponseException, InvalidKeyException, NoSuchAlgorithmException, XmlParserException, ErrorResponseException {
        Endpoint minio = configuration.getMinio();

        MinioClient client = MinioClient.builder()
                .endpoint(minio.getLocation())
                .credentials(minio.getUsername(), minio.getPassword())
                .build();

        try (InputStream stream =
                     client.getObject(
                             GetObjectArgs.builder()
                                     .bucket(model.getBucketName())
                                     .object(model.getIdentifier())
                                     .build()
                     )) {
            return byteToString(stream);
        }
    }

}
