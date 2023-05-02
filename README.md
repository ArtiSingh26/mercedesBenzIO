# MercedesBenzIO

This project is an umbrella which contains the UI Automation test for covering the front end functionalities of the Mercedes Benz website for selecting the required car model and building the car as the requirement of the customer by filtering down on fuel type. This project utilizes Cucumber framework integrated with Selenium Web Driver and using Java language for end to end automation using Maven as build management tool. Inbuilt feature of cucumber has been used for generating relevant reports. 
 
## Pre-Requisites

Before running the project, you need to download Apache Maven (if its already not there on the machine) from the official website https://maven.apache.org/download.cgi (Binary zip archive) and the path to the system environment variables. 

To verify if maven is installed correctly, open the terminal and run the command:

```bash
mvn --version
```
This command will show the version of maven if placed correctly.
Since, the project is using Java language JDK should be installed in the machine and the PATH should be set in system environment variables. (Please follow this link if required in setting up the path https://bobbyhadz.com/blog/mvn-is-not-recognized-as-internal-or-external-command)

## Running the Test

To run all the test, clone the repository -> open the terminal -> navigate to the project directory and type the following command:

```python
mvn test
```
This command will run the all the feature files. 
## Reports

Once the test run is done, the reports can be found under "target" folder inside the project with name "Cucumber-reports" which can be opened in any browser to see the latest run report.

![image](https://user-images.githubusercontent.com/85970617/235573345-d110dc7b-0dc5-487b-b1c4-973982c95063.png)
