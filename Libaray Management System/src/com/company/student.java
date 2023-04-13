package com.company;

import java.util.Scanner;

public class student {
    //***********DATA MEMBERS*************

    private String rollNumber;
    private String name;


    //*********** GETTERS***********

    public String getRollNumber() {
        return rollNumber;
    }

    public String getName() {
        return name;
    }

    //**************CONSTRUCTORS******************

    public student(String name, String rollNumber){
        this.name=name;this.rollNumber=rollNumber;
    }

    public student(){}
    //*****************************
    //**********METHODS************
    //*****************************

    //This Method is used to locate the student in the student array
    public static int[] space1 =new int[10000];
    public static int space1()
    {   int i;
        for(i=0;i<10000;i++)
        {
            if(space1[i]==0)
            {
                break;
            }
        }return i;
    }
    Scanner sc =new Scanner(System.in);

    //This method is used to search book
    public void searchBook(){
        System.out.println("Enter the book which you want to study: ");

        String check;
        check=sc.next();
        int i;
        for( i=0;i<book.space.length;i++) {
            if (book.books[i] == null) {
            } else {
                if (book.books[i].getBook().equals(check)) {
                    System.out.println(check + " is available at library\nCurrently " +book.books[i].getCopiess() + " copies available");
                    break;
                }
            }
        }
        if(i== book.space.length){
            System.out.println("The book is not here ");
        }
    }

    //This method is used to borrow a book
    public void borrow() throws InterruptedException {
        System.out.println("Enter the name of book: ");
        String check;
        check=sc.next();

        int i;
        for( i=0;i<book.space.length;i++) {
            if(book.books[i]!=null){
                if (book.books[i].getBook().equals(check)&&book.books[i].getCopiess()==0)
                {
                    System.out.println(check + " is available at library\n but currently no copies available");
                    break;
                }
                else if(book.books[i].getBook().equals(check)&&book.books[i].getCopiess()!=0)
                {
                    // ***** MAKING OBJECT OF ADMIN CLASS  ******
                    admin obj=new admin();
                    System.out.println("ONLY ADMIN CAN ISSUE YOU A BOOK ");
                    System.out.println("Enter the admin pass");
                    if(sc.next().equals(obj.getPassword()))
                    {
                        obj.issue();
                    }
                    else System.out.println("Wrong pass");
                    break;
                }
            }
        }
        if(i== book.space.length){
            System.out.println("The book is not here ");
        }


    }

    //This method is used to Return book
    public void Return() throws InterruptedException {
        System.out.println("GO to Admin Manager to Return book  ");
        System.out.println("Enter the pass for admin : ");
        admin obj_A=new admin();
        if(sc.next().equals(obj_A.getPassword()))
        {
            obj_A.receive();
        }
        else System.out.println("Wrong pass");
    }

    //This method is used to Read book
    public void read() throws InterruptedException {
        System.out.println("Enter the name of book: ");
        String check;
        check=sc.next();

        int i;
        for( i=0;i<book.space.length;i++) {
            if(book.books[i]!=null){
                if (book.books[i].getBook().equals(check)&&book.books[i].getCopiess()==0)
                {
                    System.out.println(check + " is available at library\n but currently no copies available");
                    Thread.sleep(1400);
                    break;
                }
                else if(book.books[i].getBook().equals(check)&&book.books[i].getCopiess()!=0)
                {
                    System.out.println("Yes, book is available \nYou can Read the book");
                    System.out.println("The books is in Slot "+i);
                    Thread.sleep(1400);
                    break;
                }
            }
        }
        if(i== book.space.length){
            System.out.println("The book is not here ");
            Thread.sleep(1400);
        }

    }

}




