# Songr

Songr is a web server.  It handles requests on paths and delivers appropriate responses.

## Setup
* Clone the repo via github
```git clone <repo url>```
* Run the application via your IDE or
```./gradlew bootRun```

## Paths

/hello ```public String getHelloWorld()``` Returns "Hello, World!".
/capitalize/{sentence}: ```public String capitalizePath(String sentence)``` Returns the string but capitalized.
/reverse ```public String reverseSentence(sentence)``` Returns the string reverse, but just the words.

# HELP

##Getting Started

### Reference Documentation
For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)

### Guides
The following guides illustrate how to use some features concretely:

* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/bookmarks/)

