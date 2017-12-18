package com.scimmia;


import com.scimmia.db.InvoiceBean;

import java.util.List;

/**
 * Created by lk on 2017/9/11.
 */
public class CheckResult {

    /**
     * RtnCode : 00
     * dataFrom : dataBase
     * cyrq : 2017-09-11 09:44:02.0
     * list : [{"value":"山东增值税（电子发票）","name1":"","name2":"票种"},{"value":"1","name1":"","name2":"查询次数"},{"value":"青岛肯德基有限公司济南分公司","name1":"","name2":"(销售方)名称"},{"value":"山东龙口农村商业银行股份有限公司","name1":"","name2":"(购买方)名称"},{"value":"2.35","name1":"","name2":"税额"},{"value":"41.50","name1":"","name2":"价税合计"},{"value":"否","name1":"","name2":"是否作废"}]
     * swjg_mc : 山东增值税（电子发票）
     * cyjgState : 1000
     */

    private String RtnCode;
    private String dataFrom;
    private String cyrq;
    private String swjg_mc;
    private String cyjgState;
    private List<ListBean> list;

    public String getRtnCode() {
        return RtnCode;
    }

    public void setRtnCode(String RtnCode) {
        this.RtnCode = RtnCode;
    }

    public String getDataFrom() {
        return dataFrom;
    }

    public void setDataFrom(String dataFrom) {
        this.dataFrom = dataFrom;
    }

    public String getCyrq() {
        return cyrq;
    }

    public void setCyrq(String cyrq) {
        this.cyrq = cyrq;
    }

    public String getSwjg_mc() {
        return swjg_mc;
    }

    public void setSwjg_mc(String swjg_mc) {
        this.swjg_mc = swjg_mc;
    }

    public String getCyjgState() {
        return cyjgState;
    }

    public void setCyjgState(String cyjgState) {
        this.cyjgState = cyjgState;
    }

    public List<ListBean> getList() {
        return list;
    }

    public void setList(List<ListBean> list) {
        this.list = list;
    }

    public String toShow() {
        String result = "";
        if (list != null) {
            for (ListBean temp :
                    list) {
                result = result + temp.getName2() + "\t" + temp.getValue() + "\n";
            }
        }
        return result;
    }

    public InvoiceBean toInvoice(String fpdm,String fphm,String fprq,String fpje){
        InvoiceBean result = new InvoiceBean(fpdm,fphm,fprq,fpje);
        if (list != null) {
            for (ListBean temp :list) {
                switch (temp.getName2()) {
                    case "票种":
                        result.setPiaozhong(temp.getValue());
                        break;
                    case "(销售方)名称":
                        result.setXiaoshoufang(temp.getValue());
                        break;
                    case "(购买方)名称":
                        result.setGoumaifang(temp.getValue());
                        break;
                    case "金额":
                        result.setJine(temp.getValue());
                        break;
                    case "税额":
                        result.setShuie(temp.getValue());
                        break;
                    case "价税合计":
                        result.setJiashuiheji(temp.getValue());
                        break;
                    case "是否作废":
                        result.setZuofei(temp.getValue());
                        break;
//                case "":
//                    break;
                }
            }
        }
        return result;
    }
    public static class ListBean {
        /**
         * value : 山东增值税（电子发票）
         * name1 :
         * name2 : 票种
         */

        private String value;
        private String name1;
        private String name2;

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public String getName1() {
            return name1;
        }

        public void setName1(String name1) {
            this.name1 = name1;
        }

        public String getName2() {
            return name2;
        }

        public void setName2(String name2) {
            this.name2 = name2;
        }
    }
}
