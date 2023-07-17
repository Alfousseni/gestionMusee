/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package conf;

import com.toedter.calendar.JDateChooser;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author couly
 */
public class MyFonction {
    
  

 public static void clearFormExposition(JTextField textField1, JTextField textField2, JTextField textField3, JTextArea textField4, JDateChooser dateChooser1, JDateChooser dateChooser2) {
    textField1.setText("");
    textField2.setText("");
    textField3.setText("");
    textField4.setText("");
    dateChooser1.setDate(null);
    dateChooser2.setDate(null);
}


    public static void clearFormEmployer(JTextField textField1, JTextField textField2, JTextField textField3, JTextField textField4, JTextField text5, JTextField text6) {
        textField1.setText("");
        textField2.setText("");
        textField3.setText("");
        textField4.setText("");
        text5.setText("");
        text6.setText("");

    }
    
      public static void clearSignin(JTextField textField1, JTextField textField2, JTextField textField3, JTextField textField4) {
        textField1.setText("");
        textField2.setText("");
        textField3.setText("");
        textField4.setText("");
       

    }

    public static void clearBillet(JTextField textField1, JTextField textField2, JTextField textField3, JTextField textField4, JComboBox<String> dateChooser1, JDateChooser dateChooser2) {
        textField1.setText("");
        textField2.setText("");
        textField3.setText("");
        textField4.setText("");
        dateChooser2.setDate(null);
        dateChooser1.setSelectedIndex(0);
    }

    public static boolean testField(String nom, String prenom, String tel) {
        return (prenom.trim().isEmpty()
                || nom.trim().isEmpty()
                || tel.trim().isEmpty());
    }

    public static boolean testFieldBillet(String nom, String prenom, String tel, String autre) {
        return (prenom.trim().isEmpty()
                || nom.trim().isEmpty()
                || tel.trim().isEmpty()
                || autre.trim().isEmpty());
    }

    public static boolean testFieldOeuvre(String nom, String prenom, String password, String login, String email) {
        return (prenom.trim().isEmpty()
                || nom.trim().isEmpty()
                || email.trim().isEmpty()
                || login.trim().isEmpty()
                || password.trim().isEmpty());
    }

    public static boolean testFieldEmploye(String nom, String clasique, String vip, String description, String email, String Autre) {
        return (clasique.trim().isEmpty()
                || vip.trim().isEmpty()
                || description.trim().isEmpty()
                || Autre.trim().isEmpty());
    }
    
    public static boolean testFields(String... fields) {
    for (String field : fields) {
        if (field.trim().isEmpty() || field.length()<2) {
            return true; // Au moins un champ est vide
        }
    }
    return false; // Tous les champs sont remplis
}
    public static void clearFormFields(JTextField... textFields) {
    for (JTextField textField : textFields) {
        textField.setText("");
    }
    
    
}




    public static boolean controle(String nom, String prenom) {

        if (nom.length() < 2 || prenom.length() < 2) {
            return true;
        }
        return false;
    }

    public static boolean controle(String nom, String prenom, String email, String login) {

        if (nom.length() < 2 || prenom.length() < 2 || login.length() < 2) {
            return true;
        }
        return false;
    }

    public static boolean controleTel(String tel) {
        if (!tel.startsWith("70") && !tel.startsWith("77")
                && !tel.startsWith("76") && !tel.startsWith("78")
                && !tel.startsWith("72") && !tel.startsWith("33")) {
            return true;
        }

        String regex = "^\\d{9}$";
        return !tel.matches(regex);
    }
          public static boolean isValidTime(String time) {
    String timeRegex = "^([01]\\d|2[0-3]):([0-5]\\d)(:([0-5]\\d))?$";
    return time.matches(timeRegex);
}

    public static boolean validerEmail(String email) {
        String regex = "^[a-zA-Z0-9._%+-]{3,}@[a-zA-Z]{3,}\\.[a-zA-Z]{2,}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        return !matcher.matches();
    }

    public static boolean confirmPassword(String password, String confirmPassword) {
        if (password == null || confirmPassword == null) {
            return false;
        }
        return password.equals(confirmPassword);
    }

    public static boolean validatePassword(String password) {
        if (password == null) {
            return false;
        }
        // Au moins 8 caractères
        if (password.length() < 8) {
            return false;
        }
        // Au moins une lettre minuscule
        if (!password.matches(".*[a-z].*")) {
            return false;
        }
        // Au moins une lettre majuscule
        if (!password.matches(".*[A-Z].*")) {
            return false;
        }
        // Au moins un chiffre
//        if (!password.matches(".*[0-9].*")) {
//            return false;
//        }
//        // Au moins un caractère spécial
//        if (!password.matches(".*[@#$%^&+=].*")) {
//            return false;
//        }
        return true;
    }

}
