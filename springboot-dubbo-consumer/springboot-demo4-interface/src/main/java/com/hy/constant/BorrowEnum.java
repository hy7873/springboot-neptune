package com.hy.constant;

public class BorrowEnum {

    public enum Status{
        THREE(3,"待售"),
        FOUR(4,"开始募集"),
        FIVE(5,"已满标"),
        SIX(6,"放款中"),
        SEVEN(7,"计息中"),
        NINE(9,"已结清"),
        TEN(10,"流标"),
        Eleven(11, "部分满标"),
        TWELVE(12,"退出中"),
        THIRTEEN(13,"放款成功");

        private int code;
        private String name;

        Status(int code, String name) {
            this.code = code;
            this.name = name;
        }

        public int getCode() {
            return code;
        }

        public String getName() {
            return name;
        }
    }

    public enum IsSale{
        DEFAULT(0, "默认值"),
        SALE(1, "上架"),
        UNSALE(2, "下架");

        private int code;
        private String name;

        IsSale(int code, String name) {
            this.code = code;
            this.name = name;
        }

        public int getCode() {
            return code;
        }

        public String getName() {
            return name;
        }
    }
}
