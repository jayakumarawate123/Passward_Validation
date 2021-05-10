# Passward_Validation

We like to build code for purposes of password verification. Verification will fail if any one of the rules mentioned does not pass.
1. Implement the following rules. Each one of these will throw an exception with a different message of your choice.
       - A) password should be larger than 8 chars
       - B) password should not be null
       - C password should have one uppercase letter at least
       - D password should have one lowercase letter at least
       - E password should have one number at least

2.  Add feature: Password is OK if at least three of the previous conditions is true
3.  Add feature: password is never OK if item 1.d is not true.
4. Assume Each verification takes 1 second to complete. How would you solve items 2 and 3 so tests can run faster?


## Steps to run application

1. Clone the project from the github
2. Import the project to workspace
3. Update the maven
4. Run the PasswordValidationServiceImpleTest class test cases.