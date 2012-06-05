import grails.util.GrailsUtil

class FixtureUrlMappings {

    static mappings = {

        if(GrailsUtil.getEnvironment() == "test") {
            '/fixture/cleanup'                        (controller: 'fixture', action: 'cleanup')
            '/fixture/addbrand'                       (controller: 'fixture', action: 'addbrand')
            '/fixture/addproduct'                     (controller: 'fixture', action: 'addproductforbrand')
            '/fixture/twitterapi/**'                   (controller: 'tweet', action: 'index')
        }

    }
}