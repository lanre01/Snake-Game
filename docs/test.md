#### Test Plan for The Game

###### Test for GameModel
| Test id | Test | Input | Expected Output | Actuall OutPut | Pass or Fail | comments|
|---------|------|-------|-----------------|----------------|---------------|--------|
|1.1|Test if the model correctly set player name| String "lawal"| lawal| ||
|1.2|Test if the model set the snake length| 2 | 2|||
|1.3|Test if the model set the game hasfinished value correctly|true| true| ||
|1.4| Test if the model set the food value correctly| true| true|||
|1.5|Test if the model set the highscore to be the correct value| 3000|3000|||

###### Test for GameView
| Test id | Test | Input | Expected Output | Actuall OutPut | Pass or Fail | comments|
|---------|------|-------|-----------------|----------------|---------------|--------|
|2.1|Test if the view displays the snake|N/A|snake is seen on the view||||
|2.2|Test to see if food is draw on the view|N/A|food is drawn on the view||||
|2.3|Test to see if the snake is able to eat the food|N/A| snake eat the food|snake eats the food||||
|2.4|Test to see if another food is drawn afer the food has been eaten|N/A|food is on the view||||
|2.5|Test to see if the snake moves|N/A|snake moves on the screen|||||
|2.6|Test to see if the score label updates when food is eaten|N\A|score label updates||||
|2.7|Test to see if the highscore label updates when game is restarted|N\A|highscore label updates||||
|2.8|Test to see if the name label updates|N\A|name label updates||||
|2.9|Test to see if the pause button pauses the game|N\A|snake stop moving||||
|2.10|Test to see if the pause button plays the game after it has been paused|N\A|game continues||||
|2.11|Test to see if snake changes direction with arrow keys|N\A|snake changes direction||||



###### Test for GameController
| Test id | Test | Input | Expected Output | Actuall OutPut | Pass or Fail | comments|
|---------|------|-------|-----------------|----------------|---------------|--------|
|3.1| Test to check if the model and view are initailised|True | Model model, View view| ||
|3.2|Test check if controller knows when game has finished|set gameFinished to true|the view does no update the snake||||
|3.3|Test to check if the controller draws on the canvas|canvas|snake and food drawn||||
|3.4|Test to check score menu is updated on the view during game|score=3000|score=3000||||
|3.5|Test to check if score menu is zero at the start of the game|N/A|score=0||||
|3.6|Test to check score menu is zero on restart of the game|N/A|score=0||||
|3.7|Test to check highscore menu is updated|N/A|score must equal highest score||||


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



