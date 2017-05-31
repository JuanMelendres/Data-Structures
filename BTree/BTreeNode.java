/*Class BTreeNode*/
public class BTreeNode<E>{
    static int t;  //variable to determine order of tree
    int count; // number of keys in node
    int key[];  // array of key values
    BTreeNode child[]; //array of references
    boolean leaf; //is node a leaf or not\
    BTreeNode parent;  //parent of current node.

    public BTreeNode(){

    }

    public BTreeNode(int t, BTreeNode parent){
        this.t = t;  //assign size
        this.parent = parent; //assign parent
        key = new int[2*t - 1];  // array of proper size
        child = new BTreeNode[2*t]; // array of refs proper size
        leaf = true; // everynode is leaf at first;
        count = 0; //until we add keys later.
    }

    public int getValue(int index){
        return key[index];
    }

    public BTreeNode getChild(int index){
        return child[index];
    }

    public BTreeNode getParent(int index){
        return child[index-1];
    }
}
