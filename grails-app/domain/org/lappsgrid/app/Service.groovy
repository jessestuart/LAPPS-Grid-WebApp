package org.lappsgrid.app

class Service
{

    String name

    URL url

    LicenseType license

    static hasMany = [ requires:DiscriminatorType, produces:DiscriminatorType ]

    static constraints = {
        name blank:false
        url blank:false
        license nullable:true
    }
}
