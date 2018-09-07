import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new FileReader("Input.txt"));
             BufferedWriter output = new BufferedWriter(new FileWriter("Output.txt"))){
            String readedString;
            while ((readedString = reader.readLine()) != null ){
                String[] readedMas = readedString.split(", ");
                ArrayList<Integer> inputMas = new ArrayList<>();
                for (String i : readedMas) {
                    inputMas.add(Integer.parseInt(i));
                }
                ArrayList<Integer> resultMas = sorter(inputMas);
                output.write(resultMas.toString() + "\n");
            }
        } catch (IOException e) {
            System.out.println("Проблемы при работе с файлом!");
        }
    }

    private static ArrayList<Integer> sorter(ArrayList<Integer> mas){
        ArrayList<Integer> masOfNums = new ArrayList<>();
        ArrayList<Integer> numberOfRepetitions = new ArrayList<>();
        ArrayList<Integer> resultMas = new ArrayList<>();
        int i = 0;
        while (mas.size() != 0){
            masOfNums.add(mas.get(0));
            numberOfRepetitions.add(Collections.frequency(mas, mas.get(0)));
            while (mas.indexOf(masOfNums.get(i)) != -1)
                mas.remove(masOfNums.get(i));
            i++;
        }
        for (i = 0; i < masOfNums.size(); i++){
            for (int j = 1; j < masOfNums.size() - i; j++){
                if (numberOfRepetitions.get(j - 1) < numberOfRepetitions.get(j)){
                    int tmp = numberOfRepetitions.get(j - 1);
                    numberOfRepetitions.set(j - 1, numberOfRepetitions.get(j));
                    numberOfRepetitions.set(j, tmp);
                    tmp = masOfNums.get(j - 1);
                    masOfNums.set(j - 1, masOfNums.get(j));
                    masOfNums.set(j, tmp);
                }
            }
        }
        for (i = 0; i < masOfNums.size(); i++) {
            for (int j = 0; j < numberOfRepetitions.get(i); j++){
            resultMas.add(masOfNums.get(i));
            }
        }
        return resultMas;
    }

}
