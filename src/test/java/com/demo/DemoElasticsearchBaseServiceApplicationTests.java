package com.demo;

import org.apache.http.HttpHost;
import org.elasticsearch.action.admin.indices.alias.get.GetAliasesRequest;
import org.elasticsearch.client.GetAliasesResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.cluster.metadata.AliasMetaData;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

//@SpringBootTest
class DemoElasticsearchBaseServiceApplicationTests {
    RestHighLevelClient client = null;

    @BeforeEach
    void init() {
        client = new RestHighLevelClient(
                RestClient.builder(
                        new HttpHost("172.18.32.17", 9200, "http"),
                        new HttpHost("172.18.32.18", 9200, "http"),
                        new HttpHost("172.18.32.19", 9200, "http")));
    }

    @Test
    void contextLoads() throws IOException {
        GetAliasesRequest request = new GetAliasesRequest();
        GetAliasesResponse getAliasesResponse = null;

        getAliasesResponse = this.client.indices().getAlias(request, RequestOptions.DEFAULT);

        Map<String, Set<AliasMetaData>> aliases = getAliasesResponse.getAliases();

        System.out.println(aliases);
    }
}
