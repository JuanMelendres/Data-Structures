import java.math.*;

/* Class LinkedHashEntry */
class HashEntry{

    String key;
    int value;

    /* Constructor */
    public HashEntry(String key, int value){
        this.key = key;
        this.value = value;
    }

}

/* Class HashTable */
public class HashTable{

    private int TableSize;
    private int size;
    private HashEntry[] table;
    private int primeSize;

     /* Constructor */
    public HashTable(int ts){
        this.size = 0;
        this.TableSize = ts;
        this.table = new HashEntry[this.TableSize];
        for (int i = 0; i < this.TableSize; i++){
            this.table[i] = null;
        }
        this.primeSize = getPrime();
    }

    /* Funcion para obtener el primo */
    public int getPrime(){
        for (int i = this.TableSize - 1; i >= 1; i--){
            int fact = 0;
            for (int j = 2; j <= (int) Math.sqrt(i); j++){
                if (i % j == 0){
                    fact++;
                }
            }
            if (fact == 0){
                return i;
            }
        }
        /* rergresa el primo */
        return 3;
    }

    /* Funcion para saber el tamaño de la hash*/
    public int getSize(){
        return this.size;
    }

    /* Function para saber si la hash esta vacia */
    public boolean isEmpty(){
        return this.size == 0;
    }

    /* Funcion que nos da una hash table vacia */
    public void makeEmpty(){
        this.size = 0;
        for (int i = 0; i < TableSize; i++){
            this.table[i] = null;
        }
    }

    /* Funcion para obtener por medio de la key el valor */
    public String get(String key){
        int hash1 = tHash1(key);
        int hash2 = tHash2(key);
        while (this.table[hash1] != null && !this.table[hash1].key.equals(key)){
            hash1 += hash2;
            hash1 %= this.TableSize;
        }
        return table[hash1].value + " ";
    }

    /* Funcion para insertar una key y un valor */
    public void insert(String key, int value){
        if (this.size == this.TableSize){
            System.out.println("Table full");
            return;
        }
        int hash1 = tHash1(key);
        int hash2 = tHash2(key);
        while (this.table[hash1] != null){
            hash1 += hash2;
            hash1 %= this.TableSize;
        }
        this.table[hash1] = new HashEntry(key, value);
        this.size++;
    }

    /* Funcion Hash1 que nos regresa el valor de la hash */
    private int tHash1(String x){
        int hashVal = x.hashCode();
        hashVal %= this.TableSize;
        if (hashVal < 0){
            hashVal += this.TableSize;
        }
        return hashVal;
    }

    /* Funcion Hash2 para hacer el double hashing */
    private int tHash2(String x){
        int hashVal = x.hashCode();
        hashVal %= this.TableSize;
        if (hashVal < 0){
            hashVal += this.TableSize;
        }
        return this.primeSize - hashVal % this.primeSize;
    }

    /* Funcion para remover el key */
    public void remove(String key){
        int hash1 = tHash1(key);
        int hash2 = tHash2(key);
        while (this.table[hash1] != null && !this.table[hash1].key.equals(key)){
            hash1 += hash2;
            hash1 %= this.TableSize;
        }
        this.table[hash1] = null;
        this.size--;
    }

    /* Funcion para imprimir hash table */
    public void printHashTable(){
        System.out.println("\nHash Table");
        for (int i = 0; i < this.TableSize; i++){
            if (this.table[i] != null){
                System.out.println(this.table[i].key +" "+this.table[i].value);
            }
        }
    }

}
