# Eve Data and Reporting Tool 

The Eve Data and Reporting Tool (EveDRT) is a program that retrieves data from the Eve Swagger Interface and produces useful reports for use with Eve Online.

## Prerequisites

EveDRT is a Java application that runs on your computer. You will need to have a Java Virtual Machine (JVM) installed. The easiest way to do this is to install a JVM using the package manager provided by your operating system. You can also download an OpenDJDK distribution (which includes a JVM) from [Adoptium](https://adoptium.net).

## Installing and Running

To install, download the .jar file from the latest release and put it anywhere. It is best to put the file in its own directory, because EveDRT will use its working directory to cache data and store other information.

To run, open a shell/terminal in the directory where you put the .jar file. Then run `java -jar evedrt.jar <args>` replacing <args> with program arguments as described below.

### Authenticating

If you are using EveDRT to access information that is not available to all Eve characters, then you will need to authenticate. To do this, pass `auth` as the only argument. The program will print instructions on how to sign in to the official Eve Online site using your browser. 

Token refresh is not yet implemented, so authentication will only last for a short while. It is best to authenticate before each query.

### Queries

You can execute a query by passing arguments `query <filename>` where <filename> is the path to a json file containing the query.

#### Market Query

For now, the only supported query is the market query that produces a market report. This query type is used to examine the market in a player-owned structure. NPC structures are not supported. See the example query file in the `queries` directory. 

## Troubleshooting

### I get an error like "Bad Gateway"

Let the run complete and then run it again. The program doesn't automatically retry, but manually trying again will likely fix it. 

### The program hangs and keeps printing something like "calls remaining: 1"

Kill it and start it again. 

### The program takes a long time to run

Some items take a long time to download, but they are cached, so it should be faster next time. When you first run the program, it has to download information about all the types, and this can take 20-30 minutes. Fortunately, you only have to do this once. Downloading market history also takes a long time, but it is cached for a few days.

### Information about some item types is wrong

Item data is downloaded and kept forever. It will only be wrong after an update to the game that changes item attributes. When this happens, you need to manually delete the file 'cache/dataCache/types.json'.  