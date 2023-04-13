package DoughnutFactory;

public class DoughnutStack {
    Doughnut DoughnutType;
    int quantity;

    int getQuantity(){
        return this.quantity;
    }

    void setQuantity(int quantity){
        this.quantity = quantity;
    }

    Doughnut getType(){
        return DoughnutType;
    }

    void setType(Doughnut type) {
        this.DoughnutType = type;
    }
}
