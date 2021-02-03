package cn.huzunjie.spring5.beans;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @Author HuZunJie
 * @Date 2021/2/3 18:53
 * @Email 826992656@qq.com
 * @Version 1.0
 */

public class Student {
//    数组类型属性
    private String[] stringArrays;
//    list集合类型属性
    private List<String> lists;
//      Map集合类型属性

    private Map<String, String> maps;
    //    set集合类型的属性
    private Set<String> sets;

    //学生所学多门课程List集合
    private List<Course> courseList;

    public List<Course> getCourseList() {
        return courseList;
    }

    public void setCourseList(List<Course> courseList) {
        this.courseList = courseList;
    }

    public String[] getStringArrays() {
        return stringArrays;
    }

    public void setStringArrays(String[] stringArrays) {
        this.stringArrays = stringArrays;
    }

    public List<String> getLists() {
        return lists;
    }

    public void setLists(List<String> lists) {
        this.lists = lists;
    }

    public Map<String, String> getMaps() {
        return maps;
    }

    public void setMaps(Map<String, String> maps) {
        this.maps = maps;
    }

    public Set<String> getSets() {
        return sets;
    }

    public void setSets(Set<String> sets) {
        this.sets = sets;
    }

    @Override
    public String toString() {
        return "Student{" +
                "stringArrays=" + Arrays.toString(stringArrays) +
                ", lists=" + lists +
                ", maps=" + maps +
                ", sets=" + sets +
                ", courseList=" + courseList +
                '}';
    }
}
