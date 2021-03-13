## Usage
first u need to start jeager all-in-one container
```
docker run -d --name jaeger \
  -e COLLECTOR_ZIPKIN_HTTP_PORT=9411 \
  -p 5775:5775/udp \
  -p 6831:6831/udp \
  -p 6832:6832/udp \
  -p 5778:5778 \
  -p 16686:16686 \
  -p 14268:14268 \
  -p 14250:14250 \
  -p 9411:9411 \
  jaegertracing/all-in-one:1.22
```
**application.yml**
```yaml
opentracing:
  jaeger:
    enabled: true
    http-sender:
      url: http://${JAEGER_HOST}:14268/api/traces
```
**rest controller** example:
```java
import org.oncors.logic.Trace;
import org.oncors.EnableTracing;

@EnableTracing
public class HelloApi {

    @Trace
    @GetMapping
    public ResponseEntity<String> hello() {
    }
}
```

### Jeager console
[http://localhost:16686/](http://localhost:16686/)
