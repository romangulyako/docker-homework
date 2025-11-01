package by.itacademy.dockermultistage.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
    @GetMapping("/")
    public String hello() {
        return """
            <!DOCTYPE html>
            <html>
            <head>
                <title>Java Docker App</title>
                <style>
                    body { font-family: Arial, sans-serif; margin: 40px; }
                    .container { max-width: 800px; margin: 0 auto; }
                    .info { background: #f0f0f0; padding: 20px; margin: 10px 0; }
                </style>
            </head>
            <body>
                <div class="container">
                    <h1>🚀 Multi-Stage Docker App</h1>
                    <div class="info">
                        <h2>Application Information</h2>
                        <p><strong>Technology:</strong> Spring Boot + Maven</p>
                        <p><strong>Build:</strong> Multi-stage Docker</p>
                        <p><strong>Runtime:</strong> JRE 17</p>
                    </div>
                    <div class="info">
                        <h2>Build Details</h2>
                        <p><strong>Build Stage:</strong> Maven with JDK 17</p>
                        <p><strong>Runtime Stage:</strong> JRE 17 (smaller image)</p>
                        <p><strong>Final Image Size:</strong> ~200MB (vs ~500MB with JDK)</p>
                    </div>
                    <div class="info">
                        <h2>Endpoints</h2>
                        <ul>
                            <li><a href="/">Home</a></li>
                            <li><a href="/health">Health Check</a></li>
                            <li><a href="/info">Build Info</a></li>
                        </ul>
                    </div>
                </div>
            </body>
            </html>
           \s""";
    }

    @GetMapping("/health")
    public String health() {
        return "{\"status\": \"healthy\", \"service\": \"java-app\"}";
    }

    @GetMapping("/info")
    public String info() {
        return """
            {
                "application": "Java Docker Multi-Stage",
                "java.version": "%s",
                "build.type": "multi-stage-docker",
                "message": "Built with Maven in Docker, running on JRE"
            }
            """.formatted(System.getProperty("java.version"));
    }
}
