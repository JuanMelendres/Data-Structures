import java.util.Scanner;
/*Class BTree*/
public class BTree<E extends Comparable<E>>{
    // here are variables available to tree
    static int order; // order of tree
    BTreeNode<E> root;  //every tree has at least a root node
    BTreeNode<E> nullNode;

    public BTree(int order){
        this.order = order;
        root = new BTreeNode(order, null);
    }

    public boolean isEmpty(){
        return this.root == this.nullNode;
    }

    public E<E> getRoot(){
        return this.root;
    }

    public BTreeNode search(BTreeNode root, int key){
        int i = 0;//we always want to start searching the 0th index of node.
        while(i < root.count && key > root.key[i]){//keep incrementing in node while key > current value
            i++;
        }
    	if(i <= root.count && key == root.key[i]){//obviously if key is in node we went to return node.
            return root;
        }
        if(root.leaf){//since we've already checked root if it is leaf we don't have anything else to check
            return null ;
        }
        else{ //else if it is not leave recurse down through ith child
            return search(root.getChild(i),key);
        }
    }

    public void split(BTreeNode x, int i, BTreeNode y){
        BTreeNode z = new BTreeNode(order,null);//gotta have extra node if we are to split.
        z.leaf = y.leaf;//set boolean to same as y
        z.count = order - 1;//this is updated size
        for(int j = 0; j < order - 1; j++){
            z.key[j] = y.key[j+order]; //copy end of y into front of z
        }
        if(!y.leaf){//if not leaf we have to reassign child nodes.
            for(int k = 0; k < order; k++){
                z.child[k] = y.child[k+order]; //reassing child of y
            }
        }
        y.count = order - 1; //new size of y
        for(int j = x.count ; j> i ; j--){//if we push key into x we have to rearrange child nodes
            x.child[j+1] = x.child[j]; //shift children of x
        }
        x.child[i+1] = z; //reassign i+1 child of x
        for(int j = x.count; j> i; j--){
            x.key[j + 1] = x.key[j]; // shift keys
        }
        x.key[i] = y.key[order-1];//finally push value up into root.
        y.key[order-1 ] = 0; //erase value where we pushed from
        for(int j = 0; j < order - 1; j++){
            y.key[j + order] = 0; //'delete' old values
        }
        x.count ++;  //increase count of keys in x
    }

    public void nonfullInsert(BTreeNode x, int key){
        int i = x.count; //i is number of keys in node x
        if(x.leaf){
            while(i >= 1 && key < x.key[i-1]){//here find spot to put key.
                x.key[i] = x.key[i-1];//shift values to make room
                i--;//decrement
            }
            x.key[i] = key;//finally assign value to node
            x.count ++; //increment count of keys in this node now.
        }
        else{
            int j = 0;
            while(j < x.count  && key > x.key[j]){//find spot to recurse on correct child
                j++;
            }
            if(x.child[j].count == order*2 - 1){
                split(x,j,x.child[j]);//call split on node x's ith child
                if(key > x.key[j]){
                    j++;
                }
            }
            nonfullInsert(x.child[j],key);//recurse
        }
    }

    public void insert(BTree t, int key){
        BTreeNode r = t.root; //this method finds the node to be inserted as it goes through this starting at root //node.
        if(r.count == 2*order - 1){ //if is full
            BTreeNode s = new BTreeNode(order,null);//new node
            t.root = s;
            s.leaf = false;
            s.count = 0;
            s.child[0] = r;
            split(s,0,r);//split root
            nonfullInsert(s, key); //call insert method
        }
        else{
            nonfullInsert(r,key);//if its not full just insert it
        }
    }

    public void print(BTreeNode n){
        for(int i = 0; i < n.count; i++){
            System.out.print(n.getValue(i)+" " );//this part prints root node
        }
        if(!n.leaf){//this is called when root is not leaf;
            for(int j = 0; j <= n.count  ; j++){//in this loop we recurse to print out tree in
                if(n.getChild(j) != null){ //preorder fashion. going from left most
                    System.out.println();	  //child to right most
                    print(n.getChild(j));     //child.
                }
            }
        }
    }

