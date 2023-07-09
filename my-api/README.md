# My awesome REST API

# Requirements

* Java 11
* Maven 3.6.3

# Building

TBD...

# Running

TBD...

## Checking app healthiness

This app has the actuator [health endpoint](https://docs.spring.io/spring-boot/docs/current/reference/html/production-ready-features.html#production-ready-health) enabled by default.

So you can test if the application is healthy by accessing path `/actuator/health`

```
$ curl http://localhost:8080/actuator/health
{"status":"UP"}
```
