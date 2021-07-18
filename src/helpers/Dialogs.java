package helpers;

import javax.swing.*;

public class Dialogs {
    public static String readText(String msg) {
        return JOptionPane.showInputDialog(msg);
    }

    public static int readInt(String msg) {
        return Integer.parseInt(JOptionPane.showInputDialog(msg));
    }

    public static double readDouble(String msg) {
        return Double.parseDouble(JOptionPane.showInputDialog(msg));
    }

    public static int readOptions(String title, String msg, Object[] options) {
        return JOptionPane.showOptionDialog(
                null,
                msg,
                title,
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                options[0]
        );
    }

    public static boolean readBool(String msg, String title) {
        int option = JOptionPane.showConfirmDialog(null, msg, title, JOptionPane.OK_CANCEL_OPTION);
        return option >= 1;
    }

    public static void showMessage(String msg) {
        JOptionPane.showMessageDialog(null, msg);
    }
}
