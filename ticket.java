/*
Create the class RRT(Rapid response team) with the below attributes:
ticketNo-int
raisedBy-String
assignedTo-String
priority-int
project-String
All attributes should be private,write getters and setters and parameterized constructor as required.
Create class MyClass with main method.
Implement a static method-getHighestPriorityTicket in MyClass class.
getHighestPriorityTicket method:
This method will take an array of RRT objects ,and a String value as parameters.This method will return the RRT object with highest priority
ticket from the array of the RRT objects for the given project(String parameter passed).Highest priority is the one which has lesser value.
for example:1 is considered as high priority and 5 is considered as low priority.
If no RRT with the above condition is present in the array of the RRT objects,then the method should return null.
The main method should print the ticketNo,raisedBy and assignedTo from returned object if the returned object is not null.if the returned
object is null then main method should print "No such Ticket".
input1:
123
Velantish
Mani
3
Xperience
234
Sathish
Akshaya
1
AIG
345
John
Jack
2
AIG
456
Bhuvi
Jack
5
AIG
AIG
output1:
234
Sathish
Akshaya
**************
Input2:
123
Velantish
Mani
3
Xperience
234
Sathish
Akshaya
1
AIG
345
John
Jack
2
AIG
456
Bhuvi
Jack
5
AIG
Xplore
output2:
No such ticket.
*/
keywords
import java.util.*;
public class ticket
{
    public static void main(String []args)
    {
        tickett arr[]=new tickett[4];
        Scanner sc =new Scanner(System.in);
        for(int i=0;i<arr.length;i++)
        {
            int a=sc.nextInt();sc.nextLine();
            String b=sc.nextLine();
            String c=sc.nextLine();
            int d=sc.nextInt();sc.nextLine();
            String e=sc.nextLine();
            arr[i]=new tickett(a,b,c,d,e);
        }
        String input1=sc.nextLine();
        tickett ars[]=getHighestPriorityTicket(arr,input1);
        if(ars==null)
        {
            System.out.println("nothjing");
        }
        else
        {
            System.out.println(ars[0].getTicketNo());
            System.out.println(ars[0].getRaisedBy());
            System.out.println(ars[0].getAssignedTo());
        }
    }
    public static tickett[] getHighestPriorityTicket(tickett arr[],String input)
    {
        tickett ary[]=new tickett[0];
        for(int i=0;i<arr.length;i++)
        {
            if(arr[i].getProject().equalsIgnoreCase(input))
            {
                ary=Arrays.copyOf(ary,ary.length+1);
                ary[ary.length-1]=arr[i];
            }
        }
        for(int i=0;i<ary.length-1;i++)
        {
            for(int j=0;j<ary.length-i-1;j++)
            {
                if(ary[j].getPriority()>ary[j+1].getPriority())
                {
                    tickett temp=ary[j];
                    ary[j]=ary[j+1];
                    ary[j+1]=temp;
                }
            }
        }
        if(ary.length==0)
        {
            return null;
        }
        else
        {
            return ary;
        }
    }
}
class tickett
{
    private int ticketNo;
    private String raisedBy;
    private String assignedTo;
    private int priority;
    private String project;
    public tickett(int ticketNo,String raisedBy,String assignedTo,int priority,String project)
    {
        super();
        this.ticketNo=ticketNo;
        this.raisedBy=raisedBy;
        this.assignedTo=assignedTo;
        this.priority=priority;
        this.project=project;
    }
    public int getTicketNo()
    {
        return ticketNo;
    }
    public void setTicketNo(int ticketNo)
    {
        this.ticketNo=ticketNo;
    }
    public String getRaisedBy()
    {
        return raisedBy;
    }
    public void setRaisedBy(String rassiedBy)
    {
        this.raisedBy=raisedBy;
    }
    public String getAssignedTo()
    {
        return assignedTo;
    }
    public void setAssignedTo(String asssignedTo)
    {
        this.assignedTo=assignedTo;
    }
    public int getPriority()
    {
        return priority;
    }
    public void setPriority(int priority)
    {
        this.priority=priority;
    }
    public String getProject()
    {
        return project;
    }
    public void setProject(String Project)
    {
        this.project=project;
    }
}