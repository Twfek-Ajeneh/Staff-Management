package Company;
import java.util.List;
import java.util.ArrayList;

public class Section {
    //Data Members
    //تعريف الواصفات المطلوبة
    private int sectionID;
    private String sectionname;
    private Employee sectionhead;
    // من نوع موظف من اجل وضع الموظفين الموجودين بالقسم داخلهاlistتعريف واصفة 
    public List <Employee> sectionemployee = new ArrayList <> () ;
    //Constructor
    //بناء افتراضي
    public Section(){}
    //بناء بتمرير الباراميترات
    public Section(int sectionID,String sectionname,Employee sectionhead,List <Employee> sectionemployee){
        this.sectionID = sectionID;
        this.sectionname = sectionname;
        this.sectionhead = sectionhead;
        this.sectionemployee = sectionemployee;
    }
    //Methods  
    //تابع لتعين قيمة رقم القسم
    public void setsectionID(int s){
        sectionID = s;
    }
    //تابع لارجاع قيمة رقم القسم
    public int getsectionID(){
        return sectionID;
    }
    //تابع لتعيين اسم القسم
    public void setsectionname(String s){
        sectionname = s;
    }    
    //تابع لارجاع اسم القسم
    public String getsectionname(){
        return sectionname;
    }
    // الموظفينlistتابع من اجل اضافة عناصر الى 
    public void setsectionemployee(Employee e){
        sectionemployee.add(e);
    } 
    //الموظفين اي حذف حميع العناصر الموجودة فيها listتابع من اجل تهيئة 
    public void removesectionemployee(){
        sectionemployee.removeAll(sectionemployee);
    }
    //الموظفين listتابع من اجل طباعة 
    public void printsemployee(){
        if(sectionemployee.isEmpty())
            System.out.println("There are no employees in this section.");
        else
            for(Employee em: sectionemployee){
                em.report();
                System.out.println("----------------");
            }
    }
    //تابع من اجل طباعة معلومات القسم
    public void report(){
        System.out.println("Section ID : " + sectionID);
        System.out.println("Section name : " + sectionname);
        System.out.println("Section Head : ");
        sectionhead.report();
        System.out.println("The number of employees in this section : " + sectionemployee.size());
    }
}
