/**
 * Created by denis__larin on 06.05.17.
 */
public class Main {
    public static void main(String[] args) {
        int val;
        TwoThreeTree twoThreeTree = new TwoThreeTree();
        twoThreeTree.insert(50);
        twoThreeTree.insert(60);
        twoThreeTree.insert(70);
        twoThreeTree.insert(40);
        twoThreeTree.insert(30);
        twoThreeTree.insert(20);

        twoThreeTree.printTree();
    }
}
