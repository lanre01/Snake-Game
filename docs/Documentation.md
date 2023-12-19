###### Overview of the Project

###### Initial Class Diagram
![class diagram](/docs/classdiagram.png/)
###### Final Class Diagram and Sequence Diagram
![class diagram](/docs/refactoredClassDiagram.png/)
![Sequence diagram](/docs/sequence-diagram.png/)
<p>I have inlcuded the sequence diagram as it best show the logic of the game.

###### Refactoring and Addition
|Class |Comments|
|------|---------|
|All class that uses Java Swing| All java swing was converted to JavaFX|
|Food class|Each food object now stores the its score. The controller can get the score and store the score in the model. The food class alsp implements timer. In higher levels the food time decreases which means the food can disappear the longer the player takes to eat the food. The food score also decreases during the process|
|GameContoller|The GameController class is involved with the logic of the game. It creates the snake and the food. passes the graphicscontext from the view to thee snake, paddle and food to draw the on the canvas.|
|GameView| The GameView controls the generation of the view. It uses JavaFx fxml file to load the scene. It also has a timeline that call the controller every 30ms which updates the view|
|ViewController class|Due to the way JavaFx works, the viewController has another class in it. This class is used to pass any values from the game-view.fxml file that may need to be upodated during the game. The ViewController also ensures the model and controller are singleton, so only on reference of the model and controller is used.|
|Play class| The Play class now only builds the necessary components of the game. It contains the main method that starts the game|
|Paddle class| The paddle draws a rectangle on the view from level 3. I have removes unnecessary codes from the paddle. It now extends snakeObject and can implement movable in the future|
|Snake class|I have created an easymove function in the snake class to control when the game is in level 1. Tha game only ends in level 1 if the snake bites itself. So snake go go out of the view and reapppear in the opposite side of the view.|

##### Testing
[Test](/docs/test.md/)
