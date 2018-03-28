package blog

import io.ktor.application.*
import io.ktor.features.*
import io.ktor.routing.*
import io.ktor.html.*
import kotlinx.html.*

fun Application.main(){
    install(DefaultHeaders)
    install(CallLogging)
    install(Routing) {
        get("/"){
            call.respondHtml {
                head {
                    title { + "Kotlin on Azure App Service"}
                    styleLink("https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css")
                }
                body {
                    h1 { +"Fun with Kotlin!"}
                    jumbotron { "It's running on an Azure App Service." }
                    script { src = "https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" }
                }
            }
        }
    }
}

@HtmlTagMarker
fun FlowContent.jumbotron(body: FlowContent.() -> Unit){
    div {
        classes = setOf("jumbotron")
        h1{ body() }
        p{+"This is deployed using the continuous deployments from Github in the App Service."}
        p{
            a{
                classes = setOf("btn", "btn-primary", "btn-lg")
                href = "#"
                role = "button"
                +"Learn More"
            }
        }
    }
}

