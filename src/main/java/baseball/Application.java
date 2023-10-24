package baseball;

import baseball.domain.GameResult;
import baseball.domain.player.Player;
import baseball.domain.computer.Computer;


import static baseball.domain.BaseBallGame.*;
import static baseball.domain.GameMessage.GAME_START_MESSAGE;
import static baseball.domain.GameResult.calculateBaseBallGame;


public class Application {
    public static void main(String[] args) {
        Computer computer = Computer.init();
        GameResult gameResult = GameResult.init();
        System.out.println(GAME_START_MESSAGE);
        while (!computer.isFinishedGame()) {
            computer = computer.refresh();
            Player userBaseBallNumbers = Player.createPlayerByIntegerNumbers(inputNumbers());
            gameResult = calculateBaseBallGame(userBaseBallNumbers, computer);
            gameResultMessage(gameResult);
            computer.changeGameState(inputGameStateCommand(gameResult));
        }
    }
}
