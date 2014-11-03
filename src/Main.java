import java.util.ArrayList;
import java.util.List;

public class Main {

    static List<String> harfListesi = new ArrayList<String>();
    static int count = 0;

    public static void main(String[] args) {

        harfListesi.add("A");
        harfListesi.add("B");
        harfListesi.add("C");
        harfListesi.add("D");
        harfListesi.add("E");
        harfListesi.add("F");
        harfListesi.add("G");


        harfleriDiz(new ArrayList<String>(harfListesi), new ArrayList<String>());
        System.out.println(count);
    }

    private static void harfleriDiz(List<String> harfler, List<String> kelime) {

        for (String harf : harfler) {
            if (kuralaUygunMu(kelime, harf)) {
                List<String> harflerNew = new ArrayList<String>(harfler);
                harflerNew.remove(harf);
                List<String> kelimeNew = new ArrayList<String>(kelime);
                kelimeNew.add(harf);
                harfleriDiz(harflerNew, kelimeNew);


                if (kelimeNew.size() == harfListesi.size()) {
                    System.out.println(kelime);
                    count++;
                }
            }

        }

    }

    private static boolean kuralaUygunMu(List<String> kelime, String yeniHarf) {
        if (kelime.size() == 0) {
            return true;
        } else if (Math.abs(harfListesi.indexOf(kelime.get(kelime.size() - 1)) - harfListesi.indexOf(yeniHarf)) != 1) {
            return true;
        // 'C' ve 'D' alfabetik olarak birbirini takip etmediği için (arada 'Ç' harfi var) yanyana gelebilir.
        // Bu yüzden bu durumu exclude ediyoruz.
        } else if (kelime.get(kelime.size() - 1).equals("C") & yeniHarf.equals("D")) {
            return true;
        } else if (kelime.get(kelime.size() - 1).equals("D") & yeniHarf.equals("C")) {
            return true;
        } else {
            return false;
        }
    }


}
