public class Tree {

    private Node root;

    public void add(String data){
        root = add(root, data, data.hashCode());
    }

    private Node add(Node node, String data, Integer hash){
        if(node == null){
            node = new Node(hash, data);
            return node;
        }
        if(hash < node.hash){
            node.left = add(node.left, data, hash);
        }
        else if(hash > node.hash){
            node.right = add(node.right, data, hash);
        }
        else{
            throw new RuntimeException(String.format("Element with hash %d already exist", hash));
        }
        return node;
    }

    public String find(Integer hash) {
        return find(root, hash, 0);
    }

    private String find(Node node, Integer hash, Integer count) {
        if(node == null) {
            return "";
        }
        if(node.hash.equals(hash)) {
            System.out.println("Число выполненных сравнений при поиске = " + count);
            return node.data;
        }
        else if(hash < node.hash){
            return find(node.left, hash, count + 1);
        }
        else{
            return find(node.right, hash, count + 1);
        }
    }

    private class Node {
        Integer hash;
        String data;
        Node left;
        Node right;

        public Node(Integer hash, String data) {
            this.hash = hash;
            this.data = data;
        }
    }
}
