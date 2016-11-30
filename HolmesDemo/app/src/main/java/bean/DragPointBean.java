package bean;

/**
 * Created by yaochen on 2016/11/30.
 */

public class DragPointBean {

    private int messageNum;

    public DragPointBean(int messageNum) {
        this.messageNum = messageNum;
    }

    private boolean isRemoved;

    public int getMessageNum() {
        return messageNum;
    }

    public void setMessageNum(int messageNum) {
        this.messageNum = messageNum;
    }

    public boolean isRemoved() {
        return isRemoved;
    }

    public void setRemoved(boolean removed) {
        isRemoved = removed;
    }
}
