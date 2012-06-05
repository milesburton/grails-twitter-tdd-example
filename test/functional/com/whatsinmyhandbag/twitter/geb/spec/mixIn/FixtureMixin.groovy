package com.whatsinmyhandbag.twitter.geb.spec.mixIn

import com.popcornteam.restclient.request.StringBody

class FixtureMixin {

    void cleanFixture(){

        assert jsonClient.post('fixture/cleanup', new StringBody('')).status == 200
    }

    void withBrand(String brandName){

        assert jsonClient.post("fixture/addbrand?brandName=${brandName}", new StringBody('')).bodyAsString > 0
    }

    void withProduct(String brandName, String productName){

        assert jsonClient.post("fixture/addproduct?productName=${productName}&brand=${brandName}", new StringBody('')).bodyAsString > 0
    }

}
