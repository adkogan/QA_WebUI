package ru.gb.lesson4;

public class Triangle {

    public int a;
    public int b;
    public int c;

    public Triangle(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public String toString() {
        return "Triangle{" +
                "a=" + a +
                ", b=" + b +
                ", c=" + c +
                '}';
    }

    public static boolean isTriangleValid(int a, int b, int c) {
        if ((a + b) > c && (a + c) > b && (b + c) > a) {
            return true;
        } else {
            throw new IllegalArgumentException("Невалидные стороны треугольника: одна из сторон больше или равна сумме двух других");
        }
    }

    public static boolean isTriangleVerticesNotNull(int a, int b, int c) {
        if (!(a > 0 | b > 0 | c > 0)) {
            throw new IllegalArgumentException("Введенные числа должны быть больше 0");
        }
        return true;
    }


        public static int triangleArea ( int a, int b, int c){
            int p = (int) (((a + b + c) / 2.0) * ((a + b + c) / 2.0 - a) * ((a + b + c) / 2.0 - b) * ((a + b + c) / 2.0 - c));
            return (int) Math.sqrt(p);
        }






    public static void main(String[] args) {
        double S;
        int a = 10;
        int b = 15;
        int c = 20;
        if ((isTriangleValid(a, b, c)) && (isTriangleVerticesNotNull(a,b,c))) {
            S = triangleArea(a, b, c);
            System.out.println("Площадь треугольника равна:" + S);
        }
    }





    }

