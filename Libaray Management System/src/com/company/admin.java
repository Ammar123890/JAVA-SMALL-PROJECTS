package com.company;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import  java.util.Date;
public class admin {

    //**********DATA MEMBERS**************

    private static String password="admin";
    private int[] IssueDate=new int[10000];
    private int[] IssueMonth=new int[10000];
    private int[] IssueYear=new int[10000];
    private static  int[] ReturnDate=new int[10000];
    private static  int[] ReturnMonth=new int[10000];
    private static  int[] ReturnYear=new int[10000];
    private static  int[] activities=new int[10000];

    //**********MAKING CLASS TYPE ARRAYS**********

    public static student[] students=new student[10000];


    // *********GETTERS & SETTERS*********

    public String getPassword()
    {
        return password;
    }
    public void setPassword(String password) { this.password = password; }

    //**********METHODS*******************

    Scanner sc=new Scanner(System.in);

    //This method is used to add new books
    public void addbook() throws InterruptedException {
        System.out.println("Enter the name of the book : ");
        String x= sc.next();
        System.out.println("Enter how many copies of the book has to be entered: ");
        int y=sc.nextInt();
        System.out.println("Enter the author of the book : ");
        String z=sc.next();
        book.books[book.space()]=new book(x,y,z);
        book.space[book.space()]=1; //to allocate specific location to book
        System.out.println("Book added successfully");
        Thread.sleep(1500);

    }
    //This method is used to change the pass
    public void changePass() throws InterruptedException {
        System.out.println("Enter the new password : ");
        setPassword(sc.next());
        System.out.println("Your pass has been changed successfully : ");
        Thread.sleep(1500);
    }
    //This method is used to change the record
    public void bookRecord() throws InterruptedException {
        System.out.println("About which book do you want to change its record : ");
        String check1= sc.next();
        int i;
        for( i=0;i<book.space.length;i++) {
            if (book.books[i] == null) {
            } else {
                if (book.books[i].getBook().equals(check1)) {
                    int check;
                    do {
                        System.out.println("Press 1: Change name\nPress 2: Change no of copies\nPress 3: Change author\nPress 4: To exit after change");
                        check = sc.nextInt();
                        switch (check) {
                            case 1: {
                                System.out.println("Write new name of book: ");
                                book.books[i].setBook(sc.next());
                                System.out.println("Name Changed successfully");
                                break;
                            }
                            case 2: {
                                System.out.println("Write new no of copies: ");
                                book.books[i].setCopiess(sc.nextInt());
                                System.out.println("Copies change successfully");
                                break;
                            }
                            case 3: {
                                System.out.println("Write new author name: ");
                                book.books[i].setAuthor(sc.next());
                                System.out.println("Author change successfully");
                                break;

                            }

                            case 4:
                            {
                                System.out.println("******Admin Menu*********");
                                break;
                            }
                            default:
                            { System.out.println("Invalid input");
                                break;}
                        }

                    } while (check != 4);
                    break;
                }

            }
        }
        if(i== book.books.length)
        {
            System.out.println("BOOK NOT FOUND");
        }
        Thread.sleep(1500);
    }
    //This method is used to delete books
    public void delete() throws InterruptedException {
        int i;
        System.out.println("Which book do you want to delete: ");
        String check=sc.next();
        for(i=0;i<book.space.length;i++)
        {
            if(book.books[i]!=null){
                if(book.books[i].getBook().equals(check))
                {
                    book.books[i].setBook(null);
                    book. books[i].setAuthor(null);
                    book.books[i].setCopiess(0);
                    book.space[i]=0; // free the space
                    book.books[i]=null;
                    System.out.println("Book deleted successfully ");
                    break;
                }
            }
        }
        if(i==book.books.length)
        {
            System.out.println("Books not found ");
        }
        Thread.sleep(1500);
    }

    public void availableBooks() throws InterruptedException {
        int i;
        for (i=0;i<(book.books.length);i++)
        {

            if(book.books[i]!=(null))
                System.out.println(book.books[i].getBook()+" is available at library and currently have "+book.books[i].getCopiess()+" copies and written by "+book.books[i].getAuthor());

        }
        Thread.sleep(1500);
    }


