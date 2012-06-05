package whatsinmyhandbag.twitter

import static org.junit.Assert.*

import grails.test.mixin.*
import grails.test.mixin.support.*
import org.junit.*
import whatsinmyhandbag.twitter.controller.TwitterController
import com.popcornteam.restclient.header.ContentType
import whatsinmyhandbag.twitter.domain.Brand
import spock.lang.Specification
import java.awt.print.Book
import grails.test.mixin.domain.DomainClassUnitTestMixin
import grails.plugin.spock.UnitSpec
import whatsinmyhandbag.twitter.domain.Product
import org.twitter4j.grails.plugin.Twitter4jService
import com.sun.jmx.snmp.SnmpParams
import whatsinmyhandbag.twitter.controller.command.TweetCommand
import twitter4j.TwitterException

@TestFor(TwitterController)
class TwitterControllerSpec extends UnitSpec {

    void setup(){
        controller.twitter4jService = Mock(Twitter4jService)
    }

    def 'index'() {

        when:
            controller.index()

        then:
            view == '/twitter/twitter'
    }

    def 'brands'() {

        given:
            String keyword = 'Prada'
            mockDomain(Brand)
            withBrand(keyword)

        when:
            controller.brands(keyword)

        then:
            response.contentType == "${ContentType.APPLICATION_JSON};charset=UTF-8"
            response.text == '["Prada"]'

    }

    def 'products'() {

        given:
            String brandName = 'Prada'
            String keyword = 'Shoe'
            mockDomain(Product)
            mockDomain(Brand)

            withProductAndBrand(brandName, keyword)

        when:
            controller.products(brandName, keyword)

        then:
            response.contentType == "${ContentType.APPLICATION_JSON};charset=UTF-8"
            response.text == '["Shoe"]'

    }

    def 'statusupdate'(){

        given:
            String brand = 'Prada'
            String product = 'Shoe'
            TweetCommand cmd = new TweetCommand(brand: brand, product: product)

        when:
            controller.statusupdate(cmd)

        then:
            (1) * controller.twitter4jService.updateStatus("I have ${cmd.brand}'s ${cmd.product} in my Handbag")

        and:
            view == '/twitter/success'

    }

    def 'statusupdate with exception'(){

        given:
            String brand = 'Prada'
            String product = 'Shoe'
            TweetCommand cmd = new TweetCommand(brand: brand, product: product)

        when:
            controller.statusupdate(cmd)

        then:
            (1) * controller.twitter4jService.updateStatus("I have ${cmd.brand}'s ${cmd.product} in my Handbag") >> {throw new TwitterException('')}

        and:
            flash.message == "Ops something went wrong posting your tweet. Please try again later"

    }

    private void withProductAndBrand(String brandName, String keyword) {

        Brand brand = withBrand(brandName)

        Product product = new Product(
                id: new Random().nextInt(100),
                brandId: brand.id,
                name: keyword,
                description: '',
                type: ''
        ).save(flush: true)
    }

    private Brand withBrand(String brandName) {
        new Brand(name: brandName, id: 0, version: 0, website: 'test', slug: 'test', status: false, isNew: false, description: 'test').save()
    }

}
