package org.lappsgrid.app

class ApplicationController
{

    def index() {
        def dataSources = []
        def labels = []

        [
                dataSources:DataSource.list(),
                services:Service.list()
        ]
    }

    def submit = {
        println "Submitting"
    }
}
