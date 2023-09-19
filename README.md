# Project with UI autotests for the Stellar Burgers service

---
**UI autotests have been added to the project:**
- Successful registration
- An error for an incorrect password
- Login using the "Log in to account" button on the main page 
- Login using the "Personal Account" button 
- Login using the button in the registration form 
- Login using the button in the password recovery form
- Transfer to personal account
- Switching from personal account to the constructor using constructor button
- Switching from personal account to the constructor using Stellar Burgers logo
- Log out of account
- Check that the transitions to the section "Buns"
- Check that the transitions to the section "Sauces"
- Check that the transitions to the section "Fillings"

## Technologies

| <img height="50" src="https://proxys.io/files/blog/Java/javalogo.png" width="50"/>  | Java 11            |
|-------------------------------------------------------------------------------------|--------------------|
|<img height="50" src="https://camo.githubusercontent.com/4b95df4d6ca7a01afc25d27159804dc5a7d0df41d8131aaf50c9f84847dfda21/68747470733a2f2f73656c656e69756d2e6465762f696d616765732f73656c656e69756d5f6c6f676f5f7371756172655f677265656e2e706e67" width="50"/>| Selenium 3.141.59     |
|<img height="50" src="https://cdn.fs.teachablecdn.com/L2rtxPaRxa4am1VtNegg" width="50"/>| Maven 4.0.0        |
|<img height="50" src="https://avatars.githubusercontent.com/u/874086?s=200&amp;v=4" width="50"/>| JUnit 4.13.2       |
|<img height="50" src="https://avatars.githubusercontent.com/u/19369327?s=280&v=4" width="50"/>| REST-Assured 5.3.0 |
|<img height="50" src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS9HMmuigtfRA2I1XvPSNlRVjl3A4Za7GWZbQ&amp;usqp=CAU" width="50"/>| Allure 2.15.0      |
---
## Running tests and viewing the Allure report
- To run the tests in Chrome browser, run the command: `mvn clean test -Dbrowser=chrome`
- To run the tests in Yandex browser, run the command: `mvn clean test -Dbrowser=yandex`
- To view the report, run: `mvn allure:serve`

---
[Link to the Stellar Burgers service](https://stellarburgers.nomoreparties.site/)