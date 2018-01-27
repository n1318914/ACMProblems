package com.main.vol1;

import java.util.Scanner;

//http://acm.zju.edu.cn/onlinejudge/showProblem.do?problemCode=1003
public class Q1003 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        while (scan.hasNext()) {
            String line = scan.nextLine();
            if (line.length() == 0) {
                break;
            }

            System.out.println(line);
        }

    }
}
