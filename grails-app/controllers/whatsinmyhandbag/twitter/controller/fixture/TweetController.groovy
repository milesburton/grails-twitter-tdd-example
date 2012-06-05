package whatsinmyhandbag.twitter.controller.fixture

class TweetController {

    def index() {

        if (params.status.contains('fubar')) {
            render(status: 500, text: 'esplod!')
        } else {
            render(status: 200, contentType: "application/json", text: "\n" +
                    "{\"created_at\":\"Tue Feb 21 21:29:07 +0000 2012\",\"id\":172070369035956224,\"id_str\":\"172070369035956224\",\"text\":\"The \\\"http:\\/\\/\\\" at the beginning of URLs is a command to the browser. It stands for \\\"head to this place:\\\" followed by two laser-gun noises.\",\"source\":\"web\",\"truncated\":false,\"in_reply_to_status_id\":null,\"in_reply_to_status_id_str\":null,\"in_reply_to_user_id\":null,\"in_reply_to_user_id_str\":null,\"in_reply_to_screen_name\":null,\"user\":{\"id\":63846421,\"id_str\":\"63846421\",\"name\":\"Brian Sutorius\",\"screen_name\":\"bsuto\",\"location\":\"\",\"description\":\"Every day I wake up and put on my gym shorts one leg at a time.\",\"url\":null,\"protected\":false,\"followers_count\":2278,\"friends_count\":98,\"listed_count\":98,\"created_at\":\"Fri Aug 07 22:49:15 +0000 2009\",\"favourites_count\":342,\"utc_offset\":-18000,\"time_zone\":\"Eastern Time (US & Canada)\",\"geo_enabled\":false,\"verified\":false,\"statuses_count\":625,\"lang\":\"en\",\"contributors_enabled\":false,\"is_translator\":false,\"profile_background_color\":\"4A4A4A\",\"profile_background_image_url\":\"http:\\/\\/a0.twimg.com\\/profile_background_images\\/315830622\\/bg.png\",\"profile_background_image_url_https\":\"https:\\/\\/si0.twimg.com\\/profile_background_images\\/315830622\\/bg.png\",\"profile_background_tile\":true,\"profile_image_url\":\"http:\\/\\/a0.twimg.com\\/profile_images\\/1614618159\\/av_normal.png\",\"profile_image_url_https\":\"https:\\/\\/si0.twimg.com\\/profile_images\\/1614618159\\/av_normal.png\",\"profile_link_color\":\"34395C\",\"profile_sidebar_border_color\":\"FFFFFF\",\"profile_sidebar_fill_color\":\"FFFFFF\",\"profile_text_color\":\"222222\",\"profile_use_background_image\":true,\"show_all_inline_media\":true,\"default_profile\":false,\"default_profile_image\":false,\"following\":null,\"follow_request_sent\":null,\"notifications\":null},\"geo\":null,\"coordinates\":null,\"place\":null,\"contributors\":null,\"retweet_count\":1711,\"entities\":{\"hashtags\":[],\"urls\":[],\"user_mentions\":[]},\"favorited\":false,\"retweeted\":false}")
        }
    }
}
