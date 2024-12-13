package api;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import java.io.IOException;

import static config.Props.props;

public class Specifications {
    public static RequestSpecification baseRequestSpec() throws IOException {
        return new RequestSpecBuilder()
                .setBaseUri(props.userUrl())
                .setContentType(ContentType.JSON)
                .log(LogDetail.BODY)
                .build();
    }
}
