public class Coche {
    private int id;
    private String marca;

    public Coche(int id, String marca) {
        this.id = id;
        this.marca = marca;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    @Override
    public String toString(){
        return "ID: " + this.id + "| MARCA: " + this.marca;
    }
}
