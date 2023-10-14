package ru.job4j.chess.firuges.black;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import ru.job4j.chess.firuges.Cell;

class BishopBlackTest {

    @Test
    void position() {
        Cell cell = Cell.A1;
        BishopBlack figure = new BishopBlack(cell);
        Cell cellFigure =figure.position();
        assertEquals(cell,cellFigure);
    }

    @Test
    void copy() {
        Cell cell = Cell.A1;
        BishopBlack figure = new BishopBlack(cell);
        Cell cellNew = Cell.B5;
        figure = (BishopBlack)figure.copy(cellNew);
        Cell cellFigure =figure.position();
        assertEquals(cellNew,cellFigure);
    }

    @Test
    void way() {
        BishopBlack figure = new BishopBlack(Cell.C1);
        Cell[] way = figure.way(Cell.G5);
        Cell[] exp = {Cell.D2, Cell.E3, Cell.F4, Cell.G5};
        assertArrayEquals(exp,way);
    }

    @Test
    void isDiagonal() {
        BishopBlack figure = new BishopBlack(Cell.C1);
        assertEquals(true, figure.isDiagonal(figure.position(),Cell.G5));
        assertEquals(false, figure.isDiagonal(figure.position(),Cell.G6));
    }
}