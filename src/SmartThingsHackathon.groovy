@Grab(group='org.codehaus.groovy.modules.http-builder', module='http-builder', version='0.7.1')
@Grab(group='oauth.signpost', module='signpost-core', version='1.2.1.2')
@Grab(group='oauth.signpost', module='signpost-commonshttp4', version='1.2.1.2')
 
import groovy.json.JsonSlurper
import groovyx.net.http.HTTPBuilder
import static groovyx.net.http.ContentType.*
 
def authHeader = 'yournetid@email.arizona.edu/token:yourtoken'.bytes.encodeBase64()
println authHeader
def smartthings = new HTTPBuilder("https://hackathonhelp.zendesk.com/api/v2/")
resp = smartthings.get(path: 'views/active.json', 
                       headers: ["Content-Type": "text/json", "Authorization": "Basic ${authHeader}"]) { resp, json ->

    json.views.each() { obj ->
        println obj.id
    } 
}
