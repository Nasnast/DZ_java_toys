
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        ListOfToys listOfToys = new ListOfToys();
        List<Toys> listToys = new ArrayList<>();

        Toys t1 = new Toys(1, "Кукла", 3, 1);
        Toys t2 = new Toys(2, "Мяч", 2, 1);
        Toys t3 = new Toys(3, "Мишка", 1, 1);
        Toys t4 = new Toys(4, "Юла", 3, 1);
        Toys t5 = new Toys(5, "Киндер-сюрприз", 1, 1);

        listToys.add(t1);
        listToys.add(t2);
        listToys.add(t3);
        listToys.add(t4);
        listToys.add(t5);
        printList(listToys);

        listOfToys.calculationWeight(listToys); // перерасчет веса игрушки в лотерее (зависит от количества игрушек)
        printList(listToys);

        listOfToys.lotteryToys(listToys); // розыгрыш
        listOfToys.lotteryToys(listToys);
        listOfToys.lotteryToys(listToys);
        listOfToys.lotteryToys(listToys);
        listOfToys.lotteryToys(listToys);

        System.out.println("\n" + "Оставшиеся игрушки:");
        printList(listToys);

        listOfToys.getPrizeToys(); // выдача игрушек

    }

    private static void printList(List<Toys> listToys) {
        for (Toys toy : listToys) {
            System.out.println(toy);
        }
        System.out.println();
    }
}