package Company;
//تم توريث من كلاس الموظف
public class FullTimeEmployee extends Employee{
    //Data Members
    //تعريف الواصفات المطلوبة
    protected double salary;
    protected int workyears;
    //Constructor
    //بناء افتراضي
    public FullTimeEmployee(){}
    //بناء بتمرير البارامترات
    public FullTimeEmployee (int id,String name,String address,int year,int month,int day,int sectionid,
                             double salary,int workyears){
        super(id,name,address,year,month,day,sectionid);
        this.salary=salary;
        this.workyears=workyears;
        this.leave=calcleave();
    }
    //Methods
    //تابع من اجل تعيين قية الراتب
    public void setsalary(double s){
        salary = s;
    }
    //تابع من اجل زيادة عدد سنوات الخدمة سنة واحدة
    public int updateyears(){
        workyears++;
        return workyears;
    }
    //تابع من اجل تحديد عدد الاجازات الذي يستحقها الموظف  بالاعتماد على عدد سنوات الخدمة
    public int calcleave(){
        if(workyears < 10)
            leave = (15+workyears);
        else if(workyears >= 10 && workyears <=15)
            leave =  25;
        return leave;
    } 
    //اعادة كتابة لتابع طباعة المعلومات
    @Override
    public void report (){
        System.out.println("Full Time Employee: ");
        super.report();
        System.out.println("Salary : " + salary + "$");
        System.out.println("Work Years : " + workyears);
        System.out.println("Numbers of Leave : " + (calcleave() + additionalleave) );
    }
}