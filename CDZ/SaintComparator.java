import java.util.*;
class SaintCompar implements Comparator<Member> {
   public int compare(Member m1, Member m2) {
      return (m1.ofs.compareTo(m2.ofs));
   }
}