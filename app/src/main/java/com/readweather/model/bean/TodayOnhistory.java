package com.readweather.model.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2018/2/6.
 */

public class TodayOnhistory implements Serializable{

    /**
     * reason : success
     * result : [{"day":"2/6","date":"1665年02月06日","title":"英国安妮女王出生","e_id":"1676"},{"day":"2/6","date":"1689年02月06日","title":"英国的\u201c光荣革命\u201d事件","e_id":"1677"},{"day":"2/6","date":"1778年02月06日","title":"法国正式承认美国的独立","e_id":"1678"},{"day":"2/6","date":"1802年02月06日","title":"英国物理学家查尔斯·惠斯通出生","e_id":"1679"},{"day":"2/6","date":"1840年02月06日","title":"英国与毛利人签署《怀唐伊条约》 新西兰成为英国殖民地","e_id":"1680"},{"day":"2/6","date":"1908年02月06日","title":"上海首次试行有轨电车","e_id":"1681"},{"day":"2/6","date":"1909年02月06日","title":"延续二千多年的奴婢制度宣告终结","e_id":"1682"},{"day":"2/6","date":"1919年02月06日","title":"德国魏玛共和国建立","e_id":"1683"},{"day":"2/6","date":"1920年02月06日","title":"海原大地震","e_id":"1684"},{"day":"2/6","date":"1922年02月06日","title":"侵犯中国主权的\u201c九国公约\u201d在华盛顿签订","e_id":"1685"},{"day":"2/6","date":"1928年02月06日","title":"周文雍和陈铁军举行\u201c刑场上的婚礼\u201d","e_id":"1686"},{"day":"2/6","date":"1936年02月06日","title":"冬奥会开幕　希特勒致词","e_id":"1687"},{"day":"2/6","date":"1937年02月06日","title":"张国焘向中共中央检讨错误","e_id":"1688"},{"day":"2/6","date":"1938年02月06日","title":"八路军改为第十八集团军","e_id":"1689"},{"day":"2/6","date":"1945年02月06日","title":"45国工会代表会议决定成立统一的世界工会组织","e_id":"1690"},{"day":"2/6","date":"1948年02月06日","title":"东北解放军攻克四平","e_id":"1691"},{"day":"2/6","date":"1952年02月06日","title":"中国文字改革研究委员会在京成立","e_id":"1692"},{"day":"2/6","date":"1952年02月06日","title":"英国国王乔治六世病逝","e_id":"1693"},{"day":"2/6","date":"1954年02月06日","title":"中共中央批判高岗、饶漱石分裂中央","e_id":"1694"},{"day":"2/6","date":"1956年02月06日","title":"国务院发布《关于推广普通话的指示》","e_id":"1695"},{"day":"2/6","date":"1973年02月06日","title":"四川省炉霍7.9级地震","e_id":"1696"},{"day":"2/6","date":"1976年02月06日","title":"日本洛克希德贿赂案败露，前首相田中角荣被判刑","e_id":"1697"},{"day":"2/6","date":"1978年02月06日","title":"中央广播电视大学正式开学","e_id":"1698"},{"day":"2/6","date":"1986年02月06日","title":"中国足球队组建红、黄队","e_id":"1699"},{"day":"2/6","date":"1987年02月06日","title":"我国著名热带医学专家钟惠澜逝世","e_id":"1700"},{"day":"2/6","date":"1987年02月06日","title":"谢育新转会荷兰兹瓦鲁市PEC\u201c82\u201d俱乐部队","e_id":"1701"},{"day":"2/6","date":"1989年02月06日","title":"波兰\u201c圆桌会议\u201d召开","e_id":"1702"},{"day":"2/6","date":"1993年02月06日","title":"比利时决定由中央集权国家改变为联邦政体国家","e_id":"1703"},{"day":"2/6","date":"1995年02月06日","title":"电影艺术家夏衍逝世","e_id":"1704"},{"day":"2/6","date":"1995年02月06日","title":"《我的前半生》著作权纠纷案","e_id":"1705"},{"day":"2/6","date":"1995年02月06日","title":"国内首例冻融胚胎试管婴儿在京诞生","e_id":"1706"},{"day":"2/6","date":"1996年02月06日","title":"美联邦法院要求克林顿在3月以白水案证人身份提供证词","e_id":"1707"},{"day":"2/6","date":"1998年02月06日","title":"国家教委调整中小学教育教学","e_id":"1708"},{"day":"2/6","date":"1998年02月06日","title":"金钟泌说韩不同台湾发展官方关系","e_id":"1709"},{"day":"2/6","date":"1998年02月06日","title":"厄瓜多尔总统布卡拉姆被罢免","e_id":"1710"},{"day":"2/6","date":"1999年02月06日","title":"第四届亚冬会圆满落幕 中国代表团获金牌总数第一","e_id":"1711"},{"day":"2/6","date":"2001年02月06日","title":"我科学家成功克隆乳光牙基因","e_id":"1712"},{"day":"2/6","date":"2006年02月06日","title":"《烟草控制框架公约》缔约方首次会议在日内瓦开幕","e_id":"1713"},{"day":"2/6","date":"2012年02月06日","title":"王立军事件发生","e_id":"1714"}]
     * error_code : 0
     */

    private String reason;
    private int error_code;
    private List<ResultBean> result;

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public int getError_code() {
        return error_code;
    }

    public void setError_code(int error_code) {
        this.error_code = error_code;
    }

    public List<ResultBean> getResult() {
        return result;
    }

    public void setResult(List<ResultBean> result) {
        this.result = result;
    }

    public class ResultBean {
        /**
         * day : 2/6
         * date : 1665年02月06日
         * title : 英国安妮女王出生
         * e_id : 1676
         */

        private String day;
        private String date;
        private String title;
        private String e_id;

        public String getDay() {
            return day;
        }

        public void setDay(String day) {
            this.day = day;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getE_id() {
            return e_id;
        }

        public void setE_id(String e_id) {
            this.e_id = e_id;
        }
    }
}
