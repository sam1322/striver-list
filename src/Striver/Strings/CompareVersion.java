package Striver.Strings;

import java.util.ArrayList;
import java.util.List;

public class CompareVersion {
    private static List<Integer> findVersion(String version) {
        int i = 0;
        int n = version.length();
        List<Integer> list = new ArrayList<>();
        int cnt = 0;
        while (i < n) {
            char ch = version.charAt(i);
            if (ch == '.') {
                list.add(cnt);
                cnt = 0;
            } else {
                cnt = cnt * 10 + (ch - '0');
            }
            i++;
        }
        list.add(cnt);
        return list;
    }

    public static int compareVersion1(String version1, String version2) {
        List<Integer> v1 = findVersion(version1);
        List<Integer> v2 = findVersion(version2);
        int n = v1.size();
        int m = v2.size();
        int i = 0;
        int j = 0;
        System.out.println(v1);
        System.out.println(v2);
        while (i < n && j < m) {
            if (v1.get(i) < v2.get(j)) {
                return 1;
            } else if (v1.get(i) > v2.get(i)) {
                return -1;
            }
            i++;
            j++;
        }
        return 0;
    }

    public static int compareVersion(String version1, String version2) {
        int i = 0, j = 0, n1 = version1.length(), n2 = version2.length(), num1 = 0, num2 = 0;
        while (i < n1 || j < n2) {
            while (i < n1 && version1.charAt(i) != '.') {
                num1 = num1 * 10 + (version1.charAt(i) - '0');
                i++;
            }
            while (j < n2 && version2.charAt(j) != '.') {
                num2 = num2 * 10 + (version2.charAt(j) - '0');
                j++;
            }
            if (num1 > num2) {
                return 1;
            }
            if (num1 < num2) {
                return -1;
            }
            i++;
            j++;
            num1 = 0;
            num2 = 0;
        }
        return 0;
    }

    public static void main(String[] args) {
        String v1 = "1.2";
        String v2 = "1.10";
        System.out.println(compareVersion(v1, v2));
        v1 = "1.01";
        v2 = "1.001";
        System.out.println(compareVersion(v1, v2));
        v1 = "1.0";
        v2 = "1.0.0.0";
        System.out.println(compareVersion(v1, v2));
    }
}
