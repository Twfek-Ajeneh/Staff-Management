package Company;
//كلاس خاص للتاريخ
public class Date {
    //Date Members
    //تعريف واصفات سنة  شهر  يوم
    private int year;
    private int month;
    private int day;
    //Constructor
    //بناء افتراضي وبناء بتمرير البارامترات
    public Date (){}
    public Date (int year,int month,int day){
        this.year=year;
        this.month=month;
        this.day=day;
    }
    //Methods
    //تابع من اجل التغير على قيم الواصفات في الاوبجيكت
    public void setDate(int y,int m,int d){
        year=y;
        month=m;
        day=d;
    }
    //تابع من اجل طباعة التاريخ
    public void printdate(){
        System.out.print(year + "/" + month + "/" + day);
    }    
}
