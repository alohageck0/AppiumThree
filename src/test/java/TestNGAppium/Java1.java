package TestNGAppium;

import org.testng.annotations.Test;

public class Java1 {
   @Test(dependsOnGroups = "1", groups = {"smoke"})
   public void Java1() {
      System.out.println("-------------");
      System.out.println("Above should be method from Java2");
      System.out.println("method from Java1");
   }

   @Test(dependsOnGroups = "1", groups = {"smoke"})
   public void Java2() {
      System.out.println("-------------");

      System.out.println("Above should be method from Java2");
      System.out.println("method from Java1");

   }
   @Test
   public void Java3() {
      System.out.println("this method should not run");

   }
}
