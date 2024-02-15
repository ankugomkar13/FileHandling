package org.example;

import org.example.bootcoding.model.Assignment;
import org.example.bootcoding.service.AssignmentService;
import org.example.bootcoding.service.JSONFileWriter;

import java.awt.datatransfer.SystemFlavorMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        List<Assignment> assignmentList = new ArrayList<>();
        JSONFileWriter file = new JSONFileWriter();
        AssignmentService assignmentService = new AssignmentService();
        Scanner sc = new Scanner(System.in);
        System.out.println("1 for insert value in database");
        System.out.println("2 for fetch value from database");
        System.out.println("3 for fetch value from database by diificultyLevel");
        System.out.println("4 for fetch value from database by PaidOnly");
        System.out.print("Enter your operation :-");
        int x = sc.nextInt();
            switch (x) {
                case 1:
                    assignmentService.readFile("C:\\Users\\Ankita Gomkar\\Downloads\\quesquestions.csv");
                    System.out.println("Data inserted in database");
                    break;
                case 2:
                   assignmentList=assignmentService.getAssignment();
                    file.write(assignmentList,"assignment");
                    break;
                case 3:
                    System.out.print("Enter your search level : ");
                    String input = sc.next();
                    assignmentList = assignmentService.getByDifficultyLevel(input);
                    file.write(assignmentList,"DifficultyLevel");
                    break;
                case 4:
                    System.out.print("Enter is it paid or unpaid if it is paid true otherwise enter false :");
                    boolean userinput = sc.nextBoolean();
                    assignmentList = assignmentService.getByPaidonly(userinput);
                    file.write(assignmentList,"PaidOnly");
                    break;

            }
        }

    }