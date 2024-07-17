package fx.leyu.io.savana;

import com.alibaba.fastjson.JSON;
import org.apache.commons.io.FileUtils;
import org.springframework.core.io.ClassPathResource;
import org.springframework.util.CollectionUtils;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CopyExtractionMain {
    public static void main(String[] args) throws IOException {

        Pattern pattern = Pattern.compile("'([^\\\']+)'");
        Set<String> set = new HashSet<>();

        ClassPathResource resource = new ClassPathResource("category.sql");
        FileUtils.readLines(/*new File("src/main/resources/category.sql"*/resource.getFile(), "utf-8")
                .stream()
                .forEach(x -> {
                    Matcher matcher = pattern.matcher(x);
                    int count = 0;
                    while (matcher.find()) {
                        count++;
                        if (count < 2) {
                            set.add(matcher.group(1));
                        }
                    }
                });
        System.out.println("set size: " + set.size());
        resource = new ClassPathResource("category_config.sql");
        FileUtils.readLines(resource.getFile(), "utf-8")
                .stream()
                .forEach(x -> {
                    Matcher matcher = pattern.matcher(x);
                    int count = 0;
                    while (matcher.find()) {
                        count++;
                        if (count < 2) {
                            String json = matcher.group(1);
                            try {
                                Extra extra = JSON.parseObject(json, Extra.class);
                                set.add(extra.title);
                                if (CollectionUtils.isEmpty(extra.quickOptions)) {
                                    extra.quickOptions.forEach(q -> set.add(q.text));
                                }
                                //System.out.println(extra.title);
                            } catch (Exception e) {
                                System.out.println("json: " + json);
                            }

                        }
                    }
                });
        System.out.println("set size: " + set.size());
        set.forEach(System.out::println);
    }

    private static class Extra {
        private String title;
        private List<QuickOption> quickOptions;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public List<QuickOption> getQuickOptions() {
            return quickOptions;
        }

        public void setQuickOptions(List<QuickOption> quickOptions) {
            this.quickOptions = quickOptions;
        }
    }

    private static class QuickOption {

        /**
         * 文案
         */
        private String text;

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }
    }
}
