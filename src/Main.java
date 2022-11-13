import java.sql.Array;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        boolean key = true;
        Scanner input = new Scanner(System.in);
        int[] mas = new int[20];
        int[] mas1 = new int[20];
        for (int i=0;i<mas.length;i++){
            mas[i]= (int) (Math.random() * 200 - 100);
        }
        for (int i=0;i<mas1.length;i++){
            mas1[i]= (int) (Math.random() * 200 - 100);
        }
        System.out.println("1. Выводит все элементы массива\n" +
                "2. Выводит все элементы массива 1\n" +
                "3. Выводит чётные элементы массива 1 \n" +
                "4. Выводит все элементы массива 1 через x\n" +
                "5. Выводит все элементы массива 1 пока не встретится элемент -1\n" +
                "6. Добавить элемент в конец массива 2\n" +
                "7. Добавить элемент в начало массива 2\n" +
                "8. Заменить элемент на позиции x массива 2\n" +
                "9. Удалить последний элемент массива 2\n" +
                "10. Удалить первый элемент массива 2\n" +
                "11. Удалить элемент массива 2 с определённой позиции\n" +
                "12. Создать итоговый двумерный массив (Конец программы)");
        while (key) {
            System.out.print("Введите номер задания: ");
            int za = input.nextInt();
            switch (za) {
                case 1 -> zad1(mas1);
                case 2 -> zad2(mas);
                case 3 -> zad3(mas);
                case 4 -> {
                    System.out.println("Вывести все элементы массива через x начиная с первого. Введите x: ");
                    za = input.nextInt();
                    zad4(mas, za);
                }
                case 5 -> zad5(mas);
                case 6 -> {
                    System.out.print("Добавить в конец целое число: ");
                    za = input.nextInt();
                    int[] temp = new int[mas1.length+1];
                    for (int i = 0; i<mas1.length;i++){
                        temp[i] = mas1[i];
                    }
                    temp[mas1.length] = za;
                    mas1 = new int[temp.length];
                    for (int i = 0; i<mas1.length;i++){
                        mas1[i] = temp[i];
                    }
                }
                case 7 -> {
                    System.out.print("Добавить в начало целое число: ");
                    za = input.nextInt();
                    int[] temp = new int[mas1.length+1];
                    for (int i = 1; i<temp.length;i++){
                        temp[i] = mas1[i-1];
                    }
                    temp[0] = za;
                    mas1 = new int[temp.length];
                    for (int i = 0; i<mas1.length;i++){
                        mas1[i] = temp[i];
                    }
                }
                case 8 -> {
                    System.out.print("Выберите позицию в массиве (начиная с 1): ");
                    int i = input.nextInt();
                    System.out.print("Выберите целое число на которое заменить элемент: ");
                    za = input.nextInt();
                    mas1[i-1]=za;
                }
                case 9 -> {
                    int[] temp = new int[mas1.length-1];
                    for (int i = 0; i<temp.length;i++){
                        temp[i] = mas1[i];
                    }
                    mas1 = new int[temp.length];
                    for (int i = 0; i<mas1.length;i++){
                        mas1[i] = temp[i];
                    }
                }
                case 10 -> {
                    int[] temp = new int[mas1.length-1];
                    for (int i = 0; i<temp.length;i++){
                        temp[i] = mas1[i+1];
                    }
                    mas1 = new int[temp.length];
                    for (int i = 0; i<mas1.length;i++){
                        mas1[i] = temp[i];
                    }
                }
                case 11 -> {
                    System.out.print("Выберите позицию в массиве (начиная с 1): ");
                    int a = input.nextInt() - 1;
                    int[] temp = new int[mas1.length-1];
                    for (int i = 0; i<mas1.length;i++){
                        if (i<a) {
                            temp[i] = mas1[i];
                        }
                        else if (i>a) {
                            temp[i-1] = mas1[i];
                        }
                    }
                    mas1 = new int[temp.length];
                    for (int i = 0; i<mas1.length;i++){
                        mas1[i] = temp[i];
                    }
                }
                case 12 -> {
                    key = false;
                    zad12(mas,mas1);
                }
                default -> System.out.println("Неверно выбрано задание.");
            }

        }
    }
    public static void zad1(int[] a){
        for(int i=0; i<a.length;i++){
            System.out.println(a[i]);
        }
    }
    public static void zad2(int[] a) {
        for(int i=a.length-1;i>-1;i--){
            System.out.println(a[i]);
        }
    }
    public static void zad3(int[] a){
        for(int i=0;i<a.length;i=i+2){
            System.out.println(a[i]);
        }
    }
    public static void zad4(int[] a,int b){
        for(int i=0;i<a.length;i=i+b){
            System.out.println(a[i]);
        }
    }
    public static void zad5(int[] a){
        for(int i=0; i<a.length;i++){
            System.out.println(a[i]);
            if (a[i]==-1){
                break;
            }
        }
    }
    public static void zad12(int[] a,int[] b){
        int[][] it;
        if (a.length > b.length){
            it = new int[a.length][2];
        }
        else{
            it = new int[b.length][2];
        }
        for (int i=0;i<it.length;i++){
            it[i][0] = a[i];
            it[i][1] = b[i];
        }
        for(int i =0;i< it.length;i++){
            System.out.print(it[i][0] + "  ");
        }
        System.out.println(' ');
        for(int i =0;i< it.length;i++){
            System.out.print(it[i][1] + "  ");
        }
    }
}