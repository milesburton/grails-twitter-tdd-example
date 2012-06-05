package com.whatsinmyhandbag.twitter.geb.page

import geb.Page

class TweetSentPage extends Page {

    static url = 'statusupdate'

    static at = {
        assert title == 'Tweet Sent'
        return true
    }

    static content = {
        heading                          { $('header') }
    }

}
