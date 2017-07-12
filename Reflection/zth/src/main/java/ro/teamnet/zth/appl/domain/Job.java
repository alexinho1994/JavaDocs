package ro.teamnet.zth.appl.domain;

import ro.teamnet.zth.api.annotations.Column;
import ro.teamnet.zth.api.annotations.Id;
import ro.teamnet.zth.api.annotations.Table;

/**
 * Created by Alexandru.Grameni on 7/12/2017.
 */
@Table(name = "Jobs")
public class Job {

    @Id(name = "job_id")
    private long id;
    @Column(name = "job_title")
    private String job_title;
    @Column(name = "min_sal")
    private int min_sal;
    @Column(name = "max_sal")
    private int max_sal;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getJob_title() {
        return job_title;
    }

    public void setJob_title(String job_title) {
        this.job_title = job_title;
    }

    public int getMin_sal() {
        return min_sal;
    }

    public void setMin_sal(int min_sal) {
        this.min_sal = min_sal;
    }

    public int getMax_sal() {
        return max_sal;
    }

    public void setMax_sal(int max_sal) {
        this.max_sal = max_sal;
    }
}
