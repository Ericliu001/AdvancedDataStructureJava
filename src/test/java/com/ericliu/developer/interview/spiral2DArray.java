package com.ericliu.developer.interview;

import org.junit.Test;

/**
 * Created by ericliu on 4/08/2016.
 */

public class Spiral2DArray {

    public enum Direction implements Travel {
        RIGHT {
            @Override
            public boolean process(Context context) {
                int[][] matrix = context.getMatrix();
                Point point = context.getCurrentPoint();
                Rect rect = context.getRect();

                for (int i = rect.left; i <= rect.right; i++) {
                    System.out.print(" " + matrix[point.rowIndex][i] + " ");
                }

                point.columnIndex = rect.right;
                rect.top++;
                context.setDirection(DOWN);

                if (isLastElement(rect, matrix)) {
                    return false;
                }
                return true;
            }
        },
        DOWN {
            @Override
            public boolean process(Context context) {
                int[][] matrix = context.getMatrix();
                Point point = context.getCurrentPoint();
                Rect rect = context.getRect();

                for (int i = rect.top; i <= rect.bottom; i++) {
                    System.out.print(" " + matrix[i][point.columnIndex] + " ");
                }

                point.rowIndex = rect.bottom;
                rect.right--;
                context.setDirection(LEFT);

                if (isLastElement(rect, matrix)) {
                    return false;
                }
                return true;
            }
        },
        LEFT {
            @Override
            public boolean process(Context context) {
                int[][] matrix = context.getMatrix();
                Point point = context.getCurrentPoint();
                Rect rect = context.getRect();

                for (int i = rect.right; i >= rect.left; i--) {
                    System.out.print(" " + matrix[point.rowIndex][i] + " ");
                }

                point.columnIndex = rect.left;
                rect.bottom--;
                context.setDirection(UP);

                if (isLastElement(rect, matrix)) {
                    return false;
                }
                return true;
            }
        },
        UP {
            @Override
            public boolean process(Context context) {
                int[][] matrix = context.getMatrix();
                Point point = context.getCurrentPoint();
                Rect rect = context.getRect();

                for (int i = rect.bottom; i >= rect.top; i--) {
                    System.out.print(" " + matrix[i][point.columnIndex] + " ");
                }

                point.rowIndex = rect.top;
                rect.left++;
                context.setDirection(RIGHT);

                if (isLastElement(rect, matrix)) {
                    return false;
                }
                return true;
            }
        };


        boolean isLastElement(Rect rect, int[][] matrix) {
            if (rect.left >= rect.right && rect.top >= rect.bottom) {
                if (rect.left == rect.right && rect.top == rect.bottom) {
                    System.out.print(" " + matrix[rect.top][rect.left] + " ");
                }
                return true;
            }
            return false;
        }

    }

    public interface Travel {

        boolean process(Context context);
    }


    private static class Rect {
        public int top;
        public int left;
        public int bottom;
        public int right;
    }

    private static class Point {
        public int rowIndex;
        public int columnIndex;
    }


    private static class Context {
        private int[][] matrix;
        private Point currentPoint;
        private Rect mRect;
        private Direction mDirection;


        public Point getCurrentPoint() {
            return currentPoint;
        }

        public void setCurrentPoint(Point currentPoint) {
            this.currentPoint = currentPoint;
        }

        public Direction getDirection() {
            return mDirection;
        }

        public void setDirection(Direction direction) {
            mDirection = direction;
        }

        public int[][] getMatrix() {
            return matrix;
        }

        public void setMatrix(int[][] matrix) {
            this.matrix = matrix;
        }

        public Rect getRect() {
            return mRect;
        }

        public void setRect(Rect rect) {
            mRect = rect;
        }
    }


    @Test
    public void testSpiralPrinting2DArray() {
        int[][] matrix = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        Point start = new Point();
        start.rowIndex = 0;
        start.columnIndex = 0;

        Rect rect = new Rect();
        rect.top = rect.left = 0;
        rect.bottom = matrix.length - 1;
        rect.right = matrix[0].length - 1;

        Context context = new Context();
        context.setMatrix(matrix);
        context.setCurrentPoint(start);
        context.setDirection(Direction.RIGHT);
        context.setRect(rect);

        while (context.getDirection().process(context)) ;

    }
}
