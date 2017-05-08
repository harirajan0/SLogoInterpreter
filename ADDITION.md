CompSci 308: SLogo Addition
===================

*Note: Sorry this wasn't committed prior to writing the code. I accidentally had this in my analysis_hpr4 repository instead. But, I did answer the "Estimation" questions prior to writing the code.*

Estimation
-------

I think that it shouldn't take me much longer than 30 minutes to complete the frontend addition. I know I will have to edit the CommandPromptView.java class to simply add a button that will open a new window for the user to change the turtle image. Also, I will need to write a new class called TurtleImageChanger.java which opens up a new window for users to view the current images and change the images. I also know that I will need to add a method in SLogoController.java to add a listener to the choice box in TurtleImageChanger.java. Lastly, I will have to add a short method in SLogoData.java to change the image of an individual turtle.

Review
-----

It took about 30 - 45 minute -- just slightly longer than I expected. The following files are the files I had to change:

SLogoView.java - changed to add a getter for the new button that was added
SLogoController.java - changed to add event handler to button
SLogoData.java - changed to add method to change image of an individual turtle
CommandPromptView.java - changed to add button for the given task 
TurtleImageChanger.java (new class) - full implementation of the given task
Constants.java - changed to add new appropriate constants

For the most part I got it right on the first try. I used a ChoiceBox instead of a ComboBox to display the images on my first try, but that was a rather simple fix.


Analysis
------

I think over all the design is pretty good. Apart from writing the new class, TurtleImageChanger, only a few lines had to be added in the other classes to complete this addition. I think the only major flaw in our design is that SLogoData has to be passed around to multiple different classes in order to add new features. Although this is not the worst design, it is definitely worrisome that many frontend classes have access to this vital class -- SLogoData. If I were to re-do this project, I would have maybe split up SLogoData into two separate classes, SLogoDatFrontend and SLogoDataBackend. This way, frontend would just have access to the frontend data and backend would just have access to the backend data without either side getting information it doesn't need.  

If I was not familiar with the code at all, it definitely would have taken much longer to implement this feature. However, I do think that overall, our documentation was very good, so if I were unfamiliar with the project, but took the time to go through all the documentation, I think it would take all that long to complete this addition. The main concept I would have had to understand is how SLogoData is observed by the frontend and backend to constantly update information on both sides. The way this was designed can be a little confusing if I was not familiar with the code at all, but I think this remains true for even the most well-designed code.


