package statistics.matcher;

public class QueryBuilder {
    Matcher matcher;

    public QueryBuilder() {
        matcher = new And(new All());
    }

    public Matcher build() {
        Matcher matcher = this.matcher;
        this.matcher = new And(new All());
        
        return matcher;
    }

    public QueryBuilder playsIn(String team) {
        matcher = new And(matcher, new PlaysIn(team));

        return this;
    }

    public QueryBuilder hasAtLeast(int value, String category) {
        matcher = new And(matcher, new HasAtLeast(value, category));

        return this;
    }

    public QueryBuilder hasFewerThan(int value, String category) {
        matcher = new And(matcher, new HasFewerThan(value, category));

        return this;
    }

    public QueryBuilder oneOf(Matcher ...matchers) {
        matcher = new Or(matchers);

        return this;
    }
}