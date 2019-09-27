package model;

public class Jobs implements Comparable {
    private String countryName;
    private int jobCount;

    public Jobs(String countryName, int jobCount) {
        this.countryName = countryName;
        this.jobCount = jobCount;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public int getJobCount() {
        return jobCount;
    }

    public void setJobCount(int jobCount) {
        this.jobCount = jobCount;
    }
    @Override
    public int compareTo(Object jobstu){
        int comparejobs=((Jobs)jobstu).getJobCount();
        return comparejobs-this.jobCount;
    }

    @Override
    public String toString() {
        return "Jobs{" +
                "countryName='" + countryName + '\'' +
                ", jobCount=" + jobCount +
                '}';
    }
}
