package lappsgrid.app

class Service
{

    String name

    URL url

    LicenseType license

    static hasMany = [ required:long[], produces:long[] ]

    static constraints = {
    }
}
