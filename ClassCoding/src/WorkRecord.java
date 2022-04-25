public class WorkRecord
{
    private String name; // private instance variables for WorkRecord
    private int hours;

    // Construct a WorkRecord for the specified name, with initial hours 0.
    public WorkRecord(String name)  // the constructor – code it!
    {
        this.name = name;
        this.hours = 0;
    }

    // Return the number of hours in this WorkRecord.
    public int getHours()  // a getter method – code it!
    {
        return this.hours;
    }

    // Update the number of hours when moreHours additional hours are worked.
    public void addHours(int moreHours)  // an instance method – code it!
    {
            this.hours = this.hours + moreHours;
    }

    // Return a String in the form like the example:     Andy: 15 hours
    @Override
    public String toString()  // the overridden toString method – code it!
    {
        return this.name + ": " + hours + " hours";
    }

}