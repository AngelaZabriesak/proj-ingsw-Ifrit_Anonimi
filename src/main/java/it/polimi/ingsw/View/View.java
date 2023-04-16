package it.polimi.ingsw.View;

/**
 * Defines a generic view to be implemented by each view type
 */
public interface View {
    /**
     * Asks the user to choose a Nickname.
     */
    void askNickname();

    void showLoginResult(boolean nicknameAccepted, boolean connectionSuccessful, String nickname);
    void showErrorAndExit(String error);

}
