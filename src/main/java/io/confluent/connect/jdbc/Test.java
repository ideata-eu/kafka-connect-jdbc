package io.confluent.connect.jdbc;

import org.jhades.JHades;

public class Test {
    public static void main(String[] args) {
        new JHades().printClassLoaderNames()
                .printClasspath()
                .overlappingJarsReport()
                .multipleClassVersionsReport()
                .findClassByName("javax.ws.rs.core.Application");
    }
}
