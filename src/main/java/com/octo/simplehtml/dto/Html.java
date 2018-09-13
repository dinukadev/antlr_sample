package com.octo.simplehtml.dto;

public final class Html {

    private Head head;

    public Html() {
        head = new Head();
    }

    public void setHead(Head head) {
        this.head = head;
    }

    public Head getHead() {
        return head;
    }

    public static class Title {
        private String title;

        public void setTitle(String title) {
            this.title = title;
        }

        public String getTitle() {
            return title;
        }
    }

    public static class Head {
        private Title title;

        public Head() {
            title = new Title();
        }

        public void setTitle(Title title) {
            this.title = title;
        }

        public Title getTitle() {
            return title;
        }
    }

}
