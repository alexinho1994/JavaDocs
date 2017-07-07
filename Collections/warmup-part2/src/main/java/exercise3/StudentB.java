package exercise3;

/**
 * Created by Alexandru.Grameni on 7/7/2017.
 */
public class StudentB extends Student {



    public StudentB(String firstName, String lastName) {
        super(firstName, lastName);
    }

    @Override
    public int hashCode() {
        int result;
        result = getFirstName().hashCode();
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

        StudentB std = (StudentB) o;

        if(!super.getFirstName().equals(std.getFirstName()))
            return false;

        return true;
    }
}
