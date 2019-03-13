package fx.leyu.interview.ant;

import org.apache.commons.lang3.ArrayUtils;

import java.util.Scanner;

public class MessageUtils {
    public static Message[] nearestKMessages(Scanner scanner, final int k) {
        if (scanner == null || k <= 0) {
            throw new IllegalArgumentException();
        }

        Message[] result = new Message[k];
        for (int i = 0; i < k; i++) {
            if (!scanner.hasNextLine()) {
                throw new IllegalArgumentException("Scanner has not " + k + " messages");
            }
            result[i] = new Message(scanner.nextLine());
            adjustSmallTopHeap(result, i);
        }

        while(scanner.hasNextLine()) {
            Message nextMessage = new Message(scanner.nextLine());
            if (result[0].getTimestamp() < nextMessage.getTimestamp()) {
                result[0] = nextMessage;
                adjustSmallTopHeapWithTop(result);
            }
        }
        return result;
    }

    private static void adjustSmallTopHeapWithTop(Message[] result) {
        int top = 0;
        int next = gainSmallestIndex(result, top, top * 2 + 1, top * 2 + 2);
        while (top != next) {
            exchange(result, top, next);
            top = next;
            next = gainSmallestIndex(result, top, top * 2 + 1, top * 2 + 2);
        }

    }

    private static int gainSmallestIndex(Message[] result, int top, int a, int b) {
        int resultIndex = top;
        if (a < result.length) {
            resultIndex = result[resultIndex].getTimestamp() > result[a].getTimestamp() ? a : resultIndex;
        }
        if (b < result.length) {
            resultIndex = result[resultIndex].getTimestamp() > result[b].getTimestamp() ? b : resultIndex;
        }
        return resultIndex;
    }

    private static void adjustSmallTopHeap(Message[] result, int i) {
        int top = (i - 1) / 2;
        while (i > 0) {
            if (result[i].getTimestamp() < result[top].getTimestamp()) {
                exchange(result, i, top);
            }
            i = top;
            top = (i - 1) / 2;
        }
    }

    private static void exchange(Message[] result, int a, int b) {
        Message temp = result[a];
        result[a] = result[b];
        result[b] = temp;
    }
}
