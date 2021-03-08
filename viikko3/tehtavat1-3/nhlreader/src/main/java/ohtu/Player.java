
package ohtu;

public class Player implements Comparable<Player> {
    private String name;
    private String nationality;
    private String team;
    private int assists;
    private int goals;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getNationality() {
        return nationality;
    }

    public String getTeam() {
        return team;
    }

    public int getAssists() {
        return assists;
    }

    public int getGoals() {
        return goals;
    }

    public int getPoints() {
        return assists + goals;
    }

    @Override
    public String toString() {
        return name + "\t\t" + team + "\t" + goals + " + " + assists + " = " + this.getPoints();
    }

    @Override
    public int compareTo(Player other) {
        return other.getPoints() - this.getPoints();
    }
      
}
