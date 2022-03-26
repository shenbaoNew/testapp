package com.digiwin.testapp.design;

/**
 * FileName:Other
 * Author: shenbao
 * Date: 2022/3/26 18:21
 * Description:
 */
public class Other {
    public static int COUNT = 10;

    static {
        System.out.println("other load...");
    }

    private static class InnerOther {
        public static int INNERCOUNT = 20;

        static {
            System.out.println("innerother load...");
        }
    }
}
