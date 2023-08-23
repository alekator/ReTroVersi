package server;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import logic.Board;
import logic.Cell;
import logic.Move;
import logic.Player;
import serverresponses.WhereIcanGoResponse;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;


public class serverPlayer extends Player {
    private static final Scanner scanner = new Scanner(System.in);
    public int row;
    public int col;
    public UUID uuid;

    public serverPlayer(Cell playerCell, int row, int col, UUID uuid) {
        super(playerCell);
        this.col = col - 1;
        this.row = row - 1;
        this.uuid = uuid;

    }

    @Override
    public Move makeMove(Board board) {
        final List<Move> availableMoves = board.getAllAvailableMoves(playerCell);

        Server.ClientProcessor thisPlayer = Server.clients.get(uuid);
        WhereIcanGoResponse whereIcanGoResponse = new WhereIcanGoResponse(availableMoves, board, playerCell);
        thisPlayer.sendReply(whereIcanGoResponse);


        Date dateStart = new Date();

        final Move move = new Move(this.row, this.col);

        if (availableMoves.contains(move)) {
            board.placePiece(this.row, this.col, playerCell);
            Date dateEnd = new Date();
            long finalTime = dateEnd.getTime() - dateStart.getTime();
            move.setTimeOnMove(finalTime);
            return move;
        } else {
            System.out.println("Недопустимый ход! Пожалуйста, выберите из доступных ходов.");//response + return
        }
        return move;//переделать
    }
}

