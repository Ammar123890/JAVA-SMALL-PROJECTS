package com.company;

import java.util.Scanner;

public class book {

    //************DATA MEMBERS**********

    private String Author;
    private int copiess;
    private String book;
    public static int[] space=new int[10000];
    public  static book[] books=new book[10000];


    //************GETTERS & SETTERS******

    public String getBook() {
        return book;
    }

    public void setBook(String book) {
        this.book = book;
    }

    public int getCopiess() {
        return copiess;
    }

    public void setCopiess(int copiess) {
        this.copiess = copiess;
    }

    public String getAuthor() {
        return Author;
    }

    public void setAuthor(String author) {
        Author = author;
    }

    //*************CONSTRUCTOR************

    public  book(String x, int y, String z){
        book=x;copiess=y;Author=z;
    }

    //*************METHOD*******************

    public static int space()
    {   int i;
        for(i=0;i<10000;i++)
        {
            if(space[i]==0)
            {
                break;
            }
        }return i;
    }
}
