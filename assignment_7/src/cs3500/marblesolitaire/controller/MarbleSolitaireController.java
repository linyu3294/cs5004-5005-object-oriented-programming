package cs3500.marblesolitaire.controller;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;

/**
 * This is a interface for the Marble Solitaire game controller.
 */
public interface MarbleSolitaireController {
  /**
   * Plays the game using a MarbleSolitaireModel object.
   *
   * @param model - MarbleSolitaireModel object.
   */
  public void playGame(MarbleSolitaireModel model);
}
