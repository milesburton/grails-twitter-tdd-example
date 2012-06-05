package com.whatsinmyhandbag.twitter.geb.module

import geb.Module

class TweetModule extends Module{

    static content = {
        brand           { $('#brand') }
        product         { $('#product') }
        submit          { $('#submit') }
    }
}
