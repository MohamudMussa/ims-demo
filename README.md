Coverage: 61%

![Coverage](https://github.com/MohamudMussa/ims-demo/blob/dev/documentation/Testing%20Progress%20-%2061.PNG)
	

# Inventory Management System Application by Mohamud Mussa


This is an  **Inventory Management System Application** that was build using Java and can be interact with via a Command-Line Interface. The inventory management system connects to a database and allows the end user to easily add, delete, update and create an **Customers**, **Orders** and **Items** as well. This application also allows the end user to calculate the cost of an order. 

## Table of contents
* [Prerequisite](#Prerequisite)
* [Installing](#Installing)
* [Testing](#Testing)
* [Creating JAR file](#Creating_JAR_file)
* [Deployment](#Deployment)
* [Built With](#Built_With)
* [Versioning](#Versioning)
* [Authors](#Authors)
* [License](#License)
* [Acknowledgments](#Acknowledgments)





## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes.


### Prerequisite

* [Java 14.1](https://www.eclipse.org/downloads/)
* [Git](https://git-scm.com/downloads)
* [Eclipse](https://www.eclipse.org/downloads/)
* [MySQL](https://www.mysql.com/downloads/)
* [Maven](http://maven.apache.org/download.cgi)
* [GCP](https://console.cloud.google.com/)



### Installing

1. You will need to clone down the repo, here is a link to the repo [GitHub][https://github.com/MohamudMussa/ims-demo.git]
* To do this, Git Bash in the desired folder you'd like to clone to.
* Once Git opens, you will need to initialise git, do this with the following command;
```
Git init
```
2. After this, write 
```
Git clone
```
and copy and paste the link you wanted to clone, here it is again - [GitHub][https://github.com/MohamudMussa/ims-demo.git]

3. Now its time to open the program, I used *Eclipse* but you can use anything that allows Java to run. 
4. You are aslo able to do the follow - Left click in the correct folder containing the project > then select

```
GIT BASH 	
```

into the *ims-demo/target* and then type the following **"java -jar mussa-ims-1.0.1-jar-with-dependencies.jar**

5. You can now use the program via the command line.

## Testing

All testing of this program was done using unit tests. 
JUnit and Mockito were used to write the tests.


#### Creating JAR file:

1. Right Click on the folder of the directory containing the repository
2. Select Git Bash
3. Write the following

```
mvn clean package
```

4. This will now run all testing, ensuring it all passes, you'll get JAR file in the target folder.

## Deployment

To deploy this software to a cloud database such as Google Cloud Platform (GCP) you will need to do the following;

**Open the project**

1. In the main folder 'src/main/java' Open > Ims.java
2. Scroll down until you see init("jdbc:mysql://
3. change the localhost to your desired IP address

## Built With

* [Maven](https://maven.apache.org/) - Dependency Management

## Versioning

* Version Control System: Git
* Source Code Management: GitHub
* Database Management System: MySQL Server 5.7 (local or GCP instance)

[Maven Versioning](http://maven.apache.org/download.cgi)  incremental, Minor & Major was used to update the version.


## Authors

* **Chris Perrins** - *Initial work* - [christophperrins](https://github.com/christophperrins)

* **Mohamud Mussa** - *The rest of the work* - [MohamudMussa](https://github.com/MohamudMussa)

## License

This project is licensed under the MIT license - see the [LICENSE.md](LICENSE.md) file for details 

*For help in [Choosing a license](https://choosealicense.com/)*

## Acknowledgments

* Thank you to Nick, Aswene and Vinesh & QA community


