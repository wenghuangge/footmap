create table user
(
    id       int auto_increment
        primary key,
    username varchar(20)  not null,
    phone    varchar(20)  not null,
    password varchar(100) not null,
    constraint user_username_uindex
        unique (username)
);

INSERT INTO footmap.user (id, username, phone, password) VALUES (46, 'wenghuangge', '18258677024', '$2a$10$ByKsys/zRA/KOcWs7AsgiONSOduXzJCdpypvxQiL.e70C./clAOgy');
INSERT INTO footmap.user (id, username, phone, password) VALUES (49, 'aaa', '18258677024', '$2a$10$KnMDpI/L5pyW6ZZeUcZzde4AoZwuimO2HmDx/JnEFZLabFZk3z5JC');