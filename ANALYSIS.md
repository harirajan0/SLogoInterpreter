Alex Boss

ajb112 

**Overall Design**

**Complete Program**

The high-level design of the backend is to implement the algorithms for parsing text, executing commands, and influencing the turtle in such a way that the frontend is not concerned with our algorithms. 

The front end is concerned with the user interface and presenting information to the user. This includes superficial features like changing the colors on the screen, and core features like letting the user type commands, see and run the command history, edit variables, move the turtle with buttons, etc. 

The two sides communicate through a mix of observables and controllers. SLogoData is a class containing important data like the Turtles and the Variables and that class gets passed around when access is needed - but when backend commands receive SLogoData, there is an extra method call with only the essential parameters for each command, so that commands cannot access all parts of the data. 

**Consistency**

The program is generally consistent in naming conventions and formatting. Some of the front end methods authored by Daniel have unnecessarily long names, like getTurtleImageSelectionButton(), and some of the method bodies authored by Hari are too long, like calculateLinesToDraw(), but generally methods are at the lowest visibility possible, have descriptive names, proper body lengths, and auto-formatting.

**Adding new features**

To add a new command, create a new class that extends the proper class from the package backend.commands, depending on the behavior of the command. Then add this command to the resources file for each language and to the command factory. Add special errors for this command to the resources if necessary. 

To add a new component to the front end, first add a new class that handles the required visuals. Then add a method in the Controller to set up the listener and action for that button or feature.

To allow users to load and save a library of commands, we would have to have frontend buttons for "load" and “save” that correspond to backend actions, linked via observables and the controller. In the backend, we would have to create an XML reader. It would need access to our list of commands and our list of variables in the backend. Upon loading a library, we would append all commands/variables in the XML file to the current list of commands/variables, and in saving, the opposite. 

The dependencies between parts are easy to find in that all relevant data is stored in the SLogoData, and so it is often the only parameter being passed. However, I realize that this is not the best design because it can expose data to manipulation by outside classes in a way that isn’t tightly controlled or defined. Some other dependencies are perhaps more obscure because they travel through the controller, and so methods tied between frontend-controller-backend can be hard to trace.

**Two components**

Two components I didn’t implement: CommandPromptView and SLogoController. I think CommandPromptView is easier to read, but that makes sense because its role is simpler. The majority of the methods are one line and the rest are simple boilerplate setup code.

Given that SLogoController is a controller that communicates with both the frontend and backend, it’s hard to keep it encapsulated. The class will need to have more methods added when new features are added, so it’s not closed. CommandPromptView is somewhat more encapsulated in that in order to attach functions to buttons, you can just pass a handler, which can be defined elsewhere. However, there is a separate public method for each button that manipulates the turtle, so that is not closed to adding more. 

I have learned that when my teammates (or I) write code that is not encapsulated, it is detrimental to the rest of the team because it forces them to write their code in a conforming way. It is beneficial to the entire team, not just the individual, to write clean, encapsulated code, because otherwise the individual’s design choices can leak into the project and cause the whole design to suffer.

**My Design**

I primarily contributed to the receiving, parsing, and executing of commands. I also handled exceptions. I designed smart exceptions that tell you the exact type of syntactical error you committed. My backend algorithms are hidden from the front end. My command hierarchy is closed to modification and opened for extension. In order to add a new command, you do not need to modify any existing classes except the command factory. As such, the dependencies are low.

I think the command hierarchy is well designed. As I mentioned, it conforms to the open-closed principle. It is very easy and intuitive to add a new command, whether it affects the turtle, or it’s a mathematical command, or a control command, or something else entirely. This inheritance hierarchy makes use of interfaces, abstract classes, and the factory design pattern. Each new class is small and readable. 

One challenge we wrestled with was how to allow command classes, which are very low in the hierarchy, to affect the rest of the program (turtles, variables, etc.). Based on the rest of the team’s design, we ended up passing SLogoData to the commands. I know this is not great design for reasons mentioned in the previous section, so to get around it, command superclasses extract only the necessary data from SLogoData before passing it along. For example, math commands do not actually get access to SLogoData. This was the simplest solution to the design challenge.

