package com.example.jpa.demojpa.restAssuredHelper;

import org.junit.BeforeClass;

import static io.restassured.RestAssured.*;

public class BaseClass {

    @BeforeClass
    public static void setUp() {
        baseURI = "http://localhost";
        port = 8080;
        basePath = "/api";

    }
}
