package com.home.study.collection.list;

import java.util.ArrayList;
import java.util.Collections;

public class ex1 {
    public static void main(String[] args) {
        // 기본길이 (용량, capacity)가 10인 ArrayList를 생성
        ArrayList list1 = new ArrayList(10);
        // ArrayList에는 객체만 저장가능
        list1.add(5); // 컴파일러가 오토박싱을 해줘서 아래의 형태로 처리된다.
        // list1.add(new Integer(5));
        list1.add(new Integer(4));
        list1.add(new Integer(2));
        list1.add(new Integer(0));
        list1.add(new Integer(1));
        list1.add(new Integer(3));

        // ArrayList(Collection c)
        ArrayList list2 = new ArrayList(list1.subList(1,4));
        // sublist()로 만든 arrayList 는 읽기전용
        // 내용을 바꾸려면 새로운 ArrayList로 만들어야 한다.
        print(list1, list2);

        // Collection은 인터페이스, Collections는 유틸 클래스
        Collections.sort(list1); // list1과 list2를 정렬한다.
        Collections.sort(list2);
        print(list1, list2);

        System.out.println("list1.containsAll(list2): "+list1.containsAll(list2));

        list2.add("B");
        list2.add("C");
        list2.add(3,"A");
        print(list1, list2);

        list2.set(3, "AA");
        print(list1,list2);

        list1.add(0,"1");
        System.out.println("index="+list1.indexOf("1"));
        System.out.println("index="+list1.indexOf(1));
        list1.remove("1");
        list1.remove(0);
        list1.remove(new Integer(1));


        // list1에서 list2와 겹치는 부분만 남기고 나머지는 삭제
        System.out.println("list1.retainAll(list2): " + list1.retainAll(list2));
        print(list1, list2);

        // list2에서 list1에 포함된 객체들 삭제
        for(int i = list2.size()-1; i>=0; i--){
            if(list1.contains(list2.get(i))){
                list2.remove(i);
            }
        }
        print(list1, list2);


    }

    private static void print(ArrayList list1, ArrayList list2) {
        System.out.println("list1 : " + list1);
        System.out.println("list2 : " + list2);
        System.out.println();
    }
}
