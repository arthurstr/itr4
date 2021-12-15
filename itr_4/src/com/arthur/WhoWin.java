package com.arthur;

public class WhoWin {
    public void Win(int x,int y,int n){
        if (x == y) System.out.println("It's a draw");
        else
        if ((x > y && x < y + ( n + 1)/2) || (x < y + 1 - ( n + 1)/2) ) System.out.println("It's a win)))");
        else System.out.println("It's a lose(((");
    }
}
