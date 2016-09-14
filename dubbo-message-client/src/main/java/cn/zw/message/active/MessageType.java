package cn.zw.message.active;

/**
 * @auther 'Amos'
 * @created 2016/9/12  11:40
 */
public enum MessageType {


    /**
     *  一对一
     */
    QUEUE(){

        public void setName(String name){
            this.name = name;
        }

    },

    /**
     * 一对多
     */
    TOPPIC() {
        @Override
        public void setName(String name) {
            this.name = name;
        }
    };

    public final static String DEFAULT_NAME = "DEFAULT_NAME" ;

    public abstract void setName(String name);
    protected String name ;

    public String getName() {
        return name;
    }
}
