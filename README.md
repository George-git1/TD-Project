# TD-Project

This project is a Web application which allows a user to interact with a To Do list in which they can use CRUD functionality.
The application was created using Spring Boot and was tested with Junit and Selenium.

# Getting Started
These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. See deployment for notes on how to deploy the project on a live system.

# Prerequisites:
To use this application there are Prerequisites:
- Java with Eclipse IDE if possible
- MySQL installed
- Visual Studio Code installed
- Spring Boot and Maven installed locally
- 
# Installing:
Follow the Instructions below to install it on your local machine, Follow the order of:

- Clone this repository to your machine.

- Import the backend folder with Eclipse.

- This should show the project in the package explorer on the left.

- Expand the project folder and you will be able to see a series of folders. 

- There should be A main, resources and test folder.

- Right-click the project folder and click Run As a Spring Boot App

- The Spring Boot App will start the server on port 1999.

- Import the front-end into VSC and right click on the index.html file and Open with Live server.

- The application will open in the browser and then you can see all the functionalitys of the To Do page which include:
- Add a to do.
- Read all to dos.

- Update a to do.
- Delete a to do.

# Running the tests:
The tests have both Integration and Unit tests, to run the integration you right click in tests on the file ToDoTest and run as a Junit, while for the unit tests, do the same for the ToDoUnitTest file.

JUnit and Integration tests:

![TestsRan](https://user-images.githubusercontent.com/85874668/128646438-823920df-8705-4a55-ac4c-bce075ac9c37.png)


Tests surpass the industry standard requirment of 80%.

![Coverage](https://user-images.githubusercontent.com/85874668/128646426-c865696c-0e41-4c5b-ae3f-9fab623e594f.png)

Selenium Tests:
A chrome web driver needs to be added to the files of the project so that Selenium tests can be run. 
Going to a Selenium test and right clicking Run as a Junit Test will run it for you, in this case the indexTest file.
They test the functionality of the website, So the CRUD functions and asserting wether they are succesfful. 

# All technologies the project was built With:
Maven - Build Tool and Dependency Management
Spring Boot - API Development Platform
Java - Back-End Programming Language
MySql - Database
Eclipse - IDE
Visual Studio Code - Code Editor
Git - Version Control
Jira - Software helping managing the work
HTML- Strucutre of web page
CSS- Styling
Java Script- Interactions for the web page

# Versioning:
Git was used for versioning.

# Author:
George Whyte

# Acknowledgments:
I Would like to Thank David Algie for helping me out while I complain, while I would also like to thank Jordan for helping me with a couple of issues.
