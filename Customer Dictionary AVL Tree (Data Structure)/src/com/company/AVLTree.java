package com.company;

import java.io.*;
import java.util.Scanner;

import static java.lang.Math.max;

public class AVLTree {
    private static Node root;
    private int height(Node N)
    {
        if (N == null)
            return 0;
        return N.getHeight();
    }

    private Node rightRotate(Node y)
    {
        Node x = y.getLeft();
        Node T2 = x.getRight();
        x.setRight(y);
        y.setLeft(T2);
        y.setHeight(max(height(y.getLeft()), height(y.getRight())) + 1);
        x.setHeight(max(height(x.getLeft()), height(x.getRight())) + 1);
        return x;
    }
    private Node leftRotate(Node x)
    {
        Node y = x.getRight();
        Node T2 = y.getLeft();
        y.setLeft(x);
        x.setRight( T2);
        x.setHeight(max(height(x.getLeft()), height(x.getRight())) + 1);
        y.setHeight( max(height(y.getLeft()), height(y.getRight())) + 1);
        return y;
    }
    private int getBalance(Node N)
    {
        if (N == null)
            return 0;
        return height(N.getLeft()) - height(N.getRight());
    }
    public void insert(String word, String meaning)
    {
        root=insert(root,word,meaning);
    }

    private Node insert(Node node,String word, String meaning)
    {
        if (node == null){
            Dictionary dictionary=new Dictionary(word,meaning);
            return (new Node(dictionary));
        }
        if(word.compareTo(node.getDictionary().getWord())<0)

            node.setLeft(insert(node.getLeft(),word,meaning));
          else if(word.compareTo(node.getDictionary().getWord())>0)

            node.setRight(insert(node.getRight(),word,meaning));
        else
            return node;
        node.setHeight(1 + max(height(node.getLeft()),
                height(node.getRight())));

        int balance = getBalance(node);
        if (balance > 1 && word.compareTo(node.getLeft().getDictionary().getWord())<0)
            return rightRotate(node);

        if (balance < -1 && word.compareTo(node.getRight().getDictionary().getWord())>0)
            return leftRotate(node);
        if (balance > 1 && word.compareTo(node.getLeft().getDictionary().getWord())>0)
        {
            node.setLeft(leftRotate(node.getLeft()));
            return rightRotate(node);
        }
        if (balance < -1 && word.compareTo(node.getDictionary().getWord()) <0)
        {
            node.setRight(rightRotate(node.getRight()));
            return leftRotate(node);
        }
        return node;
    }
   private Node minValueNode(Node node)
    {
        Node current = node;
        while (current.getLeft() != null)
            current = current.getLeft();
        return current;
    }
    public void Delete(String word)
    {
       root= deleteNode(root,word);
    }
    private Node deleteNode(Node root, String word)
    {

        if (root == null)
            return root;


        if (word.compareTo(root.getDictionary().getWord())< 0) {
            root.setLeft(deleteNode(root.getLeft(), word));

        }
        else if (word.compareTo(root.getDictionary().getWord()) >0){
            root.setRight(deleteNode(root.getRight(), word));
        }
        else
        {
            System.out.println("--------------DELETED-------------");
            if ((root.getLeft() == null) || (root.getRight() == null))
            {

                Node temp = null;
                if (temp == root.getLeft())
                    temp = root.getRight();
                else
                    temp = root.getLeft();

                if (temp == null)
                {
                    temp = root;
                    root = null;
                }
                else
                    root = temp;
            }
            else
            {
                Node temp = minValueNode(root.getRight());
                root.getDictionary().setWord(temp.getDictionary().getWord());
                root.getDictionary().setMeaning(temp.getDictionary().getMeaning());
                root.setRight(deleteNode(root.getRight(), temp.getDictionary().getWord()));

            }
        }

        if (root == null)
            return root;
        root.setHeight(max(height(root.getLeft()), height(root.getRight())) + 1);
        int balance = getBalance(root);
        if (balance > 1 && getBalance(root.getLeft()) >= 0)
            return rightRotate(root);
        if (balance > 1 && getBalance(root.getLeft()) < 0)
        {
            root.setLeft( leftRotate(root.getLeft()));
            return rightRotate(root);
        }
        if (balance < -1 && getBalance(root.getRight()) <= 0)
            return leftRotate(root);
        if (balance < -1 && getBalance(root.getRight()) > 0)
        {
            root.setRight(rightRotate(root.getRight()));
            return leftRotate(root);
        }

        return root;
    }
    public void search(String keyy)
    {
        System.out.println("---------------RESULT--------------");
        search(root,keyy);
    }

