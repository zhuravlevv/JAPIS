public class HashTable {

    private Tree tree;

    public HashTable() {
        tree = new Tree();
    }

    public void add(String element){
        tree.add(element);
    }

    public String find(String data) throws Exception{
        return tree.find(data);
    }

}
