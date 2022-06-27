// package Alumni;
import java.sql.*;
import java.util.*;
public class Alumnidatabase {
public static void main(String[] args) throws SQLException {
int n=0;
System.out.println("######################");
Scanner scanner=new Scanner(System.in);
while(n!=5) {
System.out.println("The available choice : ");
System.out.println("1.Add the person ");
System.out.println("2.Delete the person ");
System.out.println("3.update the person");
System.out.println("4.select the person");
System.out.println("5.Exit ");System.out.println("Enter the choice : ");
n=scanner.nextInt();
switch(n){
case 1 :adding();
break;
case 2 :deleting();
break;
case 3 :updating();
break;
case 4 :selecting();
break;
case 5:break;
default:System.out.println("Enter the correct value ");
break;
}
}
System.out.println("######################");
}
static void adding() throws SQLException {
String name,regno,dept,city;
int batchno,n;Scanner s=new Scanner(System.in);
System.out.println("==============================");
System.out.println("How many person you are going to add");
n=s.nextInt();
Connection
con=DriverManager.getConnection("jdbc:mysql://localhost:3308/custo
mers","root","20csr@044");
Statement stm=con.createStatement();
while(n!=0) {
System.out.println("Enter the name:");
name=s.next();
System.out.println("Enter the register number:");
regno=s.next();
System.out.println("Enter the batch number:");
batchno=s.nextInt();
System.out.println("Enter the department studied:");
dept=s.next();
System.out.println("Enter the city leaving now:");
city=s.next();
String str="INSERT INTO details (regno,name,batchno,dept,city)
VALUES('"+regno+"','"+name+"',"+batchno+",'"+dept+"','"+city+"');";
stm.execute(str);
n=n-1;}
System.out.println("==============================");
con.close();
}
static void deleting() throws SQLException {
String regno;
Scanner s=new Scanner(System.in);
System.out.println("==============================");
System.out.println("Enter the register number which you want to
delete :");
regno=s.next();
Connection
con=DriverManager.getConnection("jdbc:mysql://localhost:3308/custo
mers","root","20csr@044");
Statement stm=con.createStatement();
String str="DELETE FROM details WHERE regno='"+regno+"';";
stm.execute(str);
System.out.println("==============================");
con.close();
}
static void updating() throws SQLException {String name,regno,regno1,str,dept,city;
int batchno,n=9;
Scanner s=new Scanner(System.in);
System.out.println("==============================");
System.out.println("Enter the register number which you want to
update:");
regno=s.next();
Connection
con=DriverManager.getConnection("jdbc:mysql://localhost:3308/custo
mers","root","20csr@044");
Statement stm=con.createStatement();
while(n!=6) {
System.out.println("1. name:");
System.out.println("2.register number:");
System.out.println("3.batch number:");
System.out.println("4. department studied:");
System.out.println("5.city :");
System.out.println("6.Exit");
System.out.println("Enter the choice :");
n=s.nextInt();
switch(n){
case 1 :
System.out.println("Enter the name:");name=s.next();
str="UPDATE details SET name='"+name+"' WHERE
regno='"+regno+"';";
stm.execute(str);
break;
case 2 :
System.out.println("Enter the register number:");
regno1=s.next();
str="UPDATE details SET regno='"+regno1+"' WHERE
regno='"+regno+"';";
stm.execute(str);
break;
case 3 :
System.out.println("Enter the batch number:");
batchno=s.nextInt();
str="UPDATE details SET batchno="+batchno+" WHERE
regno='"+regno+"';";
stm.execute(str);
break;
case 4 :
System.out.println("Enter the department:");
dept=s.next();
str="UPDATE details SET dept='"+dept+"' WHERE regno='"+regno+"';";stm.execute(str);
break;
case 5:
System.out.println("Enter the city name :");
city=s.next();
str="UPDATE details SET city='"+city+"' WHERE regno='"+regno+"';";
stm.execute(str);
break;
case 6:break;
default:System.out.println("Enter the correct value ");
break;
}
}
System.out.println("==============================");
con.close();
}
static void selecting() throws SQLException {
String name,str="",city,dept,regno;
int n=5,num=0,batchno;
Scanner s=new Scanner(System.in);Connection
con=DriverManager.getConnection("jdbc:mysql://localhost:3308/custo
mers","root","20csr@044");
Statement stm=con.createStatement();
System.out.println("==============================");
while(n!=3) {
System.out.println("1.show all");
System.out.println("2.show the entered register number");
System.out.println("3.exit");
System.out.println("Enter the choice :");
n=s.nextInt();
switch(n) {
case 1:str="SELECT * FROM details";
num=1;
break;
case 2:
System.out.println("Enter the regioster number:");
regno=s.next();
str="SELECT * FROM details where regno='"+regno+"';";
num=1;
break;
case 3:break;
default:System.out.println("Ennter the correct value");break;
}
if(n!=0) {
ResultSet out=stm.executeQuery(str);
System.out.println("regno\t\tname\tbatchno\tdept\tcity");
while(out.next()) {
regno=out.getString("regno");
name=out.getString("name");
batchno=out.getInt("batchno");
dept=out.getString("dept");
city=out.getString("city");
System.out.println(regno+"\t"+name+"\t"+batchno+"\t"+dept+"\t"+cit
y);
}
}
}
System.out.println("==============================");
con.close();
}
}