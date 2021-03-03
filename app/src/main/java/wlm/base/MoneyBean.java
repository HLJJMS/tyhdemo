package wlm.base;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MoneyBean {

    /**
     * dataFrom :
     * emptyFlag : false
     * errorCode : 0
     * errorMessage : 处理成功
     * success : true
     */

    @SerializedName("dataFrom")
    private String dataFrom;
    @SerializedName("emptyFlag")
    private Boolean emptyFlag;
    @SerializedName("errorCode")
    private String errorCode;
    @SerializedName("errorMessage")
    private String errorMessage;
    @SerializedName("success")
    private Boolean success;
    @SerializedName("value")
    private ValueDTO value;

    public String getDataFrom() {
        return dataFrom;
    }

    public void setDataFrom(String dataFrom) {
        this.dataFrom = dataFrom;
    }

    public Boolean isEmptyFlag() {
        return emptyFlag;
    }

    public void setEmptyFlag(Boolean emptyFlag) {
        this.emptyFlag = emptyFlag;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public Boolean isSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public ValueDTO getValue() {
        return value;
    }

    public void setValue(ValueDTO value) {
        this.value = value;
    }

    public static class ValueDTO {


        @SerializedName("pageNo")
        private Integer pageNo;
        @SerializedName("pageSize")
        private Integer pageSize;
        @SerializedName("pages")
        private Integer pages;
        @SerializedName("total")
        private Integer total;
        @SerializedName("list")
        private List<ListDTO> list;

        public Integer getPageNo() {
            return pageNo;
        }

        public void setPageNo(Integer pageNo) {
            this.pageNo = pageNo;
        }

        public Integer getPageSize() {
            return pageSize;
        }

        public void setPageSize(Integer pageSize) {
            this.pageSize = pageSize;
        }

        public Integer getPages() {
            return pages;
        }

        public void setPages(Integer pages) {
            this.pages = pages;
        }

        public Integer getTotal() {
            return total;
        }

        public void setTotal(Integer total) {
            this.total = total;
        }

        public List<ListDTO> getList() {
            return list;
        }

        public void setList(List<ListDTO> list) {
            this.list = list;
        }

        public static class ListDTO {

            @SerializedName("drawFlowFund")
            private String drawFlowFund;
            @SerializedName("drawFlowFundRj")
            private String drawFlowFundRj;
            @SerializedName("estimateDrawTime")
            private String estimateDrawTime;
            @SerializedName("isGetKjpdf")
            private Integer isGetKjpdf;
            @SerializedName("isGetXlpdf")
            private Integer isGetXlpdf;
            @SerializedName("lotteryDrawNum")
            private String lotteryDrawNum;
            @SerializedName("lotteryDrawResult")
            private String lotteryDrawResult;
            @SerializedName("lotteryDrawStatus")
            private Integer lotteryDrawStatus;
            @SerializedName("lotteryDrawTime")
            private String lotteryDrawTime;
            @SerializedName("lotteryEquipmentCount")
            private Integer lotteryEquipmentCount;
            @SerializedName("lotteryGameName")
            private String lotteryGameName;
            @SerializedName("lotteryGameNum")
            private String lotteryGameNum;
            @SerializedName("lotteryGamePronum")
            private Integer lotteryGamePronum;
            @SerializedName("lotteryPromotionFlag")
            private Integer lotteryPromotionFlag;
            @SerializedName("lotterySaleBeginTime")
            private String lotterySaleBeginTime;
            @SerializedName("lotterySaleEndTimeUnix")
            private Integer lotterySaleEndTimeUnix;
            @SerializedName("lotterySaleEndtime")
            private String lotterySaleEndtime;
            @SerializedName("lotterySuspendedFlag")
            private Integer lotterySuspendedFlag;
            @SerializedName("lotteryUnsortDrawresult")
            private String lotteryUnsortDrawresult;
            @SerializedName("pdfType")
            private Integer pdfType;
            @SerializedName("poolBalanceAfterdraw")
            private String poolBalanceAfterdraw;
            @SerializedName("poolBalanceAfterdrawRj")
            private String poolBalanceAfterdrawRj;
            @SerializedName("ruleType")
            private Integer ruleType;
            @SerializedName("totalSaleAmount")
            private String totalSaleAmount;
            @SerializedName("totalSaleAmountRj")
            private String totalSaleAmountRj;
            @SerializedName("verify")
            private Integer verify;
            @SerializedName("vtoolsConfig")
            private VtoolsConfigDTO vtoolsConfig;
            @SerializedName("matchList")
            private List<?> matchList;
            @SerializedName("prizeLevelListRj")
            private List<?> prizeLevelListRj;
            @SerializedName("termList")
            private List<?> termList;

            public String getDrawFlowFund() {
                return drawFlowFund;
            }

            public void setDrawFlowFund(String drawFlowFund) {
                this.drawFlowFund = drawFlowFund;
            }

            public String getDrawFlowFundRj() {
                return drawFlowFundRj;
            }

            public void setDrawFlowFundRj(String drawFlowFundRj) {
                this.drawFlowFundRj = drawFlowFundRj;
            }

            public String getEstimateDrawTime() {
                return estimateDrawTime;
            }

            public void setEstimateDrawTime(String estimateDrawTime) {
                this.estimateDrawTime = estimateDrawTime;
            }

            public Integer getIsGetKjpdf() {
                return isGetKjpdf;
            }

            public void setIsGetKjpdf(Integer isGetKjpdf) {
                this.isGetKjpdf = isGetKjpdf;
            }

            public Integer getIsGetXlpdf() {
                return isGetXlpdf;
            }

            public void setIsGetXlpdf(Integer isGetXlpdf) {
                this.isGetXlpdf = isGetXlpdf;
            }

            public String getLotteryDrawNum() {
                return lotteryDrawNum;
            }

            public void setLotteryDrawNum(String lotteryDrawNum) {
                this.lotteryDrawNum = lotteryDrawNum;
            }

            public String getLotteryDrawResult() {
                return lotteryDrawResult;
            }

            public void setLotteryDrawResult(String lotteryDrawResult) {
                this.lotteryDrawResult = lotteryDrawResult;
            }

            public Integer getLotteryDrawStatus() {
                return lotteryDrawStatus;
            }

            public void setLotteryDrawStatus(Integer lotteryDrawStatus) {
                this.lotteryDrawStatus = lotteryDrawStatus;
            }

            public String getLotteryDrawTime() {
                return lotteryDrawTime;
            }

            public void setLotteryDrawTime(String lotteryDrawTime) {
                this.lotteryDrawTime = lotteryDrawTime;
            }

            public Integer getLotteryEquipmentCount() {
                return lotteryEquipmentCount;
            }

            public void setLotteryEquipmentCount(Integer lotteryEquipmentCount) {
                this.lotteryEquipmentCount = lotteryEquipmentCount;
            }

            public String getLotteryGameName() {
                return lotteryGameName;
            }

            public void setLotteryGameName(String lotteryGameName) {
                this.lotteryGameName = lotteryGameName;
            }

            public String getLotteryGameNum() {
                return lotteryGameNum;
            }

            public void setLotteryGameNum(String lotteryGameNum) {
                this.lotteryGameNum = lotteryGameNum;
            }

            public Integer getLotteryGamePronum() {
                return lotteryGamePronum;
            }

            public void setLotteryGamePronum(Integer lotteryGamePronum) {
                this.lotteryGamePronum = lotteryGamePronum;
            }

            public Integer getLotteryPromotionFlag() {
                return lotteryPromotionFlag;
            }

            public void setLotteryPromotionFlag(Integer lotteryPromotionFlag) {
                this.lotteryPromotionFlag = lotteryPromotionFlag;
            }

            public String getLotterySaleBeginTime() {
                return lotterySaleBeginTime;
            }

            public void setLotterySaleBeginTime(String lotterySaleBeginTime) {
                this.lotterySaleBeginTime = lotterySaleBeginTime;
            }

            public Integer getLotterySaleEndTimeUnix() {
                return lotterySaleEndTimeUnix;
            }

            public void setLotterySaleEndTimeUnix(Integer lotterySaleEndTimeUnix) {
                this.lotterySaleEndTimeUnix = lotterySaleEndTimeUnix;
            }

            public String getLotterySaleEndtime() {
                return lotterySaleEndtime;
            }

            public void setLotterySaleEndtime(String lotterySaleEndtime) {
                this.lotterySaleEndtime = lotterySaleEndtime;
            }

            public Integer getLotterySuspendedFlag() {
                return lotterySuspendedFlag;
            }

            public void setLotterySuspendedFlag(Integer lotterySuspendedFlag) {
                this.lotterySuspendedFlag = lotterySuspendedFlag;
            }

            public String getLotteryUnsortDrawresult() {
                return lotteryUnsortDrawresult;
            }

            public void setLotteryUnsortDrawresult(String lotteryUnsortDrawresult) {
                this.lotteryUnsortDrawresult = lotteryUnsortDrawresult;
            }

            public Integer getPdfType() {
                return pdfType;
            }

            public void setPdfType(Integer pdfType) {
                this.pdfType = pdfType;
            }

            public String getPoolBalanceAfterdraw() {
                return poolBalanceAfterdraw;
            }

            public void setPoolBalanceAfterdraw(String poolBalanceAfterdraw) {
                this.poolBalanceAfterdraw = poolBalanceAfterdraw;
            }

            public String getPoolBalanceAfterdrawRj() {
                return poolBalanceAfterdrawRj;
            }

            public void setPoolBalanceAfterdrawRj(String poolBalanceAfterdrawRj) {
                this.poolBalanceAfterdrawRj = poolBalanceAfterdrawRj;
            }

            public Integer getRuleType() {
                return ruleType;
            }

            public void setRuleType(Integer ruleType) {
                this.ruleType = ruleType;
            }

            public String getTotalSaleAmount() {
                return totalSaleAmount;
            }

            public void setTotalSaleAmount(String totalSaleAmount) {
                this.totalSaleAmount = totalSaleAmount;
            }

            public String getTotalSaleAmountRj() {
                return totalSaleAmountRj;
            }

            public void setTotalSaleAmountRj(String totalSaleAmountRj) {
                this.totalSaleAmountRj = totalSaleAmountRj;
            }

            public Integer getVerify() {
                return verify;
            }

            public void setVerify(Integer verify) {
                this.verify = verify;
            }

            public VtoolsConfigDTO getVtoolsConfig() {
                return vtoolsConfig;
            }

            public void setVtoolsConfig(VtoolsConfigDTO vtoolsConfig) {
                this.vtoolsConfig = vtoolsConfig;
            }

            public List<?> getMatchList() {
                return matchList;
            }

            public void setMatchList(List<?> matchList) {
                this.matchList = matchList;
            }



            public List<?> getPrizeLevelListRj() {
                return prizeLevelListRj;
            }

            public void setPrizeLevelListRj(List<?> prizeLevelListRj) {
                this.prizeLevelListRj = prizeLevelListRj;
            }

            public List<?> getTermList() {
                return termList;
            }

            public void setTermList(List<?> termList) {
                this.termList = termList;
            }

            public static class VtoolsConfigDTO {
            }


        }
    }
}
