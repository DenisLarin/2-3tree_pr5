/**
 * Created by denis__larin on 06.05.17.
 */
public class TwoThreeTree {
    private Node root;

    public TwoThreeTree() {
        this.root = new Node();
    }
    public int find(int key){
        Node curNode = root;
        int childNumber;
        while (true){
            if((childNumber = curNode.findItem(key)) != -1)
                return childNumber;// индекс потомка
            else if (curNode.isLeaf())
                return -1;//нет потомков -- лист
            else
                curNode = getNextChild(curNode,key);
        }
    }
    public void insert(int key){
        Node curNode = root;
        DataItem dataItem = new DataItem(key);
        while (true){
            //если внутри узла уже все заполнено
            if(curNode.isFull()){
                split(curNode);
                curNode = curNode.getParent();
                curNode = getNextChild(curNode,key);
            }
            else if(curNode.isLeaf())
                break;
            else
                curNode = getNextChild(curNode,key);
        }
        curNode.insertItem(dataItem);
    }
    //разбиение узла
    public void split(Node splitNode){
        DataItem item;
        Node parent, child2;
        int itemIndex;
        item = splitNode.delLastItem();
        child2 = splitNode.disconnectChild(2);
        Node newNode = new Node();

        if(splitNode == root){
            root = new Node();
            parent = root;
            root.connectChild(0,splitNode);
        }
        else
            parent = splitNode.getParent();

        itemIndex = parent.insertItem(item);
        int n = parent.getNumItem();
        for(int i = n-1; i>itemIndex;i--){
            Node temp = parent.disconnectChild(i);
            parent.connectChild(i+1,temp);
        }
        parent.connectChild(itemIndex+1,newNode);
        newNode.connectChild(0,child2);
    }

    private Node getNextChild(Node curNode, int key) {
        int i;
        int numItem = curNode.getNumItem();
        for (i = 0; i < numItem; i++){
            if(key<curNode.getItem(i).getdData())
                return curNode.getChild(i);
        }
        return curNode.getChild(i);
    }

    public void printTree(){
        recDisplayTree(root,0,0);
    }

    private void recDisplayTree(Node printNode, int level, int childNumber) {
        System.out.print("      level = " + level + " child = " + childNumber + " adress_print = " + printNode + " adress_parent = " + printNode.getParent() + "        ");
        printNode.printNode();
        int numItems = printNode.getNumItem();
        for (int i = 0; i<numItems+1;i++){
            Node next = printNode.getChild(i);
            if(next!=null)
                recDisplayTree(next,level+1,i);
            else
                return;
        }
    }
}
/*
    //разбиение узла
    public void split(Node splitNode){
        DataItem item;
        Node parent, child2;
        int itemIndex;
        item = splitNode.delLastItem();
        child2 = splitNode.disconnectChild(2);
        Node newNode = new Node();

        if(splitNode == root){
            root = new Node();
            parent = root;
            root.connectChild(0,splitNode);
        }
        else
            parent = splitNode.getParent();

        itemIndex = parent.insertItem(item);
        int n = parent.getNumItem();
        for(int i = n-1; i>itemIndex;i--){
            Node temp = parent.disconnectChild(i);
            parent.connectChild(i+1,temp);
        }
        parent.connectChild(itemIndex+1,newNode);
        newNode.connectChild(0,child2);

    }*/

