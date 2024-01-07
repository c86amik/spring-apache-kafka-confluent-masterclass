# spring-apache-kafka-confluent-masterclass

## A good understanding of the usage of Confluent with Spring Boot for publishing messages in the Topic and consuming messages from the Topic

### Software Required
* [Java 1.8](https://www.oracle.com/in/java/technologies/javase/javase8-archive-downloads.html)
* [Spring tool Suite](https://spring.io/tools) or [Eclipse](https://www.eclipse.org/downloads/packages/)
* [Apache Maven](https://maven.apache.org/download.cgi)
* [Git Bash](https://git-scm.com/downloads)
* [WSL for Windows](https://github.com/c86amik/spring-apache-kafka-confluent-masterclass#install-wsl-for-windows)
* [Confluent](https://github.com/c86amik/spring-apache-kafka-confluent-masterclass#install-confluent-on-wsl---ubuntu-2004)

### Install WSL For Windows

<ol>
<li>Open Powershell in Administrator Mode</li>
<li>Run the command - <p>`wsl --list -online`</p></li>
<li>Run the command - <p>`wsl --install -d <<Distribution Name>>`</p>List of Distribution Names - Get it from the above command</li>
<li>Now your WSL for Windows is installed in your local machine</li>
<li>In my case I have installed Ubuntu 20.04 latest one, you can download any wsl distribution</li>
<li>Create the Linux user. Provide the Username and Password and you are ready to use</li>
</ol>

### Install Confluent on WSL - Ubuntu 20.04

<ol>
<li>Downlaod the Confluent, Command - <p>`wget https://packages.confluent.io/archive/6.1/confluent-6.1.0.tar.gz`</p></li>
<li>After downloading estract the tar file, Command - <p>`tar -xvf confluent-6.1.0.tar.gz`</p></li>
<li>Now set the Environment variable as - <p>`export CONFLUENT_HOME=/home/amik/confluent-6.1.0`</p>The directory as provided it is my local machine directory yours will have a different one</li>
<li>Set the PATH variable as - <p>`export PATH=$CONFLUENT_HOME/bin:$PATH`</p></li>
<li>To verify whether Confluent is installed or not, check the version - <p>`confluent --version`</p></li>
<li>Install Java in WSL, commands are - <p>`sudo apt-get update && sudo apt-get upgrade -y`</p><p>`sudo apt install openjdk-8-jre-headless -y`</p></li>
<li>Verify Java is installed properly or not - <p>`java -version`</p></li>
<li>After Java isntall Confluent-Hub, Command - <p>`confluent-hub install --no-prompt confluentinc/kafka-connect-datagen:latest`</p></li>
<li>Now to check the status of the local services run by Confluent, Comamnd - <p>`confluent local services status`</p></li>
<li>Start all the confluent local services, Commad - <p>`confluent local services start`</p></li>
<li>Stop confluent local services, Command - <p>`confluent local services stop`</p></li>
<li>Even you can start and stop each services individually, Commands are - <p>`confluent local services zookeeper start`</p><p>`confluent local services kafka start`</p><p>`confluent local services ksql-server start`</p><p>`confluent local services connect start`</p><p>`confluent local services control-center start`</p><p>`confluent local services kafka-rest start`</p>
Just replace the <strong>`start`</strong> command with <strong>`stop`</strong> command
</li>
</ol>

### Steps to clone and run the application
* Open either Git Bash or open CMD (if you are using Windows) or Terminal (if you are using MAC) in your machine
* Clone the application from github.com as   
<code>git clone https://github.com/c86amik/spring-apache-kafka-confluent-masterclass.git</code>
* Open either <strong>STS</strong> or <strong>Eclipse</strong> and import the application as <strong>Maven</strong> project
* After the application got successfully imported in either <strong>STS</strong> or <strong>Eclipse</strong>
* Build the Jar file by running the command as - <p>`mvn clean install`</p>
* It will build the <strong>.jar</strong>s file. Manually copy and paste the .jar file in any of the mounted directory in WSL
* Run the .jar file, Command - <p>`java -jar spring-apache-kafka-confluent-masterclass-0.1.jar`</p>
* The application will start in the port <strong>7118</strong>
* Open Postman
* Paste the URL as <p>`http://localhost:7118/confluent/produceJson`</p>
* Change the HTTP Method to POST
* In the Body section copy and paste the below message
* Send the message as - <p><code>{"firstName" : "First Name", "middleName" : "", "lastName" : "Last Name", "mobileNo" : "1234567890", "email" : "test@email.com", "panNo" : "ABCDE1234F"}</code></p>
* Lastly hit the <strong>Send</strong> button
* As verification you will be able to see the message in the logs

### Testing using Postman
<ol>
<li><strong>Post UserModel for Producing and Consuming in Confluent</strong> - http://localhost:7118/confluent/produceJson</li>
</ol>

### Dummy JSON Object
* Body for the <strong>POST</strong> Method   
<code>{
	"firstName" : "First Name",
	"middleName" : "",
	"lastName" : "Last Name",
	"mobileNo" : "1234567890",
	"email" : "test@email.com",
	"panNo" : "ABCDE1234F"
}</code>