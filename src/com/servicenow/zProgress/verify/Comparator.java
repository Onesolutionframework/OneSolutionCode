package com.servicenow.zProgress.verify;

/**
 *
 *
 *
 * @author Muni Balachandra
 * @version 1.0
 * @since 2015-01-01
 */
public class Comparator {
    public static boolean compare(String exp, String act) {
        if (exp.equalsIgnoreCase(act)) {
            return true;
        } else {

            return false;
        }
    }

    public static boolean compare(int exp, int act) {
        if (exp == act) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean compare(char exp, char act) {
        if (exp == act) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean compare(double exp, double act) {
        if (exp == act) {
            return true;

        } else {
            return false;
        }
    }
}

