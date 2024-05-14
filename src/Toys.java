public class Toys {
    private int id;
    private String nameToy;
    private int quantity;
    private double weight;

    public Toys(String nameToy) {
        this.nameToy = nameToy;
    }

    public Toys(int id, String nameToy, int quantity, double weight) {
        this.id = id;
        this.nameToy = nameToy;
        this.quantity = quantity;
        this.weight = weight;
    }

    public int getID() {
        return id;
    }

    public String getNameToy() {
        return nameToy;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getWeight() {
        return weight;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "ID: " + id + " " + '"' + nameToy + '"' + " штуки: " + quantity + " вероятность выпадания в % - "
                + weight + " %";
    }

}
