package ui;

public class ColorPrint {
    public void red(String s){
        System.out.println(ConsoleColors.RED_BRIGHT + s + ConsoleColors.RESET);
    }
    public void green(String s){
        System.out.println(ConsoleColors.GREEN_BRIGHT + s + ConsoleColors.RESET);
    }
    public void blue(String s){
        System.out.println(ConsoleColors.BLUE_BRIGHT + s + ConsoleColors.RESET);
    }
    public void yellow(String s){
        System.out.println(ConsoleColors.YELLOW_BRIGHT + s + ConsoleColors.RESET);
    }
    public void redU(String s){
        System.out.println(ConsoleColors.RED_UNDERLINED + s + ConsoleColors.RESET);
    }
    public void greenU(String s){
        System.out.println(ConsoleColors.GREEN_UNDERLINED + s + ConsoleColors.RESET);
    }
    public void blueU(String s){
        System.out.println(ConsoleColors.BLUE_UNDERLINED + s + ConsoleColors.RESET);
    }
    public void yellowU(String s){
        System.out.println(ConsoleColors.YELLOW_UNDERLINED + s + ConsoleColors.RESET);
    }
}
