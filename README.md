Author: Simplex
Assignment: JavaProject2
File: README.md
Date: 2023/04/24
-----
Info:
-----
This is a resturant menu/managament system for a doughnut shop named Doughnut factory. It
manages inventory, allows customers to order, generates reports, lets the employees
mark the reports as processed, and allows the admin to modify the menu however they wish
by editing, adding, or deleting items.
-----
Running:
-----
You will need all .java files in src and all .csv files in res. You may need to fix pathing. 
When running it is anchored to what you currently directory everything is opened in. So you are
opened in Doughnuts you will need to the "/Doughtnuts" from the pathing.
-----
Contribution:
-----
Hunter Lane
-
Planning the project.
Created drafts for the diagrams.
Wrote code.
Debugging.
-
Jalethzie Pena:
-
Worked on presenation.
Wrote code.
-
Kassidy Maberry
-
Worked on code.
Debugging.
Finalized Class diagram.
-
Ambrosia Ingoglia
-
Created sequence diagrams.
Worked on presenation.
-
-----
Things that could of been improved:
----
Communication
Time Management
-----
Difficulties while writing
-----
A lot of file io errors arrose. For example the most interesting is that oringinally
menu.csv would clear itself of all data instead of updating when saving to it. Other than
that it was a lot of formatting issues. When splitting strings we'd go out of bounds because
we didn't create enough splits due to the offset being off by one. This created a giant
mass of bugs whenever we started the original debugging. The file location because 
the folder dougnut is spelt wrong I didn't notice that was causing the issues. There was also
an error when reloading the total prices of orders. The prices would swap between their actual price
and 0 dollars everytime you ran the program. This was fixed by just passing in the read price
and setting it to that in the constructor.
-----