package whatsinmyhandbag.twitter.controller

import whatsinmyhandbag.twitter.domain.Brand
import grails.converters.JSON
import whatsinmyhandbag.twitter.domain.Product
import twitter4j.TwitterException
import whatsinmyhandbag.twitter.controller.command.TweetCommand

class TwitterController {

    def twitter4jService

    def index() {
      render(view: '/twitter/twitter')
    }

    def brands(String term){

        List<Brand> brands = Brand.findAllByNameLike(term+'%',[max:15])

        render brands*.name as JSON
    }

    def products(String brand, String term){

        List<Product> products = Product.findAllByNameLike(term+'%',[max:15])

        render products*.name as JSON
    }

    def statusupdate(TweetCommand cmd){

        if (cmd.hasErrors()){
            flash.message = cmd.errors.toString()
            return redirect([action: 'index'])
        }

        try{
            twitter4jService.updateStatus("I have ${cmd.brand}'s ${cmd.product} in my Handbag")

        }catch(TwitterException ex){

            log.error ex
            flash.message = "Ops something went wrong posting your tweet. Please try again later"
            return redirect([action: 'index'])
        }

        render(view: '/twitter/success')
    }
}
