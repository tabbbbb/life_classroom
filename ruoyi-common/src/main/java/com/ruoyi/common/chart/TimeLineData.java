/**
 * Copyright (C), 2019, 蓝煌信息科技公司
 * FileName: TimeLineData
 * Author:   Administrator
 * Date:     2019/12/26 0026 11:17
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.ruoyi.common.chart;

/**
 * 图表转化需要的参数
 */
public class TimeLineData {


    private String value;

    private Tooltip tooltip;

    private String symbol;

    private Integer symbolSize;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Tooltip getTooltip() {
        return tooltip;
    }

    public void setTooltip(Tooltip tooltip) {
        this.tooltip = tooltip;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public Integer getSymbolSize() {
        return symbolSize;
    }

    public void setSymbolSize(Integer symbolSize) {
        this.symbolSize = symbolSize;
    }

    public class Tooltip{

        public Tooltip() {
        }

        private String formatter;


        public String getFormatter() {
            return formatter;
        }

        public void setFormatter(String formatter) {
            this.formatter = formatter;
        }
    }
}
