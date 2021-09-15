class VersionStrings {
 
  /* returns 1 if v2 is
  smaller, -1 if v1 is smaller, 0 if equal */
  static int compareVersion(String v1, String v2)
  {
      // vnum stores each numeric part of version
      int vnum1 = 0, vnum2 = 0;

      // loop until both String are processed
      for (int i = 0, j = 0; (i < v1.length()
                              || j < v2.length());) {

        //Processing num part of version 1 in vnum1
          while (i < v1.length()
                 && v1.charAt(i) != '.') {
              vnum1 = vnum1 * 10
                      + (v1.charAt(i) - '0');
              i++;
          }

          //Processing num part of version 1 in vnum1

          while (j < v2.length()
                 && v2.charAt(j) != '.') {
              vnum2 = vnum2 * 10
                      + (v2.charAt(j) - '0');
              j++;
          }

          if (vnum1 > vnum2)
              return 1;
          if (vnum2 > vnum1)
              return -1;
    // reset if both are equal
          vnum1 = vnum2 = 0;
          i++;
          j++;
      }
      return 0;
  }

  public static void main(String[] args)
  {
      String version1 = "1.1";
      String version2 = "1.2";

      // String version1 = "1.0.2";
      // String version2 = "1.0.5";

      if (compareVersion(version1, version2) < 0)
          System.out.println(version1 + " is smaller");
      else if (compareVersion(version1, version2) > 0)
          System.out.println(version2 + " is smaller");
      else
          System.out.println("Both are equal");
  }
}