    private void search(Node node,String key) {
        if (node != null) {
            if(node.getDictionary().getWord().equals(key)) {
                String WORD = String.format("%-25s", node.getDictionary().getWord());
                System.out.println("WORD:  " + WORD + " MEANING: " + node.getDictionary().getMeaning());
            }
            search(node.getLeft(),key);
            search(node.getRight(),key);

        }
    }
    public void preorder()
    {
        pre(root);
    }
    private void pre(Node node) {
        if (node != null) {
            String WORD = String.format("%-25s", node.getDictionary().getWord());
            System.out.println("WORD:  " + WORD + " MEANING: " + node.getDictionary().getMeaning());
            pre(node.getLeft());
            pre(node.getRight());

        }
    }


    public void postorder()
    {
        post(root);
    }
    private void post(Node node) {
        if (node != null) {

            post(node.getLeft());
            post(node.getRight());
            String WORD = String.format("%-25s", node.getDictionary().getWord());
            System.out.println("WORD:  " + WORD + " MEANING: " + node.getDictionary().getMeaning());
        }
    }

    public void inorder() {in(root);}
    private void in(Node node) {
        if (node != null) {

            in(node.getLeft());
            String WORD = String.format("%-25s", node.getDictionary().getWord());
            System.out.println("WORD:  " + WORD + " MEANING: " + node.getDictionary().getMeaning());
            in(node.getRight());
        }
    }

    public void read() {
       Scanner sc=null;
        try {
            File file = new File("Dictionary.txt"); // java.io.File
            sc = new Scanner(file);     // java.util.Scanner
            String word = null;
            String meaning = null;
            String str;
            AVLTree tree=new AVLTree();
            while ((sc.hasNextLine()))
            {
                int i=0;
                str=sc.nextLine();
                String[] arrOfStr = str.split(":");
                for(String st: arrOfStr)
                {
                    if(i==0){
                        word=st;i++;
                    }
                    else
                        meaning=st;
                }
                tree.insert(word,meaning);
            }

        }
        catch(FileNotFoundException e)
        {
            e.printStackTrace();
        }
        finally {
            if (sc != null) sc.close();
        }
    }


    public void start() throws IOException {
        PrintWriter pw1 = new PrintWriter("Dictionary.txt");
        pw1.close();
        writeInorder(root);
    }
    private void writeInorder(Node node) throws IOException {

        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("Dictionary.txt", true)));
        if (node != null) {
            writeInorder(node.getLeft());
            out.println(node.getDictionary().getWord()+": "+ node.getDictionary().getMeaning());
            writeInorder(node.getRight());

        }
        out.close();
    }
    private void writePreorder(Node node) throws IOException {

        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("Dictionary.txt", true)));
        if (node != null) {
            out.println(node.getDictionary().getWord()+": "+ node.getDictionary().getMeaning());
            writePostorder(node.getLeft());
            writePreorder(node.getRight());

        }
        out.close();
    }
    private void writePostorder(Node node) throws IOException {

        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("Dictionary.txt", true)));
        if (node != null) {
            writePreorder(node.getLeft());
            writePostorder(node.getRight());
            out.println(node.getDictionary().getWord()+": "+ node.getDictionary().getMeaning());

        }
        out.close();
    }

}
