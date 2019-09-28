package ui;

public class Console {

    public void showWelcome(){
        ColorPrint cp = new ColorPrint();
        cp.red("Welcome to the Hydra");
        cp.yellow("Built by Amir Ayub");
        cp.green("Version 1.0, September 28 2019");
    }
    public void showExp(){
        ColorPrint cp = new ColorPrint();
        cp.blueU("Please enter a job experience level: (1..6)");
        cp.blue("1 -> Internship");
        cp.blue("2 -> Entry Level");
        cp.blue("3 -> Associate");
        cp.blue("5 -> Director");
        cp.blue("6 -> Executive");
    }

    public void showJobName(){
        ColorPrint cp = new ColorPrint();
        cp.blueU("Please enter a job title:");
    }
    public void showTitle(){
        ColorPrint cp = new ColorPrint();
        cp.blueU("Please enter a name for the report:");
    }
    public void showStartMine(){
        ColorPrint cp = new ColorPrint();
        cp.yellow("Mining started! Please wait...");
        cp.yellow("Should take about 5 minutes");
    }
}
