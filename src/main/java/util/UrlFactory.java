package util;

import config.Config;

public class UrlFactory {

    private final String space = "%20";

    public String getTestUrl(){
        String location = Config.locationBase+"Saudi Arabia";
        String exp = Config.expBase+"2";
        String job = Config.jobBase+"software" + space +"developer";
        return Config.baseUrl+location+exp+job;
    }
    public String buildUrl(String location, String exp, String job){
        String fLocation = Config.locationBase+location;
        String fExp = Config.expBase+exp;
        String fJob = Config.jobBase+job;
        return Config.baseUrl+fLocation+fExp+fJob;
    }
}
