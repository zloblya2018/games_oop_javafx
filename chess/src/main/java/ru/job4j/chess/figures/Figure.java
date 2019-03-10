package ru.job4j.chess.figures;

import ru.job4j.chess.ImpossibleMoveException;

public abstract class Figure {
    /**
     * Положение фигуры на доске.
     */
    private Cell position;

    /**
     * Конструктор фигуры.
     */
    public Figure() {
    }

    /**
     * Метод возвращает положение фигуры.
     * @return Ячейка на доске.
     */
    abstract public Cell position();

    /**
     * Абстрактнй метод возвращает ячейки через которые проходит фигура за ход, если такой ход возможен.
     * @param source Ячейка начального положения фигуры.
     * @param dest Ячейка хода фигуры.
     * @return Массив ячеек, через которые должна пройти фигура.
     * @throws ImpossibleMoveException Выбрасываем исключение, если фигура так не ходит.
     */
    abstract public Cell[] way(Cell source, Cell dest) throws ImpossibleMoveException;

    /**
     * Метод возвращает имя файла изображения фигуры.
     * @return Строка с именем файла изображения фигуры.
     */
    public String icon() {
        return String.format(
                "%s.png", this.getClass().getSimpleName()
        );
    }

    /**
     * Метод проверяет находятся ли две ячейки на одной диагонали.
     * @param source Ячейка 1.
     * @param dest Ячейка 2.
     * @return Результат.
     */
    public boolean isDiagonal(Cell source, Cell dest) {
        boolean rst = false;
        if (((dest.x - dest.y) == (source.x - source.y))
                || ((dest.x + dest.y) == (source.x + source.y))) {
            rst = true;
        }
        return rst;
    }

    /**
     * Абстрактный метод он создаёт объект Figure с координатой Cell dest.
     * @param dest Ячейка нового расположения фигуры.
     * @return Фигура с новым расположением.
     */
    abstract public Figure copy(Cell dest);
}
