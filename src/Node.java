

/**
 * Created by denis__larin on 06.05.17.
 */
public class Node {
    private final int NUMBER = 3;
    private int numItem;//количество элементов в текущем узле
    private Node parent;//ссылка на родителя
    private Node[] childArray = new Node[NUMBER];//массив из детей
    private DataItem[] itemArray = new DataItem[NUMBER - 1];//массив из элементов внутри одного node

    //связывание узла с потомком
    public void connectChild(int childNum, Node child) {
        childArray[childNum] = child;
        if (child != null)
            child.parent = this;
    }

    //отсоединиение потомка от узла
    public Node disconnectChild(int childNum) {
        Node temp = childArray[childNum];
        childArray[childNum] = null;
        return temp;
    }

    //возвращение родителя
    public Node getParent() {
        return parent;
    }
    //возвращение потомка
    public Node getChild(int childNum){
        return childArray[childNum];
    }
    //проверка на лист или нет
    public boolean isLeaf(){
        return childArray[0] == null;
    }
    //количество элементов в узле
    public int getNumItem() {
        return numItem;
    }
    //получение данных по индексу, которые находятся в одном узле
    public DataItem getItem(int index){
        return itemArray[index];
    }
    //проверка на заполненность узла
    public boolean isFull(){
        return numItem == NUMBER-1;
    }
    //определение индекса элемента внутри узла
     public int findItem(int key){
         for (int i = 0; i <NUMBER-1; i++) {
             if(itemArray[i] == null)
                 break;
             else if(itemArray[i].getdData() == key){
                 return i;
             }
         }
         return -1;
     }
     //добавление элемента в узел. так как там хранится всего два элемента, проверяем их ключи и меняем если надо
    //возвращаем индекс нового элемента или 0
    public int insertItem(DataItem newItem){
        numItem++;
        int newKey = newItem.getdData();
            for (int i = NUMBER-2; i >= 0; i--) {
                if (itemArray[i] == null)
                    continue;
                else {
                    int curKey = itemArray[i].getdData();
                    if (newKey < curKey) {
                        itemArray[i + 1] = itemArray[i];
                        itemArray[i] = newItem;
                        return i;
                    }
                    else{
                        itemArray[i+1] = newItem;
                        return i+1;
                    }
                }
            }
        itemArray[0] = newItem;
        return 0;
    }
    //удаление наибольшего элемента из узла
    public DataItem delLastItem(){
        DataItem temp = itemArray[numItem-1];
        itemArray[numItem-1] = null;
        numItem--;
        return temp;
    }
    //вывод содержимого узла
    public void printNode(){
        for (int i = 0; i < numItem; i++) {
            itemArray[i].printItem();
        }
        System.out.println("|");
    }
}