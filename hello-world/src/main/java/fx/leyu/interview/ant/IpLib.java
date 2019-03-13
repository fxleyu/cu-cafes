package fx.leyu.interview.ant;

import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.Objects;

public class IpLib {
    private static IpList[] ipLists = new IpList[0];
    public static void createIpLib(String[] array) {
        if (array == null) {
            return;
        }
        ipLists = new IpList[array.length];
        for (int i = 0; i < array.length; i++) {
            ipLists[i] = new IpList(array[i]);
        }
        Arrays.sort(ipLists, (ipListOne, ipListTwo) -> Long.compare(ipListOne.start, ipListTwo.start));
    }

    public static String gainConfig(String ipString) {
        if (ipLists.length == 0) {
            return null;
        }
        int start = 0, end = ipLists.length - 1;
        long ip =getIp(ipString);
        while (start <= end && start < ipLists.length && end > -1) {
            int mid = (start + end) / 2;
            IpList ipList = ipLists[mid];
            if (ipList.getStart() <= ip && ipList.getEnd() >= ip) {
                return ipList.getConfig();
            }

            if (ipList.getStart() > ip) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return null;
    }

    private static class IpList implements Comparable{
        private long start;
        private long end;
        private String config;
        public IpList(String config) {
            if (StringUtils.isBlank(config)) {
                throw new IllegalArgumentException("invalid config is blank ");
            }
            String[] ips = config.split("~");
            if (ips.length != 2) {
                throw new IllegalArgumentException("invalid config " + config);
            }
            this.config = config;
            this.start = getIp(ips[0]);
            this.end = getIp(ips[1]);
        }

        public long getStart() {
            return start;
        }

        public void setStart(long start) {
            this.start = start;
        }

        public long getEnd() {
            return end;
        }

        public void setEnd(long end) {
            this.end = end;
        }

        public String getConfig() {
            return config;
        }

        public void setConfig(String config) {
            this.config = config;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            IpList ipList = (IpList) o;
            return start == ipList.start &&
                    end == ipList.end &&
                    Objects.equals(config, ipList.config);
        }

        @Override
        public int hashCode() {
            return Objects.hash(start, end, config);
        }

        @Override
        public int compareTo(Object o) {
            if (!(o instanceof IpList)) {
                throw new IllegalArgumentException("type error");
            }
            IpList ipList = (IpList) o;
            if (this.start == ipList.start) {
                return 0;
            }
            return this.start > ipList.start ? 1 : -1;
        }

        @Override
        public String toString() {
            return "IpList{" +
                    "start=" + start +
                    ", end=" + end +
                    ", config='" + config + '\'' +
                    '}';
        }
    }

    private static long getIp(String ip) {
        String[] ips = ip.split("\\.");
        if (ips.length != 4) {
            throw new IllegalArgumentException("invalid ip " + ip);
        }
        long result = 0;
        for (int i = 0; i < 4; i++) {
            int num = Integer.valueOf(ips[i]);
            if (num < 0 || num > 255) {
                throw new IllegalArgumentException("invalid ip " + ip);
            }
            result = result + (long)(num * Math.pow(256, 3 - i));
        }
        return result;
    }
}
