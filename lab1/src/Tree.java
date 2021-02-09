import java.util.LinkedList;
import java.util.List;

public class Tree {

    private Node root;

    public void add(String data) {
        root = add(root, data, data.hashCode());
    }

    private Node add(Node node, String data, Integer hash) {
        if (node == null) {
            node = new Node(hash, data);
            return node;
        }
        if (hash < node.hash) {
            node.left = add(node.left, data, hash);
        } else if (hash > node.hash) {
            node.right = add(node.right, data, hash);
        } else {
            throw new RuntimeException(String.format("Element with hash %d already exist", hash));
        }
        return node;
    }

    public String find(String data) throws Exception{
        return find(root, data, data.hashCode(), 0);
    }

    private String find(Node node, String data, Integer hash, Integer count) throws Exception {
        if (node == null) {
            return "";
        }
        if (node.hash.equals(hash)) {
            System.out.println("Число выполненных сравнений при поиске = " + count);
            String dataToReturn =  node.takeData(data);
            if(dataToReturn == null){
                throw new Exception("Couldn't find " + data);
            }
            return dataToReturn;

        } else if (hash < node.hash) {
            return find(node.left, data, hash, count + 1);
        } else {
            return find(node.right, data, hash, count + 1);
        }
    }

    private class Node {
        Integer hash;
        List<String> listOfData;
        Node left;
        Node right;

        public Node(Integer hash, String data) {
            this.listOfData = new LinkedList<>();
            this.hash = hash;
            this.listOfData.add(data);
        }

        public String takeData(String dataToFind) {
            for (String data :
                    listOfData) {
                if(data.equals(dataToFind))
                    return data;
            }
            return null;
        }
    }
}
