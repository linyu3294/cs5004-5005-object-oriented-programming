
 
# Lab 4: Questions in a quiz

 
    Many online questionnaire tools like SurveyMonkey, Doodle Poll, etc. (even Blackboard)

    allow creating a questionnaire made of several types of questions: Yes/No, Essay-form,

    Likert scale, etc. In this lab you will write classes that represent different types of

    questions.
 
   
   Each question, irrespective of type, has the following common aspects:
   
     
     It has the text of the question itself, and a method getQuestionText that returns it.

     It is either required or optional, and has a method that returns its status.

     It has a method answer(String) that allows one to enter an answer as a String. What

     the string contains depends on the type of question.

 The types of questions are:
         


  1. YesNo: this can be answered in one of two ways: yes or no. answer(String) would accept only "Yes" or "No" as valid answers.

  2. Essay: this can be answered in at most 140 characters, including spaces.

  3. Likert: this can be answered on a fixed, 5-point Likert scale (Strongly Agree, Agree,Neither Agree nor Disagree, Disagree, Strongly Disagree). answer(String) would accept only these precise words as valid answers. 
  
  Design the data for the above in a way that captures their similarities and accurately represents the relevant data. Create these interfaces/classes, and write appropriate constructors that allows one to create a question using it. Write tests that create and verify various question-type objects.
        


