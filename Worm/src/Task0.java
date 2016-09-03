class Task0 extends java.util.TimerTask{
long targ;
int level;
Task0(long target, int level){// constructor
		 this.targ = target;
		 this.level = level;
    }
private int n=Integer.MAX_VALUE;
public String currentn;
 
//run method..
public void run(){ 
	 n = (int)((this.targ/(1000L)));
     //System.out.println("remaining seconds:" + String.valueOf(n));
     currentn = String.valueOf(n);
      targ -= 1000;
	if(n==0){
	  try{
		new End(0,level,this);
	    System.out.println("Time is up!num1");
        this.cancel();
        // System.exit(0);
      }catch(java.lang.RuntimeException ex){throw ex;}
     }//end of if
	
	
	/*else if(targ==-1){
		  try{
		    System.out.println("Time is up!num2");
	          // ..Do something useful..
	        this.cancel();
	        // System.exit(0);
	      }catch(java.lang.RuntimeException ex){throw ex;}
	     }//end of if */
}


public void exit(){
	this.cancel();
}
public String getN(){
	return currentn;
}
public void setTarg(int x){
	targ = x;
	if(targ==-1){
		  try{
		    System.out.println("Time is up!num2");
	          // ..Do something useful..
	        this.cancel();
	        // System.exit(0);
	      }catch(java.lang.RuntimeException ex){throw ex;}
	     }//end of if
}
}