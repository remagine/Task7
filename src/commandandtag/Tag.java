package commandandtag;

public class Tag implements Comparable<Tag> {
    private final int id;

    public Tag(int number) {
        this.id = number;
        if(!(number >= 1 && number <= 9)){
            addFailHistory(this);
        }
    }

    public static void printHistory() {
        int createFailCnt = FailHistory.getCreateFailCnt();
        System.out.println(createFailCnt);
        AvailableTags.print();
        FailHistory.print();

    }

    private void addFailHistory(Tag tag) {
        FailHistory.addFailHistory(tag);
    }

    @Override
    public int compareTo(Tag o) {
        return Integer.compare(id, o.id);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Tag tag = (Tag) o;

        return id == tag.id;
    }

    @Override
    public int hashCode() {
        return id;
    }

    public void execute() {
        if(id != 0){
            AvailableTags.addTag(this);
        }
    }

    public void fail(){
        FailHistory.addFailHistory(this);
    }
}
