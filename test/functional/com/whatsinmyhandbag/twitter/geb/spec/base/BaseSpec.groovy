package com.whatsinmyhandbag.twitter.geb.spec.base

import geb.spock.GebSpec
import com.popcornteam.restclient.RestClient
import com.popcornteam.restclient.factory.HttpClientFactory
import org.apache.http.client.HttpClient
import com.whatsinmyhandbag.twitter.geb.spec.mixIn.FixtureMixin

@Mixin(FixtureMixin)
abstract class BaseSpec extends GebSpec {

    RestClient jsonClient

    void setup(){
        HttpClientFactory httpClientFactory = new HttpClientFactory()
        HttpClient httpClient = httpClientFactory.makeThreadSafeHttpClient(2)

        jsonClient = new RestClient(baseUrl, [], httpClient)
    }

    void cleanup(){
        cleanFixture()
    }
}
