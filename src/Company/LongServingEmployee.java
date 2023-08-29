package Company;
//الذي بدوره يرث من كلاس الموظفfull timeتم التوريث من كلاس 
public class LongServingEmployee extends FullTimeEmployee {
    //جميع واصفاته موروثة
    //Constructor
    //بناء افتراضي
    public LongServingEmployee(){}
    //بناء بتمرير الباراميترات
    public LongServingEmployee(int id,String name,String address,int year,int month,int day,int sectionid,
                               double salary) {
        // افتراضيا15تم ادخال سنوات الخدمة 
        super(id,name,address,year,month,day,sectionid,salary,15);
        this.leave=calcleave();
    }
    //Methods
    //اعادة كتابة لتابع تعيين قيمة الراتب
    @Override
    public void setsalary(double s){
        salary = s;
    }
    //تابع من اجل تعيين قيمة سنوات الخدمة
    public void setworkyears(int x){
        workyears=x;
    }
    //اعادة كتابة لتابع تحديد الاجازات المستحقة
    @Override
    public int calcleave(){
        if(workyears > 15){
            int i= ((workyears-15)/2);
            leave = 25+i;
        }
        else if(workyears == 15)
            leave = 25;
        return leave;
    }
    //اعادة كتابة لتابع طباعة معلومات الموظف
    @Override
    public void report(){
        System.out.println("Long Serving Employee:");
        System.out.println("Id : "  + id);
        System.out.print("Name : " + name + "\tBirth Date : ");
        BirthDate.printdate();
        System.out.println("\nStatus : " + status);
        System.out.println("Address : " + address);
        System.out.println("Salary : " + salary + "$");
        System.out.println("Work Years : " + workyears);
        System.out.println("Numbers of Leave : " + (calcleave() + additionalleave));
    }
}
