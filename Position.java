/**
 * Class Position. A quick helper to track both the index of a position in an array and the value at the same position
 * Created by KayLee on 07/11/2018.
 */
public class Position{
    int index;
    int value;

    Position(int index, int value){
        this.index = index;
        this.value = value;
    }

    public String toString(){
        return "(" + this.index + ", " + this.value + ")";
    }
}
