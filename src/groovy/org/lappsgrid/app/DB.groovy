package org.lappsgrid.app

import org.anc.lapps.client.RemoteService
import org.anc.lapps.servers.Server
import org.lappsgrid.discriminator.DiscriminatorRegistry

/**
 *
 * @author jdstuart
 */
class DB
{
//    private static final log = LoggerFactory.getLogger(this.class)

    private static final SERVICE_USERNAME = 'operator'
    private static final SERVICE_PASSWORD = 'operator'

    static init()
    {
        initDiscriminatorType()
        initServiceTable()
        initDataSourceTable()
    }

    static initDiscriminatorType()
    {
        if (!DiscriminatorType.count())
        {
            def registry = new DiscriminatorRegistry()
            registry.types().each { value ->
                String name = DiscriminatorRegistry.get(value)
//                println "name: $name, value: $value"
                new DiscriminatorType(name:name, value:value).save()
            }

            println "DiscriminatorType count: ${DiscriminatorType.count()}"
        }
    }

    static initServiceTable()
    {
        if (!Service.count())
        {
            def baseURL = 'http://grid.anc.org:8080/service_manager/invoker/anc:'
            [
                'GATE_SPLITTER',
                'GATE_TOKENIZER',
                'GATE_TAGGER',
                'OPENNLP_SPLITTER',
                'OPENNLP_TOKENIZER',
                'OPENNLP_TAGGER',
                'STANFORD_SPLITTER',
                'STANFORD_TOKENIZER',
                'STANFORD_TAGGER'
            ].each { serviceName ->
                println "Working with service: $serviceName"
                def serviceURL = "${baseURL}${serviceName}"
//                println "Service URL: $serviceURL"

                def service = new Service(name:serviceName, url:serviceURL)

                def remoteService = new RemoteService(serviceURL, SERVICE_USERNAME, SERVICE_PASSWORD)
                def requires = remoteService.requires()
                requires.each { type ->
                    def discriminatorType = DiscriminatorType.findByValue(type)
//                    println "Requires type: ${discriminatorType.name}"
                    service.addToRequires(discriminatorType)
                }
                def produces = remoteService.produces()
                produces.each { type ->
                    def discriminatorType = DiscriminatorType.findByValue(type)
//                    println "Produces type: ${discriminatorType.name}"
                    service.addToRequires(discriminatorType)
                }

                service.save()
            }

            println "Service count: ${Service.count()}"

        }
    }

    static initDataSourceTable()
    {
        def baseURL = "http://grid.anc.org:8080/service_manager/invoker/anc:"
        if (!DataSource.count())
        {
            [
                "MASC_TEXT",
                "MASC_HEADERS",
                "MASC_DATA"
            ].each { dsName ->
                def dataSource = new DataSource(name:dsName, url:"${baseURL}${dsName}").save()
            }
            println "DataSource count: ${DataSource.count()}"
        }
    }
}
