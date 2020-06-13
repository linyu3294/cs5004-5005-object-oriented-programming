  # Lab 1: Introduction to IntelliJ and Simple Data Definitions

```
Goals: The goals of this lab are to get familiar with our work environment: the IntelliJ
IDE, the Bottlenose submission, the basics of running a program in Java, and the JUnit
testing framework.
```
```
The second part of the lab will focus on practicing data definitions and examples in Java.
```
```
Related files:
Person.java Book.java PersonTest.java
```
# 1 IntelliJ IDE

```
IntelliJ is an integrated (program) development environment used by many professional
Java programmers (as well as programmers using other programming languages). It is
an Open Source product, which means anyone can use it freely and anyone can
contribute to its development.
```
```
The environment provides an editor, allows you to organize your work into several files
that together comprise a project.
```
```
There are several step in getting started:
```
```
Learn to organize your IntelliJ projects.
```
```
Learn to manage your files and save your work.
```
```
Learn how to edit your Java programs and run them, using the JUnit testing
framework.
```
```
Throughout this lab, we will refer to the tutorial video for IntelliJ.
```
# The First Project

```
Please work on this part individually. You may seek and provide help to your partner,
but we would like you to go through the entire process yourself to gain familiarity.
```
1. Follow the tutorial video for IntelliJ up to about the 6:00 mark. It will walk you
    through how to create a new project, how to organize your projects and how to set up
    your Java SDK for use from IntelliJ.

```
The video was originally made for CS 3500. Replace those references to CS 5004.
```
```
The video creates a new project called “HelloWorld”. Give your project a different
name, perhaps lab1.
```
2. Add Person.java and Book.java from above to your project. Follow the tutorial video
    for IntelliJ from 9:30 to 10:25. Verify that none of the files show any errors by
    double-clicking on them.
3. Understand the folder structure imposed by IntelliJ by listening to tutorial video for
    IntelliJ from 11:35 to 12:30.
4. Show one of the course staff your work up to this point before proceeding.
5. Add JUnit tests for the Person class. Follow the tutorial video for IntelliJ from 12:
    to 17:10, but create a test class for the Person class instead of what the tutorial is
    showing you.
6. Replace the contents of the newly created PersonTest.java with that in the file with
    the same name provided to you above.
7. Run this test case, by following the tutorial video for IntelliJ from 18:40 to 19:22.
    Verify that all tests pass.
8. Show one of the course staff your work up to this point before proceeding.

# Tests for Book

1. Create a JUnit test class for the Book class, using the same process as you did above to
    create tests for the Person class.
2. Write tests that verify that all the public methods of the Book class work as expected.

```
Work with your partner to design each test method.
```
```
Decide the objective of your test: what exactly are you testing?
```
```
Decide how you will fulfill the above objective: what must you do to ensure that
your test indeed tests what it is supposed to?
```
```
Write the test.
```
```
Execute the test to ensure it is working correctly.
```
3. Show one of the course staff your work up to this point before proceeding.

# Generate Javadocs

```
The provided files already have Javadoc-style comments. You will now generate html
documentation from these files from within IntelliJ.
```
1. Within your IntelliJ project folder, create a new folder called “docs”. IntelliJ will pull
    all the generated documentation within this folder.
2. From the IntelliJ menu, choose Tools –> Generate Javadoc....
3. In the Output Directory field, point it to the “docs” folder you created in step 1.
4. Press OK. IntelliJ will now generate the html files and open them in your browser. If
    the files do not open automatically, go to the “docs” folder and open index.html in
    your browser.
5. Correlate the Javadoc comments in the Person.java file with the output in
    Person.html file to see how Javadoc comments affect the documentation.
6. Show one of the course staff your work up to this point before proceeding.

# How does this work?

```
The Java SDK comes with a tool called javadoc. IntelliJ uses this tool and passes it all
your .java files. You will find this tool in the “bin” folder inside your Java SDK directory
(wherever you installed it on your machine).
```
# Code styling

```
Style of code is important for its readability and uniformity. Most companies impose a
code style that makes all the code created by numerous developers have the same
formatting. In this course we will use a styling convention from Google and employ
IntelliJ to enforce this style on our code. All the assignments in this course will have a
part of their grade determined by style, so it is important that you enforce this style for
all source code!
```
1. Download the style file intellij-java-google-style.xml.
2. Follow the tutorial video for IntelliJ from 20:43 to 28:12.
3. Show one of the course staff your work up to this point before proceeding.

# Submission

1. Go to the submission server. Log in using your CCIS username and password.
2. If you have not done so already, register yourself as a student of CS 5004.
3. Contact the instructor so that you can be approved.
4. Create a zip file that contains the src and test folders of your IntelliJ project for this
    lab.
5. Submit it as Lab 1 on the server.
6. Inspect your submission and look at the style grader feedback. Correct your code
    accordingly and resubmit, until the style grader no longer complains.
7. This is for demonstration purposes only. This submission will not count towards your
    grade.

# Contact information

```
Add contact information to each person. The contact information should store a phone
number and an email address. The email address should be a single string.
```
```
Draw a class diagram for how this information will fit in with the Person class. Modify
the Person class with this new information, add methods to get this information and
write tests to verify that these methods work correctly.
```
```
Show one of the course staff your work.
```
# Email address

```
Representing the email address as a single string is not ideal, because an email address is
really a composition of a username and a domain. Represent an email address as a class
that represents this information appropriately.
```
```
Modify the class diagram from above to represent this information. Modify the Person
class with this new information, add methods to get this information and write tests to
verify that these methods work correctly.
```
# A trading stock

```
Hundreds of stocks trade on the Stock Exchange every day. Owning a stock is akin to
owning a tiny part of the company. A stock is represented by the name of a company
(e.g. Microsoft Corporation), its ticker symbol (e.g. MSFT), its price per unit share (e.g.
$60.37) and other details that may be relevant when someone is trying to decide
whether to buy this stock or not. These details include (a) the lowest price of that stock
in the past 52 weeks (b) the highest price of that stock in the past 52 weeks (c) the total
debt and the total assets owned by the company (both in dollar-cent amounts) and an
analyst recommendation (1-5, 1 being strong sell and 5 being strong buy).
```
```
Design one or more classes that represent this information and express your design in a
class diagram.

