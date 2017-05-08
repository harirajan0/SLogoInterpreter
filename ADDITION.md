##Estimation
* How long will it take?
Adding the two subclasses of command will take only a few minutes. Figuring out how to add clones of the turtle image views to the root, and later remove them, should not be difficult, but I feel as though my inexperience with frontend will cause it to take up to an hour.
* How many files will I need to add or update? Why?
 I will need two add two new command classes. I will need to add those two command classes to the command factory. I will need to modify the TurtleWindowView to support stamping (adding to the root) and clearing (removing). 

##Review
* It took about 1 hour
* I had to update exactly the classes I said, plus SlogoData and SlogoView. This was the quickest sequence of methods that could be called from the command API to affect the frontend in the desired way.
* I did not get it right on the first try, because as I suspected, there were some frontend quirks about adding to the root that tripped me up.

##Analysis
* It was as I remembered. Adding new features relies as much on adding new methods into already big classes as it does on adding new classes. The backend is almost always
  satisfied with simply adding new classes but the frontend seems to always need new methods.
* There needs to be a better use of observers or of lambda functions in order to remove the huge amount of methods in classes like SlogoData and SlogoView. There needs to be
 a better way to add frontend features without adding new methods, and I propose lambdas or observers. 
* I still think it would hav been fairly obvious. I did not feel super familiar with the frontend code, yet I had no trouble figuring out which methods to add. I think the tradeoff
of adding new features by adding new methods is that while you sacrifice good design/extensibility, you gain clarity. 