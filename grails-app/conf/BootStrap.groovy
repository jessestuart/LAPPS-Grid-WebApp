import org.lappsgrid.app.DB

class BootStrap {

    def init = { servletContext ->
        DB.init()
    }
    def destroy = {
    }
}
