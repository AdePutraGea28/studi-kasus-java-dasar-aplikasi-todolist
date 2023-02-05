import java.util.Scanner;
import java.io.*;

public class AplikasiTodolist {

    // TODOLIST MODEL
    public static String[] model = new String[10];

    public static java.util.Scanner scanner = new java.util.Scanner(System.in);
    // Declaring ANSI_RESET so that we can reset the color
    public static final String ANSI_RESET = "\u001B[0m";

    // Declaring the color
    // Custom declaration
    public static final String ANSI_RED = "\u001B[31m";

    public static void main(String[] args) {

        // RUNNING PROGRAM HERE....
        viewShowTodoList();
    }

    // =================== BISNIS LOGIC =================== //
    /**
     * menampilkan todolist
     */
    public static void showTodoList() {

        var number = 1;
        for(var i = 0; i < model.length; i++) {

            if(model[i] != null) {
                System.out.println(number + ". "+ model[i]);
                number++;
            }
        }

    }

    public static void testShowTodoList() {
        model[0] = "Satu";
        model[1] = "Dua";
        model[2] = "Tiga";

        showTodoList();
    }

    /**
     * menambahkan todo ke list
     */
    public static void addTodoList(String todo) {

        // check jika model penuh atau tidak
        boolean isFull = true;
        for(var i = 0; i < model.length; i++) {
            if(model[i] == null) {
                isFull = false;
                break;
            }
        }

        // jika penuh tambah ukuran model sebanyak 2 kali lipat dari ukuran awal
        if(isFull) {
            var temp = model;
            model = new String[model.length * 2];

            for(var i = 0; i < temp.length; i++) {
                model[i] = temp[i];
            }
        }

        // tambahkan data ke dalam array yang null
        for(var i = 0; i < model.length; i++) {
            if(model[i] == null) {
                model[i] = todo;
                break;
            }
        }

    }

    public static void testAddTodoList() {
        addTodoList("Satu");
        addTodoList("Duat");
        addTodoList("Tiga");
        addTodoList("empat");
        addTodoList("lima");
        addTodoList("enam");
        addTodoList("tujuh");
        addTodoList("delapan");
        addTodoList("sembilan");
        addTodoList("sepuluh");
        addTodoList("sebelas");
        addTodoList("12");
        addTodoList("13");
        addTodoList("14");
        addTodoList("15");
        addTodoList("16");
        addTodoList("17");
        addTodoList("18");
        addTodoList("19");
        addTodoList("20");
        addTodoList("21");
        addTodoList("22");

        showTodoList();
    }

    /**
     * menghapus todo dari list
     */
    public static boolean removeTodoList(Integer number) {

        /**
         * LOGIC JIKA PARAMETER NUMBER SAMA DENGAN ATAU LEBIH BESAR DARI PANJANG MODEL, RETURN FALSE;
         * JIKA MODEL INDEX NILANYA SUDAH NULL MAKA RETURN FASE;
         * JIKA MODEL INDEX NILAI-NYA ADA ATAU TIDAK NULL MAKA RETURN TRUE;
         */

        var numberToIndex = number - 1;
        if(numberToIndex >= model.length){
            return false;
        } else if(model[numberToIndex] == null) {
            return false;
        } else {
            model[numberToIndex] = null;
            return true;
        }
    }

    public static void testRemoveTodoList() {
        addTodoList("Satu");
        addTodoList("Dua");
        addTodoList("Tiga");
        addTodoList("empat");
        addTodoList("lima");
        addTodoList("enam");
        addTodoList("tujuh");
        addTodoList("delapan");
        addTodoList("sembilan");
        addTodoList("sepuluh");

        removeTodoList(10);

        showTodoList();
    }

    // =================== BISNIS LOGIC =================== //

    // =================== VIEW TODOLIST =================== //

    public static String input(String info) {
        System.out.print(info + " : ");
        String data = scanner.nextLine();
        return data;
    }

    public static void testInput() {
        var result = input("test");
        System.out.println("Hi " + result);
    }

    /**
     * menampilkan semua list todo
     */
    public static void viewShowTodoList() {

        while(true) {
            System.out.println("TODOLIST");
            showTodoList();

            System.out.println("MENU : ");
            System.out.println("Ketik + untuk Tambah");
            System.out.println("Ketik - untuk Hapus");
            System.out.println("Ketik x untuk Keluar");

            var input = input("Pilih");

            if(input.equals("+")) {
                viewAddTodoList();
            } else if(input.equals("-")) {
                viewRemoveTodoList();
            } else if(input.equals("x") || input.equals("X")) {
                System.out.println("Bye!");
                break;
            } else {
                System.out.println(ANSI_RED + "Menu tidak ditemukan!" + ANSI_RESET);
            }
        }

    }

    public static void testViewShowTodoList() {
        addTodoList("Belajar Java Dasar");
        addTodoList("Belajar Java OOP");
        addTodoList("Belajar Java Expert");
        viewShowTodoList();
    }

    /**
     * tampilan untuk menambahkan todo ke list
     */
    public static void viewAddTodoList() {
//        System.out.println("Add Todo");
            System.out.println("Ketik x untuk batal");
            var todo = input("Tambah Todo");

            if(todo.equals("x")) {
                // batal
            } else {
                addTodoList(todo);
            }

    }

    public static void testViewAddTodoList() {
        addTodoList("makan");
        addTodoList("minum");
        addTodoList("mandi");

        viewAddTodoList();
        showTodoList();
    }

    /**
     * tampilan untuk menghapus todo dari list
     */
    public static void viewRemoveTodoList() {
        System.out.println("Ketik x untuk batal");
        var number = input("Pilih Nomor Todo");

        if(number.equals("x")) {

        } else {
            boolean isSuccess = removeTodoList(Integer.valueOf(number));
            if(!isSuccess) {
                System.out.println("Gagal mengapus todo dari list dengan nomor : " + number);
            }
        }
    }

    public static void testViewRemoveTodoList() {

        addTodoList("Makan");
        addTodoList("Minum");
        addTodoList("Membaca");

        showTodoList();
        viewRemoveTodoList();
        showTodoList();

    }

    // =================== VIEW TODOLIST =================== //

}
