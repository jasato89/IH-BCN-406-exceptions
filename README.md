# Lab 4.04

<br><br>

### Instructions

<br>

- Create a new GitHub repository named `Enterprise-Java-Development-4.04`
- Add your instructor and the class graders to your repository and ensure that your repository is private. Public repositories will receive a zero on the assignment.
- If you are unsure who your class graders are, ask your instructor or refer to the day 1 slide deck.
- Upload the code for all of the following prompts to your repository.
- Submit a URL link to your repository below.

<br><br>

### Set Up

<br>

For these labs, you will need to create two database tables and seed them with some sample data. The database data represents mock clients for a multi-city hospital.

| employee_id | department  | name            | status  |
| ----------- | ----------- | --------------- | ------- |
| 356712      | cardiology  | Alonso Flores   | ON_CALL |
| 564134      | immunology  | Sam Ortega      | ON      |
| 761527      | cardiology  | German Ruiz     | OFF     |
| 166552      | pulmonary   | Maria Lin       | ON      |
| 156545      | orthopaedic | Paolo Rodriguez | ON_CALL |
| 172456      | psychiatric | John Paul Armes | OFF     |

<br>

_Note that `admitted_by` is a foreign key to the employee table._

<br>

| patient_id | name              | date_of_birth | admitted_by |
| ---------- | ----------------- | ------------- | ----------- |
| 1          | Jaime Jordan      | 1984-03-02    | 564134      |
| 2          | Marian Garcia     | 1972-01-12    | 564134      |
| 3          | Julia Dusterdieck | 1954-06-11    | 356712      |
| 4          | Steve McDuck      | 1931-11-10    | 761527      |
| 5          | Marian Garcia     | 1999-02-15    | 172456      |

<br><br>

### Specifications

<br>

Create the routes below as efficiently as possible using validation where appropriate

1.  Create a route to add a new patient
2.  Create a route to add a new doctor
3.  Create a route to change an doctor's status
4.  Create a route to update an doctor's department
5.  Create a route to update patient's information (the user should be able to update any patient information through this route)
6.  In your `README.md` write a short answer to the following questions:

    - Did you use the same type of route to update patient information and to update an employee department?
    - Why did you choose the strategy that you chose?
    - What are the pros and cons of the strategies you chose for creating these routes?
    - What are the tradeoffs between `PUT` and `PATCH`?

