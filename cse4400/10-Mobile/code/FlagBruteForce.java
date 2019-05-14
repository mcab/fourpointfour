public class FlagBruteForce
{
    public static void test1(String t) {
        boolean r0;

        r0 = t.startsWith("MOBISEC{");
        System.out.print("starts with MOBISEC{? " + (r0 == true ? "yes" : "no"));
        System.out.println(" | test1");
    }

    public static void test2(String t) {
        java.lang.StringBuilder r0;
        String r1;
        int r2, r3;

        r0 = new java.lang.StringBuilder(t);
        r0 = r0.reverse();

        r1 = r0.toString();
        r2 = r1.charAt(0);
        r3 = 125;
        System.out.print("ends with }? " + (r2 == r3 ? "yes" : "no"));
        System.out.println(" | test2");
    }

    public static void test3(String t) {
        int r2 = 35;
        System.out.print("35 char in length? " + (r2 == t.length() ? "yes" : "no"));
        System.out.println(" | test3");
    }

    public static void test4(String t) {
        /*
        r0 = r11.toLowerCase();
        r2 = 8;
        r0 = r0.substring(r2);
        r3 = "this_is_";
        r0 = r0.startsWith(r3);
        if (r0 != 0) goto L_0x003c;
        */
        String r0 = t.toLowerCase();
        int r2 = 8;
        String r1 = r0.substring(r2);
        String r3 = "this_is_";
        boolean r4 = r1.startsWith(r3);
        // MOBISEC{this_is_ }
        System.out.print("does flag start with 'this_is_'? " + (r4 == true ? "yes" : "no"));
        System.out.println(" | test4");
    }

    public static void test5(String t) {
        /*
        r0 = new java.lang.StringBuilder;
        r0.<init>(r11);
        r0 = r0.reverse();
        r0 = r0.toString();
        r0 = r0.toLowerCase();
        r3 = 1;
        r0 = r0.substring(r3);
        r4 = 2131427368; // 0x7f0b0028 float:1.847635E38 double:1.053065039E-314;
        r4 = r10.getString(r4);
        r0 = r0.startsWith(r4);
        if (r0 != 0) goto L_0x0060;
        */
        StringBuilder r0 = new StringBuilder(t);
        String r1 = r0.reverse().toString().toLowerCase();
        int r3 = 1;
        String r4 = r1.substring(r3);
        String r5 = "ver_cis";
        boolean r6 = r4.startsWith(r5);
        
        System.out.print("does flag start end with 'sic_rev? " + (r6 == true ? "yes" : "no"));
        System.out.println(" | test5");
    }

    public static void test6(String t) {
        /*
        r0 = 17;
        r0 = r11.charAt(r0);
        r4 = 95;
        if (r0 != r4) goto L_0x0116;
        */
        int r0 = 17;
        int r1 = t.charAt(r0);
        int r2 = 95;
        
        System.out.print("is char 17 a '_'? " + (r1 == r2 ? "yes" : "no"));
        System.out.println(" | test6");
    }

    public static void test7(String t) {
        /*
        r4 = (double) getY();
        r6 = (double) getX();
        r8 = (double) getY();
        r6 = java.lang.Math.pow(r6, r8);
        r4 = r4 * r6;
        r0 = (int) r4;
        r0 = r11.charAt(r0);
        r4 = 4611686018427387904; // 0x4000000000000000 float:0.0 double:2.0;
        r6 = java.lang.Math.pow(r4, r4);
        r4 = java.lang.Math.pow(r6, r4);
        r4 = (int) r4;
        r4 = r4 + r3;
        r4 = r11.charAt(r4);
        */
        int x = 2;
        int y = 3;
        boolean result = (t.charAt((int) (((double) y) * Math.pow((double) x, (double) y))) == t.charAt(((int) Math.pow(Math.pow(2.0d, 2.0d), 2.0d)) + 1));

        System.out.print("checking for _ positions @ 17 and 24: " + (result == true ? "yes" : "no"));
        System.out.println(" | test7");
    }

    private static String bam(String s) {
        String out = "";
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c >= 'a' && c <= 'm') {
                c = (char) (c + 13);
            } else if (c >= 'A' && c <= 'M') {
                c = (char) (c + 13);
            } else if (c >= 'n' && c <= 'z') {
                c = (char) (c - 13);
            } else if (c >= 'N' && c <= 'Z') {
                c = (char) (c - 13);
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(out);
            stringBuilder.append(c);
            out = stringBuilder.toString();
        }
        return out;
    }

    public static void test8(String t) {
        /*
        r0 = r11.toUpperCase();
        r4 = getY();
        r5 = getX();
        r4 = r4 * r5;
        r5 = getY();
        r4 = r4 * r5;
        r5 = getZ();
        r5 = (double) r5;
        r7 = getX();
        r7 = (double) r7;
        r5 = java.lang.Math.pow(r5, r7);
        r7 = 4607182418800017408; // 0x3ff0000000000000 float:0.0 double:1.0;
        r5 = r5 - r7;
        r5 = (int) r5;
        r0 = r0.substring(r4, r5);
        r0 = bam(r0);
        r4 = "ERNYYL";
        r0 = r0.equals(r4);
        */
        boolean result = bam(t.substring(18, 24)).toUpperCase().equals("ERNYYL");

        System.out.print("are chars 18-24 ROT13(ERNYYL)? " + (result == true ? "yes" : "no"));
        System.out.println(" | test8");
    }

    public static void test9(String t) {
        /*
        r0 = r11.toLowerCase();
        r4 = 16;
        r0 = r0.charAt(r4);
        r5 = 97;
        */
        String r0 = t.toLowerCase();
        int r1 = 16;
        int r2 = t.charAt(r1);
        int r3 = 97;

        boolean result = r2 == r3;

        System.out.print("is char 16 an 'a'? " + (result == true ? "yes" : "no"));
        System.out.println(" | test9");
    }

    public static void test10(String t) {
        /*
        r0 = r11.charAt(r4);
        r4 = 26;
        r5 = r11.charAt(r4);
        */
        int r1 = t.charAt(16);
        int r2 = t.charAt(26);

        boolean result = r1 == r2;

        System.out.print("is char 16 == 26? " + (result == true ? "yes" : "no"));
        System.out.println(" | test10");
    }

    public static void test11(String t) {
        /*
        r0 = r11.toUpperCase();
        r5 = 25;
        r0 = r0.charAt(r5);
        r5 = r11.toUpperCase();
        r4 = r5.charAt(r4);
        r4 = r4 + r3;
        */
        String r0 = t.toUpperCase();
        int r1 = r0.charAt(25);
        int r2 = r0.charAt(26);
        boolean result = r1 == (r2 + 1);

        System.out.print("is val @ char 26 - 1 of 25? " + (result == true ? "yes" : "no"));
        System.out.println(" | test11");
    }

    public static String getR() {
        String r = "";
        boolean upper = true;
        for (int i = 0; i < 26; i++) {
            StringBuilder stringBuilder;
            if (upper) {
                stringBuilder = new StringBuilder();
                stringBuilder.append(r);
                stringBuilder.append("[A-Z_]");
                r = stringBuilder.toString();
            } else {
                stringBuilder = new StringBuilder();
                stringBuilder.append(r);
                stringBuilder.append("[a-z_]");
                r = stringBuilder.toString();
            }
            upper = !upper;
        }
        return r;
    }

    public static void test12(String t) {
        /*
        r0 = getR();
        r4 = r11.length();
        r4 = r4 - r3;
        r2 = r11.substring(r2, r4);
        r2 = r2.matches(r0);
        */
        String regex = getR();
        int r1 = t.length() - 1;
        String test = t.substring(8, r1);
        boolean result = test.matches(regex);

        System.out.print("does it fulfill the regex? " + (result == true ? "yes" : "no"));
        System.out.println(" | test12");
    }

    public static void test(String t) {
        test1(t);
        test2(t);
        test3(t);
        test4(t);
        test5(t);
        test6(t);
        test7(t);
        test8(t);
        test9(t);
        test10(t);
        test11(t);
        test12(t);
    }

	public static void main(String[] args) {
        test("MOBISEC{ThIs_iS_A_ReAlLy_bAsIc_rEv}");
	}
}