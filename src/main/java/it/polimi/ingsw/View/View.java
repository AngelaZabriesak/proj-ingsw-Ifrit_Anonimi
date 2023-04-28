package it.polimi.ingsw.View;

/**
 * Defines a generic view to be implemented by each view type
 */
public interface View {
    /**
     * Asks the user to choose a Nickname.
     */
    void askNickname();
    void askNPlayers();
    void askItem();
    void askColumn();
    void askOrder();
    void showBoard();
    void showShelf();
    void showPGoal();
    void showCGoal();
    void showScore();

    void showLoginResult(boolean nicknameAccepted, boolean connectionSuccessful, String nickname);
    void showErrorAndExit(String error);

}
