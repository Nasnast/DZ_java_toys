
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ListOfToys {

    private List<String> prizeToys = new ArrayList<>();
    private String file = "toys.txt";

    public void calculationWeight(List<Toys> toys) { // вероятность выпадания игрушки в зависимости от общего
                                                     // количества
        double sumQuantity = 0;
        for (Toys toy : toys) {
            sumQuantity += toy.getQuantity();
        }
        for (Toys toy : toys) {
            toy.setWeight(toy.getQuantity() * 100 / sumQuantity);
        }
    }

    public void lotteryToys(List<Toys> toys) {
        if (!toys.isEmpty()) {
            int random = new Random().nextInt(maxId(toys)) + 1; // случайное число от 1 до maxID (maxID изменяется)
            System.out.println(random);
            boolean flag = index(toys, random);
            if (flag == false) {
                System.out.println("Увы, вам не повезло :(");

            } else {
                prizeToy(toys, random); // лпределение приза и запись в файл
            }
        } else
            System.out.println("Игрушек больше нет!");
    }

    private void prizeToy(List<Toys> toys, int random) {
        for (Toys toy : toys) {
            if (toy.getID() == random) {
                System.out.println("Ваш выигрыш: " + toy.getNameToy());
                prizeToys.add(toy.getNameToy());
                saveToysFile(toy);
                if (toy.getQuantity() == 1) {
                    toys.remove(toy);
                } else {
                    toy.setQuantity(toy.getQuantity() - 1);
                }
                calculationWeight(toys);
                break;
            }
        }
    }

    private boolean index(List<Toys> toys, int random) {
        List<Integer> index = new ArrayList<>();
        for (Toys toy : toys) {
            index.add(toy.getID());
        }
        boolean isExists = index.contains(random); // true
        return isExists;
    }

    public int maxId(List<Toys> toys) {
        int maxId = 0;
        for (Toys toy : toys) {
            if (maxId < toy.getID()) {
                maxId = toy.getID();
            }
        }
        return maxId;
    }

    private void saveToysFile(Toys toy) { // запись выигрыша в файл
        try (FileWriter writer = new FileWriter(file, true)) {
            writer.write(toy.getNameToy());
            writer.append('\n');
            writer.flush();
            writer.close();
        } catch (IOException ex) {

            System.out.println(ex.getMessage());
        }
    }

    public void getPrizeToys() { // выдача призов
        System.out.println("Список игрушек к выдаче: " + "\n" + prizeToys);
        while (!prizeToys.isEmpty()) {
            System.out.println("Выдано: " + prizeToys.remove(0));
        }
        System.out.println("Все игрушки выданы!");
    }
}