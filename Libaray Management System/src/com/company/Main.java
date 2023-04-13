package com.company;

import java.util.Scanner;
import java.util.Scanner;
public class Main {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("*****************************");
        System.out.println("**LIBRARY MANAGEMENT SYSTEM**");
        System.out.println("*****************************");

        //*************************************************
        // Making an object for the student and admin class
        //*************************************************

        admin obj_A=new admin();
        student obj_S =new student();
        int check;
        do {
            // different modes
            System.out.println("Press 1 for Student mode");
            System.out.println("Press 2 for Admin mode");
            System.out.println("Press 0 for exit :");
            Scanner sc = new Scanner(System.in);
            check = sc.nextInt();
            switch (check) {
                case 1: {
                    int check1;
                    do {
                        System.out.println("Press 1 :Search a book");
                        System.out.println("Press 2 :Borrow a book");
                        System.out.println("Press 3 :Read a particular book");
                        System.out.println("Press 4 :Return borrowed book");
                        System.out.println("Press 5 :To exit");
                        check1 = sc.nextInt();
                        switch (check1) {
                            case 1: {
                                obj_S.searchBook();
                                break;
                            }
                            case 2: {
                                obj_S.borrow();
                                break;
                            }
                            case 3: {
                                obj_S.read();
                                break;

                            }
                            case 4: {
                                obj_S.Return();
                                break;
                            }
                            case 5: {
                                System.out.println("********MAIN MENU*********");
                                break;
                            }
                            default:{
                                System.out.println(" Invalid Input ");
                            }
                        }
                    }while(check1!=5);
                    break;
                }
                case 2: {
                    System.out.println("Enter the password for admin\n HINT:Default is admin");
                    int check2;
                    if (sc.next().equals(obj_A.getPassword())) {
                        do {
                            System.out.println("Press 1 :Add a book");
                            System.out.println("Press 2 :Modify book record");
                            System.out.println("Press 3 :Delete a book");
                            System.out.println("Press 4 :Issue a book");
                            System.out.println("Press 5 :View all available book");
                            System.out.println("Press 6 :View record that are issued");
                            System.out.println("Press 7 :Change the password");
                            System.out.println("Press 8 :To exit to previous menu");
                            check2 = sc.nextInt();
                            switch (check2) {
                                case 1: {
                                    obj_A.addbook();
                                    break;
                                }
                                case 2: {
                                    obj_A.bookRecord();
                                    break;
                                }
                                case 3: {
                                    obj_A.delete();
                                    break;
                                }
                                case 4: {
                                    obj_A.issue();
                                    break;
                                }
                                case 5: {
                                    obj_A.availableBooks();
                                    break;
                                }
                                case 6: {
                                    obj_A.issueRecord();
                                    break;
                                }
                                case 7: {
                                    obj_A.changePass();
                                    break;
                                }
                                case 8:{
                                    System.out.println("*******MAIN MENU*******");
                                    break;
                                }

                                default:{
                                    System.out.println("Invalid input ");
                                }


                            }
                        } while (check2 != 8);
                    }
                    else {
                        System.out.println("You entered an incorrect password");
                    }
                    break;
                }
                case 0: {
                    System.out.println("You terminate the program");
                    System.out.println("Thank you!!");
                    System.exit(0);
                    break;
                }
                default: {
                    System.out.println("Invalid Input");
                    break;
                }
            }
        }while (check!=0);
    }
}