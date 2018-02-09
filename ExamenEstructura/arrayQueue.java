import java.util.*;
/*  Class arrayQueue  */
public class arrayQueue{

    protected int Queue[] ;
    protected int front, rear, size, len;
    /* Constructor */
    public arrayQueue(int n){
        this.size = n;
        this.len = 0;
        Queue = new int[this.size];
        this.front = -1;
        this.rear = -1;
    }

    /*  Function to check if queue is empty */

    public boolean isEmpty(){
        return this.front == -1;
    }

    /*  Function to check if queue is full */

    public boolean isFull(){
        return this.front==0 && this.rear == this.size -1 ;
    }

    /*  Function to get the size of the queue */

    public int getSize(){
        return this.len ;
    }

    /*  Function to check the front element of the queue */

    public int peek(){
        if (isEmpty()){
           throw new NoSuchElementException("Underflow Exception");
       }
        return Queue[this.front];
    }

    /*  Function to insert an element to the queue */

    public void insert(int i){
        if (this.rear == -1){
            this.front = 0;
            this.rear = 0;
            Queue[this.rear] = i;
        }
        else if (this.rear + 1 >= this.size){
            throw new IndexOutOfBoundsException("Overflow Exception");
        }
        else if (this.rear + 1 < this.size){
            Queue[++this.rear] = i;
        }
        this.len++ ;
    }

    /*  Function to remove front element from the queue */

    public int remove(){
        if (isEmpty()){
           throw new NoSuchElementException("Underflow Exception");
       }
        else{
            this.len-- ;
            int ele = Queue[this.front];
            if (this.front == this.rear){
                this.front = -1;
                this.rear = -1;
            }
            else{
                this.front++;
            }
            return ele;
        }
    }

    /*  Function to display the status of the queue */

    public void display(){
        System.out.print("\nQueue = ");
        if (this.len == 0){
            System.out.print("Empty\n");
            return ;
        }
        for (int i = this.front; i <= this.rear; i++){
            System.out.print(Queue[i]+" ");
        }
        System.out.println();
    }
//}

/* Class QueueImplement  */

//public class QueueImplement{

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        System.out.println("Array Queue Test\n");
        System.out.println("Enter Size of Integer Queue ");
        int n = scan.nextInt();
        /* creating object of class arrayQueue */
        arrayQueue q = new arrayQueue(n);
        /* Perform Queue Operations */
        char ch;
        do{
            System.out.println("\nQueue Operations");
            System.out.println("1. insert");
            System.out.println("2. remove");
            System.out.println("3. peek");
            System.out.println("4. check empty");
            System.out.println("5. check full");
            System.out.println("6. size");
            int choice = scan.nextInt();
            switch (choice){
            case 1 :
                System.out.println("Enter integer element to insert");
                try{
                    q.insert( scan.nextInt() );
                }
                catch(Exception e){
                    System.out.println("Error : " +e.getMessage());
                }
                break;
            case 2 :
                try{
                    System.out.println("Removed Element = "+q.remove());
                }
                catch(Exception e){
                    System.out.println("Error : " +e.getMessage());
                }
                break;
            case 3 :
                try{
                    System.out.println("Peek Element = "+q.peek());
                }
                catch(Exception e){
                    System.out.println("Error : "+e.getMessage());
                }
                break;
            case 4 :
                System.out.println("Empty status = "+q.isEmpty());
                break;
            case 5 :
                System.out.println("Full status = "+q.isFull());
                break;
            case 6 :
                System.out.println("Size = "+ q.getSize());
                break;
            default : System.out.println("Wrong Entry \n ");
                break;
            }
            /* display Queue */
            q.display();
            System.out.println("\nDo you want to continue (Type y or n) \n");
            ch = scan.next().charAt(0);
        }
        while (ch == 'Y'|| ch == 'y');
    }
}
