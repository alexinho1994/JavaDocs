package exercise3;

/**
 * Created by Alexandru.Grameni on 7/7/2017.
 */
public class StudentC extends Student {
    public StudentC(String firstName, String lastName) {
        super(firstName, lastName);
    }

    @Override
    public int hashCode() {
        int result;
        result = getFirstName().hashCode();
        //result = 31*result + getLastName().hashCode();
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if(this == o)
            return true;

        if(o == null)
            return false;

        if(getClass() != o.getClass())
            return false;

        StudentC std = (StudentC) o;

        if(!super.getFirstName().equals(std.getFirstName()))
            return false;

        if(!super.getLastName().equals(std.getLastName()))
            return false;

        return true;
    }
}