    //This method is used to issue book
    public void issue() throws InterruptedException {
        String x;String y;
        System.out.println("Enter Student Name: ");
        x= sc.next();
        System.out.println("Enter Roll number: ");
        y=sc.next();
        students[student.space1()]=new student(x,y);
        System.out.println("Enter the name of the book");
        String check=sc.next();
        int i;
        for( i=0;i<book.space.length;i++) {
            if (book.books[i] != null) {
                // to search book
                if (book.books[i].getBook().equals(check) && book.books[i].getCopiess() == 0) {
                    System.out.println(check + " is available at library\n but currently no copies available");
                    break;
                }
                else if (book.books[i].getBook().equals(check) &&book. books[i].getCopiess() != 0) {
                    book. books[i].setCopiess(book.books[i].getCopiess() - 1);
                    int count;
                    //*****************************************************
                    // *****   TO enter Issue date the right way     ******
                    //*****************************************************
                    int date;
                    do{
                        count=0;
                        System.out.println("Enter issue date  (in DD or D Format) :");
                        date = sc.nextInt();
                        int dateCheck=date;
                        while (dateCheck != 0) {
                            dateCheck /= 10;
                            ++count;
                        }
                        if (count <= 2&&date<32)
                            //To enter the record against specific student
                            IssueDate[student.space1()] = date;
                        else
                            System.out.println("Please enter correct format");

                    }while (count>2||date>31);


                    int month;
                    do{
                        count=0;
                        System.out.println("Enter issue month (in MM or Mr Format) : ");
                        month=sc.nextInt();
                        int monthCheck=month;
                        while (monthCheck != 0) {

                            monthCheck /= 10;
                            ++count;
                        }
                        if (count<=2&&month<13)
                            IssueMonth[student.space1()]=month;
                        else
                            System.out.println("Please enter correct format");
                    }while (count>2||month>12);

                    do {
                        count=0;
                        System.out.println("Enter issue year (in YYYY Format) : ");
                        int year = sc.nextInt();
                        int yearCheck=year;
                        while (yearCheck != 0) {

                            yearCheck /= 10;
                            ++count;
                        }
                        if (count == 4)
                            IssueYear[student.space1()] = year;
                        else
                            System.out.println("Please enter correct format");

                    }while (count!=4);
                    System.out.println("For how many days?? so\nGive the given date for return");
                    System.out.println("After the given Return time, Student will be fined Rs 100 on Returning");
                    //*************************************************
                    //********TO ENTER THE CORRECT RETURN DATE*********
                    //*************************************************

                    int R_date;
                    do{
                        count=0;
                        System.out.println("Enter Return date  (in DD or D Format) :");
                        R_date = sc.nextInt();
                        int dateCheck=R_date;
                        while (dateCheck != 0) {

                            dateCheck /= 10;
                            ++count;
                        }
                        if (count <= 2&&R_date<31)
                            ReturnDate[student.space1()] = R_date;
                        else
                            System.out.println("Please enter correct format");
                    }while (count>2||R_date>31);


                    int R_month;
                    do{
                        count=0;
                        System.out.println("What will be Return month (in MM or M Format) : ");
                        R_month=sc.nextInt();
                        int monthCheck=R_month;
                        while (monthCheck != 0) {

                            monthCheck /= 10;
                            ++count;
                        }
                        if (count<=2&&R_month<13)
                            ReturnMonth[student.space1()]=R_month;
                        else
                            System.out.println("Please enter correct format");

                    }while (count>2||R_month>12);

                    do {
                        count=0;
                        System.out.println("What will be Return year (in YYYY Format) : ");
                        int year = sc.nextInt();
                        int yearCheck=year;
                        while (yearCheck != 0) {

                            yearCheck /= 10;
                            ++count;
                        }
                        if (count == 4)
                            ReturnYear[student.space1()] = year;
                        else
                            System.out.println("Please enter correct format");

                    }while (count!=4);

                    // to store book info which is issued
                    activities[student.space1()]=i;
                    System.out.println("BOOK ISSUED SUCCESSFULLY ");
                    student.space1[student.space1()]=1;
                    break;

                }

            }
        }

        if(i==book.books.length ){
            System.out.println("No such book!");
        }
        Thread.sleep(1500);
    }


    //This method is used to Print the Issued books
    public void issueRecord() throws InterruptedException {
        int i;
        for (i=0;i<(students.length);i++)
        {
            if(students[i]!=null) {

                System.out.println("Student : "+students[i].getName() +" Roll number: "+students[i].getRollNumber()+ " Borrowed " + book.books[activities[i]].getBook() + " Book");

            }
        }if(i== students.length)
            System.out.println("End of Record");
        Thread.sleep(1000);
    }


    //This method is used to receive book from student
    public void receive() throws InterruptedException {

        System.out.println("Enter Student's Roll no :");
        String RN= sc.next();
        System.out.println("Enter which book you want to enter : ");
        String Book=sc.next();
        int i;
        for(i=0;i<admin.students.length;i++)
        {   if(admin.students[i]!=null){
            if(RN.equals(students[i].getRollNumber())&&Book.equals(book.books[activities[i]].getBook())){

                book.books[activities[i]].setCopiess(book.books[activities[i]].getCopiess()+1);
                Date date=new Date();
                date.setDate(ReturnDate[i]);
                date.setMonth(ReturnMonth[i]);
                date.setYear(ReturnYear[i]);
                System.out.println("Enter the current date of returning (just in DD or D only): ");
                Date date1=new Date();
                date1.setDate(sc.nextInt());
                System.out.println("Enter the current month of returning (just in MM or M only: ");
                date1.setMonth(sc.nextInt());
                System.out.println("Enter the current year of returning: (Just in YYYY or YY only ");
                date1.setYear(sc.nextInt());
                //this help to compare the dates by equaling the format
                SimpleDateFormat dateForm= new SimpleDateFormat("dd,MM,yy");
                if(dateForm.format(date1).compareTo(dateForm.format(date))>0)
                    System.out.println("Returned successfully & STUDENT HAS BEEN FINED RS 100 ");
                else
                    System.out.println("Return Successfully with no fine");
                break;
            }
        }
        }
        if(admin.students.length==i)
        {
            System.out.println("There is no such record  ");
        }
        Thread.sleep(1500);
    }
}

