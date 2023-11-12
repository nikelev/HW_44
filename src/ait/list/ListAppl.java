package ait.list;

import ait.list.interfaces.IList;
import ait.list.model.MyArrayList;

public class ListAppl   {
    public static void main(String[] args) {
        IList<Integer>list=new MyArrayList<>();
        System.out.println(list.size()  );
        System.out.println(list.isEmpty());
        list.add(2);
        list.add(7);
        list.add(5);
        list.add(3);
        System.out.println(list.size()  );
        System.out.println(list.isEmpty());
        list.add(7);
        list.add(null);
        System.out.println(list.size()  );

        System.out.println(list.get(2));
        System.out.println(list.get(5));

        System.out.println(list.indexOf(3)  );
        System.out.println(list.indexOf(7)  );
        System.out.println(list.indexOf(null));//   null  нельзя сравнивать через  equals!!!!!!!!

        System.out.println(list.indexOf(10));

        int num=list.remove(2);
        System.out.println(num);
        System.out.println(list.size());

//        Integer num1=list.remove(4);
//        System.out.println(num1);
//        System.out.println(list.size());

        System.out.println(list.remove((Integer  )7));
        System.out.println(list.size());

        System.out.println("==================Homework==================");
        //list.clear();
        System.out.println(list.size());

        System.out.println(list.lastIndexOf(7));

        System.out.println(list.set(2,9));
        System.out.println(list.get(2));



    }
}
