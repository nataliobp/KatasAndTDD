package main.java.com.natalio.triescontacts;

import java.util.HashMap;
import java.util.Map;

public class Contacts {
    private Node root = null;
    private int size = 0;

    class Node{
        Map<Character, Node> data = new HashMap<>();
        String word;
        int numWords = 0;
    }

    public int size() {
        return size;
    }

    public void add(String aName) {
        root = add(aName, 0, root);
    }

    private Node add(String aName, int pos, Node aNode){
        if(aNode == null){
            aNode = new Node();
        }

        if(pos == aName.length()){
            if(aNode.word == null){
                aNode.word = aName;
                aNode.numWords++;
                size++;
            }

            return aNode;
        }

        char aChar = aName.charAt(pos);

        if(!aNode.data.containsKey(aChar)){
            aNode.data.put(aChar, new Node());
        }

        aNode.numWords++;
        add(aName, pos+1, aNode.data.get(aChar));

        return aNode;
    }

    public int countPartials(String aPartial){
        Node aNode = get(aPartial, 0, root);

        if(aNode == null){
            return 0;
        }


        return aNode.numWords;
    }

    public boolean contains(String aName){
        Node aNode = get(aName, 0, root);

        return aNode != null && aNode.word != null;
    }

    private Node get(String aName, int pos, Node aNode) {
        if(pos == aName.length()){
            return aNode;
        }

        char aChar = aName.charAt(pos);

        if(aNode == null || !aNode.data.containsKey(aChar)){
            return null;
        }

        return get(aName, pos+1, aNode.data.get(aChar));
    }
}
