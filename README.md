# Chained-vs-Unchained-Objects
This is an assignment from school that does the following:
This assignment can be simply described:

Create a "NamedObject" class, as specified below.  Use the exact project, package, and method names from the specification.  (Even tiny errors in names will break your solution.) Implement the class so that it matches the requirements in the specification.  As always, strive to submit high quality code.

Note:  We will cover two methods on Monday:  equals and hashCode.

Within the same project, create several JUnit tests for the 'chain' and 'unchain' static methods in the NamedObject class.  Create enough tests so that common errors in 'chain' and 'unchain' are revealed by your tests.  (Note:  This is intentionally vague.  The goal is for you to make a wise judgment about the suitability of your tests.)

Test your work, and polish your coding style.

Submit your work exactly as indicated below.  (Note:  The Eclipse submission plug-in is not yet ready.  I will strive to get it ready, but until then, use the instructions below.)  You may resubmit your work.

(Optional) Practice writing a report using the study questions on the other part of this assignment.  You cannot submit it and we won't grade it, but you'll be able to compare your report to my key.  (Note:  I never post solution code, but I will post analysis keys.)
This is an individual assignment - respect the plagiarism rules from the syllabus.

The NamedObject Class Specification (part 1)
In Java, we use variables with good names to store our object references.  This is fine, but what if you wanted to pass an object and a name to another part of your program.  For example, you might want to send a method "Red" (a String) along with a red Color object, or "Keyboard" (a String) along with a Scanner object.  We'll solve this simple problem by creating a NamedObject class that contains two private fields:  A String (some name), and a contained Object (some object of an unknown type).  Your NamedObject class will contain a constructor, accessors, mutators, and a few utility methods.  You'll need to be exact when naming things, see beow.

As you design this class, you will rely on the fact that you don't need to create new String or Object objects, and that you don't care what type of object is sent along with each String.  You'll just use whatever String references or Object references you get when your methods are called.

In a few cases you will be required to check method parameters for errors.  I'll talk about throwing exceptions in class on Monday.
