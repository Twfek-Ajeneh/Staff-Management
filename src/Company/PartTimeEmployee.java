package Company;
// تم توريث من كلاس الموظف
public class PartTimeEmployee extends Employee {
    //Data Members
    //تعريف الواصفات المطلوبة
    private double workedhours;
    //Constructor
    //بناء افتراضي
    public PartTimeEmployee(){}
    //بناء بتمرير  باراميترات
    public PartTimeEmployee(int id,String name,String address,int year,int month,int day,int sectionid,
                            double workedhours){
        super(id,name,address,year,month,day,sectionid);
        //هنا يختلف توع الحالة الى موظف متعاقد
        this.status="Contracting Employee.";
        this.workedhours=workedhours;
    }
    //Methods
    //تابع من اجل تعيين عدد ساعات العمل
    public void setworkedhour(double w){
        workedhours = w;
    }
    //تابع من اجل حساب الاجر الشهري المستحق
    public double calcpay(){
        //تم وضع الاجر الساعي ثابت
        double pay = workedhours*2000;
        return pay;
    }
    //اعادة كتابة لنابع طباعة المعلومات
    @Override
    public void report(){
        System.out.println("Part Time Employee: ");
        super.report();
        System.out.println("Work Hours par month : " + workedhours);
        System.out.println("The wages payable in the month : " + calcpay());
    }   
}