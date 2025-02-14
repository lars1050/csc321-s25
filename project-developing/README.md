### Disease Model Simulation using Model-View-Controller

The major elements of this code include the population, the controls, and the statistics.

The population manages the collection of Person(s). Each person will have a health status (see Status.java) and they are moving at each time step. As persons move, they risk infecting others or being infected. These interactions are viewed in the PopulationPanel. 

The ControlPanel will manage different aspects of the simulation including rate of infection, amount of prevention used against infection, and how much people are moving around. Each slider can be thought of as a Subject with a corresponding Observer (meaning a variable within the population). 

Finally, the StatsPanel will display statistics about the population during the simulation. It will get status information from the population and report on percent of population within each health status.

Each panel can be developed quite independently. The layout of the panels and components is specified in Layout.java.

_Take some time to familiarize yourself with the code. There will be changes before it is formally posted next week, but the general framework will not change.__



