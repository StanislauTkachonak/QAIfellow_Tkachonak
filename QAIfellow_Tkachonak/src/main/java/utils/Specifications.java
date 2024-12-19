package utils;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import java.io.IOException;

import static utils.Configuration.getConfigurationValue;

public class Specifications {
    public static RequestSpecification baseRequestSpec() throws IOException {
        return new RequestSpecBuilder()
                .setBaseUri(getConfigurationValue("user.url"))
                .setContentType(ContentType.JSON)
                .log(LogDetail.BODY)
                .build();
    }
}
