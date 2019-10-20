package fx.leyu.interview.ant;

import org.apache.commons.lang3.StringUtils;

import java.util.Objects;

/**
 * @author fxleyu
 */
public class Message {
    private long timestamp;
    private String message;

    public Message(String string) {
        if (StringUtils.isBlank(string)) {
            throw new IllegalArgumentException("Invalid message format, message is blank");
        }

        String[] message = string.split(",");
        if (message.length != 2) {
            throw new IllegalArgumentException("Invalid message format, message is " + string);
        }
        try {
            this.timestamp = Long.valueOf(message[0]);
            this.message = message[1];
        } catch (Exception exception) {
            throw new IllegalArgumentException("Invalid message format, message is " + string);
        }
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Message message1 = (Message) o;
        return timestamp == message1.timestamp &&
                Objects.equals(message, message1.message);
    }

    @Override
    public int hashCode() {

        return Objects.hash(timestamp, message);
    }

    @Override
    public String toString() {
        return "Message{" +
                "timestamp=" + timestamp +
                ", message='" + message + '\'' +
                '}';
    }
}
