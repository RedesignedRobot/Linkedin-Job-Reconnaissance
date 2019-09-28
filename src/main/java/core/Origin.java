package core;

import org.apache.commons.math3.analysis.function.Min;
import ui.Console;
import ui.ConsoleColors;

import java.util.Scanner;

public class Origin {

    public static void main(String[] args) {
        System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
        Console console = new Console();
        Miner miner = new Miner();
        Scanner scanner = new Scanner(System.in);
        console.showWelcome();
        console.showExp();
        String exp = scanner.nextLine();
        console.showJobName();
        String job = scanner.nextLine();
        console.showTitle();
        String title = scanner.nextLine();
        console.showStartMine();
        miner.mine(exp,job,title);

    }
}
