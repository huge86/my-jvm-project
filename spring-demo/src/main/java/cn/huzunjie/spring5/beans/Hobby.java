package cn.huzunjie.spring5.beans;

import java.util.List;

/**
 * @Author HuZunJie
 * @Date 2021/2/3 19:57
 * @Email 826992656@qq.com
 * @Version 1.0
 */

public class Hobby {
    private List<String> hobby;

    public List<String> getHobby() {
        return hobby;
    }

    public void setHobby(List<String> hobby) {
        this.hobby = hobby;
    }

    @Override
    public String toString() {
        return "Hobby{" +
                "hobby=" + hobby +
                '}';
    }
}
