package cs3500.marblesolitaire.controller;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;

/**
 * This is a class that represents a controller for Marble Solitaire Model.
 */
public class MarbleSolitaireControllerImpl implements MarbleSolitaireController {
  private final Readable in;
  private final Appendable out;
  private MarbleSolitaireModel model;
  private boolean stopGame;

  /**
   * This is a constructor for MarbleSolitaireControllerImpl.
   *
   * @param in  - A readable object.
   * @param out - A appendable object.
   * @throws IllegalArgumentException - when either parameter is a null.
   */
  public MarbleSolitaireControllerImpl(Readable in, Appendable out)
          throws IllegalArgumentException {
    if (in == null) {
      throw new IllegalArgumentException("Readable input is null.");
    }
    if (out == null) {
      throw new IllegalArgumentException("Appendable input is null.");
    }
    this.in = in;
    this.out = out;
    stopGame = false;
  }


  /**
   * Plays a game of Marble Solitaire. Try and catch throws IllegalArgumentException, if the
   * provided model is null. Try and catch throws IllegalStateException only if unable to receive
   * input or transmit output.
   *
   * @Throws
   */
  @Override
  public void playGame(MarbleSolitaireModel model) {
    // Initiate model. If null, then throw IllegalArgumentException.
    if (model == null) {
      throw new IllegalArgumentException("The model is null.");
    } else {
      this.model = model;
    }
    // Use Scanner to turn Readable into a Scanner object.
    Scanner scan = new Scanner(this.in);

    // initiates move [] array to have 0s.
    // move array contains four components [fromRow, fromCol, toRow, toCol].
    int[] move = {0, 0, 0, 0};

    // index used later for tracking the four components of move array.
    int z = 0;

    while (scan.hasNext()) {
      // saves the next scanned input to a character.
      String chara = scan.next();

      // isInteger() is a private helper method used to determine if string is a integer.
      // if scanned input is a integer, load up the indexed component in move [] array.
      if (isInteger(chara)) {
        // sets character to move [] array associated with the designated index.
        move[z] = Integer.parseInt(chara);
        // increments the move array index.
        z++;
        // once move [] array has been fully loaded, resets index tracker to 0.
        if (z == 4) {
          z = 0;
        }
      }

      // else if scanned input is not a number and if it matches 'q', do quit game logic.
      else if (chara.matches("^[a-zA-Z]*$") && chara.equalsIgnoreCase("q")) {
        try {
          out.append("Game quit!\nState of game when quit:\n");
        } catch (IOException e) {
          throw new IllegalStateException(
                  "Unable to append 'Quit Game' statement to appendable."
          );
        }
        // append game state and score.
        appendStateAndScore();
        // Set stopGame boolean to be true.
        stopGame = true;
      }

      // Input is unexpected, other than q or positive integer.
      // transmit invalid move message to appendable and try next valid input.
      else {
        try {
          out.append("Invalid move. Play again. Input must be a positive integer or 'q/Q'.\n");
        } catch (IOException e) {
          throw new IllegalStateException(
                  "Unable to append 'Invalid Move' statement to appendable."
          );
        }
      }

      // determines if the four components of move [] array has been loaded.
      // moveLoaded will be true if none of the four components is 0.
      boolean moveLoaded = Arrays.stream(move).filter(i -> i > 0).count() == 4;
      // if moveLoaded, use model to do move().
      if (moveLoaded) {
        model.move(
                move[0] - 1,
                move[1] - 1,
                move[2] - 1,
                move[3] - 1
        );
        // After each move, check if game is over.
        // If game is over, append 'Game Over' statement.
        if (model.isGameOver()) {
          try {
            out.append("Game over!\n");
          } catch (IOException e) {
            throw new IllegalStateException(
                    "Unable to append 'Game over' statement to appendable."
            );
          }
          // Set stopGame boolean to be true.
          stopGame = true;
        }
        // append game state and score.
        appendStateAndScore();
        // for each component of move [] array [fromRow, fromCol, toRow, toCol],
        // set the each component to 0, thus, completes a move cycle.
        for (int i = 0; i < move.length; i++) {
          move[i] = 0;
        }
      }
      // if stopGame boolean is true, exit while loop.
      if (stopGame) {
        break;
      }
    }
    // If model's isGameOver() returns false after exiting the while loop,
    // And user has not issued a 'quit' game,
    // Then it must mean that the while loop has ran out of inputs to scan next.
    // In this case throw a IllegalStateException.
    if (!model.isGameOver() && !stopGame) {
      throw new IllegalStateException("Readable ran out of inputs");
    }
  }

  /**
   * Determines if a string can be converted to integer.
   *
   * @return true if can be converted to int, false otherwise.
   */
  private boolean isInteger(String str) {
    try {
      Integer.parseInt(str);
      return true;
    } catch (NumberFormatException e) {
      return false;
    }
  }

  /**
   * Appends the gameState of the model and score to appendable (this.out). Factored out this method
   * to reduce code replication.
   */
  private void appendStateAndScore() {
    String score = "\nScore: X\n";
    try {
      out.append(model.getGameState());
    } catch (IOException e) {
      throw new IllegalStateException("Unable to append game state to appendable.");
    }
    try {
      out.append(score.replace("X", model.getScore() + ""));
    } catch (IOException e) {
      throw new IllegalStateException("Unable to append score to appendable.");
    }
  }

}
