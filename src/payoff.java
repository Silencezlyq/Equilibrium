public class payoff {
    int payoffForOne=0;
    int payoffForTwo=0;

    public payoff(int one, int two) {
        this.payoffForOne = one;
        this.payoffForTwo = two;
    }

    public payoff() {
        this.payoffForOne = 0;
        this.payoffForTwo = 0;
    }

    public void setPayoffForOne(int payoffForOne) {
        this.payoffForOne = payoffForOne;
    }

    public void setPayoffForTwo(int payoffForTwo) {
        this.payoffForTwo = payoffForTwo;
    }

    public int getPayoffForOne(){
        return this.payoffForOne;
    }

    public int getPayoffForTwo(){
        return this.payoffForTwo;
    }

    public int getSum(){
        return this.payoffForOne+this.payoffForTwo;
    }

    public void print(){
        System.out.println("("+this.payoffForOne+","+this.payoffForTwo+")");
    }
}
