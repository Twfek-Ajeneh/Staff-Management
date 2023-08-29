package Company;

public class Employee {
    //Data Members
    //هنا تم تعريف الواصفات المطلوبة وتمت اضافة المزيد من الواصفات للمساعدة في كتابة البرنامج 
    //واصفة رقم القسم  لا تظهر ضمن معلومات الموظف وانما تم انشائها من اجل مساعدة في فرز الموظفين على الاقسام
    protected int id,additionalleave,leave,sectionid;
    protected String name,address,status;
    //تم انشاء اوبجيكت من كلاس التاريخ ليمثل تاريخ الولادة
    protected Date BirthDate;
    //Condtructor
    //بناء افتراضي وتم استدعاء بناء افتراضي الخاص بكلاس التاريخ بداخله
    public Employee(){
        BirthDate = new Date();
    }
    //بناء بتمرير الباراميترات
    public Employee (int id,String name,String address,int year,int month,int day,int sectionid){
        this.id=id;
        //0الموظف اي كان نوعه مبدئيا لا يملك اي اجازات اضافية لذلك افتراضيا تساوي
        this.additionalleave=0;
        //مبدئيا الموظف اي كان نوعه لا يمتلك اجازات لاحقا سوف يتم اسناد قيمة مناسبة من خلال تابع 
        this.leave=0;
        this.name=name;
        this.address=address;
        //جميع الموظفين افتراضيا موظفين دائمين
        this.status="Permanent Employee.";
        this.sectionid=sectionid;
        BirthDate = new Date(year,month,day);
    }
    //Methods
    //idتابع من اجل تعيين قيمة ال 
    public void setNum(int a){
         id = a;
    }
    //idتابع من اجل ارجاع قيمة ال 
    public int getNum(){
        return id;
    }
    //تابع من اجل ارجاع قيمة الاجازات
    public int getleave(){
        return leave;
    }
    //تابع من اجل تعيين قيمة الاجازات الاضافية
    //هذا التابع من اجل استخدامه من قبل الكلاسات التي ترث من هذا الكلاس
    public void setadditionalleave(int m){
        additionalleave = additionalleave + m;
    }
    //تابع من اجل ارجاع قيمة الاجازات الاضافية
    //هذا التابع من اجل استخدامه من قبل الكلاسات التي ترث من هذا الكلاس
    public int getadditionalleave(){
        return additionalleave;
    }
    //تابع من اجل تعيين الاسم
    public void setName(String b){
        name = b;
    }
    //تابع من اجل ارجاع الاسم
    public String getName(){
        return name;
    }
    //تابع لتعيين العنوان
    public void setAddress(String c){
        address = c;
    }
    //تابع من اجل ارجاع العنوان
    public String getAddress(){
        return address;
    }
    //تابع من اجل تعيين الحالة
    public void setstatus(String s){
        status = s;
    }
    //تابع من اجل ارجاع رقم القسم الذي ينتمي اليه الموظف
    public int getsectionid(){
        return sectionid;
    }
    //تابع لتعيين تاريخ الولادة عن طريق استدعاء تابع من كلاس التاريخ
    public void setBirthDate(int y,int m,int d){
        BirthDate.setDate(y, m, d);
    }
    //تابع لارجاع تاريخ الولادة عن طريق استدعاء تابع من كلاس التاريخ
    public void getBirthDate(){
        BirthDate.printdate();
    }
    //تابع لطباعة معلومات الموظف 
    public void report(){
        System.out.println("Id : "  + id);
        System.out.print("Name : " + name + "\tBirth Date : ");
        BirthDate.printdate();
        System.out.println("\nStatus : " + status);
        System.out.println("Address : " + address);
    }
}
