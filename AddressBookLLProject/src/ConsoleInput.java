public class ConsoleInput {

   public static String input (String prompt)
   {
       String inputLine = "";
       System.out.print(prompt);
       try
       {
               inputLine = (new java.io.BufferedReader(new
java.io.InputStreamReader(System.in))).readLine();
       }
       catch (Exception e)
       {
               String err = e.toString();
               System.out.println(err);
               inputLine = "";
       }
       return inputLine;
   }

   public static String inputString (String prompt)
   {
       return input(prompt);
   }

   public static String input()
   {
       return input("");
   }

   public static int inputInt()
   {
       return inputInt("");
   }

   public static double inputDouble()
   {
       return inputDouble("");
   }

   public static char inputChar(String  prompt)
   {
       char result = (char)0;
       try
       {
               result = input(prompt).charAt(0);
       }
       catch(Exception e)
       {
               result = (char)0;
       }
       return result;
   }

   public static int inputInt(String prompt)
   {
       int result = 0;
       try
       {
               result = Integer.valueOf(input(prompt).trim()).intValue();
       }
       catch(Exception e)
       {
               result = 0;
       }
       return result;
   }

   public static double inputDouble(String prompt)
   {
       double result = 0;
       try
       {
               result = Double.valueOf(input(prompt).trim()).doubleValue();
       }
       catch(Exception e)
       {
               result = 0;
       }
       return result;
   }

       public static boolean inputBoolean(String prompt)
   {
       boolean result = false;
       try
       {
               result = Boolean.valueOf(input(prompt).trim()).booleanValue();
       }
       catch(Exception e)
       {
               result = false;
       }
       return result;
   }
}