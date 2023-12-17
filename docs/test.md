#### Test Plan for The Game

###### Test for GameModel
| Test id | Test | Input | Expected Output | Actuall OutPut | Pass or Fail | comments|
|---------|------|-------|-----------------|----------------|---------------|--------|
|1.1|Test if the model correctly set player name| String "lawal"| lawal| lawal|passed|N/A|
|1.2|Test if the model set the game hasfinished value correctly|true| true| true| Passed|N/A|
|1.3|Test if the model set the highscore to be the correct value| 1000|1000|1000|Passed|N/A|
|1.4|Test if the model set the score to be the correct value| 300|300|300|Pass|N/A|
|1.5|Test if model set start| true|true|true|Passed|N/A|
|1.6|Test if model set Level| 2|2|2|Passed|N/A|
|1.7|Test if model returns the correct minScore| 1|0|0|Passed|N/A|

###### Test for GameView
| Test id | Test | Input | Expected Output | Actuall OutPut | Pass or Fail | comments|
|---------|------|-------|-----------------|----------------|---------------|--------|
|2.1|Test if the view displays the snake|N/A|snake is seen on the view|Snake can be seen on the view|Passed|Visual test|
|2.2|Test to see if food is draw on the view|N/A|food is drawn on the view|food is drawn on the view|Passed| visual test|
|2.3|Test to see food diappears when snake eats the food|N/A| food disappear|snake eats the food|food diappeared when snake eats the food and another food is drawn|Passed| Visual test|
|2.4|Test to see if another food is drawn afer the food has been eaten|N/A|food is on the view|Another food is drawn on the view|Passed|Visual test|
|2.5|Test to see if the snake moves|N/A|snake moves on the screen|Snake moves| Passed|Visual test|
|2.6|Test to see if the score label updates when food is eaten|N\A|score label updates|Score label was updated when food is eaten|Passed| Visual test|
|2.7|Test to see if the highscore label updates when game is restarted|N\A|highscore label updates| HighScore label was updated after when a player loses|Passed| Visual test|
|2.8|Test to see if the name label updates|N\A|name label updates|Name label was updated at the start of each game when the player inputs a name|Passed| Visual test|
|2.9|Test to see if the pause button pauses the game|N\A|snake stop moving|Snake stopped moving, game stopped updating| ||
|2.10|Test to see if the pause button plays the game after it has been paused|N\A|game continues|Game continues when the play button is pressed|Passed| Visual test|
|2.11|Test to see if snake changes direction with arrow keys|N\A|snake changes direction|Snake direction changed when arrow keys are pressed|Passed| Visual test|
|2.12|Test if the game correctly displays the view|N/A|View must visble when the view is initialised|View is visible|Passed|Visual test|


###### Test for GameController
| Test id | Test | Input | Expected Output | Actuall OutPut | Pass or Fail | comments|
|---------|------|-------|-----------------|----------------|---------------|--------|
|3.1| Test to check if the model and view are initailised|model and view| Model model, View view| model and view are intialised as game plays perfectly|Passed|Visual test| 
|3.2|Test to check if the controller draws on the canvas|canvas|snake and food drawn||||
|3.3|Test to check score menu is updated on the view during game|score=3000|score=3000|Score is updated|Passed|Visual test|
|3.4|Test to check if score menu is zero at the start of the game|N/A|score=0|Score is zero|Passed|Visual test|
|3.5|Test to check score menu is zero on restart of the game|N/A|score=0|Score is Zero|Passed|Visual test|
|3.6|Test to check highscore menu is updated|N/A|score must equal highest score|HighScore was updated and highScore was the highest score|Passed|Visul test|


###### Test for Snake
| Test id | Test | Input | Expected Output | Actuall OutPut | Pass or Fail | comments|
|---------|------|-------|-----------------|----------------|---------------|--------|
 




###### Test for GameUtil
| Test id | Test | Input | Expected Output | Actuall OutPut | Pass or Fail | comments|
|---------|------|-------|-----------------|----------------|---------------|--------|
|5.1|Test if image is correctly rotated|image|rotated image 90 degrees|||||
|5.2|Test if image it reads image stored in project| image file name| image file|||| 






###### Test for ImageUtil
| Test id | Test | Input | Expected Output | Actuall OutPut | Pass or Fail | comments|
|---------|------|-------|-----------------|----------------|---------------|--------|
|6.1|Test if all files required are stored|N/A|All files required||||



###### Test for Food
| Test id | Test | Input | Expected Output | Actuall OutPut | Pass or Fail | comments|
|---------|------|-------|-----------------|----------------|---------------|--------|
||||||||




