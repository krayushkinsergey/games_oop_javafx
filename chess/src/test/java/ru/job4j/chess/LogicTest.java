package ru.job4j.chess;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;
import ru.job4j.chess.firuges.black.BishopBlack;
import ru.job4j.chess.firuges.white.PawnWhite;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

@Disabled("Тесты отключены. Удалить аннотацию после реализации всех методов по заданию.")
public class LogicTest {

    @Test
    public void whenMoveThenFigureNotFoundException()
            throws FigureNotFoundException, OccupiedCellException, ImpossibleMoveException {
        Logic logic = new Logic();
        FigureNotFoundException exception = assertThrows(FigureNotFoundException.class, () -> {
            logic.move(Cell.C1, Cell.H6);
        });
        assertThat(exception.getMessage()).isEqualTo("Figure not found on the board.");
    }

    @Test
    public void whenMoveThenFigureOccupiedCellException()
            throws FigureNotFoundException, OccupiedCellException, ImpossibleMoveException {
        Logic logic = new Logic();
        logic.add(new PawnWhite(Cell.E3));
        logic.add(new BishopBlack(Cell.C1));
        OccupiedCellException exception = assertThrows(OccupiedCellException.class,
                () -> {
                    logic.move(Cell.C1, Cell.G5);
                });
        assertThat(exception.getMessage()).isEqualTo("Figure Occupied Cell");
    }

    @Test
    public void whenMoveThenNotFigureOccupiedCellException()
            throws FigureNotFoundException, OccupiedCellException, ImpossibleMoveException {
        Logic logic = new Logic();
        logic.add(new PawnWhite(Cell.E4));
        logic.add(new BishopBlack(Cell.C1));
        OccupiedCellException execption = null;
        try {
            logic.move(Cell.C1, Cell.G5);
        } catch (OccupiedCellException e) {
            execption = e;
        }
        assertNull(execption);
    }
}