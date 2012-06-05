grails.servlet.version = "2.5" // Change depending on target container compliance (2.5 or 3.0)
grails.project.class.dir = "target/classes"
grails.project.test.class.dir = "target/test-classes"
grails.project.test.reports.dir = "target/test-reports"
grails.project.target.level = 1.6
grails.project.source.level = 1.6
//grails.project.war.file = "target/${appName}-${appVersion}.war"

grails.project.dependency.resolution = {
    // inherit Grails' default dependencies
    inherits("global") {
        // uncomment to disable ehcache
        // excludes 'ehcache'
    }
    log "info" // log level of Ivy resolver, either 'error', 'warn', 'info', 'debug' or 'verbose'
    checksums true // Whether to verify checksums on resolve

    repositories {

	mavenRepo "http://repo.grails.org/grails/plugins"

        grailsHome()
        grailsCentral()
        mavenCentral()

        mavenRepo 'http://maven.antelink.com/content/repositories/central'
        mavenRepo 'http://build.mnetcs.com:8081/artifactory/public'
	mavenRepo 'http://www.asual.com/maven/content/groups/public'
    }
    dependencies {
        // specify dependencies here under either 'build', 'compile', 'runtime', 'test' or 'provided' scopes eg.

        runtime 'mysql:mysql-connector-java:5.1.16'

        compile "org.apache.httpcomponents:httpclient:4.1.2",
                "net.xelnaga:http-imposter:1.0.120505.1424"

        test "org.codehaus.geb:geb-spock:0.7.0",
             "org.seleniumhq.selenium:selenium-support:2.21.0",
             "org.seleniumhq.selenium:selenium-firefox-driver:2.21.0",
             "cglib:cglib-nodep:2.2.2",
             "org.objenesis:objenesis:1.2"
    }

    plugins {
        runtime ":hibernate:$grailsVersion"
        runtime ":resources:1.1.6"
        runtime ":lesscss-resources:1.0.1"

        build ":tomcat:$grailsVersion"

        test ":spock:0.6",
             ":geb:0.7.0"
    }
}
