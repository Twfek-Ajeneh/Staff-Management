package Company;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

public class MainClass {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("\t\t\t\t\t\t\t\t\t\t===================");
        System.out.println("\t\t\t\t\t\t\t\t\t\t<<<<<<<HELLO>>>>>>>");
        System.out.println("\t\t\t\t\t\t\t\t\t\t===================");
        //switchيتم تعريف متحولات لعدد الموظفين و عدد الاقسام ومتحول من اجل حلقة 
        int n,m,a;
        //ادخال عدد  الاقسام 
        System.out.print("Enter the number of sections : ");
        m = input.nextInt();
        // mعدد عناصرها يساوي sectionتعريف مصفوفة من نوع 
        Section []section = new Section[m];
        //بدء حلقة واستدعاء تابع اضافة قسم الذي يعيد متحول من نوع قسم يتم اسناده الى مصفوفة
        for(int i=0;i<m;i++)
            section[i] = AddSection();
        //////////////////////////////
        //ادخال عدد الموظفين
        System.out.print("Enter the number of Employees : ");
        n = input.nextInt();
        // المدخلةnمن اجل تابع اضافة موظف كي استطيع زيادة حجم المصفوفة عن50تم تعريفها بعدد معين وهو Employeeتعريف مصفوفة من نوع 
        Employee []employee = new Employee[50];
        System.out.println("Choose (1) for Normal Employee,(2) for Full Time Employee"
                         + ",(3) for Long Serving Employee,(4) for Part Time Employee :");
        //بدء حلقة واستدعاء تابع اضافة موظف الذي يعيد متحول من نوع موظف واسناده الو مصفوفة
        for(int i=0;i<n;i++)
            employee[i] = AddEmployee();
        //استدعاء تابع لترتيب مصفوفة الموظفين جسب رقم الموظف
        ArrangeArray(n,employee);
        //استدعاء تابع لفرز الموظفين على اقسام
        SortEmployee(n,m,section,employee);
        ///////////////////////////////
        //بعد انتهاء من ادخال اقسام و موظفين تبدأ التطبيقات عليهم
        System.out.println("Enter 1 to Add new Employee, 2 to Add leave to an employee, 3 to show contract employees"
                         + ", 4 to see employee leave, 5 to end employee service, 6 to delete an employee,"
                         + "\n7 to see section employees, 8 to print section information, 9 to print information of all employees"
                         + ", 0 to exit : ");
        // من اجل اعادة الاختيار حتى ادخال رقم صفرdoحلقة 
        //بداخلها من اجل اختيار بين عملياتswitchوحلقة 
        do{
            System.out.print("Your choice : ");
            a = input.nextInt();
            switch (a){
                case 1:
                    //حالة اولى اضافة موظف 
                    //1نقوم بزيادة عدد الموظفين بمقدار 
                    n = n+1;
                    System.out.println("Choose (1) for Normal Employee,(2) for Full Time Employee"
                                       + ",(3) for Long Serving Employee,(4) for Part Time Employee :");
                    //نستدعي تابع اضافة موظف ونسند الموظف الى المكان الجديد بالمصفوفة
                    employee[n-1] = AddEmployee();
                    //نعيد استدعاء تابع ترتيب المصفوفة لترتيب العنصر الجديد
                    ArrangeArray(n,employee);
                    break;
                case 2:
                    //حالة ثانية اضافة اجازة لموظف
                    AddLeave(n,employee);
                    System.out.println("=====================");
                    break;
                case 3:
                    //حالة تالتة اظهار موظفين متعاقدين
                    ShowPartEmployee(n,employee);
                    System.out.println("=====================");
                    break;
                case 4:
                    //حالة رابعة اظهار اجازة موظف
                    ShowLeave(n,employee);
                    System.out.println("=====================");
                    break;
                case 5:
                    //حالة خامسة انهاء خدمة موظف
                    EmployeeSeparation(n,employee);
                    System.out.println("=====================");
                    break;
                case 6:
                    //حالة سادسة حذف موظف
                    n = DeleteEmployee(n,employee);
                    System.out.println("=====================");
                    /*
                    idلانه في حالة عدم تطايق ال nمن اجل اعادة قيمة الintهنا تم تعريف االتابع 
                    او عدم تغييرها في التابعnمن اجل تغيير قيمة الreferancميزة javaلا يتم حذف اي موظف وفي حالة وجود تطابق يتم حذف موظف و لا يوجد في ال 
                    */
                    break;
                case 7:
                    //حالة سابعة طباعة معلومات موظفين قسم معين
                    //موظفين لكل قسمlistحلقة من اجل مرور على كل اقسام واستدعاء تابع حذف 
                    for(int j=0;j<m;j++)
                        section[j].removesectionemployee();
                    //اعادة استدعاء تابع فرز الموظفين على اقسام
                    SortEmployee(n,m,section,employee);
                    //استدعاء تابع طباعة معلومات موظفين في قسم معين
                    PrintSEmployee(m,section);
                    System.out.println("=====================");
                    /*واعادة الاسناد في هذا الحالة وبالتي تليهاlist لقد قمت بعملية حذف 
                    الخ....لانه عند القيام بأي من عمليات الحذف او اضافة اجازة او انهاء خدمة
                    يتم تغير الببانات فقط في مصفوفة موظفين اما معلومات في اقسام لا تتغير لذلك 
                    نقوم باعادة اسناد من اجل تطبيق كل تغيرات على اقسام ايضا*/
                    break;
                case 8:
                    //حالة ثامنة طباعة معلومات جميع الاقسام
                    //نفس عملية اعادة اسناد
                    for(int j=0;j<m;j++)
                        section[j].removesectionemployee();
                    SortEmployee(n,m,section,employee);
                    PrintSection(m,section);
                    System.out.println("=====================");
                    break;
                case 9:
                    //حالة تاسعة طباعة مصفوفة موظفين
                    int c=0;
                    for(int i=0;i<n;i++){
                        employee[i].report();
                        System.out.println("----------------");
                        c++;
                    }
                    if(c == 0)
                        System.out.println("Sorry!! There are no employees to print their information.");
                    System.out.println("=====================");
                    break;
                default:
                    System.out.println("=====================");
                    break;
            }  
        }while(a != 0);
        System.out.println("===========================THANK YOU===========================");
    }
    
    //////////////////////////////////////////////////////////////////////////
    
    //تابع لانشاء قسم حيث يقوم بارجاع متحول من نوع قسم
    public static Section AddSection(){
        Scanner input = new Scanner(System.in);
        //تعريف المتحولات من اجل انشاء الاوبجيكت
        int sectionID;
        String sectionname;
        Employee sectionhead;
        List <Employee> sectionemployee = new ArrayList <> ();
        System.out.println("Enter section information : ");
        //ادخال رقم القسم
        System.out.print("Enter the section ID : ");
        sectionID = input.nextInt();
        //ادخال اسم القسم
        System.out.print("Enter the name of section : ");
        sectionname = input.next();
        //من اجل رئيس القسم يتم انشاء موظف جديدغير الموظفين الموجودين داخل مصفوفة الموظفين
        System.out.println("Enter the section head information :");
        System.out.println("Choose (1) for Normal Employee,(2) for Full Time Employee"
                         + ",(3) for Long Serving Employee,(4) for Part Time Employee : ");
        sectionhead = AddEmployee();
        //mainالموظفين فارغةحيث يتم اسناد الموظفين اليها بعد ادخالهم بالlistيتم انشاء الاوبجيكت بتمرير القيم المدخلة وتبقى 
        Section s = new Section(sectionID,sectionname,sectionhead,sectionemployee);
        return s;   
    }
    //تابع لطباعة معلومات الاقسام
    public static void PrintSection(int m,Section []section){
        //يتم تمرير عدد الاقسام ومصفوفة الاقسام الى التابع
        int c=0;
        for(int i=0;i<m;i++){
            //يتم استدعاء تابع طباعة المعلومات من كلاس القسم لكل عنصر من مصفوفة
            section[i].report();
            c++;
        }
        // تساوي الصفر cاذا لم يكن هناك اي اقسام فتبقى قيمة 
        if(c == 0)
            System.out.println("Sorry!! There are no section to print their information.");
    }
    //تابع لطباعة معلومات الموظفين الموجودين بقسم ما
    public static void PrintSEmployee(int m,Section []section){
        //يتم تمرير عدد الاقسام ومصفوفة الاقسام
        Scanner input = new Scanner(System.in);
        //انشاء متحول من اجل ان يدخل اليوزر رقم القسم المراد عرض معلومات موظفيه
        int sectionid,c=0,d=0;
        System.out.print("Enter section ID to display employees : ");
        sectionid = input.nextInt();
        //يتم المرور على كل اقسام
        for(int i=0;i<m;i++){
            if(sectionid == section[i].getsectionID()){
                //عند وجود تطابق برقم القسم يتم استدعاء تابع طباعة معلومات الموظفين من كلاس القسم ثم الخروج من الحلقة
                    section[i].printsemployee();
                    d++;
            }
            c++;
        }
        //تساوي الصفرcاذا لم يكن هناك اي قسم موجود تبقى قيمة 
        if(c == 0)
            System.out.println("Sorry!! There are no section to print their employees information.");
        //تساوي الصفرdلكن ان لم يكن هناك تتطابق مع اي قسم تبقى forاذا كان يوجد اقسام فيدخل الى حلقة ال
        else if(d == 0)
            System.out.println("Sorry!! No section has this ID.");
        
    }
    //تابع من اجل فرز الموظفين على اقسام 
    public static void SortEmployee(int n,int m,Section []section,Employee []employee){
        //يتم تمرير عدد الموظفين و عدد القسام وكل من مصفوفة الموظفين والاقسام
        //Employeeانشاء متحول نوع 
        Employee e;
        //من اجل المرور على كل الموظفينforحلقة 
        for(int i=0;i<n;i++)
            //من اجل مقارنة كل موظف مع جميع القسامforحلقة 
            for(int j=0;j<m;j++)
                if(employee[i].getsectionid() == section[j].getsectionID()){
                    //اذا وجد تطابق بين رقم القسم الخاص بالموظف ورقم القسم الاساسي
                   e = employee[i]; 
                   //الموظفين وتمرير المتحول لهlistيتم استدعاء تابع اضافة العناصر الى 
                   section[j].sectionemployee.add(e);
                }
    }
    
    //////////////////////////////////////////////////////////////////////////
    
    //Employeeتابع من اجل انشاء موظف حيث يرجع متحول من نوع 
    public static Employee AddEmployee(){
        Scanner input = new Scanner(System.in);
        //يتم انشاء متحولات المطلوبة من اجل انشاء الاوبجيكت
        int x,id,year,month,day,workyears,sectionid;
        double salary,workedhours;
        String name,address;
        Employee e;
        //هنا يتم ادخال متحول من اجل تحديد نوع الموظف المراد انشائه
        System.out.print("Your choice : ");
        x = input.nextInt();
        switch (x){
                case 1:
                    //حالة اولى من اجل انشاء موظف عادي
                    System.out.println("Enter employee information :");
                    System.out.print("Enter the employee's ID : ");
                    id = input.nextInt();
                    System.out.print("Enter the employee's name : ");
                    name = input.next();
                    System.out.print("Enter the employee's address : ");
                    address = input.next();
                    System.out.println("Enter the employee's birthday : ");
                    System.out.print("Year : ");year = input.nextInt();
                    System.out.print("Month : ");month = input.nextInt();
                    System.out.print("Day : ");day = input.nextInt();
                    System.out.print("Enter the ID of section to add the employee : ");
                    sectionid = input.nextInt();
                    //بعد ادخال جميع المعلومات المطلوبة يتم تمريرها وانشاء اوبجيكت
                    e = new Employee(id,name,address,year,month,day,sectionid);
                    System.out.println("=====================");
                    // eوارجاع متحول switchثم نقوم بالخروج من حلقة 
                    break;
                case 2:
                    //full timeحالة تانية من اجل انشاء موظف من نوع 
                    System.out.println("Enter employee information :");
                    System.out.print("Enter the employee's ID : ");
                    id = input.nextInt();
                    System.out.print("Enter the employee's name : ");
                    name = input.next();
                    System.out.print("Enter the employee's address : ");
                    address = input.next();
                    System.out.println("Enter the employee's birthday : ");
                    System.out.print("Year : ");year = input.nextInt();
                    System.out.print("Month : ");month = input.nextInt();
                    System.out.print("Day : ");day = input.nextInt();
                    System.out.print("Enter the employee's salary : ");
                    salary = input.nextDouble();
                    System.out.print("Enter the number of years of service : ");
                    workyears = input.nextInt();
                    System.out.print("Enter the ID of section to add the employee : ");
                    sectionid = input.nextInt();
                    //بعد ادخال حميع المعلومات المطلوبة يتم تمريرها وانشاء اوبجيكت
                    e = new FullTimeEmployee(id,name,address,year,month,day,sectionid,salary,workyears);
                    System.out.println("=====================");
                    //eنفس خطوة خروج وارجاع 
                    break;
                case 3:
                    //long sarvingحالة تالتة من اجل انشاء موظف من نوع 
                    System.out.println("Enter employee information :");
                    System.out.print("Enter the employee's ID : ");
                    id = input.nextInt();
                    System.out.print("Enter the employee's name : ");
                    name = input.next();
                    System.out.print("Enter the employee's address : ");
                    address = input.next();
                    System.out.println("Enter the employee's birthday : ");
                    System.out.print("Year : ");year = input.nextInt();
                    System.out.print("Month : ");month = input.nextInt();
                    System.out.print("Day : ");day = input.nextInt();
                    System.out.print("Enter the employee's salary : ");
                    salary = input.nextDouble();
                    //15نلاحظ هنا لم يتم طلب ادخال سنوات الخدمة لانها افتراضيا 
                    System.out.print("Enter the ID of section to add the employee : ");
                    sectionid = input.nextInt();
                    //بعد ادخال جميع المعلومات المطلوبة يتم تمريرها وانشاء الاوبجيكت
                    e = new LongServingEmployee(id,name,address,year,month,day,sectionid,salary);
                    System.out.println("=====================");
                    //eخروج وارجاع 
                    break;
                case 4:
                    //part timeحالة رابعة من اجل انشاء موظف من نوع 
                    System.out.println("Enter employee information :");
                    System.out.print("Enter the employee's ID : ");
                    id = input.nextInt();
                    System.out.print("Enter the employee's name : ");
                    name = input.next();
                    System.out.print("Enter the employee's address : ");
                    address = input.next();
                    System.out.println("Enter the employee's birthday : ");
                    System.out.print("Year : ");year = input.nextInt();
                    System.out.print("Month : ");month = input.nextInt();
                    System.out.print("Day : ");day = input.nextInt();
                    System.out.print("Enter the number of working hours : ");
                    workedhours = input.nextDouble();
                    System.out.print("Enter the ID of section to add the employee : ");
                    sectionid = input.nextInt();
                    //بعد ادخال المعلومات المطلوبة يتم تمريرها وانشاء اوبجيكت
                    e = new PartTimeEmployee(id,name,address,year,month,day,sectionid,workedhours);
                    System.out.println("=====================");
                    //eخروج وارجاع 
                    break;
                default:
                    //هنا اذا تم ادخال رقم غير جميع الحالات يتم انشاء الموظف كموظف عادي ويتم تعبئة المعلومات افتراضيا عبر بناء افراضي
                    System.out.println("You entered the wrong number,The data will be filled in by default!!!");
                    e = new Employee();
                }
        return e;
    }
    // الموظفidتابع من  اجل ترتيب مصفوفة الموظفين حسب 
    public static void ArrangeArray(int n,Employee []employee){
        // من اجل المساعدة في عمليات الاسنادEmployeeانشاء متحول نوع 
        Employee temp;
        //من اجل اجراء المقارنة بين ارقام الموظفينfor حلقتين 
        for(int i=0;i<n-1;i++)
            for(int j=i+1;j<n;j++)
                if(employee[i].getNum() > employee[j].getNum()){
                    temp = employee[i];
                    employee[i] = employee[j];
                    employee[j] = temp;
                }
    }
    //تابع من اجل اضافة اجازة لموظف معين
    public static void AddLeave(int n,Employee []employee){
        //تم تمرير عدد االموظفين ومصفوفة الموظفين
        Scanner input = new Scanner(System.in);
        //مطلوبidتم تعريف متحول من اجل ادخال 
        int a,c=0;
        System.out.print("Enter the employee ID to add the leave :");
        a = input.nextInt();
        //يتم المرور على كل الموظفين من اجل ايجاد الموظف المطلوب
        for(int i=0;i<n;i++)
            if(a == employee[i].getNum()){
                //على الاجازات الاضافية1اذا وجد نطابق يتم استدعاء تابع يضيف 
               employee[i].setadditionalleave(1);
               System.out.println("A leave was added to the employee.");
               c++;
               break;
            }
        // تساوي الصفرcالمطلوب تبقى idاذا لم يتم ايجاد موظف يملك ال
        if(c == 0)
            System.out.println("Sorry!! No employee has this ID.");      
    }
    //تابع من اجل طباعة جميع الموظفين المتعاقدين
    public static void ShowPartEmployee(int n,Employee []employee){
        //تم تمرير عدد الموظفين ومصفوفة الموظفين
        int c=0;
        //يتم المرور على جميع الموظفين
        for(int i=0;i<n;i++)
            if(employee[i].status == "Contracting Employee."){
                //اذا وجد تطابق بنوع الحالة يتم استدعاء تابع طباعة المعلومات من اجل هذا الموظف
                employee[i].report();
                System.out.println("----------------");
                c++;
            }
        //تساوي الصفرCاما لا يوجد موظفين متعاقدين فتبقى 
        if(c == 0)
            System.out.println("Sorry!! There are no contract employees.");
        //او يوجد ويتم طباعة عدد الموظفين المتعاقدين بالنهاية
        else
            System.out.println("The number of contract employees : " + c);
    } 
    //تابع من اجل اظهار الاجازات المستحقة لموظف معين
    public static void ShowLeave(int n,Employee []employee){
        //يتم تمرير عدد الموظفين ومصفوفة الموظفين
        Scanner input = new Scanner(System.in);
        int a,c=0;
        //يتم ادخال رقم الموظف المطلوب
        System.out.print("Enter the employee ID to see his leave : ");
        a = input.nextInt();
        //يتم المرور على جميع الموظفين
        for(int i=0;i<n;i++)
            if(a == employee[i].getNum()){
                //اذا وجد تطابق مع احد الموظفين تتم طباعة اجازات هذا الموظف ثم الخروج من حلقة
                //تتم الطباعة عن طريق استدعاء تابع يعيد الاجازات و تابع يعيد الاجازات الاضافية
                System.out.println("Number of employee Leave : " + (employee[i].getadditionalleave() + employee[i].getleave()));
                c++;
                break;
            }
        //تساوي الصفرcاذا لم يتم ايجاد تطابق تبقى قيمة 
        if(c == 0)
            System.out.println("Sorry!! No employee has this ID.");
    }
    //تابع من اجل انهاء خدمة موظف معين
    public static void EmployeeSeparation(int n,Employee []employee){
        //تم تمرير عدد الموظفين ومصفوفة الموظفين
        Scanner input = new Scanner(System.in);
        int a,c=0;
        //يتم ادخال رقم الموظف المطلوب
        System.out.print("Enter the employee ID to end his service : ");
        a = input.nextInt();
        //يتم المرور على كل الموظفين
        for(int i=0;i<n;i++)
            if(a == employee[i].getNum()){
                //اذا وجد تطابق يتم استدعاء تابع من اجل تغيير حالة الموظف الى موظف منهي الخدمة والخروج من الحلقة
                employee[i].setstatus("Service Terminated.");
                System.out.println("The employee has been terminated.");
                c++;
                break;
            }
        //اذا لم يوجد تطابق
        if(c == 0)
            System.out.println("Sorry!! No employee has this ID.");
    }
    //تابع من اجل حذف موظف معين
    public static int DeleteEmployee(int n,Employee []employee){
        //يتم تمرير عدد الموظفين ومصفوفة الموظفين
        Scanner input = new Scanner(System.in);
        int a,c=0,b=n;
        //يتم ادخال رقم الموظف المطلوب
        System.out.print("Enter the employee ID you want to delete : ");
        a = input.nextInt();
        //يتم المرور على كل الموظفين
        for(int i=0;i<n;i++)
            if(a == employee[i].getNum()){
                //اذا وجد تطابق نبدا بحلقة من اجل ازاحة جميع الموظفين الى الوراء في المصفوفة
               for(int j=i;j<n-1;j++)
                   employee[j] = employee[j+1];
               System.out.println("The employee has been deleted.");
               c++;
               b = n-1;
               break;
            }
        //اذا لم يوجد تطابق
        if(c == 0)
            System.out.println("Sorry!! No employee has this ID.");
        return b;
    }
    
}