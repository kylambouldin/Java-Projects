public class CountingDownSec {
public static void main(String[] args) throws java.lang.Exception{
 
String str = "2005-1-19-15-20";//date-time with the pattern "yyyy-M-d-k-m"
 
java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat("yyyy-M-d-k-m");
java.util.Date date = formatter.parse(str);
java.util.Timer timer = new java.util.Timer();
long target = date.getTime();//target date-time in Milliseconds
Task0 task = new Task0(target,1);
timer.schedule(task,0L, 1000L);

timer.scheduleAtFixedRate(task, 10, 1000);

}
} 
 