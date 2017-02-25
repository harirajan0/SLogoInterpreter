API Review
----------

Daniel Rubinstein
Nathaniel Brooke
*NetIDs:*
Neb17
dr148

**Part 1**
-What about your API/design is intended to be flexible?

Each of the front-end features is contained in its own class and is linked to the controller via its own listeners.

-How is your API/design encapsulating your implementation decisions?

Each functionality has its own class and its own methods, so we can add or remove a front-end functionality without understanding how the others work or breaking the others.

-What exceptions (error cases) might occur in your part and how will you handle them (or not, by throwing)?

My part (front end) does not throw any exceptions: front-end faithfully sends data to the backend (via the controller) and displays the content it receives. Any error-checking is done by the backend. If the backend finds any errors, though, the front-end will be the one displaying it.

-Why do you think your API/design is good (also define what your measure of good is)?

I think a good API is one that is flexible/ extendible and hides implementation details. In this sense, I think our design is flexible and encapsulating: each part of the display (command line, variable view, etc.) has its own class and methods, and it is easy to add a new thing to be displayed.

**Part 2**
-How do you think Design Patterns are currently represented in the design or could be used to help improve the design?

The controller is an example of a Mediator: backend never refers directly to the front end, and front end never refers directly to the backend. The controller is also an Observer: upon changing something in the backend, everything upon which this depends in the frontend is alerted, and upon changing something in the frontend, the controller launches all needed updates/changes in the backend.

-How do you think the "advanced" Java features will help you implement your design?

In the classes, could use Observables instead of passing a Node to the controller. This way, the controller will no longer be able to modify the node, which is much better design.

-What feature/design problem are you most excited to work on?

I am most excited on creating a front-end that easily allows adding new features and that the user can interact with interactively.

-What feature/design problem are you most worried about working on?

I think it will be challenging to provide enough information to the controller without the controller needing to understand the internal implementation details in my classes. I might want to increase the number of listeners/observables for this purpose.

*-Come up with at least five use cases for your part (it is absolutely fine if they are useful for both teams).*

-user wishes to execute an old command:

the user will use displayHistory() to open up the list of old commands, and then if the user clicks on a command, the controller will be alerted (via Node getCommandPromptViewNode() ) and this command will be sent to the controller via sendHistoryItem().

-user sets a variable through the command line:

getCurrentCommand() will pass this command that creates a new variable to the controller (via Node getCommandPromptViewNode() ). The controller will communicate with the backend, which will parse the command in TurtleCommandFactory, and if it is valid, send it to VariableCommand, which will execute the command. The variables are stored in VariableCommand; this is where the variable will be created. Upon creation of the new variable, the controller will be alerted, and a list of the new variables will be passed to the frontend through updateVariableDisplay(); which will read the new list of variables and display them on the screen.

-user changes the color of the background:

This is done internally via a private method in class SLogoView. This is a purely internal method, so there is no need to use controller.

-user presses the run button:

getCurrentCommand() is called in class TurtleView. The controller gets the string that is in the command bar and sends it to the backend.

-the backend sends an error:

We catch errors in SLogoView and open a window to display them.
