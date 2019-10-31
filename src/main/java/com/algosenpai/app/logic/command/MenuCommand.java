//@@author carrieng0323852

package com.algosenpai.app.logic.command;

import java.util.ArrayList;

public class MenuCommand extends Command {

    /**
     * Initializes command to show available commands.
     * @param inputs user input.
     */
    public MenuCommand(ArrayList<String> inputs) {
        super(inputs);
    }

    @Override
    public String execute() {
        if (inputs.size() < 2) {
            return "Senpai will teach you! Try these commands\n"
                    + "hello\n"
                    + "help\n"
                    + "select\n"
                    + "result\n"
                    + "history\n"
                    + "undo\n"
                    + "clear\n"
                    + "reset\n"
                    + "save\n"
                    + "exit\n"
                    + "print\n"
                    + "archive\n"
                    + "review\n"
                    + "menu <command>\n";
        } else {
            switch (inputs.get(1)) {
            case "hello":
                return "hello <name> <gender> do note that gender refers to 'boy' or 'girl'";
            case "help":
                return "help <level of difficulty>";
            case "select":
                return "select <chapter number>";
            case "result":
                return "result";
            case "history":
                return "history <number of commands you'd like to view>";
            case "undo":
                return "undo || undo <number of steps you'd like to undo>";
            case "clear":
                return "clear <chapter number>";
            case "reset":
                return "reset";
            case "save":
                return "save";
            case "exit":
                return "exit";
            case "print":
                return "print <archive | quiz | user> <filename>.pdf";
            case "archive":
                return "archive <question number>";
            case "review":
                return "review";
            default:
                return "enter `menu` or `menu <command>`";
            }
        }
    }
}
