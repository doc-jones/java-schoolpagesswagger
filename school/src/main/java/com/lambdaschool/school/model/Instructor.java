package com.lambdaschool.school.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@ApiModel(value = "instructor", description = "Defines the instructor entity, it's relationships to other entities and instructor props")
@Entity
@Table(name = "instructor")
public class Instructor
{
    @ApiModelProperty(name = "instructid", value = "Primary key for Instructor", required = true, example = "1")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long instructid;

    @ApiModelProperty(name = "instructname", value = "Instructor Name", required = true, example = "A person's name who is an instructor")
    private String instructname;

    @OneToMany(mappedBy = "instructor")
    @JsonIgnoreProperties("instructors")
    private List<Course> courses = new ArrayList<>();

    public Instructor()
    {
    }

    public Instructor(String instructname)
    {
        this.instructname = instructname;
    }

    public long getInstructid()
    {
        return instructid;
    }

    public void setInstructid(long instructid)
    {
        this.instructid = instructid;
    }

    public String getInstructname()
    {
        return instructname;
    }

    public void setInstructname(String instructname)
    {
        this.instructname = instructname;
    }

    public List<Course> getCourses()
    {
        return courses;
    }

    public void setCourses(List<Course> courses)
    {
        this.courses = courses;
    }
}
