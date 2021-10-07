# Expense Reimbursement System

## Project Description

The Expense Reimbursement System is a Server-side Company Portal application for a small company/group. The app allow employees to create reimbursement requests. All managers can view these requests and approve or deny them. When they approve/deny employee requests they can optionally leave a message.

This state of this project is from late Monday, September 6. I made updates to this project Tuesday, September 7 and introduced some errors which has temporarily set me back to presenting this slightly older version of the project. I know the errors are basic (integrating a junction table to get an Accounts table working with the Clients table). I will fix them and add in all JUnit testing, but for taday's presentation have to show this older version.

## Technologies Used
* java: 16.0.2
* Springframework Boot: 2.5.4
* Maven 3.8.2
* Javalin: 3.13.11
* AWS Mariadb java client: 2.7.4
* Hibernate Core 5.5.7
* HTML, CSS, JavaScript

### Features
- Employee
		- An employee can login to see their own reimbursements, past and pending
		- An employee can submit a reimbursement with an amount and a reason
				- Bonus allow for file upload
- Manager
		- A Manager can view all reimbursements past and pending
		- A Manager can approve or deny any reimbursement
		- Managers can view a 'statistics' page. That includes information like what employee spends the most money, mean expenditure cost etc...

## To-do list:
* Fix "null" values for Reimbursement "type" and "status"
* Complete Employee Portal
* Complete Manager Portal
* Complete Manager statistics page
* Include JUnit developer-side testing
* Include Mockito mocking tests
* Include User Story test cases
* Further build-out responsive client UI (refactor tables)

## Getting Started

## Usage
