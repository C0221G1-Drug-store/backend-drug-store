package com.backend.pharmacy_management.model.dto.report;

public  class  StatisticalChart {
    private Double turnover;
    private Double profit;
    private String dateSale;

    public StatisticalChart(Double turnover, Double profit, String dateSale) {
        this.turnover = turnover;
        this.profit = profit;
        this.dateSale = dateSale;
    }

    public StatisticalChart() {
    }

    public Double getTurnover() {
        return turnover;
    }

    public void setTurnover(Double turnover) {
        this.turnover = turnover;
    }

    public Double getProfit() {
        return profit;
    }

    public void setProfit(Double profit) {
        this.profit = profit;
    }

    public String getDateSale() {
        return dateSale;
    }

    public void setDateSale(String dateSale) {
        this.dateSale = dateSale;
    }
}
