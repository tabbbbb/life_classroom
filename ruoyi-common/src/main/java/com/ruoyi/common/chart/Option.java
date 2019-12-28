/**
 * Copyright (C), 2019, 蓝煌信息科技公司
 * FileName: Option
 * Author:   Administrator
 * Date:     2019/12/26 0026 11:23
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.ruoyi.common.chart;

import java.util.List;

/**
 *图表的数据
 */
public class Option {

    private Title title;

    private List<Series> series;

    public Title getTitle() {
        return title;
    }

    public void setTitle(Title title) {
        this.title = title;
    }

    public List<Series> getSeries() {
        return series;
    }

    public void setSeries(List<Series> series) {
        this.series = series;
    }

    public static class Title{
        private String text;

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }

        public Title() {
        }
    }


    public static class Series{

        private List<Long> data;

        public Series() {
        }

        public List<Long> getData() {
            return data;
        }

        public void setData(List<Long> data) {
            this.data = data;
        }
    }

}