    public void SearchPrintNode(BTree T,int x){
        BTreeNode temp= new BTreeNode(order,null);
        temp= search(T.root,x);
        if (temp==null){
            System.out.println("The Key does not exist in this tree");
        }
        else{
            print(temp);
        }
    }

    public void deleteKey(BTree t, int key){
        BTreeNode temp = new BTreeNode(order,null);//temp Bnode
        temp = search(t.root,key);//call of search method on tree for key
        if(temp.leaf && temp.count > order - 1){
            int i = 0;
            while( key > temp.getValue(i)){
                i++;
            }
            for(int j = i; j < 2*order - 2; j++){
                temp.key[j] = temp.getValue(j+1);
            }
            temp.count --;
        }
        else{
            System.out.println("This node is either not a leaf or has less than order - 1 keys.");
        }
    }

    public static void main(String[] args){
        Scanner input = new Scanner( System.in );
        int n,n2,temp;
        System.out.print("Enter the t of the Tree?  ");
        n=input.nextInt();

        while ( n<2){
            System.out.print("Please enter a integer greater than 1 : ");
            n=input.nextInt();//  User inputs the order of Tree and is assinged to N.
        }
        BTree tree = new BTree(n);//  B-Tree Tree with order  N is created.

        // Initial Values are added to the Tree.. The user and Input any number of Values.
        System.out.print("\n How many values do you want to enter?:  ");
        n2 = input.nextInt();
        for ( int i=0;i< n2;i++){
            System.out.print("\nEnter Value:");
            System.out.println(i+1);
            temp=input.nextInt();
            tree.insert(tree,temp);
        }
        int choice,k;// Variables used to control the Repeated loop of the MENU.

        boolean flag;
        flag=true;
        System.out.println("MENU\n");
        System.out.println("1. Enter more values in a Tree");
        System.out.println("2. Print the whole  Tree in preorder");
        System.out.println("3. Search for a Key and print the Node it belongs to");
        System.out.println("4. Delete a key from the leaf");
        System.out.println("5. Exit");

        while (flag){// This While loop runs as long as the user enters anything other than a 5.
            System.out.print("\nPlease enter your choice::");
            choice=input.nextInt();
            if ( choice == 5){
                System.out.printf("The program is exiting...,\n"
                                  +"Thank you for using B-Tree implementation in Java\n"
                                  +" Authors: Jeremy Phelps and Krish Unnikannan");
                System.exit(0);
                flag=false;
                break;
            }

            else{
                switch(choice){
                    case 1: //If the User Enters 1 this case is executed and
                            //its function is to Enter more values in a Tree.
                        System.out.print("How many values do you want to enter?:");
                        n2=input.nextInt();
                        for ( int i=0;i< n2;i++){
                            System.out.print("\nEnter Value: ");
                            System.out.println(i+1);
                            temp=input.nextInt();
                            tree.insert(tree,temp);
                        }
                        break;
                    case 2: //If the User Enters 2 this case is executed and
                            //its function is to Print the whole  Tree in preorder format.

                        tree.print(tree.root);
                        System.out.println();
                        break;
                    case 3: //If the User Enters 3 this case is executed and
                            //its function is to Delete a key from the leaf
                        System.out.println("What is the key you wish to search for:");
                        int key2=input.nextInt();
                        tree.SearchPrintNode(tree,key2);
                        break;
                    case 4: //If User Enters 4, this case is executed
                            //Its Function is to search for a Key and print the Node it belongs to
                        System.out.println("Enter a key to be deleted:");
                        int key=input.nextInt();
                        tree.deleteKey(tree,key);
                        System.out.println("Here is the tree printed in preorder after delete");
                        tree.print(tree.root);
                        break;
                    case 5: //If the User Enters 5, this case is executed and
                            //its function is to Exit
                        System.exit(0);
                        break;
                        default: // If the User enters a wrong choice, then this case is executed.
                        System.out.println("\nPlease enter a valid choice of 1,2,3 or 4\n");
                        break;
                }
            }
        }
    }
}
