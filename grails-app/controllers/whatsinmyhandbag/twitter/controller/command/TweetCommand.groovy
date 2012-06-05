package whatsinmyhandbag.twitter.controller.command

class TweetCommand {

    String brand
    String product

    static constraints = {
        brand(blank: false)
        product(blank: false)
    }
}
