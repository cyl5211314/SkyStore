package com.example.lenovo.skystore.modle.bean.shoppingfrag;

/**
 * 类描述：
 * 创建人：lenovo
 * 创建时间：2017/7/20 8:20
 */

public class ShoppingData {

    /**
     * code : 400
     * login : 0
     * datas : {"error":"请登录"}
     */

    private int code;
    private String login;
    private DatasBean datas;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public DatasBean getDatas() {
        return datas;
    }

    public void setDatas(DatasBean datas) {
        this.datas = datas;
    }

    public static class DatasBean {
        /**
         * error : 请登录
         */

        private String error;

        public String getError() {
            return error;
        }

        public void setError(String error) {
            this.error = error;
        }
    }
}
