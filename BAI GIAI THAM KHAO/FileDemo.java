import java.io.File;

public class FileDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		  File f = null;
	      String[] paths;
	      try {    
	      
	         // create new file
	         f = new File("d:/vidujava");
	                      
	         // array of files and directory
	         paths = f.list();
	         
	         // for each name in the path array
	     
	         if(f.exists()) {
	        	 for(int i=0; i<paths.length;i++)
				        	 
	            // prints filename and directory name
	            System.out.println(paths[i]);
	         }
	         else 
	        	 System.out.println("0");
	         
	      } catch(Exception e) {
	      
	         // if any error occurs
	         e.printStackTrace();
	      }
	}

}