One feature I think needs some improvement is the Executor. Currently, it is dense and hard to understand. This is because the abstract syntax tree was a completely new concept and it was very tricky to learn and implement, so my partner and I had to constantly tweak it along the way and we didn’t have time to refactor everything. Despite this, I am proud of this feature because it was very challenging but rewarding to learn. This algorithm allows us to handle loops, variable numbers of parameters, user-defined functions, and other more difficult aspects of parsing that other groups struggled with. It also allowed me to create very specific and detailed exceptions. For example, the parser can distinguish between and alert the user of the specific error committed, such as undefined function, unitialized variable, imbalanced brackets, invalid arguments, etc. This parsing algorithm doesn’t force dependencies in the rest of the program.

**Flexibility**

Flexibility means following the open-closed principle and having substitutability. I don’t think our design is the best example of flexibility, because many new features create new dependencies, especially through the controller. The observables help to a degree with reducing these dependencies. One of my biggest issues with the design is the passing around of SLogoData. Even though we protect the data by filtering it out in the superclass, I think it would have been better to explore using lambda expressions. We simply didn’t have time in the backend to do so, because frontend needed a ton of help, and because learning ASTs was difficult.

**Two features**

The first feature is SLogoModel. It is interesting because it uses the observable interface. It contains an instance of SLogoData and the Executor, so it is really just another level of abstraction between front and back end. Because it uses the observable interface, it improves the design of the project by employing encapsulation. Any class that wants to listen for changes can be added as an observer, and the implementation details of the response can be handled at a lower level. This is good in terms of flexibility. New responses can be added without making changes to this code, which is short and effective.

The second feature is SLogoView. This feature is interesting because it is the other side of the observable interface to SLogoModel. SLogoView is the observer. When things happen in SLogoModel, SLogoView has the chance to respond. As stated previously, the observer interface is good for the design of the program in the sense that behaviors can be specified at a lower level and hence more flexibly. This class is fairly dense in terms of instance variables. This class needs an instance of every element on the screen and as such it is not closed to modification because in adding a new feature to the front end, you will have to add lines of code to this class. This makes it harder to add new features. 

**Alternate Designs**

The original design was not quite adequate in handling the extensions. The problem was that in implementing more ways to affect the backend from the front end (like moving the turtle with buttons) or affecting the frontend from the backend (like the setpencolor command), we were forced to have better-designed methods of communication. That’s why we turned to observers and observables.

**Two design decisions**

At first, the parsing algorithm was to be a very simple, non-recursive function. Then we learned that we could chain commands so we started using a recursive function. We quickly realized it would not work with loops or user-defined commands so we decided to tackle the abstract syntax tree. The tradeoffs were clear: it was very difficult to learn and implement, but it yielded much better results. We were able to accomplish challenging backend extensions and specific exception handling because of it. I prefer the AST because it works better and it is more satisfying. And after a while, it is actually easier to add new types of commands.

We were deciding between lambda functions and observables for frontend-backend communication. We settled on observable because we simply didn’t figure out the best way to do lambdas in time. We use some form of lambdas by attaching event handlers to certain frontend nodes, but ideally we could have used the functional interface lambdas that we briefly talked about in class. The tradeoff is that setting up event handlers requires a lot of boilerplate code in the controller and other classes, but doing so is easier and simpler than learning the functional interface. 

**Conclusions**

Best design feature: the observable / observer interface. This was a much-needed solution to our backend-frontend communication problem. I am considering using observables for VoogaSalad. 

Worst remaining feature: the controller. It uses a ton of boilerplate and setup code, and is not flexible. It also strangely contains an instance of SLogoData and an instance of SLogoModel which itself contains SLogoData. 

**To be a better teammate**

Start: Taking a greater role in the integration / higher-level aspects of code rather than focusing on the backend primarily

Keep: Working closely with my backend partner so we are always on the same page

Stop: Assuming everything will work out if I let the other sub-teams worry about their own work

 

