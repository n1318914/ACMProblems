/*
 * 文件名：P1001.java
 * 版权：Copyright by www.ixuenong.com
 * 描述：
 */

package com.main.vol1;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


//http://acm.zju.edu.cn/onlinejudge/showProblem.do?problemCode=1002
public class Q1002
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        List<Integer> result = new ArrayList<>();
        while(true)
        {
            if(scan.hasNextInt())
            {
                int length = scan.nextInt();
                if(length == 0)
                {
                    break;
                }
                char[][] a = new char[length][length];
                for(int i = 0; i < length; i++)
                {
                    String line = scan.next();
                    a[i] = line.toCharArray();
                }

            
                List<String> list = new ArrayList<>();
                List<String> tmp = new ArrayList<>();
                for (int n = 0; n < a.length; n++)
                {
                    for(int m =0; m < a.length; m ++)
                    {
                        //定位第一个位置
                        tmp.clear();
                        for (int i = 0; i < a.length; i++ )
                        {
                            for (int j = 0; j < a[i].length; j++ )
                            {
                                
                                if(Integer.parseInt(i +""+ j) < Integer.parseInt(n +"" +m))
                                {
                                    continue;
                                }
                                //判断该位置是否可以放置堡垒
                                if (canSet(i, j, a, tmp))
                                {
                                    tmp.add(i + "" + j);
                                }
                            }
                        }
                        if (list.size() < tmp.size())
                        {
                            list.clear();
                            list.addAll(tmp);
                        }
                    }
                }
                
                result.add(list.size());
                System.out.println(list.size());
            }
        }
        
        /*for(int i = 0; i < result.size(); i++)
        {
            if(i != 0) 
            {
                System.out.println();
            }
            System.out.print(result.get(i));
        }*/
    }

    //判断是否可以放置堡垒
    public static boolean canSet(int i, int j, char[][] a, List<String> tmp)
    {
        //该位置如果是墙不可放置
        if (isWall(i, j, a))
        {
            return false;
        }
        //该位置已有堡垒
        if (isCastle(i, j, tmp))
        {
            return false;
        }
        //查看四个方向，是否满足放置条件
        //直到撞到墙或者边界之前都没有撞到堡垒的话，该位置可以放置堡垒
        
        boolean left = true, top = true, right = true, bottom = true;
        for(int k = 1; k < a.length; k++)
        {
            if(left)
            {
                //向左遍历
                if(isBorder(i, j-k, a.length) || isWall(i, j - k, a))//撞到边界了
                {
                    left = false;
                }
                if(isCastle(i, j - k, tmp))//该位置有堡垒了
                {
                    return false;
                }
            }
            if(right)
            {
                //向左遍历
                if(isBorder(i, j + k, a.length) || isWall(i, j + k, a))//撞到边界了
                {
                    right = false;
                }
                if(isCastle(i, j + k, tmp))//该位置有堡垒了
                {
                    return false;
                }
            }
            if(top)
            {
                //向左遍历
                if(isBorder(i - k, j, a.length) || isWall(i - k, j, a))//撞到边界了
                {
                    top = false;
                }
                if(isCastle(i - k, j, tmp))//该位置有堡垒了
                {
                    return false;
                }
            }
            if(bottom)
            {
                //向左遍历
                if(isBorder(i + k, j, a.length) || isWall(i + k, j, a))//撞到边界了
                {
                    bottom = false;
                }
                if(isCastle(i + k, j, tmp))//该位置有堡垒了
                {
                    return false;
                }
            }
        }
        return true;
    }
    
    //判断节点是否撞到墙
    public static boolean isWall(int x, int y, char[][] a)
    {
        if(a[x][y] == 'X' || a[x][y] == 'x')
        {
            return true;
        }
        return false;
    }
    //判断节点是否撞到边界
    public static boolean isBorder(int x, int y,int size)
    {
        if(x < 0 || x >= size)
        {
            return true;
        }
        if(y < 0 || y >= size)
        {
            return true;
        }
        return false;
    }
    //判断是否已有堡垒
    public static boolean isCastle(int x, int y,List<String> tmp)
    {
        return tmp.contains(x + "" + y);
    }
}
