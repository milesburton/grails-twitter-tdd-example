modules = {

    application {}

    core {
        resource url: '/js/libs/modernizr-2.5.3.min.js',                                 disposition: 'head'
        resource url: '/js/libs/jquery-1.7.1.min.js',                                    disposition: 'head'
        resource url: '/js/plugins.js',                                                  disposition: 'head'

        resource url: '/js/libs/jquery-ui-1.8.20.custom.min.js',                         disposition: 'defer'

        resource url: '/css/reset.css'
        resource url: '/css/fonts.css'
        resource url: '/css/jquery/smoothness/jquery-ui-1.8.20.custom.css'

        resource url: '/less/core.less',                                                attrs: [ rel: "stylesheet/less", type: 'css' ]
        resource url: '/js/core.js',                                                    disposition: 'head'
    }

    twitter {

        resource url: '/less/twitter.less',                                             attrs: [ rel: "stylesheet/less", type: 'css' ]

        resource url: '/js/twitter.js',                                                 disposition: 'defer'
    }

}