# **What Are Thooose? Trainer Inventory**

## **Contents**

* ### [Brief](#Brief)
  * ### [Scope](#Scope)
* ### [My Approach](#Approach)
* ### [Design](#Design)
  * ### [Kanban Board](#Architecture)
* ### [Creation](#Creation)

## **Brief**

The brief for this project is to create a CRUD application using the supporting tools, methodologies and technologies that encapsulate all core modules covered during training.

### **Scope**

The following requirements also need to be implemented:

* A Jira Kanban Board with full expansion on user stories, use cases and tasks needed to complete the project.

* Clear documentation from a design phase describing the architecture used.

* A detailed risk assessment.

* A relational database used to store data for the project.

* The application must have a functioning front-end website and integrated API. 

* Code fully integrated into a Version Control System

### **Approach**

To meet the scope I have decided to create a simple inventory where users will be able to do the following:

* Add entries that will include:
  * Shoe name
  * Shoe size
  * Brand
  * Colour
* Users will also be allowed to:
  * View, edit or delete entries


## **Design**

### **Kanban Board**

A Kanban board was used to track issues that needed to be completed for the purpose of completing the application. Epics were created that included issues, stories and tasks. These were arranged based on the issue they related to. Below is a quick screenshot of my Kanban Board in use.  

![Kanban Screenshot](images/Kanban_screenshot.png)  

### **Entity Relationship Diagram**

The Entity Relationship Diagram shows the structure of my database below: 

![Kanban Screenshot](images/ER_Diagram.png)

There is a One-to-Many relationship between the Brand and Shoes entities. This allows a user to add many different shoes to one brand. 


### **Creation**

To build this project a number of different technologies were used:

#### **Version Control**

The version control system used for this project was Git. A repository was created for the project, which acted as a source for code


