package helpers;

import models.Project;

import java.util.Comparator;

public class ProjectComparator implements Comparator<Project> {

    @Override
    public int compare(Project o1, Project o2) {

        int result = o1.getNaam().compareTo(o2.getNaam());

        if (result == -1) {
            return o1.getNaam().compareTo(o2.getNaam());
        } else if (result == 0) {
            return -(o1.getFactuurBedrag() - o2.getFactuurBedrag());
        } else {
            return o1.getNaam().compareTo(o2.getNaam());
        }
//        if (o1.getNaam().equals(o2.getNaam())) {
//            return o1.getFactuurBedrag()- o2.getFactuurBedrag();
//        } else {
//            return o1.getNaam().compareTo(o2.getNaam());
//        }
//
//        if (o1.getNaam().equals(o2.getNaam())) {
//            return o1.getFactuurBedrag() - o2.getFactuurBedrag();
//        }else {
//            return o1.getNaam().compareTo(o2.getNaam());
//        }

//return result;
    }

}
