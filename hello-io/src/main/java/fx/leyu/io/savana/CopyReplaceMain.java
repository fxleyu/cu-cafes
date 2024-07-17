package fx.leyu.io.savana;

import com.google.common.collect.Maps;
import org.apache.commons.io.FileUtils;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;

public class CopyReplaceMain {

   public static final Map<String, String> map = Maps.newHashMap();
    static {
        map.put("Savana_IN", "Savana_IQ");
        map.put("en-IN", "ar-IQ");
        map.put("SPORTSWEAR","ملابس رياصية");
        map.put("Loungewear","ملابس منزلية");
        map.put("Cardigans","كارديجان");
        map.put("Sweatshirts","قميص البلوزة");
        map.put("Short dresses","فساتين قصير");
        map.put("Jewelry","جوهرات");
        map.put("Dresses & Jumpsuits","فساتين وجمبسوت");
        map.put("Sexy lingerie","ملابس داخلية نسائية");
        map.put("DRESSES","فساتين");
        map.put("A-line dresses","فساتين طويل ضيقة");
        map.put("DENIM","بنطلون جينز");
        map.put("New in dresses","فساتين جديدة");
        map.put("Bags","حقائب");
        map.put("Hair accessories","زينة الشعر");
        map.put("T-shirts & Tops","القمصاء والقمم");
        map.put("Press on nails","مجموعة أظافر صناعية");
        map.put("New in clothing","حلابس جديد");
        map.put("CURVE","حجم كبير");
        map.put("Shorts","شورت");
        map.put("Blowout sale","مبيعات الانفجار");
        map.put("K-pop zone","منطقة الكيبوب");
        map.put("RSVP ready","جاهز للرد");
        map.put("Black dresses","فساتين سوداء");
        map.put("Sale tops","الأكثر مبيعا");
        map.put("White dresses","فساتين بيضاء");
        map.put("Lingerie sets","بدلة الملابس الداخلية");
        map.put("Curve","حجم كبير");
        map.put("Pants","بنطلون");
        map.put("OCCASION","مناسبة");
        map.put("Date outfits","ثوب حفلات");
        map.put("Coquette aesthetic","جمالية");
        map.put("SWIMWEAR","ملابس السباحة");
        map.put("Skirts & Shorts","تنورة وشورت");
        map.put("Bridgerton inspired","إلهام من");
        map.put("KNITWEAR","ملابس محبوكة");
        map.put("Glasses","نظارة");
        map.put("Vacation ready","جاهز للعطلة");
        map.put("Phone cases","غطاء الهاتف");
        map.put("Bras","حماية صدر نسائية");
        map.put("Bodysuits","يوديسوت");
        map.put("Winter clearance","تخليص الملابس الشتوية");
        map.put("Cami dresses"," فستان كامي");
        map.put("Knitwear","حلابس محبوكة");
        map.put("Jackets & Blazers","جاكيتات وسترات");
        map.put("Shorts & Skirts","شورت وتنورة");
        map.put("Lingerie","ملابس داخلية");
        map.put("NEW IN","جديد");
        map.put("Swimwear","ملابس السباحة");
        map.put("New in curve","حجم كبير جديد");
        map.put("CLOTHING","ملابس");
        map.put("Party dresses","فساتين سهرة");
        map.put("Co-ords & Jumpsuits","مجموعة ملابس علوية وسروال ");
        map.put("Pullovers","سترة بلوفر");
        map.put("T-shirts","قمصاء");
        map.put("Skirts","تنورات");
        map.put("Resort destination","ثوب سفر");
        map.put("Sports bras","حماية صدر رياضية");
        map.put("Sale blouses","قمصاء بأسعار مخفضة");
        map.put("One-pieces","قطعة واحدة");
        map.put("Maxi dresses","فساتين طويلة");
        map.put("Panties","سروال داخلي");
        map.put("LINGERIE & LOUNGEWEAR","الملابس الداخلية والملابس المنزلية");
        map.put("Matching sets","مجموعة الملابس");
        map.put("Fresh blooms","بطباعة أزهار");
        map.put("Blouses","قمصاء");
        map.put("Sale bottoms","قيعان بأسعار مخفضة");
        map.put("Jeans","جينز");
        map.put("Sporty looks","مظهر رياضي");
        map.put("Leggings & Pants","طماق رياضي وبنطلونات");
        map.put("TRENDING","اتجاه");
        map.put("ACCESSORIES & JEWELRY","إكسسوارات ومجوهرات");
        map.put("Bikini sets"," مجموعة بكيني");
        map.put("Dresses","فساتين");
        map.put("New in swimwear","ملابس السباحة الجديدة");
        map.put("Bodycon dresses","فساتين ضيقة ");
        map.put("Sale dresses","فساتين بأسعار مخفضة");
        map.put("Cover ups","غطاء كروشيه");
        map.put("New in denim","بنطلون جينز جديد");
        map.put("Coats & Blazers","معاطف وسترات");
        map.put("Tops","ملابس علوية");
        map.put("Sportswear","ملابس رياضية");
        map.put("SALE 🔥","البيع بأسعار مخفضة");
        map.put("New in sportswear","ملابس رياضية جديدة");
        map.put("Jackets","جاكيتات");
        map.put("SALE","البيع بأسعار مخفضة");
        map.put("Holiday party","حفلات وإجازات");
        map.put("Sports & Gym","رياضة وأنشضة خارجية");
        map.put("Daily","يومية");
    }
    public static void main(String[] args) throws IOException {
        ClassPathResource resource = new ClassPathResource("category.sql");
        FileUtils.readLines(resource.getFile(), "utf-8")
                .stream()
                .forEach(x -> {


                });

        resource = new ClassPathResource("category_config.sql");
        FileUtils.readLines(resource.getFile(), "utf-8")
                .stream()
                .forEach(x -> {
                    for (Map.Entry<String, String> stringStringEntry : map.entrySet()) {
                        x = x.replaceAll(stringStringEntry.getKey().trim(), stringStringEntry.getValue().trim());
                    }
                    System.out.println(x);
                });
    }
}
