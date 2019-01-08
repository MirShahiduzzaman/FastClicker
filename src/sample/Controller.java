/**Mir Shahiduzzaman*/
package sample;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.util.Duration;


public class Controller
{
    int counter = 0;
    @FXML
    Button click;
    @FXML
    Button start;
    @FXML
    Label playScore;
    @FXML
    Label bestScore;


    boolean playTime = false;
    int highScore = 0;

    public void startGame()
    {
        //checks to see if change is in session
        //once button is clicked timer starts and each click counted using the counter varible
        //once Timer is down the count is displayed and compared with best score
        if(!playTime)
        {
            playTime = true;
            counter = 0;
            click.setText("Click Me!!!");
            Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(10), ev -> {
                playScore.setText("You Scored: " + counter);
                if (highScore < counter)
                {
                    highScore = counter;
                    bestScore.setText("Highscore: " + highScore);
                }
                click.setText("Don't Click Me!");
                playTime = false;
            }
            ));
            timeline.play();
        }
    }

    public void pressButton()
    {//increments the counter and updates the display
        if(playTime)
        {
            counter++;
            playScore.setText("Your Score: " + counter);
        }
    }
}
