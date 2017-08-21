package fx.leyu.learn.mybatis.imooc.bean;

public class Message {
    private int id;
    private String command;
    private String description;
    private String content;
    public int getId() {
        return id;
    }
    public String getCommand() {
        return command;
    }
    public String getDescription() {
        return description;
    }
    public String getContent() {
        return content;
    }
    public void setId(int id) {
        this.id = id;
    }
    public void setCommand(String command) {
        this.command = command;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public void setContent(String content) {
        this.content = content;
    }
    @Override
    public String toString() {
        return "Message [id=" + id + ", command=" + command + ", description="
                + description + ", content=" + content + "]";
    }

}
