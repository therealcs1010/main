package com.algosenpai.app.logic;

import com.algosenpai.app.logic.command.Command;
import com.algosenpai.app.logic.command.CommandEnum;
import com.algosenpai.app.logic.command.PrintCommand;

import java.util.Arrays;


public class Parser {

    /**
     * Handle string entered by user.
     * @param input the raw user input
     * @return the Command with the relevant type and parameter.
     */
    public Command parseInput(String input) {
        String commandWord = "NULL";
        int parameter = 0;

        if (input.contains(" ")) {
            String[] parsedInput = input.split(" ");
            commandWord = parsedInput[0].toLowerCase();
            parameter = Integer.parseInt(parsedInput[1]);
        } else {
            commandWord = input;
        }

        System.out.println(commandWord);

        switch (commandWord) {
        case "hello":
            return new Command(CommandEnum.SETUP, 0, input);
        case "menu":
            return new Command(CommandEnum.MENU, 0, input);
        case "start":
            return new Command(CommandEnum.START, 0, input);
        case "select":
            return new Command(CommandEnum.SELECT, parameter, input);
        case "result":
            return new Command(CommandEnum.RESULT, 0, input);
        case "report":
            return new Command(CommandEnum.REPORT, 0, input);
        case "back":
            return new Command(CommandEnum.BACK, 0, input);
        case "history":
            return new Command(CommandEnum.HISTORY, 0, input);
        case "undo":
            return new Command(CommandEnum.UNDO, 0, input);
        case "clear":
            return new Command(CommandEnum.CLEAR, 0, input);
        case "reset":
            return new Command(CommandEnum.RESET, 0, input);
        case "save":
            return new Command(CommandEnum.SAVE, 0, input);
        case "help":
            return new Command(CommandEnum.HELP, 0, input);
        case "exit":
            return new Command(CommandEnum.EXIT, 0, input);
        case "print":
            return new PrintCommand(CommandEnum.PRINT, 0, input);
        case "archive":
            return new Command(CommandEnum.ARCHIVE, 0, input);
        default:
            return new Command(CommandEnum.INVALID, 0, input);
        }
    }

    /**
     * Returns command to execute after parsing the user input.
     * @param s string taken in
     * @return boolean true if the string can be returned as an integer else boolean false
     */
    public static boolean isInteger(String s) {
        try {
            Integer.parseInt(s);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Returns the command that is closest to whatever the user has typed in.
     * @param userInput the command user's wants to execute
     * @return closest command the user might have meant
     */

    public static String possibleCommand(String userInput) {
        String[] all = {"menu",
            "start",
            "select",
            "report",
            "result",
            "back",
            "history",
            "undo",
            "clear",
            "reset",
            "save",
            "help",
            "exit"
        };
        String str = "";
        double num = -1;
        for (String s : all) {
            double temp = countPairs(userInput, userInput.length(), s, s.length()) / s.length();
            if (temp > num) {
                num = temp;
                str = s;
            }
        }
        return str;
    }

    /**
     * To get the number of characters the two strings have in common.
     * @param unknownCommand the command user has inputted
     * @param l1 length of the unknownCommand
     * @param knownCommand one of the commands in the list of commands
     * @param l2 length of a particular command
     * @return the number of pairs of alphabets that the both strings have in common
     */

    public static int countPairs(String unknownCommand, int l1, String knownCommand, int l2) {

        int []freq1 = new int[26];
        int []freq2 = new int[26];
        Arrays.fill(freq1, 0);
        Arrays.fill(freq2, 0);

        int count = 0;

        for (int i = 0; i < l1; i++) {
            freq1[unknownCommand.charAt(i) - 'a']++;
        }
        for (int i = 0; i < l2; i++) {
            freq2[knownCommand.charAt(i) - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            count += (Math.min(freq1[i], freq2[i]));
        }

        return count;
    }

    /**
     * To tell if the user's input is meant to be an answer by checking if there is a digit inside.
     * @param s takes in the string that is to be checked
     * @return true if string contains a digit otherwise false
     */
    public static boolean hasDigit(String s) {
        for (char c: s.toCharArray()) {
            if (Character.isDigit(c)) {
                return true;
            }
        }
        return false;
    }
}
