package com.whatsinmyhandbag.twitter.geb.spec

import com.whatsinmyhandbag.twitter.geb.page.TwitterPage

import com.popcornteam.restclient.response.RestResponse

import com.whatsinmyhandbag.twitter.geb.spec.base.BaseSpec
import com.whatsinmyhandbag.twitter.geb.page.TweetSentPage

class TwitterSpec extends BaseSpec {

    def 'verify structure'(){

        given:
            to TwitterPage

        when:
            at TwitterPage

        then:
            heading.displayed
            tweet.displayed
            tweet.brand.displayed
            tweet.product.displayed
            tweet.submit.displayed

        and:
            heading.text() == "What's in My Handbag"
    }

    def 'brands'(){

        given:
            String keyword = 'Prada'
            withBrand(keyword)

        when:
            RestResponse response = jsonClient.get("twitter/brands?term=${keyword}")

        then:
            response.bodyAsString == '["Prada"]'
    }

    def 'brands with no data'(){

        given:
            String keyword = 'Prada'

        when:
            RestResponse response = jsonClient.get("twitter/brands?term=${keyword}")

        then:
            response.bodyAsString == '[]'
    }

    def 'brands with no match'(){

        given:
            String keyword = 'Prada'
            withBrand(keyword)

        when:
            RestResponse response = jsonClient.get("twitter/brands?term=test")

        then:
            response.bodyAsString == '[]'
    }

    def 'products'(){

        given:
            String brand = 'Prada'
            String product = 'Shoe'
            withBrand(brand)
            withProduct(brand,product)

        when:
            RestResponse response = jsonClient.get("twitter/products?brand=${brand}&term=${product}")

        then:
            response.bodyAsString == """["${product}"]"""

    }

    def 'products with no data'(){

        given:
            String brand = 'Prada'
            String product = 'Shoe'

        when:
            RestResponse response = jsonClient.get("twitter/products?brand=${brand}&term=${product}")

        then:
            response.bodyAsString == '[]'

    }

    def 'products with no match'(){

        given:
            String brand = 'Prada'
            String product = 'Shoe'
            withBrand(brand)

        when:
            RestResponse response = jsonClient.get("twitter/products?brand=${brand}&term=${product}")

        then:
            response.bodyAsString == '[]'

    }

    def 'user can search for product'(){

        given:
            String brand = 'Prada'
            String product = 'Shoe'
            withBrand(brand)
            withProduct(brand,product)

        and:
            to TwitterPage

        when:
            at TwitterPage

        and:
            tweet.brand << 'Pra'
            sleep(500)

        then:
            brandDropdown.displayed
            brandDropdown.text() == brand

        when:
            brandDropdown.children().first().children().first().click()
            tweet.brand.value() == brand

        then:
            tweet.product << 'Sho'

        when:
            sleep(500)
            productDropdown.text() == product
            productDropdown.children().first().children().first().click()

        then:
            sleep(500)
            tweet.product.value() == product

        when:
            tweet.submit.click()

        then:
            at TweetSentPage
    }

    def 'user can manually tweet'(){

        given:
            String brand = 'Prada'
            String product = 'Shoe'

        when:
            to TwitterPage
            at TwitterPage

        and:
            tweet.brand << brand
            tweet.product << product
            tweet.submit.click()

        then:
            at TweetSentPage
    }

    def 'user is informed of tweet failure'(){

        given:
            String brand = 'Prada'
            String product = 'fubar'

        when:
            to TwitterPage
            at TwitterPage

        and:
            tweet.brand << brand
            tweet.product << product
            tweet.submit.click()

        then:
            at TwitterPage

        and:
            errors == 'Ops something went wrong posting your tweet. Please try again later'
    }
}
