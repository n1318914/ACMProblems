package com.main.vol1;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;


//http://acm.zju.edu.cn/onlinejudge/showProblem.do?problemCode=1003
public class Q1003
{

    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);

        while (true)
        {
            if(scan.hasNext())
            {
                String line = scan.nextLine();
                if (line.length() == 0)
                {
                    break;
                }
                int a = Integer.valueOf(line.split(" ")[0]) > Integer.valueOf(line.split(" ")[1]) ? Integer.valueOf(line.split(" ")[0]) : Integer.valueOf(line.split(" ")[1]);
                int b = Integer.valueOf(line.split(" ")[0]) <= Integer.valueOf(line.split(" ")[1]) ? Integer.valueOf(line.split(" ")[0]) : Integer.valueOf(line.split(" ")[1]);
                
                if(a > b)
                {
                    if(a <= 0)
                    {
                        return;
                    }
                    if(b <= 0)
                    {
                        System.out.println(a);
                        continue;
                    }
                    List<Integer> sa = new ArrayList<>(getDivid(a, null));
                    List<Integer> sb = new ArrayList<>(getDivid(b, null));
                    //如果b说谎了，a赢
                    if(sb.isEmpty())
                    {
                        System.out.println(a);
                        continue;
                    }
                    if(sa.isEmpty())
                    {
                        System.out.println(b);
                        continue;
                    }
                    sa.removeAll(sb);
                    //通过剩余的除数相乘如果能够得到a  则a赢
                    if(canGet(a, sa))
                    {
                        System.out.println(a);
                        continue;
                    }
                }
            }
        }
    }
    //获得所有除数
    public static Set<Integer> getDivid(int num, Set<Integer> list)
    {
        if(null == list)
        {
            list = new HashSet<>(); 
            if(num < 100)
            {
                list.add(num);
            }
        }
        for(int i = 2; i < 100; i++)
        {
            if(num != i && num % i == 0 && num/i < 100)
            {
                list.add(i);
                list.add(num / i);
                getDivid(num / i, list);
            }
        }
        return list;
    }
    
    //遍历相乘，判断是否能够得到指定数字
    public static boolean canGet(int num, List<Integer> list)
    {
        for(int i = 0; i < list.size(); i++)
        {
            int number = 1;
            for(int j = i; j < list.size(); j++)
            {
                number = number * list.get(j);
                if(number == num)
                {
                    return true;
                }
            }
        }
        return false;
    }
}
