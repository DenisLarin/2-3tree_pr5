/**
 * Created by denis__larin on 06.05.17.
 */
/*элементы данных, которые хранятся внутри узла
* будет хранить только int элемент, для упрощения*/
public class DataItem {
    private int data;

    public DataItem(int dData) {
        this.data = dData;
    }
    public void printItem(){
        System.out.print("|" + data);
    }

    public int getdData() {
        return data;
    }
}
