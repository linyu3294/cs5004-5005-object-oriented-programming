package cs3500.marblesolitaire;

import java.io.InputStreamReader;

import cs3500.marblesolitaire.controller.MarbleSolitaireController;
import cs3500.marblesolitaire.controller.MarbleSolitaireControllerImpl;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelImpl;
import cs3500.marblesolitaire.model.hw04.EuropeanSolitaireModelImpl;
import cs3500.marblesolitaire.model.hw04.TriangleSolitaireModelImpl;

/**
 * Class used to represent the game in the root/src folder.
 */
public final class MarbleSolitaire {

  /**
   * Main class used to play the game and enter command line arguments.
   *
   * @param args - List of arguments in a string array.
   */
  public static void main(String[] args) {
    String strBoard = "";
    int row = 0;
    int col = 0;
    int scale = 0;

    for (int i = 0; i < args.length; i++) {
      String s = args[i];
      if (s.contains("english") || s.contains("european") || s.contains("triangular")) {
        strBoard = s;
      }
      if (s.contains("-hole")) {
        row = Integer.parseInt(args[i + 1]);
        col = Integer.parseInt(args[i + 2]);
      }
      if (s.contains("-size")) {
        scale = Integer.parseInt(args[i + 1]);
      }
      System.out.println(s);
    }

    StringBuffer out = new StringBuffer();
    Readable in = new InputStreamReader(System.in);
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(in, out);
    MarbleSolitaireModel model = null;

    if (strBoard.equals("english")) {
      if (scale != 0 & row != 0 & col != 0) {
        model = new MarbleSolitaireModelImpl(scale, row, col);
      } else if (scale == 0 & row != 0 & col != 0) {
        model = new MarbleSolitaireModelImpl(row, col);
      } else if (scale != 0 & row == 0 & col == 0) {
        model = new MarbleSolitaireModelImpl(scale);
      } else if (scale == 0 & row == 0 & col == 0) {
        model = new MarbleSolitaireModelImpl();
      }

      if (strBoard.equals("european")) {
        if (scale != 0 & row != 0 & col != 0) {
          model = new EuropeanSolitaireModelImpl(scale, row, col);
        } else if (scale == 0 & row != 0 & col != 0) {
          model = new EuropeanSolitaireModelImpl(row, col);
        } else if (scale != 0 & row == 0 & col == 0) {
          model = new EuropeanSolitaireModelImpl(scale);
        } else if (scale == 0 & row == 0 & col == 0) {
          model = new EuropeanSolitaireModelImpl();
        }

        if (strBoard.equals("triangular")) {
          if (scale != 0 & row != 0 & col != 0) {
            model = new TriangleSolitaireModelImpl(scale, row, col);
          } else if (scale == 0 & row != 0 & col != 0) {
            model = new TriangleSolitaireModelImpl(row, col);
          } else if (scale != 0 & row == 0 & col == 0) {
            model = new TriangleSolitaireModelImpl(scale);
          } else if (scale == 0 & row == 0 & col == 0) {
            model = new TriangleSolitaireModelImpl();
          }
        }
        controller.playGame(model);
      }
    }
  }
}
