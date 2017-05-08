SLogo Addition
===================

##Estimation: before looking at the old code:

-how long do you think it will take you to complete this new feature?
I think it will probably take around 45mn. 

-how many files will you need to add or update? Why?
I'll need to add a way of picking the image in the frontend. The backend doesn't need to be aware that I changed the turtle image so I won't need to do use observers. Currently we can see if a turtle is active when we hover over it so this information shouldn't be hard to retrieve, but then I will need to create a menu containing this. I'll probably need to edit around 4/5 files. I don't remember their names at all but I think
I should recognize them fairly easily when I open up the code.


##Review: after completing the feature:
-how long did it take you to complete this new feature?
It took me a bit over an hour.

-how many files did you need to add or update? Why?
I needed to modify 5 classes and create 2. I needed to create a visual way to select a turtle image, and then change it with a file chooser. I needed to integrate this within CommandPrompt view, as that is where all buttons are set up. Finally, I needed a way to get images from the turtle images from the TurtleView to the TurtleImagesView.

-did you get it completely right on the first try?
I needed to look over my Slogo project quite a bit to see where I should be putting things. For instance, at first, I had almost forgotten how buttons are set up and put it in SlogoView instead of SLogoController.

##Analysis: what do you feel this exercise reveals about your project's design and documentation?
was it as good (or bad) as you remembered?
I think it is pretty good: we were consistent in the way we set up things on the screen, got data, did observing. The classes are well commented and the method names are clear.

what could be improved?
I think we could add instructions on how to add functionalities within the Readme. Doing so would help any future developper (and would even help me remind myself of how my program works after not looking at it for a while).

what would it have been like if you were not familiar with the code at all?
I think it would have been fine, because our classes had clear purposes and we followed the MVC paradigm, with which most people have already worked with. I think most people would have the intuition that the visuals belong in the View, the actions when you click on the buttons are launched via the controller, and that we are modifying the backend. If not, our classes are well commented which would have helped me had I not seen the code.