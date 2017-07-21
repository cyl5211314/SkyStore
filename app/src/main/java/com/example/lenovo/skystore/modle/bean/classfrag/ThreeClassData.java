package com.example.lenovo.skystore.modle.bean.classfrag;

import java.util.List;

/**
 * 类描述：
 * 创建人：lenovo
 * 创建时间：2017/7/19 10:45
 */

public class ThreeClassData {


    /**
     * code : 200
     * datas : {"class_list":[{"gc_id":"622","gc_name":"米面杂粮"},{"gc_id":"623","gc_name":"食用油"},{"gc_id":"624","gc_name":"调味品"},{"gc_id":"625","gc_name":"南北干货"},{"gc_id":"626","gc_name":"方便食品"},{"gc_id":"627","gc_name":"有机食品"}]}
     */

    private int code;
    private DatasBean datas;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public DatasBean getDatas() {
        return datas;
    }

    public void setDatas(DatasBean datas) {
        this.datas = datas;
    }

    public static class DatasBean {
        private List<ClassListBean> class_list;

        public List<ClassListBean> getClass_list() {
            return class_list;
        }

        public void setClass_list(List<ClassListBean> class_list) {
            this.class_list = class_list;
        }

        public static class ClassListBean {
            /**
             * gc_id : 622
             * gc_name : 米面杂粮
             */

            private String gc_id;
            private String gc_name;

            public String getGc_id() {
                return gc_id;
            }

            public void setGc_id(String gc_id) {
                this.gc_id = gc_id;
            }

            public String getGc_name() {
                return gc_name;
            }

            public void setGc_name(String gc_name) {
                this.gc_name = gc_name;
            }
        }
    }
}
