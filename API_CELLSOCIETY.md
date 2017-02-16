Simulation

-Internal: Methods for the backend to interact with the backend. Such methods as computeNextState(), getCoords(), 

-External: Methods for the frontend to interact with the backend. Such methods as getCellAtPoint(), placeCell(), advanceState()

Configuration

-Internal:

XMLException class allows different aspects of the Configuration to throw the appropriate exceptions. 

XMLReader has methods that facilitate parsing through the XML file. 

Setters to set values such as grid width, grid height, grid shape, etc.

-External:

Mostly getter methods to pass values to Simulation/Visualization

In the ConfigDoc class, the formatWithXMLTags() is a good public method to have as it will help save data from the Simulation for the save to XML feature

Visualization

-Internal:

Sets the screen’s width, height, formats the XML that it has already retrieved. Also, the methods that actually display the shapes on the screen should be internal because they don’t interact with the simulation and configuration.

-External:

Get’s the cell shapes, gets the grid shape and size, gets the XML information. These parts rely on the simulation and/or 

