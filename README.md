# Eve Data and Reporting Tool 

The Eve Data and Reporting Tool (EveDRT) is a program that retrieves data from the Eve Swagger Interface and produces useful reports for use with Eve Online.

## Prerequisites

EveDRT is a Java application that runs on your computer. You will need to have a Java Virtual Machine (JVM) installed. The easiest way to do this is to install a JVM using the package manager provided by your operating system. You can also download an OpenDJDK distribution (which includes a JVM) from [Adoptium](https://adoptium.net).

## Installing and Running

To install, download the .jar file from the latest build and put it anywhere. It is best to put the file in its own directory, because EveDRT will use its working directory to cache data and store other information.

To run, open a shell/terminal in the directory where you put the .jar file. Then run `java -jar evedrt.jar <args>` replacing <args> with program arguments as described below.

### Authenticating

If you are using EveDRT to acces information that is not available to all Eve characters, then you will need to authenticate. To do this, pass `auth` as the only argument. The program will print instructions on how to sign in to the official Eve Online site using your browser. 

Token refresh is not yet implemented, so authentication will only last for a short while. It is best to authenticate before each query.

### Queries

You can execute a query by passing arguments `query <filename>` where <filename> is the path to a json file containing the query.

#### Market Report

