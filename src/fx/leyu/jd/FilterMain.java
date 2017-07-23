package fx.leyu.jd;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FilterMain {
    private List<CouponNode> list;
    public FilterMain(){
        List<Map<String, Object>> initList = new ArrayList<>();
        
        Map<String, Object> map = new HashMap<>();
        map.put("keywords", new String[]{"充值", "QQ"});
        map.put("flag", "1");
        initList.add(map);
        
        map = new HashMap<>();
        map.put("keywords", new String[]{"充值", "游戏"});
        map.put("flag", "2");
        initList.add(map);
        
        map = new HashMap<>();
        map.put("keywords", new String[]{"电影票"});
        map.put("flag", "3");
        initList.add(map);
        
        map = new HashMap<>();
        map.put("keywords", new String[]{"演出票"});
        map.put("flag", "3");
        initList.add(map);
     
        map = new HashMap<>();
        map.put("keywords", new String[]{"充值"});
        map.put("flag", "4");
        initList.add(map);
        
        list = init(initList);
    }
    
    private List<CouponNode> init(List<Map<String, Object>> initList) {
        List<CouponNode> result = new ArrayList<>();
        for (Map<String,Object> map : initList) {
            result.add(new CouponNode(map));
        }
        return result;
    }

    public static void main(String[] args) {
        FilterMain me = new FilterMain();
        
        String test = "QQ充值优惠券";
        System.out.println(me.getInfo(test));
    }

    private String getInfo(String test) {
        for (CouponNode node : list) {
            if(node.isMatch(test, "5.7")){
                return node.toString();
            }
        }
        return null;
    }



}

class CouponNode {
    private int flag;
    private String[] keywords;
    private String minVersion;
    private String maxVersion;
    
    public CouponNode(Map<String, Object> map){
        for (String key : map.keySet()) {
            if ("keywords".equalsIgnoreCase(key)) {
                keywords = (String[])map.get(key);
            } else if ("MIN_VERSION".equalsIgnoreCase(key)) {
                minVersion = ((String)map.get(key)).toLowerCase();
            } else if ("MAX_VERSION".equalsIgnoreCase(key)) {
                maxVersion = ((String)map.get(key)).toLowerCase();
            } else if ("FLAG".equalsIgnoreCase(key)) {
                flag = Integer.valueOf((String)map.get(key)).intValue();
            }
        }
    }
    
    public boolean isMatch(String string, String clientInfo) {
        if (keywords == null) {
            return false;
        }
        string = string.toLowerCase();
        for (String keyword : keywords) {
            if (!string.contains(keyword)) {
                return false;
            }
        }
        
        if (minVersion != null && minVersion.compareTo(clientInfo) > 0) {
            return false;
        }
        
        if (maxVersion != null && maxVersion.compareTo(clientInfo) < 0) {
            return false;
        }
        
        return true;
    }
    
    @Override
    public String toString() {
        return "flag = " + flag;
    }
}