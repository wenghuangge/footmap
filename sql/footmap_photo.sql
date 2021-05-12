create table photo
(
    id        int auto_increment
        primary key,
    userId    int            null,
    longitude double(20, 10) null,
    latitude  double(20, 10) null,
    image     varchar(1000)  null,
    time      bigint         null,
    praiseNum int            null,
    label     varchar(255)   null,
    province  varchar(255)   null,
    city      varchar(255)   null,
    address   varchar(255)   null,
    visible   int            null,
    photoTime bigint         null,
    title     varchar(500)   null,
    content   varchar(500)   null
)
    charset = utf8;

INSERT INTO footmap.photo (id, userId, longitude, latitude, image, time, praiseNum, label, province, city, address, visible, photoTime, title, content) VALUES (441, 46, 109.511909, 18.252847, '["http://121.199.55.115:80/group1/M00/00/00/ecc3c2COq02AVNT9AADgFVyqZVM33.jpeg","http://121.199.55.115:80/group1/M00/00/00/ecc3c2COq02AVBcnAAKtULVsx9Y25.jpeg"]', 1549964181201, null, null, '海南省', '三亚市', null, 0, null, '往南走', '最南边的地方');
INSERT INTO footmap.photo (id, userId, longitude, latitude, image, time, praiseNum, label, province, city, address, visible, photoTime, title, content) VALUES (442, 46, 121.12, 52.15, '["http://121.199.55.115:80/group1/M00/00/00/ecc3c2COsROAc1poAAAZnYDzxDQ64.jpeg"]', 1539964181201, null, null, '黑龙江省', '大兴安岭地区', null, 0, null, '北方', '去过最北的地方.................................................');
INSERT INTO footmap.photo (id, userId, longitude, latitude, image, time, praiseNum, label, province, city, address, visible, photoTime, title, content) VALUES (443, 46, 75.57, 38.2, '["http://121.199.55.115:80/group1/M00/00/00/ecc3c2COscuAIycWAAA4bNxdnkQ38.jpeg"]', 1529964367668, null, null, '新疆维吾尔自治区', '喀什地区', null, 0, null, '西边', '去过最西边的地方.........................');
INSERT INTO footmap.photo (id, userId, longitude, latitude, image, time, praiseNum, label, province, city, address, visible, photoTime, title, content) VALUES (444, 46, 131.15, 46.5, '["http://121.199.55.115:80/group1/M00/00/00/ecc3c2COsp2ATwVYAAAnlJqXEJM80.jpeg"]', 1519964575602, null, null, '黑龙江省', '佳木斯市', null, 0, null, '东边', '去东边看看');
INSERT INTO footmap.photo (id, userId, longitude, latitude, image, time, praiseNum, label, province, city, address, visible, photoTime, title, content) VALUES (445, 46, 75.57, 38.2, '["http://121.199.55.115:80/group1/M00/00/00/ecc3c2COv_KANwMbAAA9K5EZxm481.jpeg"]', 1619968005874, null, null, '新疆维吾尔自治区', '喀什地区', null, 0, null, '新疆游玩', '哈哈哈哈哈哈哈哈');
INSERT INTO footmap.photo (id, userId, longitude, latitude, image, time, praiseNum, label, province, city, address, visible, photoTime, title, content) VALUES (448, 46, null, null, '["http://121.199.55.115:80/group1/M00/00/00/ecc3c2CXSZyANPkWAAAnlJqXEJM66.jpeg"]', 1620527523841, null, null, '浙江省', '杭州市', null, 0, null, 'aaa', 'aaaa');