/**Mir Shahiduzzaman*/
package sample;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.util.Duration;

import static sample.BackEnd.*;


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

                if(counter>Integer.parseInt(high1))
                {
                    generateCsvFile("highScores.csv",String.valueOf(counter),high2,high3);
                }
                else
                {
                    if(counter>Integer.parseInt(high2))
                    {
                        generateCsvFile("highScores.csv",high1,String.valueOf(counter),high3);
                    }
                    else
                    {
                        if(counter>Integer.parseInt(high3))
                        {
                            generateCsvFile("highScores.csv",high1,high2,String.valueOf(counter));
                        }
                    }
                }
                bestScore.setText("High Scores:\n 1) " + high1 +"  2) " + high2 + "  3) " + high3);
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
