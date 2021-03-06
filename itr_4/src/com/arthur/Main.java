package com.arthur;

import java.security.NoSuchAlgorithmException;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Vector names = new Vector();
        for (String arg : args) {
            names.add(arg);
        }
        /*Iterator<String> itr = names.iterator();
        while(itr.hasNext())
            System.out.println(itr.next());*/
        Table table = new Table();
        table.names = names;
        WhoWin player = new WhoWin();
        KeyGen key = new KeyGen();;
        HMAC hmac = new HMAC();
        while(true){
            key.generate(names.size());
            System.out.println("HMAC key:" + hmac.calculateHMac(key.Key,Integer.toString(key.ComputerMove)));
            System.out.println("Available moves:");
            int i = 1;
            Iterator<String> itr = names.iterator();
            while(itr.hasNext())
                System.out.println(i++ + " - " +itr.next());
            System.out.println("0 - exit");
            System.out.println("? - help");
            System.out.print("Enter your move:");
            Scanner in = new Scanner(System.in);
            String choicepeople = in.next();
            if (Objects.equals(choicepeople, "0")) break;
            if (Objects.equals(choicepeople, "?")) table.GenerationTable();
            System.out.println("Your move:" + ((String) names.get(Integer.parseInt(choicepeople) - 1)));
            System.out.println(key.ComputerMove);
            System.out.println("Computer move:" + ((String) names.get(key.ComputerMove)));
            player.Win(Integer.parseInt(choicepeople) - 1,key.ComputerMove,names.size());
        }
    }


}
