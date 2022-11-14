import java.sql.Array;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        boolean key = true;
        Scanner input = new Scanner(System.in);
        //создаём 2 массива
        int[] mas = new int[20];
        int[] mas1 = new int[20];
        //забиваем массивы числами от -100 до +100
        for (int i=0;i<mas.length;i++){
            mas[i]= (int) (Math.random() * 200 - 100);
        }
        for (int i=0;i<mas1.length;i++){
            mas1[i]= (int) (Math.random() * 200 - 100);
        }
        //запрашиваем задание
        System.out.println("1. Выводит все элементы массива 1\n" +
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
                "12. Создать итоговый двумерный массив (Конец программы)\n" +
                "13. (не входит в задание, сделано для проверки работы программы) Выводит все элементы массива 2");
        //программу в цикл, чтобы можно было выполнять несколько раз задание с массивом
        while (key) {
            System.out.print("Введите номер задания: ");
            int za = input.nextInt();
            //от номера задания смотрим что выполнять
            switch (za) {
                case 1 -> zad1(mas);
                case 2 -> zad2(mas);
                case 3 -> zad3(mas);
                case 4 -> {
                    System.out.println("Вывести все элементы массива через x начиная с первого. Введите x: ");
                    za = input.nextInt();
                    zad4(mas, za);
                }
                case 5 -> zad5(mas);
                case 6 -> {
                    //запрос числа добавляемого в конец массива
                    System.out.print("Добавить в конец целое число: ");
                    za = input.nextInt();
                    //создаём массив размерностью на 1 больше
                    int[] temp = new int[mas1.length+1];
                    //сохраняем в него старый массив
                    for (int i = 0; i<mas1.length;i++){
                        temp[i] = mas1[i];
                    }
                    //сохраняем в последний элемент новое число
                    temp[mas1.length] = za;
                    //пересоздаём основной массив но с большей размерность и сохраняем в него ответ
                    mas1 = new int[temp.length];
                    for (int i = 0; i<mas1.length;i++){
                        mas1[i] = temp[i];
                    }
                }
                case 7 -> {
                    //запрос числа добавляемого в начало массива
                    System.out.print("Добавить в начало целое число: ");
                    za = input.nextInt();
                    //создаём массив размерностью на 1 больше
                    int[] temp = new int[mas1.length+1];
                    //сохраняем в него старый массив
                    for (int i = 1; i<temp.length;i++){
                        temp[i] = mas1[i-1];
                    }
                    //записываем в первый элемент новое число
                    temp[0] = za;
                    //пересоздаём основной массив но с большей размерность и сохраняем в него ответ
                    mas1 = new int[temp.length];
                    for (int i = 0; i<mas1.length;i++){
                        mas1[i] = temp[i];
                    }
                }
                case 8 -> {
                    //запрос числа и позиции для замены элемента
                    System.out.print("Выберите позицию в массиве (начиная с 1): ");
                    int i = input.nextInt();
                    System.out.print("Выберите целое число на которое заменить элемент: ");
                    za = input.nextInt();
                    //заменяем этот элемент на наше число
                    mas1[i-1]=za;
                }
                case 9 -> {
                    //создаём временный массив размерностью на 1 меньше
                    int[] temp = new int[mas1.length-1];
                    //записываем во временный массив старый кроме последнего элемента
                    for (int i = 0; i<temp.length;i++){
                        temp[i] = mas1[i];
                    }
                    //пересоздаём старый массив с размерность на 1 меньше и сохраняем в него ответ
                    mas1 = new int[temp.length];
                    for (int i = 0; i<mas1.length;i++){
                        mas1[i] = temp[i];
                    }
                }
                case 10 -> {
                    //создаём временный массив размерностью на 1 меньше
                    int[] temp = new int[mas1.length-1];
                    //записываем во временный массив старый пропустив первый элемент
                    for (int i = 0; i<temp.length;i++){
                        temp[i] = mas1[i+1];
                    }
                    //пересоздаём старый массив с размерность на 1 меньше и сохраняем в него ответ
                    mas1 = new int[temp.length];
                    for (int i = 0; i<mas1.length;i++){
                        mas1[i] = temp[i];
                    }
                }
                case 11 -> {
                    //спращиваем позицию элемента что надо удалить
                    System.out.print("Выберите позицию в массиве (начиная с 1): ");
                    int a = input.nextInt() - 1;
                    //создаём временный массив размерностью на 1 меньше
                    int[] temp = new int[mas1.length-1];
                    //записываем во временный массив старый массив
                    for (int i = 0; i<mas1.length;i++){
                        if (i<a) {
                            //числа до заданной позиции
                            temp[i] = mas1[i];
                        }
                        else if (i>a) {
                            //числа после заданной позиции
                            temp[i-1] = mas1[i];
                        }
                    }
                    //пересоздаём старый массив с размерность на 1 меньше и сохраняем в него ответ
                    mas1 = new int[temp.length];
                    for (int i = 0; i<mas1.length;i++){
                        mas1[i] = temp[i];
                    }
                }
                case 12 -> {
                    //завершаем цикл и выполняем задание 12
                    key = false;
                    zad12(mas,mas1);
                }
                case 13 -> zad13(mas1);
                default -> System.out.println("Неверно выбрано задание.");
            }

        }
    }
    public static void zad1(int[] a){
        //вывод массива
        for(int i=0; i<a.length;i++){
            System.out.println(a[i]);
        }
    }
    public static void zad2(int[] a) {
        //вывод массива наоборот
        for(int i=a.length-1;i>-1;i--){
            System.out.println(a[i]);
        }
    }
    public static void zad3(int[] a){
        //вывод четных элементов массива
        for(int i=0;i<a.length;i=i+2){
            System.out.println(a[i]);
        }
    }
    public static void zad4(int[] a,int b){
        //вывод элементов массива через x
        for(int i=0;i<a.length;i=i+b){
            System.out.println(a[i]);
        }
    }
    public static void zad5(int[] a){
        //вывод элементов массива
        for(int i=0; i<a.length;i++){
            System.out.println(a[i]);
            //если встречается -1 то вывод завершается
            if (a[i]==-1){
                break;
            }
        }
    }
    public static void zad12(int[] a,int[] b){
        //создаём двумерный массив
        int[][] it;
        //узнаём сколько строк должно быть в двумерном массиве
        if (a.length > b.length){
            //если массив 1 больше то строк в двумерном массиве столько сколько ячеек в массиве 1
            it = new int[a.length][2];
        }
        else{
            //если массив 1 больше то строк в двумерном массиве столько сколько ячеек в массиве 1
            it = new int[b.length][2];
        }
        //записывам в двумерный массив прошлые 2
        for (int i=0;i<it.length;i++){
            it[i][0] = a[i];
            it[i][1] = b[i];
        }
        for(int i =0;i< it.length;i++){
            //выводим строку под номером i
            System.out.println(it[i][0] + "         " + it[i][1]);
        }

    }
    public static void zad13(int[] a){
        //вывод массива
        for(int i=0; i<a.length;i++){
            System.out.println(a[i]);
        }
    }
}