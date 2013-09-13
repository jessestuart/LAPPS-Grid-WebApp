package org.lappsgrid.app

class DataSource
{

    /**
     * Name of the data source (i.e., MASC)
     */
    String name

    /**
     * URL linking to the data source service
     */
    URL url

    /**
     *
     */
    LicenseType license

    // TODO add doc type

    static constraints = {
        license nullable:true
    }
}
