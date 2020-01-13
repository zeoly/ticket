```
alert dialog ticket price
login dialog
captcha(https://blog.csdn.net/li_qinging/article/details/98876091)
click positon
login
```

```javascript
var seatTypeForHB = {
    SWZ: "9_商务座",
    TZ: "P_特等座",
    ZY: "M_一等座",
    ZE: "O_二等座",
    GR: "6_高级软卧",
    RW: "4_软卧",
    SRRB: "F_动卧",
    YW: "3_硬卧",
    RZ: "2_软座",
    YZ: "1_硬座",
    WZ: "1_无座",
    QT: "H_其他"
};
```

```javascript
var seatTypeCodeForName = {
    A: "高级动卧",
    I: "一等卧",
    J: "二等卧",
    P: "特等座",
    M: "一等座",
    O: "二等座",
    F: "动卧",
    "9": "商务座",
    "6": "高级软卧",
    "4": "软卧",
    "3": "硬卧",
    "2": "软座",
    "1": "硬座",
    H: "其他",
    WZ: "无座",
    W: "无座"
};
```


```javascript
function cr(cQ, cS) {
    var cP = [];
    for (var cO = 0; cO < cQ.length; cO++) {
        var cT = [];
        var cN = cQ[cO].split("|");
        cT.secretStr = cN[0];
        cT.buttonTextInfo = cN[1];
        var cR = [];
        cR.train_no = cN[2];
        cR.station_train_code = cN[3];
        cR.start_station_telecode = cN[4];
        cR.end_station_telecode = cN[5];
        cR.from_station_telecode = cN[6];
        cR.to_station_telecode = cN[7];
        cR.start_time = cN[8];
        cR.arrive_time = cN[9];
        cR.lishi = cN[10];
        cR.canWebBuy = cN[11];
        cR.yp_info = cN[12];
        cR.start_train_date = cN[13];
        cR.train_seat_feature = cN[14];
        cR.location_code = cN[15];
        cR.from_station_no = cN[16];
        cR.to_station_no = cN[17];
        cR.is_support_card = cN[18];
        cR.controlled_train_flag = cN[19];
        cR.gg_num = cN[20] ? cN[20] : "--";
        cR.gr_num = cN[21] ? cN[21] : "--";
        cR.qt_num = cN[22] ? cN[22] : "--";
        cR.rw_num = cN[23] ? cN[23] : "--";
        cR.rz_num = cN[24] ? cN[24] : "--";
        cR.tz_num = cN[25] ? cN[25] : "--";
        cR.wz_num = cN[26] ? cN[26] : "--";
        cR.yb_num = cN[27] ? cN[27] : "--";
        cR.yw_num = cN[28] ? cN[28] : "--";
        cR.yz_num = cN[29] ? cN[29] : "--";
        cR.ze_num = cN[30] ? cN[30] : "--";
        cR.zy_num = cN[31] ? cN[31] : "--";
        cR.swz_num = cN[32] ? cN[32] : "--";
        cR.srrb_num = cN[33] ? cN[33] : "--";
        cR.yp_ex = cN[34];
        cR.seat_types = cN[35];
        cR.exchange_train_flag = cN[36];
        cR.houbu_train_flag = cN[37];
        cR.houbu_seat_limit = cN[38];
        if (cN.length > 46) {
            cR.dw_flag = cN[46]
        }
        cR.from_station_name = cS[cN[6]];
        cR.to_station_name = cS[cN[7]];
        cT.queryLeftNewDTO = cR;
        cP.push(cT)
    }
    return cP
}
```