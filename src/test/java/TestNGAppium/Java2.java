package TestNGAppium;

import org.testng.annotations.Test;

public class Java2 {
   @Test
   public void Java1() {
      System.out.println("method from Java2(1) executes first");
   }

   @Test(groups = {"1"}, dependsOnMethods = {"Java1"})
   public void Java2() {
      System.out.println("method from Java2(2) executes second");

   }
   @Test
   public void Java3() {
      System.out.println("this method should not run");

   }
}
