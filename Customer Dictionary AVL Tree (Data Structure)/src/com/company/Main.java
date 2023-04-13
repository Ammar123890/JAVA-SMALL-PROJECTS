package com.company;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        AVLTree obj=new AVLTree();
        obj.read();
        obj.start();
        boolean flag=true;
        boolean flag2 = true;
        Scanner sc=new Scanner(System.in);
        do
        {
            System.out.println("PRESS 1: TO DISPLAY ALL RECORD\nPRESS 2: TO SEARCH:\nPRESS 3: TO DELETE WORD\nPRESS 0: TO EXIT");
            int check=sc.nextInt();
            switch (check)
            {
                case 1: {

                    do {
                        System.out.println("PRESS 1: FOR INORDER DISPLAY\nPRESS 2: FOR POST ORDER\nPRESS 3: PREORDER\nPRESS 0 TO EXIT");
                        int check2 = sc.nextInt();
                        switch (check2) {
                            case 1: {
                                obj.inorder();
                                break;
                            }
                            case 2: {
                                obj.postorder();
                                break;
                            }
                            case 3: {
                                obj.preorder();
                                break;
                            }
                            case 0: {
                                flag2 = false;
                                break;
                            }
                        }
                    }while (flag2);
                    break;
                }
                case 2:
                {
                    System.out.println("ENTER WORD YOU WANT TO SEARCH: ");
                    sc.nextLine();
                    String str=sc.nextLine();
                    obj.search(str);
                    break;
                }
                case 3:
                {
                    System.out.println("ENTER WORD YOU WANT TO DELETE: ");
                    sc.nextLine();
                    String str=sc.nextLine();
                    obj.Delete(str);
                    obj.start();

                    break;

                }
                case 0:
                {
                    obj.start();
                    flag=false;
                    break;
                }
            }
        }while (flag);



    }
}
