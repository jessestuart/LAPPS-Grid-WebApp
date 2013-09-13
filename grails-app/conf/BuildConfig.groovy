grails.servlet.version = "2.5" // Change depending on target container compliance (2.5 or 3.0)
grails.project.class.dir = "target/classes"
grails.project.test.class.dir = "target/test-classes"
grails.project.test.reports.dir = "target/test-reports"
grails.project.target.level = 1.6
grails.project.source.level = 1.6
// grails.project.war.file = "target/${appName}-${appVersion}.war"

grails.project.dependency.resolution = {
    // inherit Grails' default dependencies
    inherits("global") {
        // uncomment to disable ehcache
        // excludes 'ehcache'
//        excludes 'grails-plugin-log4j', 'log4j'
    }
    log "error" // log level of Ivy resolver, either 'error', 'warn', 'info', 'debug' or 'verbose'
    checksums true // Whether to verify checksums on resolve

    repositories {
        inherits true // Whether to inherit repository definitions from plugins
        grailsPlugins()
        grailsHome()
        grailsCentral()
        mavenCentral()

        mavenLocal()
        mavenRepo "http://www.anc.org/maven/release"
        mavenRepo "http://www.anc.org/maven/snapshot"
        mavenRepo "http://www.anc.org:8080/nexus/content/repositories/snapshots"
        mavenRepo "http://www.anc.org:8080/nexus/content/repositories/releases"

        // uncomment these to enable remote dependency resolution from public Maven repositories
        //mavenCentral()
        //mavenLocal()
        //mavenRepo "http://snapshots.repository.codehaus.org"
        //mavenRepo "http://repository.codehaus.org"
        //mavenRepo "http://download.java.net/maven/2/"
        //mavenRepo "http://repository.jboss.com/maven2/"
    }

    def versions = [
            lapps:"1.0.1-SNAPSHOT",
            discriminator:'1.2.0',
            logback:'1.0.6',
            slf4j:'1.6.2'
    ]

    dependencies {
        // specify dependencies here under either 'build', 'compile', 'runtime', 'test' or 'provided' scopes eg.
        compile "org.anc.lapps.proc.client:soap-client:${versions.lapps}"
        compile "org.lappsgrid:discriminator:${versions.discriminator}"

        // Logging
//        build "ch.qos.logback:logback-core:${versions.logback}"
//        build "ch.qos.logback:logback-classic:${versions.logback}"
//        runtime "ch.qos.logback:logback-core:${versions.logback}"
//        runtime "ch.qos.logback:logback-classic:${versions.logback}"
//        runtime "org.slf4j:log4j-over-slf4j:${versions.slf4j}"

        // runtime 'mysql:mysql-connector-java:5.1.16'
    }

    plugins {
        runtime ":hibernate:$grailsVersion"
        runtime ":jquery:1.7.1"
        runtime ":resources:1.1.6"

        // Uncomment these (or add new ones) to enable additional resources capabilities
        //runtime ":zipped-resources:1.0"
        //runtime ":cached-resources:1.0"
        //runtime ":yui-minify-resources:0.1.4"

        build ":tomcat:$grailsVersion"
    }
}
