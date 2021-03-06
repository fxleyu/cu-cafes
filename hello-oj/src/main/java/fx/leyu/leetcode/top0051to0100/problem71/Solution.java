package fx.leyu.leetcode.top0051to0100.problem71;

import java.util.LinkedList;

public class Solution {
    public String simplifyPath(String path) {
        if (path == null || !path.contains("/")) {
            return path;
        }

        LinkedList<String> result = new LinkedList<String>();
        String[] pathNames = path.split("/");
        for (String name : pathNames) {
            if (name == null || name.trim().length() == 0 || ".".equals(name)) {
                continue;
            }
            if (!"..".equals(name)) {
                result.addLast(name.trim());
                continue;
            }
            if (!result.isEmpty()) {
                result.removeLast();
            }
        }

        if (result.isEmpty()) {
            return "/";
        }

        StringBuilder builder = new StringBuilder();
        for (String string : result) {
            builder.append("/").append(string);
        }
        return builder.substring(path.startsWith("/") ? 0 : 1);
    }
}
