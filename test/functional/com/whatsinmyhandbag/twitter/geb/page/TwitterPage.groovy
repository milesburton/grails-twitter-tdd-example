package com.whatsinmyhandbag.twitter.geb.page

import geb.Page
import com.whatsinmyhandbag.twitter.geb.module.TweetModule

class TwitterPage extends Page {

    static url = ''

    static at = {
        assert title == 'Tweet Centre'
        return true
    }

    static content = {
        heading                          { $('header') }
        tweet                            { module TweetModule, $('form.tweet') }
        brandDropdown                    { $('#brand-dropdown') }
        productDropdown(required:false)  { $('#product-dropdown') }
        errors(required: false)          { $('.error').text() }
    }

}
