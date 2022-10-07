package com.ruoyi.system.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class SelectDeptList {

    private HashMap<Integer,List<Deptzi>> objectObjectHashMap;

    private ArrayList<Deptzhu> objects ;

    @Override
    public String toString() {
        return "SelectDeptList{" +
                "objectObjectHashMap=" + objectObjectHashMap +
                ", objects=" + objects +
                '}';
    }
}
