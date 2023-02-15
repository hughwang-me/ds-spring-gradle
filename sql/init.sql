create table `ds-mx-spring`.user
(

    ID           varchar(64)  not null
        primary key,
    username     varchar(255) null,
    password     varchar(255) null,
    CREATED_TIME mediumtext   null,
    UPDATED_TIME mediumtext   null,
    OPERATOR     varchar(255) null,
    VALID        int          null
);

