package ru.job4j.chess.figures.white;

import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.figures.Cell;
import ru.job4j.chess.figures.Figure;

/**
 *
 * @author Petr Arsentev (parsentev@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class BishopWhite extends Figure {
    private final Cell position;

    public BishopWhite(final Cell position) {
        this.position = position;
    }

    @Override
    public Cell position() {
        return this.position;
    }

    @Override
    public Cell[] way(Cell source, Cell dest) throws ImpossibleMoveException {
        int deltaX = source.getX() - dest.getX();
        int deltaY = source.getY() - dest.getY();
        int size = Math.abs(deltaX);
        if (Math.abs(deltaX) != Math.abs(deltaY)) {
            throw new ImpossibleMoveException("Данная фигура не может так ходить");
        }
        Cell[] steps = new Cell[size];
        int resultX = deltaX < 0 ? 1 : -1;
        int resultY = deltaY < 0 ? 1 : -1;
        for (int i = 0; i < size; i++) {
            steps[i] = Cell.getCellByXY((source.getX() + resultX * (i + 1)),
                    (source.getY() + resultY * (i + 1)));
        }

        return steps;
    }

    @Override
    public Figure copy(Cell dest) {
        return new BishopWhite(dest);
    }
}
